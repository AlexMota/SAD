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
import java.util.ArrayList;
import java.util.List;
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
                
            }
        });
        
        buttonAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarThreads();
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

    private void criarThreads() {
        int total = 10;        
        labelTotal.setText(""+total);
        
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadAvaliacao(i, ControllerViewAvaliacao.this)).start();
        }
    }

    public void avaliacaoRealizada(Avaliacao avaliacao) {
        addItemTable(avaliacao);
    }

    public synchronized void addItemTable(Avaliacao avaliacao) {
        tableModel.insertRow(0, new Object[]{avaliacao.getProfessor(), avaliacao.getDepartamento(), avaliacao.getTotal()});
    }

    public void iniciada(int id) {
        updateLabelThread(1, 0);
    }

    public void finalizada(int id) {
        updateLabelThread(-1, 1);
    }

    private synchronized void updateLabelThread(int rodando, int finalizadas) {
        totalRodando += rodando;
        labelRodando.setText("" + totalRodando);
        
        totalFinalizadas += finalizadas;
        labelFinalizadas.setText(""+totalFinalizadas);
    }

}
