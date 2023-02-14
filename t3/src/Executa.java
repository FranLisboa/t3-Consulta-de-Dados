
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Executa {
    static Scanner in = new Scanner(System.in);
    private static ArrayList<Pesquisador> lista = new ArrayList<>();
    private static ArrayList<Pesquisador> listaUltimaPesquisa = new ArrayList<>();

    public static void iniciar() {
        int sair = 0;
        while (sair == 0) {
            System.out.println("Escolha o que deseja executar\n" +
                    "[0]Sair\n" +
                    "[1]Carregar dados abertos\n" +
                    "[2]Classificar dados por nome\n" +
                    "[3]Consultar todos os dados\n" +
                    "[4]Consultar dados de um nome incompleto\n" +
                    "[5]Salvar os dados da consulta em arquivo\n" +
                    "[6]Ver significado dos dados\n");
            int escolhaFuncao = in.nextInt();
            in.nextLine();
            switch (escolhaFuncao) {

                case 0:
                    sair = 1;
                    break;

                case 1:
                    try {
                        System.out.println("Digite o nome do arquivo a serem carregados os dados");
                        String nomeArquivo= in.nextLine();
                        LeitorArquivo.cadstraPesquisadores(nomeArquivo);
                    } catch (FileNotFoundException e) {
                        System.out.println("Arquivo nao encontrado");

                    }
                    lista = LeitorArquivo.getLista();
                    break;

                case 2:
                    if(lista.isEmpty()){
                        System.out.println("Nenhum dado cadastrado");
                        break;
                    }
                    int escolhaOrdem = 0;

                    do {
                        System.out.println("Deseja classificar em qual ordem? [1]Crescente [2]Descrescente ");
                        escolhaOrdem = in.nextInt();
                    } while (escolhaOrdem != 1 && escolhaOrdem != 2);

                    if (escolhaOrdem == 1) {
                        Collections.sort(lista);
                    }
                    if (escolhaOrdem == 2) {
                        Collections.sort(lista, Collections.reverseOrder());
                    }
                    break;

                case 3:
                    if(lista.isEmpty()){
                        System.out.println("Nenhum dado cadastrado");
                        break;
                    }
                    for (Pesquisador p : lista) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    if(lista.isEmpty()){
                        System.out.println("Nenhum dado cadastrado");
                        break;
                    }
                    listaUltimaPesquisa.clear();
                    String nomeParcial;
                    System.out.println("Digite um nome");
                    nomeParcial = in.next();
                    nomeParcial=nomeParcial.toUpperCase();
                    for (Pesquisador p : lista) {
                        if (p.getNome().contains(nomeParcial)) {
                            System.out.println(p);
                            listaUltimaPesquisa.add(p);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome do arquivo em que deseja salvar os dados");
                    String nomeArquivo=in.next();
                    try {
                        if(!salvaDadosArquivo(nomeArquivo,listaUltimaPesquisa)) System.out.println("Nenhum dado consultado anteriormente");;
                    } catch (FileNotFoundException e) {
                        System.out.println("Arquivo nao encontrado");
                    }
                    break;

                case 6:
                    System.out.println("id_servidor:  Identificador do registro de docente pesquisador.\n" +
                            "nome:  Nome do pesquisador. \n" +
                            "id_unidade:  Identificador da unidade de relação do pesquisador.\n" +
                            "unidade:  Unidade de relação do pesquisador. \n" +
                            "id_centro:  Identificador do centro acadêmico ao qual o pesquisador pertence.\n" +
                            "centro:  Centro acadêmico ao qual o pesquisador pertence.\n" +
                            "coordenador:  Indica a quantidade de projetos, que atua como coordenador.\n" +
                            "internos:  Indica a quantidade de projetos internos.\n" +
                            "externos:  Indica a quantidade de projetos externos.");
                    break;

                default:
                    System.out.println("Esta escolha nao é valida");
                    break;
            }


        }
    }
    public static boolean salvaDadosArquivo(String nomeArquivo,ArrayList<Pesquisador> listaUltimaPesquisa2) throws FileNotFoundException {

        if(listaUltimaPesquisa2.isEmpty())return false;
        PrintWriter out = new PrintWriter(nomeArquivo);
        out.println("\"id_servidor\";\"nome\";\"id_unidade\";\"unidade\";\"id_centro\";\"centro\";\"coordenador\";\"internos\";\"externos\"");
        for(Pesquisador p:listaUltimaPesquisa2){
            out.println(p.resumoCSV());
            out.flush();
        }
        out.println();
        out.close();

        return true;
    }
}