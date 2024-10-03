package src.main.repository;

import entities.Animal;
import src.main.repository.ConectarBancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    public void adicionarAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO Animal (NOME, RACA, IDADE, DONO, TIPO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setInt(3, animal.getIdade());
            stmt.setObject(4, animal.getDono());
            stmt.setString(5, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar animal: " + e.getMessage());
            throw new SQLException("Erro ao tentar adicionar animal no banco de dados.", e);
        }
    }

    public List<Animal> buscarAnimais() throws SQLException {
        String sql = "SELECT * FROM Animal";
        List<Animal> animais = new ArrayList<>();

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getString("NOME"),
                        rs.getString("RACA"),
                        rs.getString("TIPO"),
                        rs.getInt("IDADE"),
                        null
                );

                animais.add(animal);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar animais: " + e.getMessage());
            throw new SQLException("Erro ao tentar buscar animais no banco de dados.", e);
        }

        return animais;
    }

    public void removerAnimal(Animal animal) throws SQLException {
        String sql = "DELETE FROM Animal WHERE NOME = ? AND RACA = ? AND IDADE = ? AND TIPO = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setInt(3, animal.getIdade());
            stmt.setString(4, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao remover animal: " + e.getMessage());
            throw new SQLException("Erro ao tentar remover animal do banco de dados.", e);
        }
    }
}
