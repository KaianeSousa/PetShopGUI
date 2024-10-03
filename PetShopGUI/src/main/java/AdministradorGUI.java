import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorGUI {

    public void mostrarTelaAdministrador() {
        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;

        JButton botaoListarClientes = new JButton("Ver Clientes Cadastrados");
        JButton botaoListarAnimais = new JButton("Ver Animais Cadastrados");
        JButton botaoVoltar = new JButton("Voltar");

        Dimension tamanhoBotao = new Dimension(200, 30);
        botaoListarClientes.setPreferredSize(tamanhoBotao);
        botaoListarAnimais.setPreferredSize(tamanhoBotao);
        botaoVoltar.setPreferredSize(tamanhoBotao);

        botaoListarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarClientesGUI listaclientes = new ListarClientesGUI();
                listaclientes.mostrarTelaListarClientes();
            }
        });

        botaoListarAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarAnimaisGUI listarAnimais = new ListarAnimaisGUI();
                listarAnimais.mostrarTelaListarAnimais();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        botaoListarClientes.setBackground(Color.decode("#CD6C0A"));
        botaoListarClientes.setForeground(Color.decode("#FFFFFF"));

        botaoListarAnimais.setBackground(Color.decode("#CD6C0A"));
        botaoListarAnimais.setForeground(Color.decode("#FFFFFF"));

        botaoVoltar.setBackground(Color.decode("#ABD0EF"));
        botaoVoltar.setForeground(Color.decode("#025091"));

        gbc.gridx = 0; gbc.gridy = 0;
        panelBotoes.add(botaoListarClientes, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelBotoes.add(botaoListarAnimais, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelBotoes.add(botaoVoltar, gbc);

        frame.add(panelBotoes);
        frame.setVisible(true);
    }
}