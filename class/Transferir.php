<?php

class Transferir extends Transacao
{
	private $id;
	private $CPF;
	private $conta;
	private $agencia;
	private $valor;

	// identificação das partes
	private $userOrig;
	private $userDest;

	// Para fazer um controle para não executar duas transações diferentes ao mesmo tempo
	// Sem este controle, poderia haver erros graves na contabilidade da conta
	private $contaLiberada = false; // Padrão falso
	private $tokenAutorizacao; // será gerado um token

	// Define os status das validações.
	// Somente se todos forem verdadeiro é realizada a tranfência
	// stastu fica falso por default, simbolicamente trancado.
	private $dadosValidados = false;
	private $statusId = false;
	private $statusCPF = false;
	private $statusConta = false;
	private $statusAgencia = false;
	private $statusValor = false;

	// Armazena o HTML que será respondido para o front-end
	public $html;

    // Os parâmetros a baixo é de uso obrigatório
    // http://php.net/manual/en/language.oop5.abstract.php
    public function dados($id, $CPF, $conta, $agencia, $valor) {
        $this->id      = $id;
		$this->CPF     = $CPF;
		$this->conta   = $conta;
		$this->agencia = $agencia;
		$this->valor   = $valor;

		$this->userOrig = wp_get_current_user();
		$this->userDest = get_user_by('id', $id);
    }
    public function test(){ // Será removido em produção
    	$this->validaTodosDados();

        echo $this->html;
    }
    private function bloqueioTemporario(){ // executar bloqueio nas duas contas

    	$this->tokenAutorizacao = wp_hash('***Valor Aleatório*** Paderia ser qualer coisa');

    	// Verifica se a conta de origem está diponível para fazer alterações
    	if ( $this->userOrig !== 0 ){

    		wp_update_user( array(
    			// Se tiver diponível muda o status para zero e define o token como Id da transação
    			'ID' => $this->userOrig->ID, 'bloqueio' => 0,
    			'ID' => $this->userOrig->ID, 'token_autorizacao' => $this->tokenAutorizacao
    		));

    		$this->bloqueioContas = true;

    	}
    	else{ 
    		// envia mensagem informando que a conta está ocupada
    		return $this->contaLiberada = false;

    	}

    	// Verifica se a conta de destino está disponível para fazer auterações
    	if ( $this->userDest !== 0 ){
    		
    		wp_update_user( array(

    			// Se tiver diponível muda o status para zero e define o token como Id da transação
    			'ID' => $this->userDest->ID, 'bloqueio' => 0,
    			'ID' => $this->userDest->ID, 'token_autorizacao' => $this->tokenAutorizacao

    		));

    	}
    	else{
    		// envia mensagem informando que a conta está ocupada
    		$this->desbloquear();
    		return $this->contaLiberada = false;

    	}

    }

    private function desbloquear(){
    	// Se o bloqueio foi realizado com sucesso, eu libero para novas transações.
        if ($this->tokenAutorizacao === $this->userOrig->token_autorizacao){

            // Se esta condição fosse falsa, impediria uma indevida liberação atrapalhado uma outra transação em curso
        	wp_update_user( array(

            	// Se tiver diponível muda o status para zero e define o token como Id da transação
            	'ID' => $this->userOrig->ID, 'bloqueio' => ''
        	
        	));
        }
        if ($this->tokenAutorizacao === $this->userDest->token_autorizacao){

            // Se esta condição fosse falsa, impediria uma indevida liberação atrapalhado uma outra transação em curso
        	wp_update_user( array(

            	// Se tiver diponível muda o status para zero e define o token como Id da transação
            	'ID' => $this->userDest->ID, 'bloqueio' => ''
        	
        	));
        }
    }

    private function validaTodosDados(){

    	$this->validarId();
    	$this->validarCPF();
    	$this->validarConta();
    	$this->validarConta();
    	$this->validarAgencia();

    	if ($this->statusId && $this->statusCPF && $this->statusConta && $this->statusAgencia && $this->statusValor){

    		return $this->dadosValidados = true;

    	} 

    }


    private function validarId(){
    	// valida Id
    	// Se o retorno for booleano, o objeto não foi definido
    	if( $this->userDest == true ) {
    		return $this->statusId = true;
    	}
    	else{
    		$this->dadosValidados = false;
    		return $this->html .= '<p>O id '.$this->id.' não existe.</p>';
    	}

    }
    private function validarCPF(){
		// valida CPF
		if($this->userDest->CPF == $this->CPF){
			return $this->statusCPF = true;
		}
		else{

			return $this->html .= '<p>O CPF '.$this->CPF.' está incorreto.</p>';
		}
    }
    private function validarConta(){
    	// valida Conta
    	if($this->userDest->conta == $this->conta){
			return $this->statusConta = true;
		}
		else{
			return $this->html .= '<p>A Conta '.$this->conta.' está incorreta.</p>';
		}
    }
    private function validarAgencia(){
    	// valida Agencia
    	if($this->userDest->agencia == $this->agencia){
			return $this->statusAgencia = true;
		}
		else{
			return $this->html .= '<p>A Agência '.$this->agencia.' está incorreta.</p>';
		}
    }
    private function validarValor(){
    	// valida Valor: Se tem saldo suficiente
    	if($this->userOrig->saldo >= $this->valor){
			return $this->statusValor = true;
		}
		else{
			return $this->html .= '<p>Seu saldo é insuficiente para transferiri este valor. Saldo: '.$this->saldo.'</p>';
		}
    }

    private function transfereciaAutorizada(){

    	// transação aqui.
    	if($this->userOrig->token_autorizacao === $this->tokenAutorizacao && $this->userOrig->token_autorizacao === $this->tokenAutorizacao){

    		// transação aqui
            global $wpdb;

            // Valores de débito e crédito
            $debitar  = (int)$this->userOrig->saldo - (int)$this->valor;
            $creditar = (int)$this->userDest->saldo + (int)$this->valor;

            // Inicia o método transacional
            $wpdb->query('START TRANSACTION');

            $dadosTransacional = array (
                'ID' => $this->userOrig->ID, 'saldo' => $debitar, // débito na conta de quem faz a transferência
                'ID' => $this->userDest->ID, 'saldo' => $creditar // crétido na conta de quem recebe a tranferência
            );

            $resultado = wp_update_user($dadosTransacional);

            if ($resultado) {
                $wpdb->query('COMMIT');
                $this->desbloquear(); // libera a conta novamente
                return 'Sucesso!';
            }
            else {
                $wpdb->query('ROLLBACK');
                $this->desbloquear(); // libera a conta novamente
                //return 'Error desconhecido...'
            }
    	}
        else {
            // Se entrar neste "esle", significa que na hora houve algum conflito no bloqueio temporário
            // Talvez, alguma outra transação estava sendo feita ao mesmo tempo
        }
    }

    public function exec(){

    	$this->validaTodosDados();

    	if ($this->dadosValidados){

	    	// Bloqueia as conta de origem e destino para
	    	// ocorrer outra trasação
	    	// Isso vai garantir a integridade dos valores
	    	$this->bloqueioTemporario();

	    	if ($this->contaLiberada){

	    		$this->transfereciaAutorizada();

	    	}
    	
    }

    return $html;

	}
}
