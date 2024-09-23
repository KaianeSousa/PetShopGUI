import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalGUI {

    public void MostrarTelaAnimal () {
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
        gbc.weightx = 1.0;

        // Criando os rótulos e campos de texto
        JLabel labelNomeAnimal = new JLabel("Nome do Animal:");
        JTextField textNomeAnimal = new JTextField(20);

        // Adicionando os componentes ao painel
        gbc.gridx = 0; gbc.gridy = 0; // Linha 0, Coluna 0
        panel.add(labelNomeAnimal, gbc);
        gbc.gridx = 1; gbc.gridy = 0; // Linha 0, Coluna 1
        panel.add(textNomeAnimal, gbc);
/*
        JLabel labelEspecie = new JLabel("Espécie:");
        JTextField textEspecie = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 1; // Linha 1, Coluna 0
        panel.add(labelEspecie, gbc);
        gbc.gridx = 1; gbc.gridy = 1; // Linha 1, Coluna 1
        panel.add(textEspecie, gbc);
*/
        JLabel labelIdade = new JLabel("Idade:");
        JTextField textIdade = new JTextField(5);

        JLabel labelRaca = new JLabel("Raça:");
        JTextField textRaca = new JTextField(20);


        gbc.gridx = 0; gbc.gridy = 2; // Linha 2, Coluna 0
        panel.add(labelIdade, gbc);
        gbc.gridx = 1; gbc.gridy = 2; // Linha 2, Coluna 1
        panel.add(textIdade, gbc);

        // Criando o botão de cadastro
        JButton botaoCadastrar = new JButton("Cadastrar Animal");
        botaoCadastrar.setPreferredSize(new Dimension(20, 30));

        gbc.gridx = 0; gbc.gridy = 3; // Linha 3, Coluna 0
        panel.add(labelRaca, gbc);
        gbc.gridx = 1; gbc.gridy = 3; // Linha 3, Coluna 1
        panel.add(textRaca, gbc);

        // Adicionando o botão de cadastro
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; // Linha 4, ocupando duas colunas
        panel.add(botaoCadastrar, gbc);

        // Adicionando funcionalidade ao botão
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAnimal = textNomeAnimal.getText();
               // String especie = textEspecie.getText();
                String idade = textIdade.getText();
                String raca = textRaca.getText();

                // Exibindo uma mensagem de confirmação
                JOptionPane.showMessageDialog(frame, "Animal cadastrado com sucesso:\n" +
                        "Nome: " + nomeAnimal + "\nIdade: " + idade + "\nRaça: " + raca);
            }
        });

        // Adicionando o painel ao frame
        frame.add(panel);

        // Tornando o frame visível
        frame.setVisible(true);
    }

    public void mostrarTelaAnimal() {
    }
}
