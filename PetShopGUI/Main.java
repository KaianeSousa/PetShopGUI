import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        ImageIcon logo = new ImageIcon("img/logo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;

        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoAdministrar = new JButton("Área do Administrador");

        Dimension tamanhoBotao = new Dimension(200, 30);
        botaoEntrar.setPreferredSize(tamanhoBotao);
        botaoCadastrar.setPreferredSize(tamanhoBotao);
        botaoAdministrar.setPreferredSize(tamanhoBotao);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI = new LoginGUI();
                loginGUI.mostrarTelaLogin();
            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroGUI cadastroGUI = new CadastroGUI();
                cadastroGUI.mostrarTelaCadastro();
            }
        });

        botaoAdministrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministradorGUI AdministradorGUI = new AdministradorGUI();
                AdministradorGUI.mostrarTelaAdministrador();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBotoes.add(botaoEntrar, gbc);

        gbc.gridy = 1;
        panelBotoes.add(botaoCadastrar, gbc);

        gbc.gridy = 2;
        panelBotoes.add(botaoAdministrar, gbc);

        frame.setLayout(new BorderLayout());
        frame.add(logoLabel, BorderLayout.CENTER);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
