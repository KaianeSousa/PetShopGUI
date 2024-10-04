import repository.AnimalRepository;
import entities.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroAnimalGUI {

    private AnimalRepository animalRepository = new AnimalRepository();
    private ArrayList<Animal> animaisCadastrados = new ArrayList<>();

    public void mostrarTelaCadastroAnimal() {
        JFrame frame = new JFrame("Cadastro de Animal");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelNomeAnimal = new JLabel("Nome do Animal:");
        JTextField textNomeAnimal = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelNomeAnimal, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textNomeAnimal, gbc);

        JLabel labelIdade = new JLabel("Idade:");
        JTextField textIdade = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelIdade, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(textIdade, gbc);

        JLabel labelTipo = new JLabel("Tipo:");
        JTextField textTipo = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(labelTipo, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(textTipo, gbc);

        JLabel labelRaca = new JLabel("Raça:");
        JTextField textRaca = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(labelRaca, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(textRaca, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton botaoCadastrar = new JButton("Cadastrar");
        buttonPanel.add(botaoCadastrar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
