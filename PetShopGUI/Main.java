import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tamanho da Janela
        frame.setSize(500, 400);

        // Carregando a imagem da logo
        ImageIcon logo = new ImageIcon("img/catsPNG.png");

        // Criando um JLabel com a imagem
        JLabel logoLabel = new JLabel(logo);

        // Centralizando a logo
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Criando painel de botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout()); // Usando GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz com que o botão preencha a largura
        gbc.weightx = 10.0; // Permite que o botão expanda

        // Criando os botões
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar");

        // Adicionando ações aos botões
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Botão 1 foi clicado!");
            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicionando funcionalidade ao botão
                botaoCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Fechar a tela atual
                        frame.dispose();
                        // Abrir a tela AnimalGUI
                        CadastroGUI cadastroGUI = new CadastroGUI();
                        cadastroGUI.mostrarTela();
                    }
                });
            }
        });

        botaoEntrar.setPreferredSize(new Dimension(100, 40)); // Largura 200px, Altura 50px
        botaoCadastrar.setPreferredSize(new Dimension(100, 40));
        // Adicionando os botões ao painel
        gbc.gridx = 0; // Posição na grade (coluna)
        panelBotoes.add(Box.createVerticalStrut(70), gbc);
        gbc.gridy = 0; // Posição na grade (linha)
        panelBotoes.add(botaoEntrar, gbc);

        gbc.gridy = 1; // Mover para a próxima linha
        panelBotoes.add(botaoCadastrar, gbc);

        // Configurando o layout do frame
        frame.setLayout(new BorderLayout());


        // Adicionando componentes ao frame
        frame.add(logoLabel, BorderLayout.CENTER); // Logo no centro
        frame.add(panelBotoes, BorderLayout.SOUTH); // Painel de botões na parte inferior

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
