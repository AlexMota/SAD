package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ThreadAvaliacao implements Runnable {

    AvaliacaoListener avaliacaoListener;

    public ThreadAvaliacao(AvaliacaoListener avaliacaoListener) {
        this.avaliacaoListener = avaliacaoListener;
    }

    @Override
    public void run() {
        int i = 1;
        while (i < 100) {
            // enviar a avaliação que acabou de ser realizada
            avaliacaoListener.avaliacaoFinalizada(new Avaliacao());
        }
    }

}
