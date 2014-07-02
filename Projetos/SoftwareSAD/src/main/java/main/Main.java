package main;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.*;
import java.util.List;

/**
 *
 * @author phelipe
 */
public class Main {

    public static void main(String[] args) {

        TesteResolucao.InserirResolucaoUfgCompleta();

        selecionarTodosGruposRaiz();

        selecionarAtividadeDaResolucao();
    }

    /**
     * Selecionar todos grupos Raiz, que nao tem
     */
    public static void selecionarTodosGruposRaiz() {

        DAOFactory daof = DAOFactory.getFactory();
        List<Grupo> grupos = daof.getGrupoDAO().getGruposRaiz();
        for (Grupo grupo : grupos) {
            System.err.println(grupo.toString());
        }
    }

    /**
     * Selecionar todas as atividades da resolução x
     */
    public static void selecionarAtividadeDaResolucao() {
        DAOFactory daof = DAOFactory.getFactory();
        Resolucao resolucao = daof.getResolucaoDAO().getAll().get(0);

        List<Atividade> atividades = daof.getResolucaoDAO().getAllAtividades(resolucao);
        for (Atividade atividade : atividades) {
            System.err.println(atividade.toString());
        }
    }

    /**
     * Testando todos os cruds.
     * <br>
     * Criando uma resolução
     * <br>
     * Adicionando os grupos e atividades a essa resoluçao
     * <br>
     * Salvandos todas as atividades</p>
     */
    public static void TesteBasicoCadastro() {

        DAOFactory daof = DAOFactory.getFactory();

        // Criando a resolução
        Resolucao resolucao = new Resolucao("Resolução 2014");
        daof.getResolucaoDAO().save(resolucao);
        System.out.println(resolucao.toString());

        // Atividade sem grupo da resoluçao
        Atividade atividade_0 = new Atividade("Atividade sem grupo da resolução " + resolucao.getNome(), resolucao, 20);
        daof.getAtividadeDAO().save(atividade_0);

        // Grupo raiz sem grupo pai
        Grupo grupo0 = new Grupo(resolucao, "II - PRODUÇÃO INTELECTUAL");

        // Criando o grupo1 que é subgrupo do grupo0 e adicionado esse grupo nas atividades 
        Grupo grupo1 = new Grupo(resolucao, grupo0, "Artigo completo ou texto literário publicado em periódico");
        Atividade atividade1 = new Atividade("Com classificação no Qualis/CAPES", resolucao, grupo1, 20);
        Atividade atividade2 = new Atividade("Não sujeito à classificação no Qualis/CAPES", resolucao, grupo1, 10);

        //  Criando o grupo2 que é subgrupo do grupo0 e adicionando uma atividade
        Grupo grupo2 = new Grupo(resolucao, grupo0, "II -1 Produção Científica");
        grupo2.addAtividade(new Atividade("Resumo de artigo em periódicos especializados nacional ou internacional com corpo editorial", resolucao, 5));

        //Salvando os grupos
        daof.getGrupoDAO().save(grupo2);

        // Salvando as atividades
        daof.getAtividadeDAO().save(atividade1);
        daof.getAtividadeDAO().save(atividade2);
    }

}
