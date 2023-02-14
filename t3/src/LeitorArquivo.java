import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorArquivo {

    private static ArrayList<Pesquisador> lista= new ArrayList<>();

    public static void cadstraPesquisadores(String nomeArquivo) throws FileNotFoundException, InputMismatchException {
        String id_servidor;
        int int_id_servidor;
         String nome;
        String id_unidade;
        int int_id_unidade;
         String unidade;
        String id_centro;
        int int_id_centro;
         String centro;
        String coordenador;
        int int_coordenador;
        String internos;
        int int_internos;
        String externos;
        int int_externos;

        Scanner in=new Scanner(new File(nomeArquivo));
        in.nextLine();

        in.useDelimiter(";|\\s*#\\s*|\\s*\n\\s*");
        while (in.hasNext())
        {

            id_servidor =in.next();
            int_id_servidor=Integer.parseInt(id_servidor.substring(1,id_servidor.length()-1));

            nome=in.next();
            nome=nome.substring(1,nome.length()-1);


            id_unidade=in.next();
            int_id_unidade=Integer.parseInt(id_unidade.substring(1,id_unidade.length()-1));

            unidade=in.next();
            unidade=unidade.substring(1,unidade.length()-1);

            id_centro=in.next();
            int_id_centro=Integer.parseInt(id_centro.substring(1,id_centro.length()-1));

            centro=in.next();
            centro=centro.substring(1,centro.length()-1);


            coordenador=in.next();
            int_coordenador=Integer.parseInt(coordenador.substring(1,coordenador.length()-1));

            internos=in.next();
            int_internos=Integer.parseInt(internos.substring(1,internos.length()-1));

            externos=in.next();
            int_externos=Integer.parseInt(externos.substring(1,externos.length()-1));


            Pesquisador pesquisador=new Pesquisador( int_id_servidor,  nome,  int_id_unidade,  unidade,  int_id_centro,  centro,  int_coordenador,  int_internos,  int_externos);
            lista.add(pesquisador);

        }
        in.close();
    }

    public static ArrayList<Pesquisador> getLista() {
        return (ArrayList<Pesquisador>) lista.clone();
    }
}
