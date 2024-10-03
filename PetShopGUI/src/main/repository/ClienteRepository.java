package src.main.repository;

import entities.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public void adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (NOME, TELEFONE, EMAIL, ENDERECO) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar adicionar cliente no banco de dados.", e);
        }
    }

    public List<Cliente> buscarClientes() throws SQLException {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("NOME"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setEndereco(rs.getString("ENDERECO"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar buscar clientes no banco de dados.", e);
        }

        return clientes;
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET NOME = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ? WHERE TELEFONE = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar atualizar cliente no banco de dados.", e);
        }
    }

    public void removerCliente(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE TELEFONE = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover cliente do banco de dados.", e);
        }
    }
}
