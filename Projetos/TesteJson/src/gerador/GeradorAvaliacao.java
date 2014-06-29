/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author alunoinf
 */
public class GeradorAvaliacao {
    Gerador gerador;
    Gson gson;
    ArrayList<Avaliacao> avaliacoes;
    
    
    public GeradorAvaliacao() {
        avaliacoes = new ArrayList<>();
        gerador = new Gerador();
        gson = new Gson();
    }
    
    
    public void gerarJsonAvaliacao(int quantRegistros){
    
        for (int i = 0; i < quantRegistros; i++) {
            Avaliacao aval = new Avaliacao();//Cria uma avaliação, que possui o registro de N docentes
            aval.setProfessor(gerador.geradorNomeProf());//Gera o nome do professor
            aval.setDepartamento(gerador.geradorDepartamento());//Gera um departamento
            aval.setAtividades(gerador.geradorAtividades());//Gera as atividades que ele realizou
            avaliacoes.add(aval);
        }
    
        String textoJsonAval = gson.toJson(avaliacoes);
        
                try {
            
            FileWriter fileWriter = new FileWriter("json_files/avaliacoes.json");
            fileWriter.write(textoJsonAval);
            fileWriter.close();
           
            
        } catch (Exception e) {
            
        }
        
    }
    
}
