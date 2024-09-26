import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalGUI {

    public void MostrarTelaAnimal() {
        JFrame frame = new JFrame("Cadastro de Animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JTextField textIdade = new JTextField(10);

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

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
                frame.dispose(); 
            }
        });

        frame.add(panel);

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
