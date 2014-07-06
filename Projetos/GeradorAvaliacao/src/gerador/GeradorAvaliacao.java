/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre Mota
 * Clase geradora de lotes de arquivos referentes as avaliacoes.
 */
public class GeradorAvaliacao {

    Gson gson;

    public GeradorAvaliacao() {
        gson = new Gson();
    }

    public void gerarJsonAvaliacao(int quantRegistros) {
        String textoJsonAval;
        Gerador gerador;
        FileWriter fileWriter = null;
        int cont;
        ArquivoAvaliacao aval;
        Docente docente;
        gerador = new Gerador();

        for (int i = 0; i < quantRegistros; i++) {
            cont = i + 1;
            docente = new Docente(gerador.geradorNomeProf(), gerador.geradorDepartamento(), cont);
            aval = new ArquivoAvaliacao(docente, gerador.geradorAtividades());//Cria uma avaliação, que possui o registro de N docentes

            textoJsonAval = gson.toJson(aval);//tranforma o objeto em string Json
            try {

                fileWriter = new FileWriter("json_files/avaliacoes/avaliacao_" + cont + ".json");
                fileWriter.write(textoJsonAval);
                fileWriter.close();

            } catch (Exception e) {

            }

        }

    }

}
