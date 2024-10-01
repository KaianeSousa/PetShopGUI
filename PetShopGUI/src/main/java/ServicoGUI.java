import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicoGUI {

    public void mostrarTelaServicos() {
        JFrame frame = new JFrame("Serviços");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelServicos = new JLabel("Escolha um serviço:", JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(labelServicos, gbc);

        JButton botaoBanho = new JButton("Banho");
        gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(botaoBanho, gbc);

        JButton botaoTosa = new JButton("Tosa");
        gbc.gridx = 1;
        panel.add(botaoTosa, gbc);

        JButton botaoVeterinario = new JButton("Consulta Veterinária");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(botaoVeterinario, gbc);

        JButton botaoPasseio = new JButton("Passeio com Animais");
        gbc.gridx = 1;
        panel.add(botaoPasseio, gbc);

        botaoBanho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AgendamentoGUI agendamentoGUI = new AgendamentoGUI();
                agendamentoGUI.mostrarTelaAgendamento("Banho");
            }
        });

        botaoTosa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AgendamentoGUI agendamentoGUI = new AgendamentoGUI();
                agendamentoGUI.mostrarTelaAgendamento("Tosa");
            }
        });

        botaoVeterinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AgendamentoGUI agendamentoGUI = new AgendamentoGUI();
                agendamentoGUI.mostrarTelaAgendamento("Consulta Veterinária");
            }
        });

        botaoPasseio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                AgendamentoGUI agendamentoGUI = new AgendamentoGUI();
                agendamentoGUI.mostrarTelaAgendamento("Passeio com Animais");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}