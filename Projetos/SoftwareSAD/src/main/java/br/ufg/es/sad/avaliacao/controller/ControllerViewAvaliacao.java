package br.ufg.es.sad.avaliacao.controller;

import br.ufg.es.sad.avaliacao.model.Avaliacao;
import br.ufg.es.sad.avaliacao.model.AvaliacaoListener;
import br.ufg.es.sad.avaliacao.model.ComboBoxAdapter;
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
import java.util.List;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ControllerViewAvaliacao implements AvaliacaoListener {

    // View
    ViewAvaliacao view;
    JTable tableResultado;
    JButton buttonAvaliar;
    JComboBox comboBoxResolucao;

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
        comboBoxResolucao = view.getComboBoxResolucao();
        tableResultado = view.getTableResolucao();
        tableModel = (DefaultTableModel) tableResultado.getModel();

        buttonAvaliar = view.getButtonAvaliar();
        buttonAvaliar.setEnabled(false);
    }

    int i = 1;

    private void initListeners() {
        buttonAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableModel.insertRow(0, new Object[]{("Linha" + (i++))});
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
        List<Resolucao> resolucoes = daof.getResolucaoDAO().getAll();
        comboBoxResolucao.setModel(new ComboBoxAdapter(resolucoes));
    }

    public void avaliacaoFinalizada(Avaliacao avaliacao) {
        addItemTable(avaliacao);
    }

    public synchronized void addItemTable(Avaliacao avaliacao) {
        tableModel.insertRow(0, new Object[]{(avaliacao.toString())});
    }

}
