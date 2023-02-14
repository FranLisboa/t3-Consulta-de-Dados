import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormularioPesquisaNome {
    private GUI gui;
    String nome;
    private JPanel painel;
    private JTextArea textArea1;
    private JButton voltarButton;
    private JButton okButton;
    private JTextField textField1;
    private ArrayList<Pesquisador> lista;
    private ArrayList<Pesquisador> listaUltimaPesquisa=new ArrayList<>();


    public FormularioPesquisaNome(GUI gui) {
    this.gui=gui;
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(lista.isEmpty())textArea1.setText("Lista vazia");
                    else {
                        listaUltimaPesquisa.clear();
                        nome = textField1.getText();
                        nome = nome.toUpperCase();
                        for (Pesquisador p : lista) {
                            if (p.getNome().contains(nome)) {
                                textArea1.append(p + "\n\n");
                                listaUltimaPesquisa.add(p);
                            }
                        }
                        if(listaUltimaPesquisa.isEmpty())textArea1.setText("Nenhum pesquisador foi encontrado");
                        gui.setListaUltimaPesquisa(listaUltimaPesquisa);
                    }
                }catch (NullPointerException ex){textArea1.setText("Nenhum dado foi carregado");}
                catch (Exception ex){textArea1.setText("Erro");}
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(1);
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
