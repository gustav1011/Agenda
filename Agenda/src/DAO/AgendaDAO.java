package DAO;
import connection.ConnectionFactory;// importação do pacote connection.ConnectionFactory em específico para fazer a conexão com o BD
import java.sql.Connection;// importação do pacote modelo.Agenda em específico
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Agenda;
import modelo.Contato;

public class AgendaDAO {
    // CRUD operations

public void insert (Agenda agenda){
    // Save the agenda in the database

    String sqlAgenda = "INSERT INTO Agenda (nome) VALUES (?)";
    String sqlContato = "INSERT INTO Contato (nome, email, telefone, tipo_ctt_id, agenda_id) VALUES (?, ?, ?, ?, ?)";


    Connection conn = null;
    
    PreparedStatement pstmAgenda  = null;
    PreparedStatement pstmContato = null;

    ResultSet rs = null;

    try {
        // conexao com o banco de dados feita para o operação
        conn = ConnectionFactory.connectionToMyDb();

        pstmAgenda  = (PreparedStatement) conn.prepareStatement(sqlAgenda,PreparedStatement.RETURN_GENERATED_KEYS); // Para recuperar o ID gerado;
        pstmAgenda.setString(1, agenda.getNome());
        pstmAgenda.execute();

        rs = pstmAgenda.getGeneratedKeys();
            int agendaId = 0;
            if (rs.next()) {
                agendaId = rs.getInt(1); // Recupera o ID gerado
            }

            for (Contato contato : agenda.getContatos()) {
                pstmContato.setString(1, contato.getNome());
                pstmContato.setString(2, contato.getEmail());
                pstmContato.setString(3, contato.getTelefone());
                pstmContato.setString(4, contato.getTipoCtt()); // TipoCtt é uma enum com ID
                pstmContato.setInt(5, agendaId); // Associar o contato à agenda usando o ID recuperado

                pstmContato.addBatch(); // Adiciona ao batch de inserção
            }

    } catch (Exception e) {
        e.printStackTrace();
    }   finally{
try {
    if(pstmAgenda!= null){
        pstmAgenda.close();
    }

    if(conn!= null){
        conn.close();
    }
} catch (Exception e) {
   e.printStackTrace();
     }
   }
 }

}
