import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import repository.AdministradorRepository;
import repository.ConectarBancoDeDados;
import repository.ClienteRepository;

public class LoginClienteGUI {

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

        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(botaoEntrar, gbc);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText();
                String senha = new String(textSenha.getPassword());

                try (Connection connection = ConectarBancoDeDados.getConnection()) {
                    AdministradorRepository repo = new AdministradorRepository(connection);
                    if (repo.verificarCredenciais(email, senha)) {
                        JOptionPane.showMessageDialog(frame, "Sucesso na conexão!");
                        frame.dispose();
                        ServicoGUI servicosGUI = new ServicoGUI();
                        servicosGUI.mostrarTelaServicos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "E-mail ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.add(panel);
        frame.setVisible(true);
    }
}
