import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalGUI {

    public void MostrarTelaAnimal() {
        // Criando o JFrame
        JFrame frame = new JFrame("Cadastro de Animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tamanho da Janela
        frame.setSize(500, 400);

        // Criando o painel principal com GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento interno (padding)
        gbc.weightx = 1.0; // Aumenta a largura do espaço ocupado pela linha

        // Criando os rótulos e campos de texto
        JLabel labelNomeAnimal = new JLabel("Nome do Animal:");
        JTextField textNomeAnimal = new JTextField(20);

        // Adicionando os componentes ao painel
        gbc.gridx = 0; gbc.gridy = 0; // Linha 0, Coluna 0
        panel.add(labelNomeAnimal, gbc);
        gbc.gridx = 1; gbc.gridy = 0; // Linha 0, Coluna 1
        panel.add(textNomeAnimal, gbc);

        JLabel labelIdade = new JLabel("Idade:");
        JTextField textIdade = new JTextField(5);
        JLabel labelRaca = new JLabel("Raça:");
        JTextField textRaca = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 1; // Linha 1, Coluna 0
        panel.add(labelIdade, gbc);
        gbc.gridx = 1; gbc.gridy = 1; // Linha 1, Coluna 1
        panel.add(textIdade, gbc);

        gbc.gridx = 0; gbc.gridy = 2; // Linha 2, Coluna 0
        panel.add(labelRaca, gbc);
        gbc.gridx = 1; gbc.gridy = 2; // Linha 2, Coluna 1
        panel.add(textRaca, gbc);

        // Criando um painel para o botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Usando FlowLayout para centralizar
        JButton botaoCadastrar = new JButton("Cadastrar Animal");
        buttonPanel.add(botaoCadastrar); // Adiciona o botão ao painel

        // Configurando o GridBagConstraints para o botão
        gbc.gridx = 0; // Posição na coluna
        gbc.gridy = 3; // Posição na linha
        gbc.gridwidth = 2; // Ocupando duas colunas
        panel.add(buttonPanel, gbc); // Adiciona o painel do botão ao painel principal

        // Adicionando funcionalidade ao botão
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAnimal = textNomeAnimal.getText();
                String idade = textIdade.getText();
                String raca = textRaca.getText();

                // Exibindo uma mensagem de confirmação
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
                frame.dispose(); // Fechar a tela após o cadastro
            }
        });

        // Adicionando o painel ao frame
        frame.add(panel);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
