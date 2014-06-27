/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import java.util.ArrayList;

/**
 *
 * @author alunoinf
 */
public class Avaliacao {
    
    String professor;
    String departamento;
    ArrayList<Atividade> atividades;

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    
    
}
