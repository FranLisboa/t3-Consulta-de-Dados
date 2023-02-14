import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//este formulario é para consultar todos os dados, percebi que o nome era ruim depois de fazer, portanto não modifiquei por possiveis conflitos
public class FormularioPesquisa {
    private GUI gui;
    private JPanel painel;
    private JButton voltarButton;
    private JButton carregarButton;
    private JTextArea textArea1;

    private ArrayList<Pesquisador> lista;


    public FormularioPesquisa(GUI gui) {
        this.gui=gui;

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(lista.isEmpty())textArea1.setText("Lista Vazia");
                    textArea1.setText("");
                    for (Pesquisador p :
                            lista) {
                        textArea1.append(p + "\n\n");
                    }
                    gui.setListaUltimaPesquisa(lista);
                }catch (NullPointerException ex){
                    textArea1.setText("Nenhum dado foi carregado");
                }catch (Exception ex){
                    textArea1.setText("Erro");
                }
                }

        });
    }

    public void setLista(ArrayList<Pesquisador> lista) {
        this.lista = lista;
    }

    public JPanel getPainel() {
        return painel;
    }
}
