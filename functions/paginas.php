<?php
/*
Este arquivo vai verificar qual página inicial será exibida.
*/
function paginas(){

	// Define a página
	$pagina       = $_POST['pagina']; 

	// Recupera o arquivo que está em parts/nome-arquivo.php
	get_template_part('parts/'.$pagina);

	wp_die();
}

add_action('wp_ajax_paginas', 'paginas');
add_action('wp_ajax_nopriv_paginas', 'paginas');


