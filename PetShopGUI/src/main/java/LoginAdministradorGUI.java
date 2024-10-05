import repository.ConectarBancoDeDados;
import repository.AdministradorRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginAdministradorGUI {

    private JFrame frame;
    private JLabel labelEmail;
    private JTextField textEmail;
    private JLabel labelSenha;
    private JPasswordField textSenha;
    private JButton botaoEntrar;


    public void mostrarTelaLoginAdministrador() {

        frame = new JFrame("Entrar Como Administrador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelEmail = new JLabel("E-mail:");
        textEmail = new JTextField(20);
        labelEmail.setForeground(Color.decode("#CD6C0A"));
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(textEmail, gbc);

        labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(20);
        labelSenha.setForeground(Color.decode("#CD6C0A"));
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(labelSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(textSenha, gbc);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setPreferredSize(new Dimension(100, 30));
        botaoEntrar.setMnemonic(KeyEvent.VK_E);
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

                // Validação dos campos obrigatórios
                if (email.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.",
                            "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
                    return;
                }

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
