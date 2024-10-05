import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        JLabel titulo = new JLabel("Seja bem-vindo ao nosso PetShop");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.decode("#025091"));
        titulo.setBorder(new EmptyBorder(20, 0, 20, 0));

        JPanel panelTituloLogo = new JPanel();
        panelTituloLogo.setLayout(new BorderLayout());
        panelTituloLogo.setBackground(Color.decode("#ABD0EF"));
        panelTituloLogo.add(titulo, BorderLayout.NORTH);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout());
        panelBotoes.setBackground(Color.decode("#f6f6f6"));

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

        botaoEntrar.setBackground(Color.decode("#025091"));
        botaoEntrar.setForeground(Color.WHITE);

        botaoCadastrar.setBackground(Color.decode("#ABD0EF"));
        botaoCadastrar.setForeground(Color.decode("#025091"));

        botaoAdministrar.setBackground(Color.decode("#CD6C0A"));
        botaoAdministrar.setForeground(Color.WHITE);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginClienteGUI loginClienteGUI = new LoginClienteGUI();
                loginClienteGUI.mostrarTelaLogin();
            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroClienteGUI cadastroClienteGUI = new CadastroClienteGUI();
                cadastroClienteGUI.mostrarTelaCadastroCliente();
            }
        });

        botaoAdministrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdministradorGUI loginAdministradorGUI = new LoginAdministradorGUI();
                loginAdministradorGUI.mostrarTelaLoginAdministrador();
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
        frame.add(panelTituloLogo, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(Color.decode("#ABD0EF"));
        frame.setVisible(true);
    }
}
