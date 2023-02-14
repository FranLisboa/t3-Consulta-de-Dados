import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class FormularioCarregaDados {

    private GUI gui;
    private String nomeArquivo;
    private JTextField textField1;
    private JButton okButton;
    private JLabel textoResultado;
    private JPanel painel;
    private JButton voltarButton;

    private ArrayList<Pesquisador>lista;

    public FormularioCarregaDados(GUI gui) {
        this.gui = gui;
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            nomeArquivo=textField1.getText();
                try {
                    nomeArquivo=nomeArquivo+".csv";
                    LeitorArquivo.cadstraPesquisadores(nomeArquivo);
                    lista=LeitorArquivo.getLista();
                    gui.setLista(lista);
                    gui.setListaUltimaPesquisa(new ArrayList<>());
                    textoResultado.setText("Concluído");

                } catch (FileNotFoundException ex) {
                    textoResultado.setText("Arquivo não encontrado");
                }catch(NumberFormatException ex){
                    textoResultado.setText("Erro de formatação do arquivo");
                }
                catch(Exception ex){
                    textoResultado.setText("Erro");
                }
            }
        });
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
}
