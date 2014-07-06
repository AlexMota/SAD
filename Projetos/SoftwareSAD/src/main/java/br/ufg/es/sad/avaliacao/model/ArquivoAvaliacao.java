package br.ufg.es.sad.avaliacao.model;

import java.util.ArrayList;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
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
