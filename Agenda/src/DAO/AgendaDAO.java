package DAO;
import connection.ConnectionFactory;// importação do pacote connection.ConnectionFactory em específico para fazer a conexão com o BD
import java.sql.Connection;// importação do pacote modelo.Agenda em específico
import java.sql.PreparedStatement;
import modelo.Agenda;

public class AgendaDAO {
    // CRUD operations

public void save (Agenda agenda){
    // Save the agenda in the database

    String sql = "INSERT INTO Agenda (nome) VALUES (?)";

    Connection conn = null;
    
    PreparedStatement pstm = null;

    try {
        // conexao com o banco de dados feita para o operação
        conn = ConnectionFactory.connectionToMyDb();
        pstm  = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, agenda.getNome());
        //pstm.setContatos(2, agenda.getContatos());

        pstm.execute();

    } catch (Exception e) {
        e.printStackTrace();
    }   finally{
try {
    if(pstm!= null){
        pstm.close();
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
