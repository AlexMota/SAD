package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ThreadAvaliacao implements Runnable {

    int id;

    ThreadListener threadListener;

    public ThreadAvaliacao(int id, ThreadListener threadListener) {
        this.id = id;
        this.threadListener = threadListener;
    }

    @Override
    public void run() {
        // notificacar que a thread iniciou sua execução
        threadListener.iniciada(id);

        int i = 1;
        while (i < 2000) {
            // Processar a avaliação e 
            // ......
            // ......
            // Enviar a avaliação que acabou de ser realizada
            threadListener.avaliacaoRealizada(new Avaliacao("Professor " + id, "departamento " + id, 1280));

            i++;
            // ir para a proxima avaliação
        }

        // notificacar que a thread finalizou sua execução
        threadListener.finalizada(id);
    }

}
