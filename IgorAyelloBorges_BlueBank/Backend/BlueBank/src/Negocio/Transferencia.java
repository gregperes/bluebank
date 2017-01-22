/*
 * Classe transferência de saldo
 */
package Negocio;

/**
 *
 * @author IGOR
 */
public class Transferencia {
    
    public void Incluir(String contaOrigem, String agenciaOrigem, String contaDestino, String agenciaDestino, double valor) throws Exception
    {
        try
        {
           Dado.Conta conta = new Dado.Conta();
           Tipo.Conta conta1 = conta.SelecionarPorConta(contaOrigem, agenciaOrigem);
           Tipo.Conta conta2 = conta.SelecionarPorConta(contaDestino, agenciaDestino);
           if(conta1.Valor < valor)throw new Exception("Valor a ser transferido é maior que o saldo na conta de origem.");
           Dado.Transferencia transferencia = new Dado.Transferencia();
           //Debita valor da conta
           conta1.Valor = conta1.Valor - valor;
           conta.AlterarPorConta(conta1.Conta, conta1.Agencia, conta1.Valor);
           conta2.Valor = conta2.Valor + valor;
           conta.AlterarPorConta(conta2.Conta, conta2.Agencia, conta2.Valor);
           transferencia.Incluir(conta1, conta2, valor);
        }
        catch(Exception ex)
        {
            throw new Exception("Houve um erro no sistema " + ex);
        }
    }
}
