/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;

import static Dado.Base.AbrirConexaoBanco;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author IGOR
 */
public class Transferencia extends Base {
    public void Incluir(Tipo.Conta conta1, Tipo.Conta conta2, double valor) throws Exception
    {
        Connection con = AbrirConexaoBanco();
        try
        {
            Statement stt = con.createStatement();
            stt.execute("INSERT INTO `transferencia`(`ContaOrigem`, `ContaDestino`, `DataTransacao`, `Valor`) VALUES ("+conta1.Conta+","+conta2.Conta+", NOW(),"+valor+")");
            con.close();
        }
        catch( Exception ex)
        {
            throw new Exception("Não foi possível completar a transação " + ex);  
        }
    }
}
