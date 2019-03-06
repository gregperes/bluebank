<?php

/*

*/

function busca(){
	$id = $_POST['busca'];

	$user = get_user_by('id', $id);

	$html = "";

	if ( $user ){

		$html = '<input id="nome" disabled placeholder="Nome*" value="'.$user->first_name.' '.$user->last_name.'" name="nome" type="text" maxlength="45" class="mb-2 form-control">
	        	<input id="CPF" disabled placeholder="CPF: somente números*" value="'.$user->CPF.'" type="text" name="CPF" maxlength="11" class="mb-2 form-control">
	        	<input id="agencia" disabled placeholder="Agência*" value="'.$user->agencia.'" type="text" name="agencia" class="mb-2 form-control">
	        	<input id="conta" disabled placeholder="Conta*" value="'.$user->conta.'" type="text" name="conta" class="mb-2 form-control">';
	}
	else {
		$html = false;
	}
	echo $html;

	wp_die();
}

add_action('wp_ajax_busca', 'busca');