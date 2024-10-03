import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {

    public void mostrarTelaLogin() {

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelEmail = new JLabel("E-mail:");
        JTextField textEmail = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textEmail, gbc);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(textSenha, gbc);

        JButton botaoLogin = new JButton("Entrar");
        botaoLogin.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(botaoLogin, gbc);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText();
                String senha = new String(textSenha.getPassword());
                frame.dispose();
                ServicoGUI servicosGUI = new ServicoGUI();
                servicosGUI.mostrarTelaServicos();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
