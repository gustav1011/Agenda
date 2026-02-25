package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContatoDAO {

     private static Connection conn = null; /// variavel de classe estatica
    

        public void insertContato(int id, String nome,String email, String telefone, String tipoctt) { ////quero inserir um contato em uma agenda atraves de agenda_id
        String sql = "INSERT INTO Contato (nome, email, telefone, tipo_ctt, agenda_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstmContato = null;

        try {
            conn = ConnectionFactory.connectionToMyDb();

            pstmContato = conn.prepareStatement(sql);
            pstmContato.setString(1, nome);
            pstmContato.setString(2,email);
            pstmContato.setString(3, telefone);
            pstmContato.setString(4, tipoctt);
            pstmContato.setInt(5, id);

            pstmContato.executeUpdate();
            //System.out.println("Contato inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
}
