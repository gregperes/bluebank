/*
 * Acesso a tabela conta no banco de dados
 */
package Dado;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;
/**
 *
 * @author IGOR
 */
public class Conta extends Base {
    //Consulta a tabela conta por número da conta
    public Tipo.Conta SelecionarPorConta(String conta, String agencia) throws Exception
    {
        Connection con = AbrirConexaoBanco();
        try
        {
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT ID, Agencia, Conta, CPF, Valor FROM `conta` WHERE Conta =" + conta + " AND Agencia=" + agencia );
            Tipo.Conta tipoConta = new Tipo.Conta();
            if(res.next())
            {
                tipoConta.Agencia = res.getString("Agencia");
                tipoConta.CPF = res.getString("CPF");
                tipoConta.Conta = res.getString("Conta");
                tipoConta.ID = res.getInt("ID"); 
                tipoConta.Valor = res.getDouble("Valor");
            }
            stt.close();
            res.close();
            con.close();
            return tipoConta;
        }
        catch( Exception ex)
        {
            throw new Exception("Não foi possível completar a transação " + ex);  
        }
    }
    //Atualiza o valor da conta
    public void AlterarPorConta(String conta, String agencia, double valor) throws Exception
    {
        Connection con = AbrirConexaoBanco();
        try
        {
            Statement stt = con.createStatement();
            stt.execute("UPDATE `conta` SET `Valor`= " + valor + " WHERE `Agencia`= " + agencia + " AND `Conta`= " + conta);
            con.close();
        }
        catch( Exception ex)
        {
            throw new Exception("Não foi possível completar a transação " + ex);  
        }
    }
}
