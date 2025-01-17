package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root"; // Usuário do banco de dados
    private static final String PASSWORD = "8989"; // Senha do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/db_agenda"; // URL do banco de dados

    // Método estático para estabelecer uma conexão com o banco de dados
    public static Connection connectionToMyDb() {
        try {
            // Usar o novo driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão com o banco de dados
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado: " + e.getMessage());
            throw new RuntimeException("Driver não encontrado", e);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro de conexão", e);
        }
    }

    // Método principal para teste de conexão
    public static void main(String[] args) {
        try (Connection con = connectionToMyDb()) {
            if (con != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Falha ao fechar a conexão: " + e.getMessage());
        }
    }
}
