import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroGUI {

    private JTextField textNome;
    private JLabel labelNome;
    private JTextField textTelefone;
    private JTextField textEndereco;

    public void mostrarTela() {
        // Criando o JFrame
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tamanho da Janela
        frame.setSize(500, 400);

        // Criando o painel principal com GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbcCadastro = new GridBagConstraints();
        gbcCadastro.fill = GridBagConstraints.HORIZONTAL;
        gbcCadastro.insets = new Insets(10, 10, 10, 10); // Espaçamento interno (padding)
        gbcCadastro.weightx = 1.0;

        // Criando os rótulos e campos de texto
        JLabel labelNome = new JLabel("Nome:");
        JTextField textNome = new JTextField(20);

        // Adicionando os componentes ao painel
        gbcCadastro.gridx = 0; gbcCadastro.gridy = 0; // Linha 0, Coluna 0
        panel.add(labelNome, gbcCadastro);
        gbcCadastro.gridx = 1; gbcCadastro.gridy = 0; // Linha 0, Coluna 1
        panel.add(textNome, gbcCadastro);

        JLabel labelEndereco = new JLabel("Endereço:");
        JTextField textEndereco = new JTextField(20);

        gbcCadastro.gridx = 0; gbcCadastro.gridy = 1; // Linha 1, Coluna 0
        panel.add(labelEndereco, gbcCadastro);
        gbcCadastro.gridx = 1; gbcCadastro.gridy = 1; // Linha 1, Coluna 1
        panel.add(textEndereco, gbcCadastro);

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField textTelefone = new JTextField(20);

        gbcCadastro.gridx = 0; gbcCadastro.gridy = 2; // Linha 2, Coluna 0
        panel.add(labelTelefone, gbcCadastro);
        gbcCadastro.gridx = 1; gbcCadastro.gridy = 2; // Linha 2, Coluna 1
        panel.add(textTelefone, gbcCadastro);

        // Criando o botão de agendamento
        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        // Adicionando o botão de agendamento
        gbcCadastro.gridx = 0; gbcCadastro.gridy = 3; gbcCadastro.gridwidth = 1; // Linha 3, ocupando duas colunas
        panel.add(botaoCadastrarCliente, gbcCadastro);

        // Criando o botão "Cadastrar Animal"
        JButton botaoCadastrarAnimal = new JButton("Cadastrar Animal");
        // Adicionando o botão ao painel
        gbcCadastro.gridx = 0; gbcCadastro.gridy = 4; gbcCadastro.gridwidth = 1; // Linha 3, ocupando duas colunas
        panel.add(botaoCadastrarAnimal, gbcCadastro);

        // Adicionando funcionalidade ao botão
        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String endereco = textEndereco.getText();
                String telefone = textTelefone.getText();

                // Exibindo uma mensagem de confirmação
                JOptionPane.showMessageDialog(frame, "Cadastro Realizado com Sucesso!\n" +
                        "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone);
            }
        });


        // Adicionando funcionalidade ao botão
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
