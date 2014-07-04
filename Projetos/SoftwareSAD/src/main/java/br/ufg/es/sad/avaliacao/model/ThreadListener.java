package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public interface ThreadListener {

    /**
     * Quando a thread iniciar ela notifica que iniciou sua execuçao no run()
     *
     * @param id identificador da thread
     */
    void iniciada(int id);

    /**
     * Ao finalizar ela notifica que finalizou sua execução
     *
     * @param id identificador da thread
     */
    void finalizada(int id);

    /**
     * Ao finalizar uma avaliação a thread envia a notificação avaliada
     *
     * @param avaliacao
     */
    void avaliacaoRealizada(Avaliacao avaliacao);
}
