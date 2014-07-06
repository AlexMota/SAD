package br.ufg.es.sad.avaliacao.controller;

import br.ufg.es.sad.avaliacao.model.Avaliacao;
import br.ufg.es.sad.avaliacao.model.ComboBoxAdapter;
import br.ufg.es.sad.avaliacao.model.ThreadAvaliacao;
import br.ufg.es.sad.avaliacao.model.ThreadListener;
import br.ufg.es.sad.avaliacao.view.ViewAvaliacao;
import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ControllerViewAvaliacao implements ThreadListener {

    // View
    ViewAvaliacao view;
    JTable tableResultado;
    JButton buttonAvaliar;
    JButton buttonSelecionarArquivos;
    JComboBox comboBoxResolucao;

    JLabel labelTotal;
    JLabel labelRodando;
    JLabel labelFinalizadas;

    int totalThreads = 0;
    int totalRodando = 0;
    int totalFinalizadas = 0;

    // ***************************
    DefaultTableModel tableModel;

    // Persistence
    DAOFactory daof;

    // Resolucação selecionada
    Resolucao resolucao;

    // Lista de atividades da resolução
    List<AtividadeResolucao> atividades;

    // Arquivos de avaliacao do diretorio selecionado
    File[] filesAvaliacao;

    // Número de arquivos que devem ser processados por cada thread
    private static final int FILES_POR_THREAD = 500;

    public ControllerViewAvaliacao() {
        initView();
        initListeners();
        initDao();
        updateComboResolucao();
    }

    /**
     *
     */
    public void showView() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }

    private void initView() {
        // View
        view = new ViewAvaliacao();
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(ViewAvaliacao.EXIT_ON_CLOSE);

        // Componentes da view
        labelTotal = view.getLabelTotal();
        labelRodando = view.getLabelRodando();
        labelFinalizadas = view.getLabelFinalizadas();

        comboBoxResolucao = view.getComboBoxResolucao();
        tableResultado = view.getTableResolucao();
        tableModel = (DefaultTableModel) tableResultado.getModel();

        buttonSelecionarArquivos = view.getButtonSelecionarArquivos();
        buttonAvaliar = view.getButtonAvaliar();
        disable(buttonAvaliar);
    }

    private void initListeners() {
        buttonSelecionarArquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setDialogTitle("Selecione diretório com os arquivos para avaliação");

                int returnVal = chooser.showSaveDialog(view);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File directory = chooser.getSelectedFile();
                    if (directory.isDirectory()) {
                        // Listar arquivos json do diretório
                        filesAvaliacao = directory.listFiles(new FileFilter() {

                            public boolean accept(File pathname) {
                                return pathname.getName().contains(".json");
                            }
                        });

                        // Habilitar botao de iniciar avaliação
                        if (filesAvaliacao.length > 0) {
                            enable(comboBoxResolucao);
                        }
                    } else {
                        showMenssagem("Diretório inválido");
                    }
                }
            }
        });

        buttonAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset();
                iniciarAvaliacao();
            }
        });

        comboBoxResolucao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    resolucao = (Resolucao) ie.getItem();

                    // após selecionar a resolução habilitar botão da avaliação
                    enable(buttonAvaliar);
                }
            }
        });
    }

    private void initDao() {
        daof = DAOFactory.getFactory();
    }

    /**
     * Listar todas resoluções e atualizar a combo de resoluçao
     */
    private void updateComboResolucao() {
        List<Resolucao> resolucoes = new ArrayList<Resolucao>();
        try {
            resolucoes = daof.getResolucaoDAO().getAll();
        } catch (Exception e) {
            showMenssagem("Erro ao selecionar as resoluções");
        }
        comboBoxResolucao.setModel(new ComboBoxAdapter(resolucoes));
    }

    /**
     * Criar as threads de avaliação Quebra a lista de arquivos em arrays
     * contendo x arquivos por thread.
     */
    private void iniciarAvaliacao() {

        // Verificando os arquivos do diretório selecionado
        if (filesAvaliacao.length > 0) {
            disable(buttonSelecionarArquivos);
            for (File[] files : getListFiles()) {
                startThreadAvaliacao(1, files, getAtividades());
            }
        } else {            
            showMenssagem("Diretório não contem arquivos para avaliação");
        }

    }

    /**
     * Processa a lista de arquivos selecionados, criando sublistas de acordo
     * com a quantidade de arquivos que cada thread vai selecionar.
     *
     * @return
     */
    private List<File[]> getListFiles() {
        List<File[]> filesThread = new ArrayList<File[]>();

        totalThreads = filesAvaliacao.length / FILES_POR_THREAD;

        boolean restoArquivos = (filesAvaliacao.length % FILES_POR_THREAD) != 0;
        if (restoArquivos) {
            totalThreads++;
        }

        labelTotal.setText("" + totalThreads);

        int from = 0;
        int to = 0;
        // Criar as sublista dos files selecionados em 1000 arquivos por array
        for (int i = 0; i < totalThreads; i++) {
            boolean ultimaIteracao = (i == (totalThreads - 1));
            if (ultimaIteracao && restoArquivos) {
                from = to;
                to = filesAvaliacao.length;
            } else {
                from = i * FILES_POR_THREAD;
                to = from + FILES_POR_THREAD;
            }

            File[] copyOfRange = Arrays.copyOfRange(filesAvaliacao, from, to);
            filesThread.add(copyOfRange);
        }

        return filesThread;
    }

    private List<AtividadeResolucao> getAtividades() {
        if (atividades == null) {
            try {
                atividades = daof.getResolucaoDAO().getAllAtividadeResolucao(resolucao.getId());
            } catch (Exception e) {
                showMenssagem("Erro ao selecionar as atividades da resolução " + resolucao.toString());
                disable(buttonAvaliar);
            }
        }
        return atividades;
    }

    /**
     * Criar a thread para processar a avaliação a partir dos arquivos
     *
     * @param id
     * @param files
     */
    private void startThreadAvaliacao(int id, File[] files, List<AtividadeResolucao> atividades) {
        new Thread(new ThreadAvaliacao(id, files, atividades, ControllerViewAvaliacao.this)).start();
    }

    int avaliacoesRealizadas = 0;

    @Override
    public void avaliacaoRealizada(Avaliacao avaliacao) {
        synchronized (this) {
            addItemTable(avaliacao);
            avaliacoesRealizadas++;
        }
    }

    /**
     * Adicionar a avalição realizada pela thread na tabela
     *
     * @param avaliacao realizada pela thread
     */
    public void addItemTable(Avaliacao avaliacao) {
        tableModel.insertRow(0, new Object[]{avaliacao.getProfessor(), avaliacao.getDepartamento(), avaliacao.getTotal()});
    }

    @Override
    public void iniciada(int id) {
        synchronized (this) {
            updateLabelThread(1, 0);
        }
    }

    @Override
    public void finalizada(int id) {
        synchronized (this) {
            updateLabelThread(-1, 1);

            if (totalFinalizadas == totalThreads) {
                enable(buttonSelecionarArquivos);
            }
        }
    }

    private void updateLabelThread(int rodando, int finalizadas) {
        totalRodando += rodando;
        labelRodando.setText("" + totalRodando);

        totalFinalizadas += finalizadas;
        labelFinalizadas.setText("" + totalFinalizadas);
    }

    /**
     * Reiniciar os valores das variaves e dos componentes da view
     */
    private void reset() {
        labelFinalizadas.setText("0");
        labelRodando.setText("0");
        labelTotal.setText("0");

        clearTable();

        totalFinalizadas = 0;
        totalRodando = 0;
        totalThreads = 0;

    }

    /**
     * Remover todas as linhas da tabela
     */
    private void clearTable() {
        while (!(tableModel.getRowCount() == 0)) {
            tableModel.removeRow(0);
        }
    }

    private void showMenssagem(String menssagem) {
        JOptionPane.showMessageDialog(view, menssagem);
    }

    private void enable(JComponent component) {
        component.setEnabled(true);
    }

    private void disable(JComponent component) {
        component.setEnabled(false);
    }
}
