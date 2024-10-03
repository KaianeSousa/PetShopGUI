import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Criação do título com padding
        JLabel titulo = new JLabel("Seja bem-vindo ao nosso PetShop");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);  // Centralizar o texto
        titulo.setFont(new Font("Arial", Font.BOLD, 18));  // Definir fonte e tamanho do texto

        // Alterando a cor do texto do título
        titulo.setForeground(Color.decode("#025091"));  // Azul escuro

        // Adicionando padding ao título (espaço interno)
        titulo.setBorder(new EmptyBorder(20, 0, 20, 0));  // 20px de padding superior e inferior

        // Criação do logo
        ImageIcon logo = new ImageIcon("src/main/img/logo.png");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);  // Centralizar o logo

        // Cria um painel para agrupar o título e o logo
        JPanel panelTituloLogo = new JPanel();
        panelTituloLogo.setLayout(new BorderLayout());
        panelTituloLogo.setBackground(Color.decode("#ABD0EF"));  // Cor de fundo do painel

        // Adiciona o título e o logo ao painel
        panelTituloLogo.add(titulo, BorderLayout.NORTH);  // Título na parte superior
        panelTituloLogo.add(logoLabel, BorderLayout.CENTER);  // Logo logo abaixo do título

        // Painel para os botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout());
        panelBotoes.setBackground(Color.decode("#f6f6f6"));  // Cor de fundo do painel dos botões

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaço entre os botões
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;

        // Criação dos botões
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoAdministrar = new JButton("Área do Administrador");

        Dimension tamanhoBotao = new Dimension(200, 30);
        botaoEntrar.setPreferredSize(tamanhoBotao);
        botaoCadastrar.setPreferredSize(tamanhoBotao);
        botaoAdministrar.setPreferredSize(tamanhoBotao);

        // Definindo cores para os botões
        botaoEntrar.setBackground(Color.decode("#025091"));
        botaoEntrar.setForeground(Color.WHITE);

        botaoCadastrar.setBackground(Color.decode("#ABD0EF"));
        botaoCadastrar.setForeground(Color.decode("#025091"));

        botaoAdministrar.setBackground(Color.decode("#CD6C0A"));
        botaoAdministrar.setForeground(Color.WHITE);

        // Ações dos botões
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
                CadastroClienteGUI CadastroClienteGUI = new CadastroClienteGUI();
                CadastroClienteGUI.mostrarTelaCadastroCliente();
            }
        });

        botaoAdministrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministradorGUI AdministradorGUI = new AdministradorGUI();
                AdministradorGUI.mostrarTelaAdministrador();
            }
        });

        // Adiciona os botões ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBotoes.add(botaoEntrar, gbc);

        gbc.gridy = 1;
        panelBotoes.add(botaoCadastrar, gbc);

        gbc.gridy = 2;
        panelBotoes.add(botaoAdministrar, gbc);

        // Configura o layout do frame
        frame.setLayout(new BorderLayout());
        frame.add(panelTituloLogo, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(Color.decode("#ABD0EF"));  // Define cor de fundo geral
        frame.setVisible(true);
    }
}
