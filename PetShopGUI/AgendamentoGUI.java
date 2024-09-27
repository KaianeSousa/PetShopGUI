import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class AgendamentoGUI {

    public void mostrarTelaAgendamento(String servicoEscolhido) {
        JFrame frame = new JFrame("Agendamento de Serviços");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelServico = new JLabel("Serviço selecionado: " + servicoEscolhido);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(labelServico, gbc);

        JLabel labelData = new JLabel("Escolha a data:");
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(labelData, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(dateChooser, gbc);

        JButton botaoAgendar = new JButton("Agendar");
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(botaoAgendar, gbc);

        botaoAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date dataSelecionada = dateChooser.getDate();
                String dataFormatada = (dataSelecionada != null) ? String.format("%1$td/%1$tm/%1$tY", dataSelecionada) : "Data não selecionada";
                JOptionPane.showMessageDialog(frame, "Agendamento realizado com sucesso:\n" +
                        "Serviço: " + servicoEscolhido + "\nData: " + dataFormatada);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
