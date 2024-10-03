import repository.ClienteRepository;
import entities.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ListarClientesGUI {

    private ClienteRepository clienteRepository = new ClienteRepository();
    private List<Cliente> clientes;

    public void mostrarTelaListarClientes() {
        JFrame frame = new JFrame();
        frame.setTitle("Listar Clientes");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            listarClientes(frame);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao buscar clientes: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        frame.setVisible(true);
    }

    public void listarClientes(JFrame frame) throws SQLException {
        clientes = clienteRepository.buscarClientes();

        if (clientes != null && !clientes.isEmpty()) {
            JPanel panelBotoes = new JPanel();
            JButton botaoExcluir = new JButton("Excluir");
            JButton botaoEditar = new JButton("Editar");

            JComboBox<String> clienteComboBox = new JComboBox<>();
            for (int i = 0; i < clientes.size(); i++) {
                clienteComboBox.addItem("Cliente " + (i + 1) + ": " + clientes.get(i).getNome());
            }

            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            atualizarTextArea(textArea);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 400));

            botaoExcluir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = clienteComboBox.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Cliente clienteSelecionado = clientes.get(selectedIndex);
                        try {
                            clienteRepository.removerCliente(clienteSelecionado);
                            clientes.remove(selectedIndex);
                            clienteComboBox.removeItemAt(selectedIndex);
                            JOptionPane.showMessageDialog(frame, "Cliente removido com sucesso.");
                            atualizarTextArea(textArea);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(frame, "Erro ao remover cliente: " + ex.getMessage(),
                                    "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Por favor, selecione um cliente.");
                    }
                }
            });

            botaoEditar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = clienteComboBox.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Cliente clienteSelecionado = clientes.get(selectedIndex);
                        editarCliente(clienteSelecionado, clienteComboBox, selectedIndex, textArea);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Por favor, selecione um cliente.");
                    }
                }
            });

            panelBotoes.add(clienteComboBox);
            panelBotoes.add(botaoExcluir);
            panelBotoes.add(botaoEditar);

            frame.setLayout(new BorderLayout());
            frame.add(panelBotoes, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum cliente cadastrado ainda.", "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String mostraCliente(Cliente cliente, int index) {
        return  "Cliente " + (index + 1) + ": \n" +
                "Nome: " + cliente.getNome() + "\n" +
                "Telefone: " + cliente.getTelefone() + "\n" +
                "E-mail: " + cliente.getEmail() + "\n" +
                "Endereço: " + cliente.getEndereco() + "\n" +
                "_____________________________________________";
    }

    private void editarCliente(Cliente cliente, JComboBox<String> comboBox, int selectedIndex, JTextArea textArea) {
        JTextField campoNome = new JTextField(cliente.getNome());
        JTextField campoTelefone = new JTextField(cliente.getTelefone());
        JTextField campoEmail = new JTextField(cliente.getEmail());
        JTextField campoEndereco = new JTextField(cliente.getEndereco());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);
        panel.add(new JLabel("Telefone:"));
        panel.add(campoTelefone);
        panel.add(new JLabel("E-mail:"));
        panel.add(campoEmail);
        panel.add(new JLabel("Endereço:"));
        panel.add(campoEndereco);

        int result = JOptionPane.showConfirmDialog(null, panel, "Editar Cliente",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            cliente.setNome(campoNome.getText());
            cliente.setTelefone(campoTelefone.getText());
            cliente.setEmail(campoEmail.getText());
            cliente.setEndereco(campoEndereco.getText());

            try {
                clienteRepository.atualizarCliente(cliente);
                clientes.set(selectedIndex, cliente);
                comboBox.insertItemAt("Cliente " + (selectedIndex + 1) + ": " + cliente.getNome(), selectedIndex);
                comboBox.removeItemAt(selectedIndex + 1);
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
                atualizarTextArea(textArea);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void atualizarTextArea(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clientes.size(); i++) {
            sb.append(mostraCliente(clientes.get(i), i)).append("\n\n");
        }
        textArea.setText(sb.toString());
    }
}
