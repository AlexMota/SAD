package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class AtividadeRealizada {

    private int id;
    private int peso;

    public AtividadeRealizada(int id, int peso) {
        this.id = id;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
