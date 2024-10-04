import entities.Agendamento;
import repository.AgendamentoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoGUI {
    private List<Agendamento> agendamentos = new ArrayList<>(); // Lista para armazenar os agendamentos

    public void mostrarTelaAgendamento(String servicoEscolhido) {
        JFrame frame = new JFrame("Agendamento de Serviços");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        JLabel labelHorario = new JLabel("Escolha o horário:");
        String[] horarios = {"08:00", "09:00", "10:00", "11:00", "12:00",
                "14:00", "15:00", "16:00", "17:00", "18:00"};
        JComboBox<String> comboBoxHorarios = new JComboBox<>(horarios);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        panel.add(labelHorario, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(comboBoxHorarios, gbc);

        JButton botaoAgendar = new JButton("Agendar");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botaoAgendar, gbc);

        botaoAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date dataSelecionada = dateChooser.getDate();

                if (dataSelecionada != null) {
                    Date dataSql = new Date(dataSelecionada.getTime()); // Converte java.util.Date para java.sql.Date

                    // Captura o horário selecionado
                    String horarioSelecionado = (String) comboBoxHorarios.getSelectedItem();
                    Time horarioSql = Time.valueOf(horarioSelecionado + ":00"); // Converte String para java.sql.Time

                    // Cria um novo agendamento
                    Agendamento novoAgendamento = new Agendamento(dataSql, horarioSql);
                    AgendamentoRepository.salvarAgendamento(novoAgendamento); // Salva o agendamento no banco

                    agendamentos.add(novoAgendamento); // Adiciona o agendamento à lista

                    // Exibe a mensagem
                    JOptionPane.showMessageDialog(frame, "Agendamento realizado com sucesso:\n" +
                            "Serviço: " + servicoEscolhido + "\nData: " + dataSql + "\nHorário: " + horarioSql);
                } else {
                    JOptionPane.showMessageDialog(frame, "Data não selecionada. Por favor, escolha uma data.");
                }

                frame.dispose();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
