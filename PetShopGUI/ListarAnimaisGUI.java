import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ListarAnimaisGUI {

    // Conexão com o banco de dados
    private Connection connection;

    public ListarAnimaisGUI() {
        try {
            // Configurar a conexão com o banco de dados PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/seu_banco_de_dados"; // Altere conforme necessário
            String user = "seu_usuario"; // Altere conforme necessário
            String password = "sua_senha"; // Altere conforme necessário
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void mostrarTelaListarAnimais() {
        JFrame frame = new JFrame("Lista de Animais");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        frame.setSize(600, 400);

        // Criando a tabela para exibir os animais
        String[] columnNames = {"ID", "Nome", "Espécie", "Raça", "Idade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Carregar os animais do banco de dados
        carregarAnimais(model);

        // Adicionando a tabela a um JScrollPane para rolagem
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tornando o frame visível
        frame.setVisible(true);
    }

    private void carregarAnimais(DefaultTableModel model) {
        String query = "SELECT id, nome, especie, raca, idade FROM animais"; // Ajuste conforme sua tabela e colunas
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Puxando dados do banco e adicionando à tabela
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especie = rs.getString("especie");
                String raca = rs.getString("raca");
                int idade = rs.getInt("idade");

                // Adicionando a linha ao modelo da tabela
                model.addRow(new Object[]{id, nome, especie, raca, idade});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar animais: " + e.getMessage());
        }
    }
}
