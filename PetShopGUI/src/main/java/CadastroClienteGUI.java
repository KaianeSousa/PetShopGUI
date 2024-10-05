import entities.Cliente;
import repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroClienteGUI {

    private JTextField textNome;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JTextField textEndereco;
    private JPasswordField textSenha;
    private ClienteRepository clienteRepository;
    private List<Cliente> clientes;

    public CadastroClienteGUI() {
        clienteRepository = new ClienteRepository();
        clientes = new ArrayList<>();
    }

    public void mostrarTelaCadastroCliente() {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelNome = new JLabel("Nome:");
        textNome = new JTextField(20);
        labelNome.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textNome, gbc);

        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);
        labelEndereco.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(textEndereco, gbc);

        JLabel labelEmail = new JLabel("E-mail:");
        textEmail = new JTextField(20);
        labelEmail.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(textEmail, gbc);

        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);
        labelTelefone.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(textTelefone, gbc);

        JLabel labelSenha = new JLabel("Senha:");
        textSenha = new JPasswordField(20);
        labelSenha.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(labelSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(textSenha, gbc);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;  gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(botaoCadastrar, gbc);

        botaoCadastrar.addActionListener((ActionEvent e) -> {
            String nome = textNome.getText();
            String endereco = textEndereco.getText();
            String email = textEmail.getText();
            String telefone = textTelefone.getText();
            String senha = new String(textSenha.getPassword());

            if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente para se cadastrar.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente cliente = new Cliente(nome, telefone, email, endereco, senha);

            try {
                clienteRepository.adicionarCliente(cliente);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso!");
            clientes.add(cliente);

                CadastroAnimalGUI cadastroAnimalGUI = new CadastroAnimalGUI();
                cadastroAnimalGUI.mostrarTelaCadastroAnimal();

            frame.dispose();
        });

        botaoCadastrar.setBackground(Color.decode("#CD6C0A"));
        botaoCadastrar.setForeground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#F0F8FF"));
    }

    public List<Cliente> getClientesCadastrados() {
        return clientes;
    }
}
