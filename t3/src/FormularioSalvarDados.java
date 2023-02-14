import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FormularioSalvarDados {
    private GUI gui;
    String nomeArquivo;
    private JTextField textField1;
    private JLabel textoResultado;
    private JPanel painel;
    private JButton voltarButton;
    private JButton okButton;

    private ArrayList<Pesquisador> listaUltimaPesquisa;

    public FormularioSalvarDados(GUI gui) {
        this.gui=gui;
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeArquivo=textField1.getText();
                try {
                    nomeArquivo=nomeArquivo+".csv";
                    if(!Executa.salvaDadosArquivo(nomeArquivo,listaUltimaPesquisa)){textoResultado.setText("Nenhum nome conslutado anteriormente ou nenhum pesquisador foi encontrado");}
                    else textoResultado.setText("Concluído");
                } catch (FileNotFoundException ex) {
                    textoResultado.setText("Digite um nome para o arquivo");
                }catch (NullPointerException ex){
                    textoResultado.setText("Nenhum dado cadastrado");
                }catch (Exception ex){
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

    public void setListaUltimaPesquisa(ArrayList<Pesquisador> listaUltimaPesquisa) {
        this.listaUltimaPesquisa = listaUltimaPesquisa;
    }

    public JPanel getPainel() {
        return painel;
    }
}
