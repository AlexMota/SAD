/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author alunoinf
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
