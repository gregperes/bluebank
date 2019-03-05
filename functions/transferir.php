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

	var_dump($dadosTransferencia);

	wp_die();
}

add_action('wp_ajax_transferir', 'transferir');
add_action('wp_ajax_nopriv_transferir', 'transferir');