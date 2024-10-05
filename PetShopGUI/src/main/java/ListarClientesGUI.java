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
    private JFrame frame;

    public void mostrarTelaListarClientes() {
        frame = new JFrame();
        frame.setTitle("Listar Clientes");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            listarClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Erro ao buscar clientes: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        frame.setVisible(true);
    }

    public void listarClientes() throws SQLException, ClassNotFoundException {
        clientes = clienteRepository.buscarClientes();

        frame.getContentPane().removeAll();
        frame.repaint();

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

            atualizarListaClientes(textArea);

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
                            atualizarListaClientes(textArea);
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

            frame.getContentPane().setBackground(Color.decode("#F0F8FF"));

            frame.setLayout(new BorderLayout());
            frame.add(panelBotoes, BorderLayout.NORTH);
            frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum cliente cadastrado ainda.", "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String mostraEntradas(Cliente cliente) {
        String entradas = "ID: " + cliente.getId() + "\n" +
                "Nome: " + cliente.getNome() + "\n" +
                "Telefone: " + cliente.getTelefone() + "\n" +
                "Email: " + cliente.getEmail() + "\n" +
                "Endereço: " + cliente.getEndereco() + "\n" +
                "_____________________________________________________________________________\n";

        return entradas;
    }

    public void editarCliente(Cliente clienteSelecionado, JComboBox<String> clienteComboBox, int index, JTextArea textArea) {
        JTextField nomeField = new JTextField(clienteSelecionado.getNome());
        JTextField telefoneField = new JTextField(clienteSelecionado.getTelefone());
        JTextField emailField = new JTextField(clienteSelecionado.getEmail());
        JTextField enderecoField = new JTextField(clienteSelecionado.getEndereco());
        JTextField senhaField = new JTextField(clienteSelecionado.getSenha());

        Object[] message = {
                "Nome:", nomeField,
                "Telefone:", telefoneField,
                "Email:", emailField,
                "Endereço:", enderecoField,
                "Senha:", senhaField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Editar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            clienteSelecionado.setNome(nomeField.getText());
            clienteSelecionado.setTelefone(telefoneField.getText());
            clienteSelecionado.setEmail(emailField.getText());
            clienteSelecionado.setEndereco(enderecoField.getText());
            clienteSelecionado.setSenha(senhaField.getText());

            try {
                clienteRepository.atualizarCliente(clienteSelecionado);
                clientes.set(index, clienteSelecionado);
                atualizarListaClientes(textArea);
                JOptionPane.showMessageDialog(frame, "Cliente atualizado com sucesso.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(frame, "Erro ao atualizar cliente: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void atualizarListaClientes(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append(mostraEntradas(cliente)).append("\n");
        }
        textArea.setText(sb.toString());
    }
}
