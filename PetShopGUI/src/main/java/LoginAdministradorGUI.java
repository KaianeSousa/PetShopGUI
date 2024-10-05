import repository.ConectarBancoDeDados;
import repository.AdministradorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginAdministradorGUI {

    public void mostrarTelaLoginAdministrador() {
        JFrame frame = new JFrame("Entrar Como Administrador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelEmail = new JLabel("E-mail:");
        JTextField textEmail = new JTextField(20);
        labelEmail.setForeground(Color.decode("#CD6C0A"));
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(textEmail, gbc);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);
        labelSenha.setForeground(Color.decode("#CD6C0A"));
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(labelSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(textSenha, gbc);


        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(botaoEntrar, gbc);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textEmail.getText();
                String senha = new String(textSenha.getPassword());

                try (Connection connection = ConectarBancoDeDados.getConnection()) {
                    AdministradorRepository repo = new AdministradorRepository(connection);
                    if (repo.verificarCredenciais(email, senha)) {
                        JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                        frame.dispose();
                        AdministradorGUI adminGUI = new AdministradorGUI();
                        adminGUI.mostrarTelaAdministrador();
                    } else {
                        JOptionPane.showMessageDialog(frame, "E-mail ou senha incorretos!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados: " +
                            ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        botaoEntrar.setBackground(Color.decode("#CD6C0A"));
        botaoEntrar.setForeground(Color.WHITE);

        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#FFFACD"));
    }
}
