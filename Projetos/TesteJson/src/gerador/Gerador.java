/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunoinf
 */
public class Gerador {

    private ArrayList<String> departamentos;
    private ArrayList<String> nomesProfessores;
    private int quantAtividades;
    private int pesoMaximo;

    public Gerador() {
        Gson gson = new Gson();
        quantAtividades = 10;
        pesoMaximo = 20;
        BufferedReader bufferedReader1 = null;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader1 = new BufferedReader(new FileReader("departamentos.json"));
            bufferedReader2 = new BufferedReader(new FileReader("professores.json"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gerador.class.getName()).log(Level.SEVERE, null, ex);
        }
        departamentos = gson.fromJson(bufferedReader1, new TypeToken<List<String>>() {
        }.getType());

        nomesProfessores = gson.fromJson(bufferedReader2, new TypeToken<List<String>>() {
        }.getType());
    }

    public String geradorNomeProf() {

        Random random = new Random();
        int limite = nomesProfessores.size();
        int indiceSorteado = random.nextInt(limite);

        return nomesProfessores.get(indiceSorteado);
        
    }

    public String geradorDepartamento() {

        Random random = new Random();
        int limite = departamentos.size();
        int indiceSorteado = random.nextInt(limite);

        return departamentos.get(indiceSorteado);
        
    }

    public int geradorId() {

        Random random = new Random();
        int idAtividade = 1 + random.nextInt(quantAtividades);

        return idAtividade;
    }

    public int geradorPeso() {

        Random random = new Random();
        int peso = 1 + random.nextInt(pesoMaximo);

        return peso;
    }
}
