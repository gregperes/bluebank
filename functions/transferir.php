<?php
/*
Este arquivo será responsável por executar a Class Transferir localizada em /class/Tranferir.php.
O JavaScript enviará uma requisição para processá-lo e devolver a resposta por meio do AJAX.
*/

function transferir(){

	$dadosTransferencia = filter_input_array(INPUT_POST, $_POST); // Evita caracteres indesejáveis

	// Pegue os dados enviados do formulário
	$id       = $dadosTransferencia['id'];
	$CPF      = $dadosTransferencia['CPF'];
	$agencia  = $dadosTransferencia['agencia'];
	$conta    = $dadosTransferencia['conta'];
	$valor    = $dadosTransferencia['valor'];

	// Testa a class para ver se a transferencia está sendo feita para o próprio usuário 
	if (wp_get_current_user()->ID != $id) {

		// Cria um objeto para realizar a transferência
		$transferir = new Transferir;

		// Define os objeto com os parâmetros obrigatório
		$transferir->dados($id, $CPF, $conta, $agencia, $valor);

		// Executa o método que realiza a transferência
		echo $transferir->exec();
		
	}
	else{
		echo '<p class="text-danger">Não é possível transferir falores para a sua própria conta.</p>';
	}

	wp_die();
}

add_action('wp_ajax_transferir', 'transferir');