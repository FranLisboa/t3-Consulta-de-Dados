import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSignificado {
    private JPanel painel;
    private JButton voltarButton;

    public FormularioSignificado(GUI gui) {
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
