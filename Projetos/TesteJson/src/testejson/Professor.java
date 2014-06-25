/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testejson;

import java.util.List;

/**
 *
 * @author alunoinf
 */
public class Professor {
    
    private String nome;
    private String departamento;
    private List<Atividade> atividades;

    public Professor(String nome, String departamento, List<Atividade> atividades) {
        this.nome = nome;
        this.departamento = departamento;
        this.atividades = atividades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
}
