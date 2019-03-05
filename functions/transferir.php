<?php
/*
Este arquivo será responsável por executar a Class Transferir localizada em /class/Tranferir.php.
O JavaScript enviará uma requisição para processá-lo e devolver a resposta por meio do AJAX.
*/

function transferir(){

	$dadosTransferencia = filter_input_array(INPUT_POST, $_POST); // Evita caracteres indesejáveis

	$id       = $dadosTransferencia['id'];
	$CPF      = $dadosTransferencia['CPF'];
	$agencia  = $dadosTransferencia['agencia'];
	$conta    = $dadosTransferencia['conta'];
	$valor    = $dadosTransferencia['valor'];

	echo 'Dado colatado corretamente: '.$id."\n";
	echo 'Dado colatado corretamente: '.$CPF."\n";
	echo 'Dado colatado corretamente: '.$agencia."\n";
	echo 'Dado colatado corretamente: '.$conta."\n";
	echo 'Dado colatado corretamente: '.$valor."\n";

	$class = new Transferir;
	$class->dados($id, $CPF, $agencia, $conta, $valor);
	$class->test();

	wp_die();
}

add_action('wp_ajax_transferir', 'transferir');
add_action('wp_ajax_nopriv_transferir', 'transferir');