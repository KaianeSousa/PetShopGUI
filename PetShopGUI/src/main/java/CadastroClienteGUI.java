import entities.Cliente;
import repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroClienteGUI {

    private JTextField textNome;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JTextField textEndereco;
    public JButton botaoCadastrarAnimal;
    public JButton botaoVoltar;
    private JPanel painelButton;

    private ClienteRepository clienteRepository;
    private List<Cliente> clientes;

    public CadastroClienteGUI() {
        clienteRepository = new ClienteRepository();
        clientes = new ArrayList<>();
    }

    public void mostrarTelaCadastroCliente() {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelNome = new JLabel("Nome:");
        textNome = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNome, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(textNome, gbc);

        labelNome.setForeground(Color.decode("#025091"));  // Azul escuro


        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(textEndereco, gbc);

        labelEndereco.setForeground(Color.decode("#025091"));  // Azul escuro

        JLabel labelEmail = new JLabel("E-mail:");
        textEmail = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(textEmail, gbc);

        labelEmail.setForeground(Color.decode("#025091"));  // Azul escuro


        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(textTelefone, gbc);

        labelTelefone.setForeground(Color.decode("#025091"));  // Azul escuro


        botaoVoltar = new JButton("Voltar");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botaoVoltar, gbc);

        botaoVoltar.setBackground(Color.decode("#ABD0EF"));
        botaoVoltar.setForeground(Color.decode("#025091"));

        botaoCadastrarAnimal = new JButton("Cadastrar Animal");

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botaoCadastrarAnimal, gbc);

        botaoCadastrarAnimal.setBackground(Color.decode("#025091"));
        botaoCadastrarAnimal.setForeground(Color.WHITE);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        botaoCadastrarAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String endereco = textEndereco.getText();
                String email = textEmail.getText();
                String telefone = textTelefone.getText();

                Cliente cliente = new Cliente(nome, telefone, email, endereco);

                try {
                    clienteRepository.adicionarCliente(cliente);
                    JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso!");
                    clientes.add(cliente);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao cadastrar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                frame.dispose();
                CadastroAnimalGUI cadastroAnimalGUI = new CadastroAnimalGUI();
                cadastroAnimalGUI.mostrarTelaCadastroAnimal();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public List<Cliente> getClientesCadastrados() {
        return clientes;
    }
}
