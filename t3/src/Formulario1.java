import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario1 {
    private GUI gui;
    private JButton carregarDadosButton;
    private JButton classificarDadosButton;
    private JButton significadoDadosButton;
    private JButton consultarTodosDadosButton;
    private JButton consultarNomeButton;
    private JButton salvarDadosButton;
    private JButton sairButton;
    private JPanel painel;
    private JLabel text;

    public Formulario1(GUI gui) {
        this.gui=gui;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        consultarTodosDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(2);

            }
        });
        carregarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(3);
            }
        });
        significadoDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(4);
            }
        });
        classificarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(5);
            }
        });
        consultarNomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(6);

            }
        });
        salvarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanel(7);

            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }
}
