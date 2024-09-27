import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ListarClientesGUI {

    // Conexão com o banco de dados
    private Connection connection;

    public ListarClientesGUI() {
        try {
            // Configurar a conexão com o banco de dados PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/pgAdmin4";
            String user = "Kaiane";
            String password = "ads123";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void mostrarTelaListarClientes() {
        JFrame frame = new JFrame("Lista de Clientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        frame.setSize(600, 400);

        // Criando a tabela para exibir os clientes
        String[] columnNames = {"ID", "Nome", "Endereço", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Carregar os clientes do banco de dados
        carregarClientes(model);

        // Adicionando a tabela a um JScrollPane para rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tornando o frame visível
        frame.setVisible(true);
    }

    private void carregarClientes(DefaultTableModel model) {
        String query = "SELECT id, nome, endereco, telefone FROM clientes"; // Ajuste conforme sua tabela e colunas
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Puxando dados do banco e adicionando à tabela
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");

                // Adicionando a linha ao modelo da tabela
                model.addRow(new Object[]{id, nome, endereco, telefone});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar clientes: " + e.getMessage());
        }
    }
}
