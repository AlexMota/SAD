package br.ufg.es.sad.avaliacao.model;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
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
    List<Atividade> atividades;
    Gson gson;

    public ThreadAvaliacao(int id, File[] files, List<Atividade> atividades, ThreadListener threadListener) {
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
         ArquivoAvaliacao arqAval;
         ArrayList<AtividadeRealizada> atividadesRealizadas;
         double somaValores;
        for (int i = 0; i < files.length; i++) {
            somaValores = 0;
            try {
                bufferedReader = new BufferedReader(new FileReader(files[i].toString()));
                arqAval = gson.fromJson(bufferedReader, ArquivoAvaliacao.class);
                atividadesRealizadas = arqAval.getAtividades();
                for (AtividadeRealizada ativRealiz : atividadesRealizadas) {
                    
                    for (Atividade atividade : atividades) {
                        
                        if (ativRealiz.getId() == atividade.getId()) {
                            somaValores += ativRealiz.getPeso();
                            break;
                        }
                    }
                    
                }
             threadListener.avaliacaoRealizada(new Avaliacao(arqAval.getDocente().getNome(), arqAval.getDocente().getDepartamento(), somaValores));
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThreadAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //int i = 1;
        //while (i < 2000) {
            // Processar a avaliação e 
            // ......
            // ......
            // Enviar a avaliação que acabou de ser realizada
            //threadListener.avaliacaoRealizada(new Avaliacao("Professor " + id, "departamento " + id, 1280));

            //i++;
            // ir para a proxima avaliação
        //}

        // notificacar que a thread finalizou sua execução
        threadListener.finalizada(id);
    }

}
