import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorGUI {

    public void mostrarTelaAdministrador() {
        JFrame frame = new JFrame("Pet Shop");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;

        JButton botaoListarClientes = new JButton("Ver Clientes Cadastrados");
        JButton botaoListarAnimais = new JButton("Ver Animais Cadastrados");

        Dimension tamanhoBotao = new Dimension(200, 30);
        botaoListarClientes.setPreferredSize(tamanhoBotao);
        botaoListarAnimais.setPreferredSize(tamanhoBotao);

        botaoListarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarClientesGUI listaclientes = new ListarClientesGUI();
                listaclientes.mostrarTelaListarClientes();
            }
        });

        botaoListarClientes.setBackground(Color.decode("#CD6C0A"));
        botaoListarClientes.setForeground(Color.decode("#FFFFFF"));

        botaoListarAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarAnimaisGUI listarAnimais = new ListarAnimaisGUI();
                listarAnimais.mostrarTelaListarAnimais();
            }
        });

        botaoListarAnimais.setBackground(Color.decode("#CD6C0A"));
        botaoListarAnimais.setForeground(Color.decode("#FFFFFF"));

        gbc.gridx = 0; gbc.gridy = 0;
        panelBotoes.add(botaoListarClientes, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelBotoes.add(botaoListarAnimais, gbc);

        frame.add(panelBotoes);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#FFFACD"));
    }
}