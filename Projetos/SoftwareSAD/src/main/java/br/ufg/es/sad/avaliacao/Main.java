package br.ufg.es.sad.avaliacao;

import br.ufg.es.sad.avaliacao.controller.ControllerViewAvaliacao;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerViewAvaliacao controllerView = new ControllerViewAvaliacao();
        controllerView.showView();
    }

}
