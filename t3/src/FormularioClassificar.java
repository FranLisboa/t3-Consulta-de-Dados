import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class FormularioClassificar {
    private GUI gui;

    private JButton crescenteButton;
    private JButton decrescenteButton;
    private JLabel ordemLabel;
    private JPanel painel;
    private JLabel textoResultado;
    private JButton voltarButton;
    private ArrayList<Pesquisador> lista;


    public FormularioClassificar(GUI gui) {
        this.gui=gui;
        try {
            crescenteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (lista.isEmpty()) textoResultado.setText("Lista Vazia");
                        else {
                            Collections.sort(lista);
                            textoResultado.setText("Concluído");
                        }
                    }catch (NullPointerException ex){textoResultado.setText("Nenhum dado foi carregado");}
                    catch (Exception ex){textoResultado.setText("Erro");}
                }
            });
            decrescenteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (lista.isEmpty()) textoResultado.setText("Lista Vazia");
                        else {
                            Collections.sort(lista, Collections.reverseOrder());
                            textoResultado.setText("Concluído");
                        }
                    }catch (NullPointerException ex){textoResultado.setText("Nenhum dado foi carregado");}
                    catch (Exception ex){textoResultado.setText("Erro");}
                }
            });
        }catch (NullPointerException ex){textoResultado.setText("Nenhum dado foi carregado");}
        catch (Exception e){textoResultado.setText("Erro");}
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }

    public void setLista(ArrayList<Pesquisador> lista) {
        this.lista = lista;
    }
}
