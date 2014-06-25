/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testejson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Soundbank;

/**
 *
 * @author alunoinf
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        
        ArrayList<Atividade> atividades = new ArrayList<Atividade>();
        atividades.add(new Atividade(1,4));
        atividades.add(new Atividade(2,5));
        atividades.add(new Atividade(3,2));
        atividades.add(new Atividade(4,6));
        atividades.add(new Atividade(5,2));
        
        Professor professor = new Professor("Marcelo Quinta"," INF", atividades);
        Professor professor2 = new Professor("Laerte","NASA", atividades);
        Professor professor3 = new Professor("Alexandre"," INF", atividades);
           
        List<Professor> professores = new ArrayList<Professor>();
        professores.add(professor);
        professores.add(professor2);
        professores.add(professor3);  
        
        Gson gson = new Gson();
        
        String textoJson = gson.toJson(professores);

        //System.out.println(textoJson);
        
        try {
            
            FileWriter fileWriter = new FileWriter("avaliacao.json");
            fileWriter.write(textoJson);
            fileWriter.close();
           
            
        } catch (Exception e) {
        }
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("avaliacao.json"));
            List<Professor> prof2 = gson.fromJson(bufferedReader, new TypeToken<List<Professor>>(){}.getType());
            for (Professor prof : prof2) {
                System.err.println(prof.getNome());                               
            }
            //System.out.println(prof2.toString());
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
}
