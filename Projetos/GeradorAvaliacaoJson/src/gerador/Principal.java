/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author alunoinf
 */
public class Principal {
    
    public static void main(String[] args) {
        
        GeradorAvaliacao geraAval = new GeradorAvaliacao();
        
        geraAval.gerarJsonAvaliacao(10000);
        System.out.println("Gerado!");
    }
    
}
