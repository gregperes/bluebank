<?php

/*

*/

function busca(){

	$id   = $_POST['busca'];
	$html = "";

	if (wp_get_current_user()->ID != $id){

		$user = get_user_by('id', $id);		

		if ( $user ){

			$html = '<input id="nome" disabled placeholder="Nome*" value="'.$user->first_name.' '.$user->last_name.'" name="nome" type="text" maxlength="45" class="mb-2 form-control">
		        	<input id="CPF" disabled placeholder="CPF: somente números*" value="'.$user->CPF.'" type="text" name="CPF" maxlength="11" class="mb-2 form-control">
		        	<input id="agencia" disabled placeholder="Agência*" value="'.$user->agencia.'" type="text" name="agencia" class="mb-2 form-control">
		        	<input id="conta" disabled placeholder="Conta*" value="'.$user->conta.'" type="text" name="conta" class="mb-2 form-control">';
		}
		else {
			$html = '<p class="text-danger">Este usuário não existe.</p>';
		}

	}
	else {
		$html = '<p class="text-danger">Proibido enviar transferencia para a mesma conta.</p>';
	}
	echo $html;

	wp_die();
}

add_action('wp_ajax_busca', 'busca');