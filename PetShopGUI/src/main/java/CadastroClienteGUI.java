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
    private JButton botaoCadastrarAnimal;
    private JLabel prosseguirCadastro;
    private JPanel painelButton;

    private ClienteRepository clienteRepository;
    private List<Cliente> clientes;

    public CadastroClienteGUI() {
        clienteRepository = new ClienteRepository();
        clientes = new ArrayList<>();
    }

    public void mostrarTelaCadastroCliente() {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);

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

        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(textEndereco, gbc);

        JLabel labelEmail = new JLabel("E-mail:");
        textEmail = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(textEmail, gbc);

        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(textTelefone, gbc);

        JLabel prosseguirCadastro = new JLabel("Clique no botão prosseguir com seu cadastro no sistema.");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(prosseguirCadastro, gbc);

        JButton botaoCadastrarAnimal = new JButton("Cadastrar Animal");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botaoCadastrarAnimal, gbc);



        botaoCadastrarAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String endereco = textEndereco.getText();
                String email = textEmail.getText();
                String telefone = textTelefone.getText();

                if (nome.isEmpty() || endereco.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Para se cadastrar, preencha corretamente todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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
