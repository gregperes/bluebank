<?php
/*
Este arquivo serve para realizar novos cadastros de usuários.
*/

function cadastro() {
  global $wpdb;

  $cadastro = filter_input_array(INPUT_POST, $_POST); // Evita caracteres indesejáveis

  // Pegue os dados enviados do formulário
  $first_name  = $cadastro['first_name'];
  $last_name   = $cadastro['last_name'];
  $CPF         = $cadastro['CPF'];
  $user_email  = $cadastro['user_email'];
  $user_pass   = $cadastro['user_pass'];

  // automático
  $agencia       = 555;
  $conta         = uniqid();
  $valor         = 250;
  $user_login    = $conta;


  
  // Inicia o método transacional
  $wpdb->query('START TRANSACTION');

  $novoUser = array(
    'user_pass'  => $user_pass,
    'user_login' => $user_login, 
    'first_name' => $first_name,
    'last_name'  => $last_name,
    'CPF'        => $CPF,
    'agencia'    => $agencia,
    'conta'      => $conta,
    'saldo'      => $valor
  );
  $statusInsert = wp_insert_user($novoUser);
  $result = ""; 
  // Se o cadastro foi bem sucediso conclui. Caso contrário cancela o cadastro.
  if (!$statusInsert->errors){
  	$wpdb->query('COMMIT'); // Se deu tudo certo confirma
  	$result .= '<p class="text-success"><b>Cadastro realizado com sucesso!</b></p>'; 
  	$result .= '<p class="text-primary"><b>Bônus pela abertura da conta. Saldo: '.$valor.'</b></p>';
  	$result .= '<p class="text-primary">Id: '.get_user_by("login", $user_login)->ID.'</p>';
  	$result .= '<p class="text-primary">Login: '.$user_login.'</p>';
  	$result .= '<p class="text-primary">Senha: '.$user_pass.'</p>';
  	$result .= '<p class="text-primary">Agência: '.$agencia.'</p>';
  	$result .= '<p class="text-primary">Conta: '.$conta.'</p>';
  	echo $result;

  }
  else{
  	
  	$wpdb->query('ROLLBACK'); // Cancelar de ocorreu algum erro
  	echo '<p class="text-danger">Ocorreu um erro. Tente novamente mais tarde.</p>';

	}
	wp_die();
}
add_action('wp_ajax_nopriv_cadastro', 'cadastro');