import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import repository.ConectarBancoDeDados;
import repository.ClienteRepository;

public class LoginClienteGUI {

    public void mostrarTelaLogin() {
        JFrame frame = new JFrame("Entrar Como Cliente");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelEmail = new JLabel("E-mail:");
        JTextField textEmail = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(textEmail, gbc);
        labelEmail.setForeground(Color.decode("#025091"));

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(labelSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(textSenha, gbc);
        labelSenha.setForeground(Color.decode("#025091"));

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
                    ClienteRepository clienteRepo = new ClienteRepository(connection);
                    if (clienteRepo.verificarCredenciais(email, senha)) {
                        JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
                        frame.dispose();

                        ServicoGUI servicosGUI = new ServicoGUI();
                        servicosGUI.mostrarTelaServicos();
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

        botaoEntrar.setBackground(Color.decode("#025091"));
        botaoEntrar.setForeground(Color.WHITE);

        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#F0F8FF"));
    }
}
