package br.ufg.es.sad.avaliacao.model;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class Avaliacao {

    Integer id;
    String professor;
    String departamento;
    Double total;

    public Avaliacao(Integer id, String professor, String departamento, double total) {
        this.id = id;
        this.professor = professor;
        this.departamento = departamento;
        this.total = total;
    }

    public Avaliacao(String professor, String departamento) {
        this.professor = professor;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addTotal(double valor) {
        total += valor;
    }

    @Override
    public String toString() {
        return "Avaliação";
    }

}
