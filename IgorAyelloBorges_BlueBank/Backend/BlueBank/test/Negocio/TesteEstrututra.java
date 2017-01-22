/*
 * Classe para omntar estrutura do teste
 */
package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IGOR
 */
public class TesteEstrututra {
    String url = "jdbc:mysql://localhost:3306/bluebank";
    String user = "root";
    String password = "";
     public void InserirConta(String agencia, String conta, String cpf, double valor) throws SQLException, InstantiationException, IllegalAccessException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            stt.execute("INSERT INTO `conta`(`Agencia`, `Conta`, `CPF`, `Valor`) VALUES (" + agencia + "," + conta + "," + cpf + "," + String.valueOf(valor) + ")");
            con.close();
            stt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExcluirConta(String agencia, String conta, String cpf) throws InstantiationException, SQLException, IllegalAccessException
    {
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            stt.execute("DELETE FROM `conta` WHERE Agencia = " + agencia + " AND Conta = " + conta + " AND CPF = " + cpf);
            con.close();
            stt.close();
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
