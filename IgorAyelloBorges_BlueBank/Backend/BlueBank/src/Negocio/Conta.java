/*
 * Classe conta para regra de negócios
 */
package Negocio;

/**
 *
 * @author IGOR
 */
public class Conta {
    //Consulta a tabela conta por número da conta
    public Tipo.Conta SelecionarPorContaAgencia(String conta, String agencia) throws Exception
    {
        try
        {
            if(conta == null)throw new Exception("Conta não informada.");
            if(agencia == null)throw new Exception("Agência não informada.");
            if(conta.length() < 6)throw new Exception("Dados incompletos da Conta.");
            if(agencia.length() < 5)throw new Exception("Dados incompletos da Agência.");
            Dado.Conta dadoConta = new Dado.Conta();
            Tipo.Conta tipoConta = dadoConta.SelecionarPorConta(conta, agencia);
            if(tipoConta.CPF == null)throw new Exception("Conta não existe");
            return tipoConta;
        }
        catch(Exception ex)
        {
            throw new Exception("Houve um erro no sistema " + ex);
        }
        
    }
    
    public void AlterarContaPorContaAgencia(String conta, String agencia, double valor) throws Exception
    {
        try
        {
            //Varifica se as contas existem
            if(conta == null)throw new Exception("Conta não informada.");
            if(agencia == null)throw new Exception("Agência não informada.");
            if(conta.length() < 6)throw new Exception("Dados incompletos da Conta.");
            if(agencia.length() < 5)throw new Exception("Dados incompletos da Agência.");
            Dado.Conta dadoConta = new Dado.Conta();
            Tipo.Conta tipoConta = dadoConta.SelecionarPorConta(conta, agencia);
            if(tipoConta.CPF == null)throw new Exception("Conta não existe");
            dadoConta.AlterarPorConta(conta, agencia, valor);
            Tipo.Conta tipoContaConferencia = dadoConta.SelecionarPorConta(conta, agencia);
            if(tipoContaConferencia.Valor != valor)throw new Exception("Transferência não realizada.");
        }
        catch(Exception ex)
        {
            throw new Exception("Houve um erro no sistema " + ex);
        }
    }
    
}
