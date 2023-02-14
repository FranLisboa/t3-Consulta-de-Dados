import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private Formulario1 formulario1;
    private FormularioPesquisa formularioPesquisa;
    private FormularioCarregaDados formularioCarregaDados;
    private FormularioSignificado formularioSignificado;
    private FormularioClassificar formularioClassificar;
    private FormularioPesquisaNome formularioPesquisaNome;
    private FormularioSalvarDados formularioSalvarDados;
    private ArrayList<Pesquisador> lista;
    private ArrayList<Pesquisador> listaUltimaPesquisa;
    public GUI() throws HeadlessException {
        super();

        setPreferredSize(new Dimension(800,800));
        formulario1=new Formulario1(this);
        formularioPesquisa=new FormularioPesquisa(this);
        formularioCarregaDados=new FormularioCarregaDados(this);
        formularioSignificado=new FormularioSignificado(this);
        formularioClassificar=new FormularioClassificar(this);
        formularioPesquisaNome=new FormularioPesquisaNome(this);
        formularioSalvarDados=new FormularioSalvarDados(this);
        setContentPane(formulario1.getPainel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1200,800);
        this.setTitle("Consulta Pesquisadores UFRN");


    }
    public void setPanel(int panel){
        switch (panel){
            case(1):
                this.setContentPane(formulario1.getPainel());
                this.pack();
                this.setSize(800,800);
            break;
            case(2):
                formularioPesquisa.setLista(lista);

                this.setContentPane(formularioPesquisa.getPainel());
                this.pack();
                this.setSize(800,800);
                formularioPesquisa.setLista(lista);

            break;
            case (3):
                this.setContentPane(formularioCarregaDados.getPainel());
                this.pack();
                this.setSize(800,800);
            break;

            case (4):
                this.setContentPane(formularioSignificado.getPainel());
                this.pack();
                this.setSize(800,800);
            break;

            case (5):
                this.setContentPane(formularioClassificar.getPainel());
                this.pack();
                this.setSize(800,800);
                formularioClassificar.setLista(lista);
                break;

            case (6):
                this.setContentPane(formularioPesquisaNome.getPainel());
                this.pack();
                this.setSize(800,800);
                formularioPesquisaNome.setLista(lista);
                break;

            case (7):
                this.setContentPane(formularioSalvarDados.getPainel());
                this.pack();
                this.setSize(800,800);
                formularioSalvarDados.setListaUltimaPesquisa(listaUltimaPesquisa);
                break;
        }


    }

    public ArrayList<Pesquisador> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Pesquisador> lista) {
        this.lista = lista;
    }

    public ArrayList<Pesquisador> getListaUltimaPesquisa() {
        return listaUltimaPesquisa;
    }

    public void setListaUltimaPesquisa(ArrayList<Pesquisador> listaUltimaPesquisa) {
        this.listaUltimaPesquisa = listaUltimaPesquisa;
    }
}
