package main;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Criar uma resoluçao completa, com com grupos e atividades. <br>
 * Resoluçao base:
 * http://www.adufg.org.br/dados/editor3/file/Resolucao_CONSUNI_2013_0032.pdf
 *
 * @author Paulo Henrique
 * @since 02/07/2014
 * @version 0.1
 */
public class TesteResolucao {

    public static void main(String[] args) {
        // Lista com as atividades
        List<Atividade> atividades = new ArrayList<Atividade>();

        // Criando a resolução
        Resolucao resolucao = new Resolucao("Resolução 32/2013");

        //Criando grupos pai
        Grupo grupo1 = new Grupo(resolucao, "I – ATIVIDADES DE ENSINO");
        Grupo grupo2 = new Grupo(resolucao, "II - PRODUÇÃO INTELECTUAL");
        Grupo grupo3 = new Grupo(resolucao, "III – ATIVIDADES DE PESQUISA E EXTENSÃO");
        Grupo grupo4 = new Grupo(resolucao, "IV - ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÇÃO");
        Grupo grupo5 = new Grupo(resolucao, "V - OUTRAS ATIVIDADES");

        //Criando e adicionando subgrupos
        //subgrupos do grupo 1
        Grupo subGrupo1_1 = new Grupo(resolucao, grupo1, "I -1 Graduação");
        Grupo subGrupo1_2 = new Grupo(resolucao, grupo1, "I -2 Pós-Graduação stricto e lato sensu");

        //subgrupos grupo 2
        Grupo subGrupo2_1 = new Grupo(resolucao, grupo2, "II -1 Produção Científica");
        Grupo subGrupo2_2 = new Grupo(resolucao, grupo2, "II - 2 Produção Artística e Cultural ");
        Grupo subGrupo2_3 = new Grupo(resolucao, grupo2, "II - 3 Produção Técnica e Tecnológica");
        Grupo subGrupo2_4 = new Grupo(resolucao, grupo2, "II - 4 Outro Tipo de Produção");

        //subrgrupos grupo 3
        Grupo subGrupo3_1 = new Grupo(resolucao, grupo3, "III -1 Atividades de Coordenação de Pesquisa");
        Grupo subGrupo3_2 = new Grupo(resolucao, grupo3, "III - 2 Atividades de Extensão");

        //subgrupos grupo 4
        Grupo subGrupo4_1 = new Grupo(resolucao, grupo4, "IV – 1 Direção e Função Gratificada ");
        Grupo subGrupo4_2 = new Grupo(resolucao, grupo4, "IV – 2 Atividades Administrativas ");
        Grupo subGrupo4_3 = new Grupo(resolucao, grupo4, "IV – 3 Outras Atividades Administrativas");
        Grupo subGrupo4_4 = new Grupo(resolucao, grupo4, "IV – 4 Atividades de Representação Fora da UFG");

        //subgrupos grupo 5
        Grupo subGrupo5_1 = new Grupo(resolucao, grupo5, "V - 1 Atividades Acadêmicas - Orientação");
        Grupo subGrupo5_2 = new Grupo(resolucao, grupo5, "V - 2 Atividades Acadêmicas – Bancas e Cursos");
        Grupo subGrupo5_3 = new Grupo(resolucao, grupo5, "V - 3 Atividades de Aprendizado e Aperfeiçoamento");

        //atividades subgrupo 1_1
        atividades.add(new Atividade("Aulas presenciais na graduação*", resolucao, subGrupo1_1, 10));
        atividades.add(new Atividade("Aulas do ensino a distância na graduação", resolucao, subGrupo1_1, 10));
        //atividades subgrupo 1_2
        atividades.add(new Atividade("Aulas presenciais na pós-graduação", resolucao, subGrupo1_2, 10));
        atividades.add(new Atividade("Aulas do ensino a distância na pós-graduação", resolucao, subGrupo1_2, 10));

        //atividades subgrupo 2_1
        atividades.add(new Atividade("Artigo completo ou texto literário publicado em periódico Com classificação no Qualis/CAPES", resolucao, subGrupo2_1, 20));
        atividades.add(new Atividade("Artigo completo ou texto literário publicado em periódico Não sujeito à classificação no Qualis/CAPES ", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Resumo de artigo em periódicos especializados nacional ou internacional com corpo editorial", resolucao, subGrupo2_1, 5));
        atividades.add(new Atividade("Artigos ou textos literários em repositórios de publicação eletrônica ligados a editoras ou universidades (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Resumo expandido publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso Internacional ", resolucao, subGrupo2_1, 8));
        atividades.add(new Atividade("Resumo expandido publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso Nacional ", resolucao, subGrupo2_1, 6));
        atividades.add(new Atividade("Resumo expandido publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso Regional ou Local  ", resolucao, subGrupo2_1, 4));
        atividades.add(new Atividade("Resumo simples publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso  Internacional ", resolucao, subGrupo2_1, 4));
        atividades.add(new Atividade("Resumo simples publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso  Nacional ", resolucao, subGrupo2_1, 3));
        atividades.add(new Atividade("Resumo simples publicado em anais (total máximo a ser considerado neste item são 10 pontos) de congresso  Regional ou Local ", resolucao, subGrupo2_1, 2));
        atividades.add(new Atividade("Trabalho completo publicado em anais de congresso cientificoTrabalho completo publicado em anais de congresso cientifico", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Editor ou Coordenador editorial de livro publicado com selo de editora que possua corpo editorial", resolucao, subGrupo2_1, 20));
        atividades.add(new Atividade("Livro publicado com selo de editora que possua corpo editorial ", resolucao, subGrupo2_1, 40));
        atividades.add(new Atividade("Livro publicado com selo de editora que não possua corpo editorial ", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Capítulo de livro publicado com selo de editora que possua corpo editorial (total máximo a ser considerado neste item são 40 pontos)", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Edição ou organização de livro (coletânea) publicado com selo de editora que possua corpo editorial", resolucao, subGrupo2_1, 12));
        atividades.add(new Atividade("Capítulo traduzido de livro publicado com selo de editora que possua corpo editorial (total máximo a ser considerado neste item são 20 pontos)", resolucao, subGrupo2_1, 5));
        atividades.add(new Atividade("Tradução ou revisão científica de livro traduzido e publicado com selo de editora que possua corpo editorial", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Resenhas, prefácios ou verbetes ", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Livro didático desenvolvido para projetos institucionais/governamentais  ", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Editor de periódicos especializados indexados com corpo editorial", resolucao, subGrupo2_1, 20));
        atividades.add(new Atividade("Editor de jornais ou revistas com distribuição Local ou regional", resolucao, subGrupo2_1, 15));
        atividades.add(new Atividade("Editor de jornais ou revistas com distribuição Local ou Nacional ", resolucao, subGrupo2_1, 20));
        atividades.add(new Atividade("Editor de jornais ou revistas com distribuição Local ou Internacional  ", resolucao, subGrupo2_1, 20));
        atividades.add(new Atividade("Dissertação de Mestrado defendida de aprovada (sendo o docente o autor da dissertação)", resolucao, subGrupo2_1, 10));
        atividades.add(new Atividade("Tese de Doutorado defendida e aprovada (sendo o docente o autor da tese) ", resolucao, subGrupo2_1, 15));
        /////////////////////////////////////////////////////
        //atividades subgrupo 2_2
        ////////////////////////////////////////////////////
        atividades.add(new Atividade("Criação, produção e direção de filmes, vídeos, discos, audiovisuais,coreografias, peças teatrais, óperas ou musicais, ou musicais apresentados em eventos locais ou regionais ", resolucao, subGrupo2_2, 10));
        atividades.add(new Atividade("Criação, produção e direção de filmes, vídeos, discos, audiovisuais,coreografias, peças teatrais, óperas ou musicais, ou musicais apresentados em eventos nacionais", resolucao, subGrupo2_2, 15));
        atividades.add(new Atividade("Criação, produção e direção de filmes, vídeos, discos, audiovisuais,coreografias, peças teatrais, óperas ou musicais, ou musicais apresentados em eventos internacionais", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Criação e produção do projeto gráfico de livros: concepção gráfica (mancha gráfica, diagramação, escolha de fonte)", resolucao, subGrupo2_2, 10));
        atividades.add(new Atividade("Design (gráfico, de luz, de figurino e formas animadas, cenográfico e similares)", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Design de impressos por peça (limitados a 20 pontos) ", resolucao, subGrupo2_2, 1));
        atividades.add(new Atividade("Design de interfaces digitais", resolucao, subGrupo2_2, 10));
        atividades.add(new Atividade("Design de interfaces digitais ou produtos com inovação tecnológica", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Exposições e apresentações artísticas locais ou regionais Participação individual, camerista, solista ou ator principal", resolucao, subGrupo2_2, 16));
        atividades.add(new Atividade("Exposições e apresentações artísticas locais ou regionais Participação coletiva ou coadjuvante", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Exposições e apresentações artísticas nacionais Participação individual, camerista, solista ou ator principal ", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Exposições e apresentações artísticas nacionais Participação coletiva ou coadjuvante  ", resolucao, subGrupo2_2, 10));
        atividades.add(new Atividade("Exposições e apresentações artísticas internacionais  Participação individual, camerista, solista ou ator principal ", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Exposições e apresentações artísticas internacionais  Participação coletiva ou coadjuvante ", resolucao, subGrupo2_2, 15));
        atividades.add(new Atividade("Composições musicais Editadas ", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Composições musicais Editadas Publicadas em revistas científicas", resolucao, subGrupo2_2, 20));
        atividades.add(new Atividade("Composições musicais Editadas Gravadas ", resolucao, subGrupo2_2, 15));
        atividades.add(new Atividade("Composições musicais Executadas em apresentações públicas  ", resolucao, subGrupo2_2, 15));
        atividades.add(new Atividade("Produção artística, arquitetônica ou de design premiada em evento Local ou regional  ", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Produção artística, arquitetônica ou de design premiada em evento Nacional  ", resolucao, subGrupo2_2, 10));
        atividades.add(new Atividade("Produção artística, arquitetônica ou de design premiada em evento internacional  ", resolucao, subGrupo2_2, 15));
        atividades.add(new Atividade("Arranjos musicais (canto, coral e orquestral)  ", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Apresentação artística ou cultural em rádio ou TV  ", resolucao, subGrupo2_2, 5));
        atividades.add(new Atividade("Sonoplastia (cinema, música, rádio, televisão, teatro)   ", resolucao, subGrupo2_2, 3));
        /////////////////////////////////////////////////////////
        //atividades subgrupo 2_3
        /////////////////////////////////////////////////////////
        atividades.add(new Atividade("Desenvolvimento de programa de computador (software) com registro no INPI ou com ampla disponibilização em ambientes de software livre", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Desenvolvimento de software com divulgação em periódicos indexados e com corpo editorial ou em anais de congresso científico", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Desenvolvimento de software para uso institucional (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Desenvolvimento e registro no INPI de topografia de circuito integrado", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Desenvolvimento de produto, processo ou técnica com registro de patente no INPI ou modelo de utilidade", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Desenvolvimento e registro no INPI de desenho industrial", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Desenvolvimento e registro no INPI de processo de indicação geográfica", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Desenvolvimento e registro no INPI de marcas", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Participação em comitê editorial de periódicos especializados indexados e de editoras universitárias", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Parecer de consultoria ad hoc em comitês de avaliação de concursos e editais de publicação de livros de editoras com corpo editorial", resolucao, subGrupo2_3, 3));
        atividades.add(new Atividade("Parecer de consultoria ad hoc para periódicos especializados com corpo editorial ou para instituições de fomento à pesquisa ou para livros de editoras com corpo editorial", resolucao, subGrupo2_3, 3));
        atividades.add(new Atividade("Projeto, parecer ou relatório técnico realizado em consultoria ou assessoria oficializada por convite, convênio, contrato ou designação Parecer com anotação de responsabilidade técnica (ART) ou registro de responsabilidade técnica (RRT)", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Projeto, parecer ou relatório técnico realizado em consultoria ou assessoria oficializada por convite, convênio, contrato ou designação Parecer sem anotação de responsabilidade técnica (ART) ou registro de responsabilidade técnica (RRT)", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Projeto, parecer ou relatório técnico realizado em consultoria ou assessoria oficializada por convite, convênio, contrato ou designação Projeto ou Relatório Técnico com anotação de responsabilidade técnica", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Projeto, parecer ou relatório técnico realizado em consultoria ou assessoria oficializada por convite, convênio, contrato ou designação Projeto ou Relatório Técnico sem anotação de responsabilidade técnica (ART) ou registro de responsabilidade técnica (RRT)", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Anais, Manuais, catálogos, boletins, com ficha bibliográfica (organizador / redator)", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Produção e publicação de mapas, cartas ou similares", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Desenvolvimento de maquete", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Manutenção de obra artística Restauração de obra artística", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Manutenção de obra artística Conservação de obra artística", resolucao, subGrupo2_3, 10));
        atividades.add(new Atividade("Manutenção de obra artística Curadoria de exposições", resolucao, subGrupo2_3, 5));
        atividades.add(new Atividade("Produção de cinema, vídeo, rádio, TV ou mídias digitais Editor", resolucao, subGrupo2_3, 20));
        atividades.add(new Atividade("Produção de cinema, vídeo, rádio, TV ou mídias digitais Participante (total máximo a ser considerado neste item são 9 pontos) ", resolucao, subGrupo2_3, 3));
        ///////////////////////////////////////////////////////////////      
        //atividades subgrupo 2_4
        ///////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Artigos de opinião veiculados em jornais e revistas (eletrônico ou impresso)", resolucao, subGrupo2_4, 1));
        atividades.add(new Atividade("Texto ou material didático para uso institucional (não fracionados e com ampla divulgação)", resolucao, subGrupo2_4, 2));
        atividades.add(new Atividade("Artigos de divulgação científica, tecnológica e artística veiculados em jornais e revistas (eletrônico ou impresso)", resolucao, subGrupo2_4, 3));
        atividades.add(new Atividade("Apresentação oral de trabalho publicado em anais de congresso científico (total máximo a ser considerado neste item são 9 pontos)", resolucao, subGrupo2_4, 3));
        atividades.add(new Atividade("Apresentação em painel de trabalho publicado em anais de congresso científico (total máximo a ser considerado neste item são 3 pontos)", resolucao, subGrupo2_4, 1));
        atividades.add(new Atividade("Trabalho premiado em evento científico nacional ou internacional ", resolucao, subGrupo2_4, 5));
        atividades.add(new Atividade("Tese, dissertação e trabalho de iniciação científica premiados por instituições de fomento (sendo o docente o autor ou orientador do produto) ", resolucao, subGrupo2_4, 8));

        //atividades 3_1
        atividades.add(new Atividade("Coordenador de projeto conjuntos de pesquisa e cooperação científica (tipo PRODOC, PROCAD, PNPD, entre outros) e de cursos MINTER e DINTER aprovados por órgãos oficiais de fomento", resolucao, subGrupo3_1, 10));
        atividades.add(new Atividade("Coordenador de projeto de pesquisa aprovado com comprovação de financiamento (exceto bolsas)", resolucao, subGrupo3_1, 10));
        atividades.add(new Atividade("Coordenador de projeto de pesquisa aprovado sem financiamento (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo3_1, 5));
        ////////////////////////////////////////////////////////////
        //atividades 3_2
        ////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Coordenador de projeto de extensão aprovado com comprovação de financiamento (exceto bolsas)", resolucao, subGrupo3_2, 10));
        atividades.add(new Atividade("Coordenador de projeto ou programa de extensão/cultura cadastrado na PROEC (total máximo a ser considerado neste item são 15 pontos)", resolucao, subGrupo3_2, 5));
        atividades.add(new Atividade("Coordenador de contratos e de convênios de cooperação institucional internacional", resolucao, subGrupo3_2, 5));
        atividades.add(new Atividade("Coordenador de contratos e de convênios de cooperação institucional nacional", resolucao, subGrupo3_2, 3));
        atividades.add(new Atividade("Participante de projeto de extensão/cultura cadastrado na PROEC (total máximo a ser considerado neste item são 15 pontos)", resolucao, subGrupo3_2, 3));
        atividades.add(new Atividade("Curso de extensão ministrado com 20 ou mais horas (total máximo a ser considerado neste item são 15 pontos)", resolucao, subGrupo3_2, 5));
        atividades.add(new Atividade("Curso de extensão ministrado com menos de 20 horas (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo3_2, 2));
        atividades.add(new Atividade("Palestrante, conferencista ou participante em mesa redonda em evento científico, cultural ou artístico Evento internacional (total máximo a ser considerado neste item são 15 pontos)", resolucao, subGrupo3_1, 5));
        atividades.add(new Atividade("Palestrante, conferencista ou participante em mesa redonda em evento científico, cultural ou artístico Evento nacional (total máximo a ser considerado neste item são 12 pontos)", resolucao, subGrupo3_1, 4));
        atividades.add(new Atividade("Palestrante, conferencista ou participante em mesa redonda em evento científico, cultural ou artístico Evento regional ou local (total máximo a ser considerado neste item são 9 pontos)", resolucao, subGrupo3_1, 3));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos locais Presidente", resolucao, subGrupo3_2, 4));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos locais Comissão organizadora", resolucao, subGrupo3_2, 2));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos regionais Presidente", resolucao, subGrupo3_2, 6));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos regionais Comissão organizadora ", resolucao, subGrupo3_2, 3));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos nacionais presidente ", resolucao, subGrupo3_2, 8));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos nacionais comissão organizadora ", resolucao, subGrupo3_2, 4));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos internacionais presidente ", resolucao, subGrupo3_1, 10));
        atividades.add(new Atividade("Promoção ou produção de eventos artísticos e científicos internacionais presidente comissão organizadora", resolucao, subGrupo3_2, 5));

        //atividades 4_1
        atividades.add(new Atividade("Reitor ou Vice-Reitor ou Pró-Reitor", resolucao, subGrupo4_1, 14));
        atividades.add(new Atividade("Chefe de Gabinete", resolucao, subGrupo4_1, 10));
        atividades.add(new Atividade("Coordenador ou assessor vinculado à Reitoria", resolucao, subGrupo4_1, 10));
        atividades.add(new Atividade("Diretor de Unidade Acadêmica, de Unidade Acadêmica Especial ou do CEPAE", resolucao, subGrupo4_1, 10));
        atividades.add(new Atividade("Diretor de Campus do interior", resolucao, subGrupo4_1, 12));
        atividades.add(new Atividade("Vice-diretor de Campus do interior", resolucao, subGrupo4_1, 12));
        atividades.add(new Atividade("Diretor Geral do Hospital das Clínicas ", resolucao, subGrupo4_1, 10));
        atividades.add(new Atividade("Coordenador ou assessor vinculado às Pró-Reitorias ou à Direção dos Campus do Interior", resolucao, subGrupo4_1, 8));
        atividades.add(new Atividade("Coordenador de Programa de Pós-Graduação stricto sensu", resolucao, subGrupo4_1, 8));
        atividades.add(new Atividade("Coordenador de Curso de Ensino Básico ou de Graduação", resolucao, subGrupo4_1, 8));
        atividades.add(new Atividade("Vice-diretor de Unidade Acadêmica ou Unidade Acadêmica Especial ou do CEPAE", resolucao, subGrupo4_1, 8));
        atividades.add(new Atividade("Diretor do Hospital Veterinário", resolucao, subGrupo4_1, 8));
        atividades.add(new Atividade("Diretor de Órgão da Administração (CERCOMP, CGA, CEGRAF, CIAR, DDRH, CS, SIASS, Museu, Rádio, Biblioteca etc.)", resolucao, subGrupo4_1, 8));
        //////////////////////////////////////////////////////
        //atividades 4_2
        ///////////////////////////////////////////////////////
        atividades.add(new Atividade("Coordenador de projeto institucional com financiamento ou de contratos e convênio com plano de trabalho aprovado", resolucao, subGrupo4_2, 5));
        atividades.add(new Atividade("Coordenador de curso de especialização, residência médica ou residência multiprofissional em saúde (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo4_2, 10));
        atividades.add(new Atividade("Membro representante de classe da carreira docente no CONSUNI", resolucao, subGrupo4_2, 10));
        atividades.add(new Atividade("Membro do Conselho de Curadores ou do Plenário do CEPEC ou de Conselho de Fundações", resolucao, subGrupo4_2, 10));
        atividades.add(new Atividade("Atividades acadêmicas e administrativas designadas por portaria do Reitor, Pró-Reitor ou Diretor de Unidade Acadêmica com carga horária >=150 horas", resolucao, subGrupo4_2, 10));
        ////////////////////////////////////////////////////////////
        //atividades 4_3
        //////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Presidente da CPPD", resolucao, subGrupo4_3, 7));
        atividades.add(new Atividade("Presidente da Comissão de Avaliação Institucional ou da Comissão Própria de Avaliação", resolucao, subGrupo4_3, 5));
        atividades.add(new Atividade("Membros da Coordenação Permanente do Centro de Seleção ", resolucao, subGrupo4_3, 5));
        atividades.add(new Atividade("Diretores do HC ", resolucao, subGrupo4_3, 5));
        atividades.add(new Atividade("Presidente do Comitê de Ética em Pesquisa da UFG e do HC/UFG", resolucao, subGrupo4_3, 5));
        atividades.add(new Atividade("Membros da CPPD ou da Comissão de Avaliação Institucional ou da Comissão Própria de Avaliação ou da CAD", resolucao, subGrupo4_3, 5));
        atividades.add(new Atividade("Coordenador de Pesquisa ou de Ensino ou de Extensão ou de Estágio das Unidades Acadêmicas", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Chefe de Departamento", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Chefe do Pronto Socorro ou da Maternidade ou do CEROF do Hospital das Clínicas da UFG", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Coordenador das Atividades de Interação com a Sociedade", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Coordenador das Atividades de Pesquisa e de Pós–Graduação lato sensu", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Membros do Comitê de Ética da UFG e do HC/UFG", resolucao, subGrupo4_3, 3));
        atividades.add(new Atividade("Membros do Comitê Interno e Externo do PIBIC ", resolucao, subGrupo4_3, 3));
        /////////////////////////////////////////////////////////////
        //atividades 4_4
        /////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Representante titular em conselho de classe profissional com carga horária igual ou superior a 150 horas", resolucao, subGrupo4_4, 10));
        atividades.add(new Atividade("Presidente do Sindicato de Docentes da UFG ", resolucao, subGrupo4_4, 10));
        atividades.add(new Atividade("Diretor do Sindicato de Docentes da UFG ", resolucao, subGrupo4_4, 3));
        atividades.add(new Atividade("Representante sindical com carga horária igual ou superior a 150 horas ", resolucao, subGrupo4_4, 10));
        atividades.add(new Atividade("Representante em entidade científica, artística e cultural com carga horária igual ou superior a 150 horas ", resolucao, subGrupo4_4, 10));
        atividades.add(new Atividade("Representante em comissão de órgão governamental com carga horária igual ou superior a 150 horas", resolucao, subGrupo4_4, 10));

        //atividades 5_1
        atividades.add(new Atividade("Aluno orientado em tese de doutorado defendida e aprovada", resolucao, subGrupo5_1, 20));
        atividades.add(new Atividade("Aluno co-orientado em tese de doutorado defendida e aprovada", resolucao, subGrupo5_1, 7));
        atividades.add(new Atividade("Aluno orientado em tese de doutorado em andamento", resolucao, subGrupo5_1, 10));
        atividades.add(new Atividade("Aluno co-orientado em tese de doutorado em andamento", resolucao, subGrupo5_1, 4));
        atividades.add(new Atividade("Aluno orientado em dissertação de mestrado defendida e aprovada", resolucao, subGrupo5_1, 15));
        atividades.add(new Atividade("Aluno co-orientado em dissertação de mestrado defendida e aprovada ", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado em dissertação de mestrado em andamento", resolucao, subGrupo5_1, 8));
        atividades.add(new Atividade("Aluno co-orientado em dissertação de mestrado em andamento", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno orientado em monografia de especialização aprovada (máximo de 24 pontos)", resolucao, subGrupo5_1, 8));
        atividades.add(new Atividade("Aluno orientado em monografia de especialização em andamento (total máximo a ser considerado neste item são 12 pontos)", resolucao, subGrupo5_1, 4));
        atividades.add(new Atividade("Aluno orientado em residência médica ou em residência multiprofissional em saúde ", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado em estágio supervisionado", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno orientado em projeto de final de curso", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno de outra IFE orientado em tese de doutorado defendida e aprovada", resolucao, subGrupo5_1, 6));
        atividades.add(new Atividade("Aluno de outra IFE co-orientado em tese de doutorado defendida e aprovada ", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno de outra IFE orientado em tese de doutorado em andamento", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno de outra IFE co-orientado em tese de doutorado em andamento", resolucao, subGrupo5_1, 2));
        atividades.add(new Atividade("Aluno de outra IFE orientado em dissertação de mestrado defendida e aprovada ", resolucao, subGrupo5_1, 4));
        atividades.add(new Atividade("Aluno de outra IFE orientado em dissertação de mestrado em andamento", resolucao, subGrupo5_1, 2));
        atividades.add(new Atividade("Aluno de outra IFE co-orientado em dissertação de mestrado em andamento", resolucao, subGrupo5_1, 1));
        atividades.add(new Atividade("Aluno orientado em programa de iniciação científica (PIBIC/PIVIC/PROLICEN/PICME-OBMEP)", resolucao, subGrupo5_1, 6));
        atividades.add(new Atividade(" Aluno orientado em programa de iniciação científica júnior", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade(" Aluno orientado em programa especial de treinamento (PET)", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade(" Aluno orientado com bolsa de DTI, PIBIT, AT, Jovens Talentos e similares ", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado com bolsa de licenciatura (PIBID e similares)", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado com bolsa extensão/cultura/ensino", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado em projetos de extensão/cultura/ensino sem bolsa", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado com bolsa PROCOM ou similar, vinculada a projeto de pesquisa/extensão/ensino", resolucao, subGrupo5_1, 5));
        atividades.add(new Atividade("Aluno orientado em programa de monitoria", resolucao, subGrupo5_1, 3));
        atividades.add(new Atividade("Aluno orientado em atividade não curricular com bolsa", resolucao, subGrupo5_1, 2));
        atividades.add(new Atividade("Aluno orientado em atividade não curricular sem bolsa", resolucao, subGrupo5_1, 1));
        atividades.add(new Atividade("Pesquisador supervisionado em estágio de pós-doutoramento (PRODOC, PNPD, DCR, entre outros)", resolucao, subGrupo5_1, 8));
        atividades.add(new Atividade("Aluno orientado em Prática como Componente Curricular (PCC) ", resolucao, subGrupo5_1, 1));
        ////////////////////////////////////////////////////////////////////
        //atividades 5_2
        ////////////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Presidente do Sindicato de Docentes da UFG ", resolucao, subGrupo5_2, 10));
        atividades.add(new Atividade("Membro de banca de concurso para docente efetivo Na instituição ", resolucao, subGrupo5_2, 4));
        atividades.add(new Atividade("Membro de banca de concurso para docente efetivo Em outra instituição  ", resolucao, subGrupo5_2, 6));
        atividades.add(new Atividade("Membro de banca de concurso para docente substituto ", resolucao, subGrupo5_2, 2));
        atividades.add(new Atividade("Membro de banca de defesa de dissertação de mestrado Na instituição", resolucao, subGrupo5_2, 4));
        atividades.add(new Atividade("Membro de banca de defesa de dissertação de mestrado Em outra instituição ", resolucao, subGrupo5_2, 6));
        atividades.add(new Atividade("Membro de banca de defesa de tese de doutorado Na instituição", resolucao, subGrupo5_2, 6));
        atividades.add(new Atividade("Membro de banca de defesa de tese de doutorado em outra instituição", resolucao, subGrupo5_2, 8));
        atividades.add(new Atividade("Membro de banca de qualificação de mestrado na instituição", resolucao, subGrupo5_2, 3));
        atividades.add(new Atividade("Membro de banca de qualificação de mestrado em outra instituição", resolucao, subGrupo5_2, 4));
        atividades.add(new Atividade("Membro de banca de qualificação de doutorado Na instituição", resolucao, subGrupo5_2, 5));
        atividades.add(new Atividade("Membro de banca de qualificação de doutorado em outra instituição", resolucao, subGrupo5_2, 6));
        atividades.add(new Atividade("Membro de banca de defesa de monografia, projeto final de curso e outros tipos de bancas (total máximo a ser considerado neste item são 10 pontos)", resolucao, subGrupo5_2, 2));
        atividades.add(new Atividade("Membro de corpo de júri Concursos internacionais", resolucao, subGrupo5_2, 8));
        atividades.add(new Atividade("Membro de corpo de júri Concursos nacionais", resolucao, subGrupo5_2, 6));
        atividades.add(new Atividade("Cursos, palestras ou treinamento não curricular ministrados para docentes, funcionários ou alunos da UFG ", resolucao, subGrupo5_2, 2));
        atividades.add(new Atividade("Coordenador de projeto institucional de intercâmbio internacional", resolucao, subGrupo5_2, 10));
        /////////////////////////////////////////////////////////////////
        //atividades 5_3
        /////////////////////////////////////////////////////////////////
        atividades.add(new Atividade("Docente regularmente matriculado em curso de doutorado com relatórios de pós-graduação aprovados (pontuação por mês de curso)", resolucao, subGrupo5_3, 12));
        atividades.add(new Atividade("Estágio Pós-Doutoral ou Estágio Sênior (pontuação por mês de estágio)", resolucao, subGrupo5_3, 12));
        atividades.add(new Atividade("Docente em licença para capacitação (Artigo 87, Lei N.8112) (pontuação por mês de licença)", resolucao, subGrupo5_3, 12));
        atividades.add(new Atividade("Curso de aperfeiçoamento realizado com carga horária superior a 40 horas", resolucao, subGrupo5_3, 3));
        atividades.add(new Atividade("Curso de aperfeiçoamento realizado com carga horária inferior a 40 horas", resolucao, subGrupo5_3, 1));
        atividades.add(new Atividade("Participação em Congressos, Seminários, Encontros, Jornadas etc. (total máximo a ser considerado neste item são 3 pontos)", resolucao, subGrupo5_3, 1));

        //Salvar a resolução
        DAOFactory daof = DAOFactory.getFactory();
        
        daof.getResolucaoDAO().save(resolucao);
        
        daof.getAtividadeDAO().save(atividades);
        
        
        //salvando os grupos
        /**
         * daof.getGrupoDAO().save(grupo1);
         * daof.getGrupoDAO().save(subGrupo1_1);
         * daof.getGrupoDAO().save(subGrupo1_2);
         * daof.getGrupoDAO().save(grupo2);
         * daof.getGrupoDAO().save(subGrupo2_1);
         * daof.getGrupoDAO().save(subGrupo2_2);
         * daof.getGrupoDAO().save(subGrupo2_3);
         * daof.getGrupoDAO().save(subGrupo2_4);
         * daof.getGrupoDAO().save(grupo3);
         * daof.getGrupoDAO().save(subGrupo3_1);
         * daof.getGrupoDAO().save(subGrupo3_2);
         * daof.getGrupoDAO().save(grupo4);
         * daof.getGrupoDAO().save(subGrupo4_1);
         * daof.getGrupoDAO().save(subGrupo4_2);
         * daof.getGrupoDAO().save(subGrupo4_3);
         * daof.getGrupoDAO().save(subGrupo4_4);
         * daof.getGrupoDAO().save(grupo5);
         * daof.getGrupoDAO().save(subGrupo5_1);
         * daof.getGrupoDAO().save(subGrupo5_2);
         * daof.getGrupoDAO().save(subGrupo5_3);
         */
    }
}
