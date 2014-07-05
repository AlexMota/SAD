/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leitor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gerador.ArquivoAvaliacao;
import gerador.AtividadeRealizada;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class LeitorAvaliacao {

    ArrayList<ArquivoAvaliacao> avaliacoes;
    Gson gson;

    public LeitorAvaliacao() {
        this.gson = new Gson();
        avaliacoes = new ArrayList<>();
    }

    public void lerJsonAvaliacao(int quantRegistros) {
        BufferedReader bufferedReader;
        int cont;
        ArquivoAvaliacao aval;
        for (int i = 0; i < quantRegistros; i++) {

            cont = i + 1;
            try {
                bufferedReader = new BufferedReader(new FileReader("json_files/avaliacoes/avaliacao_" + cont + ".json"));
                //avaliacoes = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Avaliacao>>() {}.getType());
                aval = gson.fromJson(bufferedReader, ArquivoAvaliacao.class);
                avaliacoes.add(aval);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LeitorAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Leitura completada!");

    }

    public void imprimirAvaliacoes() {
        ArrayList<AtividadeRealizada> atividades;
        for (ArquivoAvaliacao avaliacao : avaliacoes) {
            System.out.println("###################################");
            System.out.println("Professor: " + avaliacao.getDocente().getNome());
            System.out.println("Departamento: " + avaliacao.getDocente().getDepartamento());
            System.out.println("ID: " + avaliacao.getDocente().getId());

            atividades = avaliacao.getAtividades();

            for (AtividadeRealizada atividade : atividades) {
                System.out.println("Id: " + atividade.getId() + " Peso: " + atividade.getPeso());
            }
        }
    }

    public void imprimirNumeroRegistros() {
        System.out.println("Numero de registros: " + avaliacoes.size());
    }

}
