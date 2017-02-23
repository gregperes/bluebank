/*
 * Classe de teste Conta
 */
package Negocio;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IGOR
 */
public class ContaTest {
    
    public ContaTest() {
    }
    /**
     * Test of ConsultarPorContaAgencia method, of class Conta.
     */
    String url = "jdbc:mysql://localhost:3306/bluebank";
    String user = "root";
    String password = "";
    @Test
    public void testConsultarPorContaAgencia() throws Exception {
        /*
        String conta1 = "00000";
        String agencia1 = "000000";
        Conta instance1 = new Conta();
        instance1.ConsultarPorContaAgencia(conta1, agencia1);
        */
        try {
            String agencia2 = "11111";
            String conta2 = "111111";
            String cpf2 = "11111111111";
            double valor2 = 100.00;
            Negocio.TesteEstrututra testeEstrutura = new Negocio.TesteEstrututra();
            testeEstrutura.InserirConta(agencia2, conta2, cpf2, valor2);
            Conta instance2 = new Conta();
            assertNotNull(instance2.SelecionarPorContaAgencia(conta2, agencia2));
            testeEstrutura.ExcluirConta(agencia2, conta2, cpf2);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ContaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
