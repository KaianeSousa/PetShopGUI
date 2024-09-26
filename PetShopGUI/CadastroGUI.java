import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroGUI {

    private JTextField textNome;
    private JTextField textTelefone;
    private JTextField textEndereco;

    public void mostrarTela() {
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
        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);
        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textNome, gbc);
        gbc.gridx = 0; gbc.gridy = 1; 
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1; gbc.gridy = 1; /
        panel.add(textEndereco, gbc);
        gbc.gridx = 0; gbc.gridy = 2; 
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1; gbc.gridy = 2; 
        panel.add(textTelefone, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); 

        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton botaoCadastrarAnimal = new JButton("Cadastrar Animal");

        buttonPanel.add(botaoCadastrarCliente); 
        buttonPanel.add(botaoCadastrarAnimal);

        gbc.gridx = 0; 
        gbc.gridy = 3; 
        gbc.gridwidth = 2; 
        panel.add(buttonPanel, gbc); 

        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String endereco = textEndereco.getText();
                String telefone = textTelefone.getText();
                
                JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
            }
        });

        botaoCadastrarAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AnimalGUI animalGUI = new AnimalGUI();
                animalGUI.MostrarTelaAnimal();
            }
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}
