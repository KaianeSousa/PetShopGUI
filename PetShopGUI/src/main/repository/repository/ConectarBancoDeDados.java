package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBancoDeDados {
    private static final String URL = "jdbc:mysql://localhost:3307/petshop";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o Banco de Dados estabelecida com sucesso!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver do MySQL: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados.");
                e.printStackTrace();
            }
        }
    }
}
