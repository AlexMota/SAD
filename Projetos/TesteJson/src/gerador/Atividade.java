/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author alunoinf
 */
public class Atividade {

    private int id;
    private int peso;

    public Atividade(int id, int peso) {
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
