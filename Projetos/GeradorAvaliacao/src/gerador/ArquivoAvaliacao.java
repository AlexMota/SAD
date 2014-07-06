/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import java.util.ArrayList;

/**
 *
 * @author Alexandre Mota
 * Classe referente a estrutura básica do arquivo Json
 * Conteudo: um docente e as atividades realizadas;
 */
public class ArquivoAvaliacao {
    
    Docente docente;
    ArrayList<AtividadeRealizada> atividades;

    public ArquivoAvaliacao(Docente docente, ArrayList<AtividadeRealizada> atividades) {
        this.docente = docente;
        this.atividades = atividades;
    }

    
    
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public ArrayList<AtividadeRealizada> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<AtividadeRealizada> atividades) {
        this.atividades = atividades;
    }
    
}
