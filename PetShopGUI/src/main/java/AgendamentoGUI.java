import entities.Agendamento;
import repository.AgendamentoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoGUI {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void mostrarTelaAgendamento(String servicoEscolhido) {
        JFrame frame = new JFrame("Agendamento de Serviços");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        JLabel labelServico = new JLabel("Serviço selecionado: " + servicoEscolhido);
        labelServico.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(labelServico, gbc);

        JLabel labelData = new JLabel("Escolha a data:");
        labelData.setFont(new Font("Arial", Font.PLAIN, 14));
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
        botaoAgendar.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botaoAgendar, gbc);

        botaoAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date dataSelecionada = dateChooser.getDate();

                if (dataSelecionada != null) {
                    Date dataSql = new Date(dataSelecionada.getTime());


                    String horarioSelecionado = (String) comboBoxHorarios.getSelectedItem();
                    Time horarioSql = Time.valueOf(horarioSelecionado + ":00");

                    Agendamento novoAgendamento = new Agendamento(dataSql, horarioSql);
                    try {
                        AgendamentoRepository.salvarAgendamento(novoAgendamento);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    agendamentos.add(novoAgendamento);

                    // Exibe a mensagem
                    JOptionPane.showMessageDialog(frame, "Agendamento realizado com sucesso:\n" +
                            "Serviço: " + servicoEscolhido + "\nData: " + dataSql + "\nHorário: " + horarioSql);
                } else {
                    JOptionPane.showMessageDialog(frame, "Data não selecionada. Por favor, escolha uma data.");
                }

                frame.dispose();
            }
        });


        botaoAgendar.setBackground(Color.decode("#025091"));
        botaoAgendar.setForeground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#F0F8FF"));
    }
}
