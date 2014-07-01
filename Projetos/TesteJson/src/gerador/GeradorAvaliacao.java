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
 * @author alunoinf
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
        Avaliacao aval;

        for (int i = 0; i < quantRegistros; i++) {
            gerador = new Gerador();
            aval = new Avaliacao();//Cria uma avaliação, que possui o registro de N docentes
            aval.setProfessor(gerador.geradorNomeProf());//Gera o nome do professor
            aval.setDepartamento(gerador.geradorDepartamento());//Gera um departamento
            aval.setAtividades(gerador.geradorAtividades());//Gera as atividades que ele realizou
            cont = i + 1;
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
