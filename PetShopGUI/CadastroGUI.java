import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroGUI {

    private JTextField textNome;
    private JTextField textTelefone;
    private JTextField textEndereco;

    public void mostrarTela() {
        // Criando o JFrame
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Criando o painel principal com GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento interno (padding)
        gbc.weightx = 1.0;

        // Criando os rótulos e campos de texto
        JLabel labelNome = new JLabel("Nome:");
        textNome = new JTextField(20);
        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);
        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);

        // Adicionando os componentes ao painel
        gbc.gridx = 0; gbc.gridy = 0; // Linha 0, Coluna 0
        panel.add(labelNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0; // Linha 0, Coluna 1
        panel.add(textNome, gbc);
        gbc.gridx = 0; gbc.gridy = 1; // Linha 1, Coluna 0
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1; gbc.gridy = 1; // Linha 1, Coluna 1
        panel.add(textEndereco, gbc);
        gbc.gridx = 0; gbc.gridy = 2; // Linha 2, Coluna 0
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1; gbc.gridy = 2; // Linha 2, Coluna 1
        panel.add(textTelefone, gbc);

        // Criando um painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Usando FlowLayout para centralizar

        // Criando os botões de cadastro
        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton botaoCadastrarAnimal = new JButton("Cadastrar Animal");

        buttonPanel.add(botaoCadastrarCliente); // Adicionando o botão de cliente ao painel
        buttonPanel.add(botaoCadastrarAnimal); // Adicionando o botão de animal ao painel

        // Configurando o GridBagConstraints para o painel de botões
        gbc.gridx = 0; // Posição na coluna
        gbc.gridy = 3; // Posição na linha
        gbc.gridwidth = 2; // Ocupando duas colunas
        panel.add(buttonPanel, gbc); // Adiciona o painel de botões ao painel principal

        // Adicionando funcionalidade ao botão de cadastro de cliente
        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String endereco = textEndereco.getText();
                String telefone = textTelefone.getText();
                // Exibindo uma mensagem de confirmação
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
            }
        });

        // Adicionando funcionalidade ao botão de cadastro de animal
        botaoCadastrarAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela atual
                frame.dispose();
                // Abrir a tela AnimalGUI
                AnimalGUI animalGUI = new AnimalGUI();
                animalGUI.MostrarTelaAnimal();
            }
        });

        // Adicionando o painel ao frame
        frame.add(panel);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
