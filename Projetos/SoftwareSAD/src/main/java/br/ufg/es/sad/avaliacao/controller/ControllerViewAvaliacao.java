package br.ufg.es.sad.avaliacao.controller;

import br.ufg.es.sad.avaliacao.model.Avaliacao;
import br.ufg.es.sad.avaliacao.model.ThreadListener;
import br.ufg.es.sad.avaliacao.model.ComboBoxAdapter;
import br.ufg.es.sad.avaliacao.model.ThreadAvaliacao;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.ufg.es.sad.avaliacao.view.ViewAvaliacao;
import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

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

    // 
    DefaultTableModel tableModel;

    // Persistence
    DAOFactory daof;

    // Resolucação selecionada
    Resolucao resolucao;

    // Lista de atividades da resolução
    List<Atividade> atividades;

    File[] filesAvaliacao;

    private static final int FILES_POR_THREAD = 1000;

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
        buttonAvaliar.setEnabled(false);
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
                            comboBoxResolucao.setEnabled(true);
                        } else {
                            comboBoxResolucao.setEnabled(false);
                        }

                    } else {
                        System.err.println("Diretório inválido");
                    }
                }
            }
        });

        buttonAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTable();
                iniciarAvaliacao();
            }
        });

        comboBoxResolucao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    resolucao = (Resolucao) ie.getItem();

                    // após selecionar a resolução habilitar botão da avaliação
                    buttonAvaliar.setEnabled(true);
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
            System.err.println("Erro ao selecionar as resoluções");
        }
        comboBoxResolucao.setModel(new ComboBoxAdapter(resolucoes));
    }

    /**
     * Criar as threads de avaliação Quebra a lista de arquivos em arrays
     * contendo 1000 arquivos.
     */
    private void iniciarAvaliacao() {
        buttonSelecionarArquivos.setEnabled(false);

        // Verificando os arquivos do diretório selecionado
        if (filesAvaliacao.length > 0) {
            totalThreads = filesAvaliacao.length / FILES_POR_THREAD;
            labelTotal.setText("" + totalThreads);

            // Criar as sublista dos files selecionados em 1000 arquivos por array
            for (int i = 0; i < totalThreads; i++) {
                int from = i * FILES_POR_THREAD;
                int to = from + FILES_POR_THREAD;
                File[] copyOfRange = Arrays.copyOfRange(filesAvaliacao, from, to);

                startThreadAvaliacao(i, copyOfRange, getAtividades());
            }
        } else {
            System.err.println("Diretório não contem arquivos para avaliação");
        }

    }

    private List<Atividade> getAtividades() {
        if (atividades == null) {
            try {
                atividades = daof.getResolucaoDAO().getAllAtividades(resolucao);
            } catch (Exception e) {
                System.err.println("Erro ao selecionar as atividades da resolução " + resolucao.toString() + e.getMessage());
            }
            System.out.println(atividades);
        }
        return atividades;
    }

    /**
     * Criar a thread para processar a avaliação a partir dos arquivos
     *
     * @param id
     * @param files
     */
    private void startThreadAvaliacao(int id, File[] files, List<Atividade> atividades) {
        new Thread(new ThreadAvaliacao(id, files, atividades, ControllerViewAvaliacao.this)).start();
    }

    @Override
    public void avaliacaoRealizada(Avaliacao avaliacao) {
        addItemTable(avaliacao);
    }

    public synchronized void addItemTable(Avaliacao avaliacao) {
        tableModel.insertRow(0, new Object[]{avaliacao.getProfessor(), avaliacao.getDepartamento(), avaliacao.getTotal()});
    }

    @Override
    public void iniciada(int id) {
        updateLabelThread(1, 0);
    }

    @Override
    public void finalizada(int id) {
        updateLabelThread(-1, 1);

        if (totalFinalizadas == totalThreads) {
            buttonSelecionarArquivos.setEnabled(true);
        }
    }

    private synchronized void updateLabelThread(int rodando, int finalizadas) {
        totalRodando += rodando;
        labelRodando.setText("" + totalRodando);

        totalFinalizadas += finalizadas;
        labelFinalizadas.setText("" + totalFinalizadas);
    }

    /**
     * Remover todas as linhas da tabela
     */
    private void clearTable() {
        while (!(tableModel.getRowCount() == 0)) {
            tableModel.removeRow(0);
        }
    }

}
