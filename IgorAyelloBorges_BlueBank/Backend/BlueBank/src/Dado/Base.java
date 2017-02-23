/*
 * Classe base para conexão com o banco de dados
 */
package Dado;
import java.sql.*;
/**
 *
 * @author IGOR AYELLO BORGES
 */
public class Base {
    //region Variáveis
    //String de conexão com o banco
    private static String url = "jdbc:mysql://localhost:3306/bluebank";
    //Usuário
    private static String user = "root";
    //Senha
    private static String password = "";
    //endregion
    //Region métodos
    //Abre conexão com o banco de dados
    public static Connection AbrirConexaoBanco() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            if(con == null)throw new Exception("Houve um problema com a conexão.");
            return con;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
             throw(new Exception("Erro ao realizar a conexão com o banco de dados."));
            
        }
    }
    //endregion
}
