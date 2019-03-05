<?php
/*
Este arquivo define os compos dos usuários.
Por padrão, o WordPress não fornece campos como CPF, Conta, etc.
Estamos definindo este campo exatamente para suprir esta falta.
*/

add_filter('user_contactmethods', function ($profile_fields) {

	$profile_fields['CPF']                 = 'CPF';
	$profile_fields['conta']               = 'Conta Corrente';
	$profile_fields['agencia']             = 'Agência';
	$profile_fields['saldo']               = 'Saldo Disponível';
	$profile_fields['bloqueio']            = 'Saldo Disponível';
	$profile_fields['token_autorizacao']   = 'Saldo Disponível';

	return $profile_fields;
});