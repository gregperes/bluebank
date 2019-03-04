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
    private function bloqueioTemporario(){ // executar bloqueio nas duas contas

    	$this->tokenAutorizacao = wp_hash('***Valor Aleatório*** Paderia ser qualer coisa');

    	// Verifica se a conta de origem está diponível para fazer alterações
    	if ( $this->userOrig !== 0 ){

    		wp_update_user( array(
    			// Se tiver diponível muda o status para zero e define o token como Id da transação
    			'ID' => $this->userOrig->ID, 'bloqueio' => 0,
    			'ID' => $this->userOrig->ID, 'token_autorizacao' => $this->tokenAutorizacao
    		));

    		return $this->bloqueioContas = true;

    	}
    	else{ 
    		// envia mensagem informando que a conta está ocupada
    		return $this->contaLiberada = false;

    	}

    	// Verifica se a conta de destino está disponível para fazer auterações
    	if ( $this->contaLiberada === true && $this->userDest !== 0 ){
    		
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

    public function test(){
    	//return $this->userDest->CPF;
    }

    private function desbloquear(){
    	// muda $user->podeprocessar para 1.
    	wp_update_user( array(

    	// Se tiver diponível muda o status para zero e define o token como Id da transação
    	'ID' => $this->userOrig->ID, 'bloqueio' => ''
    	
    	));
    	wp_update_user( array(

    	// Se tiver diponível muda o status para zero e define o token como Id da transação
    	'ID' => $this->userDest->ID, 'bloqueio' => ''
    	
    	));
    }

    private function validaTodosDados(){
    	$this->validarCPF();
    	$this->validarId();
    	$this->validarConta();
    	$this->validarConta();
    	$this->validarAgencia();
    }

    private function validarCPF(){
    	// valida CPF
    	return $this->dadosValidados = true;
    }
    private function validarId(){
    	// valida Id
    	return $this->dadosValidados = true;
    }
    private function validarConta(){
    	// valida Conta
    	return $this->dadosValidados = true;
    }
    private function validarAgencia(){
    	// valida Agencia
    	return $this->dadosValidados = true;
    }
    private function validarValor(){
    	// valida Valor: Se tem saldo suficiente
    	return $this->dadosValidados = true;
    }

    private function transfereciaAutorizada(){

    	// transação aqui.
    	if($this->userOrig->token_autorizacao === $this->tokenAutorizacao && $this->userOrig->token_autorizacao === $this->tokenAutorizacao){

    		// transação aqui
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
