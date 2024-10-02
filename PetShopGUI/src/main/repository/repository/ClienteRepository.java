package repository;

import entities.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID; // Importação correta do UUID

public class ClienteRepository {

    public void adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (ID, NOME, TELEFONE, EMAIL, ENDERECO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) { // Alterado para ConectarBancoDeDados
            stmt.setString(1, cliente.getId().toString()); // ID como UUID
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar cliente: " + e.getMessage());
            throw new SQLException("Erro ao tentar adicionar cliente no banco de dados.", e);
        }
    }

    public List<Cliente> buscarClientes() throws SQLException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) { // Alterado para ConectarBancoDeDados
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(UUID.fromString(rs.getString("ID"))); // Usando UUID em vez de UID
                cliente.setNome(rs.getString("NOME"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setEndereco(rs.getString("ENDERECO"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar clientes: " + e.getMessage());
            throw new SQLException("Erro ao tentar buscar clientes no banco de dados.", e);
        }

        return clientes;
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET NOME = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ? WHERE ID = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) { // Alterado para ConectarBancoDeDados
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getId().toString()); // ID como UUID
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
            throw new SQLException("Erro ao tentar atualizar cliente no banco de dados.", e);
        }
    }

    public void removerCliente(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE ID = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) { // Alterado para ConectarBancoDeDados
            stmt.setString(1, cliente.getId().toString()); // ID como UUID
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
            throw new SQLException("Erro ao tentar remover cliente do banco de dados.", e);
        }
    }
}
