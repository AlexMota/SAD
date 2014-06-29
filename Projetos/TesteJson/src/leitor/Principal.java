/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leitor;

/**
 *
 * @author Alexandre
 */
public class Principal {
    
    public static void main(String[] args) {
        LeitorAvaliacao leitorAvaliacao = new LeitorAvaliacao();
        
        leitorAvaliacao.lerJsonAvaliacao();
        leitorAvaliacao.imprimirNumeroRegistros();
        leitorAvaliacao.imprimirAvaliacoes();
    }
    
}
