/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author Alexandre Mota
 * Classe principal do gerador.
 * Insira no parametro do método a quantidade
 * de registros a serem gerados
 */
public class Principal {
    
    public static void main(String[] args) {
        
        GeradorAvaliacao geraAval = new GeradorAvaliacao();
        
        geraAval.gerarJsonAvaliacao(10000);
        System.out.println("Gerado!");
    }
    
}
