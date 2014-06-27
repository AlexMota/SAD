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
    Gerador gerador = new Gerador();
    Gson gson = new Gson();
    ArrayList<Avaliacao> avaliacoes;
    
    
    public GeradorAvaliacao() {
        avaliacoes = new ArrayList<>();
    
    }
    
    
    public void gerarJsonAvaliacao(){
    
        for (int i = 0; i < 100; i++) {
            Avaliacao aval = new Avaliacao();
            aval.setProfessor(gerador.geradorNomeProf());
            aval.setDepartamento(gerador.geradorDepartamento());
            ArrayList<Atividade> atividades = new ArrayList<>();
            atividades.add(new Atividade(gerador.geradorId(), gerador.geradorPeso()));
            atividades.add(new Atividade(gerador.geradorId(), gerador.geradorPeso()));
            atividades.add(new Atividade(gerador.geradorId(), gerador.geradorPeso()));
            aval.setAtividades(atividades);;
            avaliacoes.add(aval);
        }
    
        String textoJsonAval = gson.toJson(avaliacoes);
        
                try {
            
            FileWriter fileWriter = new FileWriter("avaliacoes.json");
            fileWriter.write(textoJsonAval);
            fileWriter.close();
           
            
        } catch (Exception e) {
        }
        
    }
    
}
