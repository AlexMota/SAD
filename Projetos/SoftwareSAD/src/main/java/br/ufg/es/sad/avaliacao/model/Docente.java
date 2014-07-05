/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Alexandre
 */
public class Docente {
    
    private String nome;
    private String departamento;
    private int id;

    public Docente(String nome, String departamento, int id) {
        this.nome = nome;
        this.departamento = departamento;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
