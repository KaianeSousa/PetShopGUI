import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteGUI {

    private JTextField textNome;
    private JTextField textTelefone;
    private JTextField textEmail;
    private JTextField textEndereco;
    public JButton botaoCadastrarAnimal;
    public JButton botaoVoltar;
    private JPanel painelButton;
    

    public void mostrarTelaCadastro() {
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

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(textNome, gbc);

        JLabel labelEndereco = new JLabel("Endereço:");
        textEndereco = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelEndereco, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(textEndereco, gbc);
        
        JLabel labelEmail = new JLabel("E-mail:");
        textEmail = new JTextField(20);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(textEmail, gbc);
        
        JLabel labelTelefone = new JLabel("Telefone:");
        textTelefone = new JTextField(20);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(labelTelefone, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(textTelefone, gbc);

        JPanel painelButton = new JPanel();
        painelButton.setLayout(new FlowLayout());

        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoCadastrarAnimal = new JButton("Cadastrar Animal");

        painelButton.add(botaoVoltar);
        painelButton.add(botaoCadastrarAnimal);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(painelButton, gbc);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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