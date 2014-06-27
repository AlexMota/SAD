/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testejson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gerador.Gerador;
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
        //Gerador<Professor> grador = new Gerador<Professor>();
        //gerador.

        
                ArrayList<String> profs = new ArrayList<>();
        profs.add("Marcelo");
        profs.add("Pedro");
        profs.add("Auri");
        profs.add("Ingrid");
        profs.add("Maria");
        profs.add("Fernanda");
        
//        ArrayList<String> deps = new ArrayList<>();
//        deps.add("FEF");
//        deps.add("ICB");
//        deps.add("INF");
//        deps.add("IQ");
//        deps.add("IF");
//        deps.add("FIC");
        
        //Departamento dep1 = new Departamento();
        //dep1.setNome("FEF");
        //Departamento dep2 = new Departamento();
        //dep2.setNome("INF");
        //Departamento dep3 = new Departamento();
        //dep3.setNome("IQ");
        //Departamento dep4 = new Departamento();
        //dep4.setNome("IF");
        //Departamento dep5 = new Departamento();
        //dep5.setNome("ICB");
        //Departamento dep6 = new Departamento();
        //dep6.setNome("IQ");


//
//        deps.add(dep1);
//        deps.add(dep2);
//        deps.add(dep3);
//        deps.add(dep4);
//        deps.add(dep5);
//        deps.add(dep6);
        
        
        Gson gson = new Gson();

        String textoJson = gson.toJson(profs);

        //System.out.println(deps);

        try {

            FileWriter fileWriter = new FileWriter("professores.json");
            fileWriter.write(textoJson);
            fileWriter.close();


        } catch (Exception e) {
        }
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("avaliacao.json"));
//            List<Professor> prof2 = gson.fromJson(bufferedReader, new TypeToken<List<Professor>>() {
//            }.getType());
//            for (Professor prof : prof2) {
//                System.err.println(prof.getNome());
//            }
//            //System.out.println(prof2.toString());
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

    }
}
