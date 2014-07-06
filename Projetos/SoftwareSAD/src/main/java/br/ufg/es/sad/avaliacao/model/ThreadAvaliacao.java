package br.ufg.es.sad.avaliacao.model;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.AtividadeResolucao;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 03/07/2014
 * @serial 0.1
 */
public class ThreadAvaliacao implements Runnable {

    int id;

    ThreadListener threadListener;
    File[] files;
    List<AtividadeResolucao> atividades;
    Gson gson;

    public ThreadAvaliacao(int id, File[] files, List<AtividadeResolucao> atividades, ThreadListener threadListener) {
        this.id = id;
        this.files = files;
        this.atividades = atividades;
        this.threadListener = threadListener;
        gson = new Gson();

    }

    @Override
    public void run() {
        // notificacar que a thread iniciou sua execução
        threadListener.iniciada(id);
        BufferedReader bufferedReader;
        ArquivoAvaliacao arquivoAvaliacao;
        ArrayList<AtividadeRealizada> atividadesRealizadas;
        double somaValores;
        for (File file : files) {
            somaValores = 0;
            try {
                // ler aquivo
                bufferedReader = new BufferedReader(new FileReader(file.toString()));
                // converter arquivo em objeto ArquivoAvaliacao.class
                arquivoAvaliacao = gson.fromJson(bufferedReader, ArquivoAvaliacao.class);
                // atividades do arquivo
                atividadesRealizadas = arquivoAvaliacao.getAtividades();
                for (AtividadeRealizada ativRealiz : atividadesRealizadas) {

                    for (AtividadeResolucao atr : atividades) {
                        if (ativRealiz.getId() == atr.getAtividade().getId()) {
                            somaValores += atr.getValor() * ativRealiz.getPeso();
                            break;
                        }
                    }

                }
                threadListener.avaliacaoRealizada(new Avaliacao(arquivoAvaliacao.getDocente().getNome(), arquivoAvaliacao.getDocente().getDepartamento(), somaValores));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThreadAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        threadListener.finalizada(id);
    }

}
