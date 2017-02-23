/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Tipo.Transferencia;
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
public class TransferenciaTest {
    
    public TransferenciaTest() {
    }
    /**
     * Test of AlterarTransferencia method, of class Transferencia.
     */
    @Test
    public void testAlterarTransferencia() throws Exception {
        Negocio.TesteEstrututra testeEstrutura = new Negocio.TesteEstrututra();
        String agencia1 = "11111";
        String conta1 = "111111";
        String cpf1 = "11111111111";
        double valor1 = 100.00;
        testeEstrutura.InserirConta(agencia1, conta1, cpf1, valor1);
        String agencia2 = "22222";
        String conta2 = "222222";
        String cpf2 = "22222222222";
        double valor2 = 100.00;
        testeEstrutura.InserirConta(agencia2, conta2, cpf2, valor2);
        double valor = 50.00;
        Negocio.Transferencia instance = new Negocio.Transferencia();
        instance.Incluir(conta1, agencia1, conta2, agencia2, valor);
        testeEstrutura.ExcluirConta(agencia1, conta1, cpf1);
        testeEstrutura.ExcluirConta(agencia2, conta2, cpf2);
    }
    
}
