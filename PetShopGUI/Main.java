import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        ImageIcon logo = new ImageIcon("img/catsPNG.png");

        JLabel logoLabel = new JLabel(logo);

        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.weightx = 10.0;
        
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar");

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Botão 'Entrar' foi clicado!");
            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroGUI cadastroGUI = new CadastroGUI();
                cadastroGUI.mostrarTela();
            }
        });

        botaoEntrar.setPreferredSize(new Dimension(100, 40)); 
        botaoCadastrar.setPreferredSize(new Dimension(100, 40));

        gbc.gridx = 0;
        panelBotoes.add(Box.createVerticalStrut(70), gbc);
        gbc.gridy = 0; 
        panelBotoes.add(botaoEntrar, gbc);

        gbc.gridy = 1; 
        panelBotoes.add(botaoCadastrar, gbc);

        frame.setLayout(new BorderLayout());

        frame.add(logoLabel, BorderLayout.CENTER); 
        frame.add(panelBotoes, BorderLayout.SOUTH); 

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
