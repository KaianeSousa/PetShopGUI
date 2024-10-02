import entities.Cliente;
import repository.ClienteRepository;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListarClientesGUI {

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
        ClienteRepository cr = new ClienteRepository();
        List<Cliente> clientes = cr.buscarClientes();

        if (clientes != null && !clientes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Cliente cliente : clientes) {
                sb.append(mostraCliente(cliente)).append("\n\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(700, 500));

            frame.add(scrollPane, BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhum cliente cadastrado ainda.", "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String mostraCliente(Cliente cliente) {
        return "----------------------------------------------------------------------\n" +
                "Identificador do cliente: " + cliente.getId() + "\n" +
                "Nome do cliente: " + cliente.getNome() + "\n" +
                "Telefone: " + cliente.getTelefone() + "\n" +
                "E-mail: " + cliente.getEmail() + "\n" +
                "Endereço: " + cliente.getEndereco();
    }

    public static void main(String[] args) {
        ListarClientesGUI listarClientesGUI = new ListarClientesGUI();
        listarClientesGUI.mostrarTelaListarClientes();
    }
}
