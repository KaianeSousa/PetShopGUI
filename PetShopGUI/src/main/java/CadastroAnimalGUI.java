import repository.AnimalRepository;
import entities.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroAnimalGUI {

    private JFrame frame;
    private JPanel panel;
    private JLabel labelNomeAnimal;
    private JLabel labelIdade;
    private JLabel labelTipo;
    private JLabel labelRaca;

    private JButton botaoCadastrar;

    private AnimalRepository animalRepository = new AnimalRepository();
    private ArrayList<Animal> animaisCadastrados = new ArrayList<>();

    public void mostrarTelaCadastroAnimal() {
        frame = new JFrame("Cadastro de Animal");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        labelNomeAnimal = new JLabel("Nome do Animal:");
        JTextField textNomeAnimal = new JTextField(20);
        labelNomeAnimal.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelNomeAnimal, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textNomeAnimal, gbc);

        labelIdade = new JLabel("Idade:");
        JTextField textIdade = new JTextField(20);
        labelIdade.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelIdade, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(textIdade, gbc);

        labelTipo = new JLabel("Tipo:");
        JTextField textTipo = new JTextField(20);
        labelTipo.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(labelTipo, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(textTipo, gbc);

        labelRaca = new JLabel("Raça:");
        JTextField textRaca = new JTextField(20);
        labelRaca.setForeground(Color.decode("#025091"));
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(labelRaca, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(textRaca, gbc);

        botaoCadastrar = new JButton("Cadastrar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(botaoCadastrar, gbc);

        botaoCadastrar.addActionListener((ActionEvent e) -> {
            String nomeAnimal = textNomeAnimal.getText();
            String idade = textIdade.getText();
            String tipo = textTipo.getText();
            String raca = textRaca.getText();

            if (nomeAnimal.isEmpty() || idade.isEmpty() || tipo.isEmpty() || raca.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Para se cadastrar, preencha corretamente todos os campos.",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Animal animal = new Animal(nomeAnimal, raca, tipo, idade);
                animaisCadastrados.add(animal);
                animalRepository.adicionarAnimal(animal);
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
                frame.dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar animal: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCadastrar.setBackground(Color.decode("#025091"));
        botaoCadastrar.setForeground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#F0F8FF"));
    }
}
