package repository;

import entities.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    public void adicionarAnimal(Animal animal) throws SQLException {
        String sql = "INSERT INTO animais (NOME, RACA, IDADE, TIPO) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, animal.getIdade());
            stmt.setString(4, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar adicionar animal no banco de dados.", e);
        }
    }

    public List<Animal> buscarAnimais() throws SQLException {
        String sql = "SELECT * FROM animais";
        List<Animal> animais = new ArrayList<>();

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getString("NOME"),
                        rs.getString("RACA"),
                        rs.getString("TIPO"),
                        rs.getString("IDADE")
                );

                animais.add(animal);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar buscar animais no banco de dados.", e);
        }

        return animais;
    }

    public void atualizarAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE animais SET NOME = ?, RACA = ?, IDADE = ?, TIPO = ? WHERE NOME = ? AND RACA = ? AND IDADE = ? AND TIPO = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, animal.getIdade());
            stmt.setString(4, animal.getTipo());
            stmt.setString(5, animal.getNome());
            stmt.setString(6, animal.getRaca());
            stmt.setString(7, animal.getIdade());
            stmt.setString(8, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar atualizar animal no banco de dados.", e);
        }
    }

    public void removerAnimal(Animal animal) throws SQLException {
        String sql = "DELETE FROM animais WHERE NOME = ? AND RACA = ? AND IDADE = ? AND TIPO = ?";

        try (PreparedStatement stmt = ConectarBancoDeDados.getConnection().prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getRaca());
            stmt.setString(3, animal.getIdade());
            stmt.setString(4, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar remover animal do banco de dados.", e);
        }
    }
}
