package DAO;
import connection.ConnectionFactory;// importação do pacote connection.ConnectionFactory em específico para fazer a conexão com o BD
import java.sql.Connection;// importação do pacote modelo.Agenda em específico
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Agenda;
import modelo.Contato;

public class AgendaDAO {
    // CRUD operations

    public void insert(Agenda agenda) {
        // SQL de inserção na tabela Agenda
        String sqlAgenda = "INSERT INTO Agenda (nome) VALUES (?)";
    
        // SQL de inserção na tabela Contato
        String sqlContato = "INSERT INTO Contato (nome, email, telefone, tipo_ctt, agenda_id) VALUES (?, ?, ?, ?, ?)";  
    
        Connection conn = null;
        PreparedStatement pstmAgenda = null;
        PreparedStatement pstmContato = null; 
        ResultSet rs = null;
    
        try {
            // Conectar ao banco de dados
            conn = ConnectionFactory.connectionToMyDb();
            conn.setAutoCommit(false);  // Desabilitar auto-commit para controlar a transação
    
            // Inserir na tabela Agenda
            pstmAgenda = conn.prepareStatement(sqlAgenda, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmAgenda.setString(1, agenda.getNome());
            pstmAgenda.execute();
    
            // Recuperar o ID da agenda gerada
            rs = pstmAgenda.getGeneratedKeys();
            int agendaId = 0;
            if (rs.next()) {
                agendaId = rs.getInt(1); // Recupera o ID da agenda gerado
            }
    
            // Inserir os contatos na tabela Contato com o agenda_id associando os contatos à agenda
            pstmContato = conn.prepareStatement(sqlContato);
    
            for (Contato contato : agenda.getContatos()) {
                pstmContato.setString(1, contato.getNome());
                pstmContato.setString(2, contato.getEmail());
                pstmContato.setString(3, contato.getTelefone());
                pstmContato.setString(4, contato.getTipoCtt()); // TipoCtt é uma enum com ID
                pstmContato.setInt(5, agendaId); // Associar o contato à agenda usando o ID gerado
    
                pstmContato.executeUpdate(); // Executa a inserção individualmente para cada contato
            }
    
            // Commit das transações se tudo ocorrer corretamente
            conn.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Em caso de erro, realizar rollback
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmAgenda != null) pstmAgenda.close();
                if (pstmContato != null) pstmContato.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}