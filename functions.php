<?php
/*
Este é um arquivo de configuração para definicar comportamentos importantes da aplicação.
*/

// Se uma uma classe for instanciada em qualquer lugar, ela será carregada
// Esta funcção está sendo usado no lugar de __autolad
// http://php.net/manual/pt_BR/function.spl-autoload-register.php
spl_autoload_register( function ($className){

	// faz a validação se esta class existe
	if(file_exists(get_template_directory().DIRECTORY_SEPARATOR."class".DIRECTORY_SEPARATOR.$className.".php") === true ){

		// em caso positivo carrega a classe
		require_once( get_template_directory().DIRECTORY_SEPARATOR."class".DIRECTORY_SEPARATOR.$className.".php" );
	}

});



// Carrega todos os arquivos da pasta functions
// Isso permite separar o código por arquivo dando maior legibilidade
$pasta = get_template_directory() . "/functions/";
$arquivos = glob($pasta."*.php"); 
foreach($arquivos as $phpFile){
   require_once("$phpFile");
}

