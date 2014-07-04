package br.ufg.es.sad.avaliacao.model;

import br.ufg.es.sad.entity.Resolucao;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ComboBoxAdapter extends AbstractListModel<Resolucao> implements ComboBoxModel<Resolucao> {

    List<Resolucao> resolucoes;

    Resolucao selection = null;

    public ComboBoxAdapter(List<Resolucao> resolucoes) {
        this.resolucoes = resolucoes;
    }

    @Override
    public int getSize() {
        return resolucoes.size();
    }

    @Override
    public Resolucao getElementAt(int index) {
        return resolucoes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (Resolucao) anItem;
    }

    @Override
    public Resolucao getSelectedItem() {
        return selection;
    }

}
