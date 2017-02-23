$(document).ready(function() {

	//CARREGA AGENCIA E CONTA DE ORIGEM NO FORMULARIO
	cOrigem = $('.conta #conta').html();
	agOrigem = $('.conta #agencia').html();

	$('#agenciaOrigem').attr('placeholder', agOrigem);
	$('#contaOrigem').attr('placeholder', cOrigem);


	//LIMITE NUMEROS INPUT
	$('#agenciaDestino').keypress(function() {
	    if (this.value.length >= 4) {
	        return false;
	    }
	});
	$('#contaDestino').keypress(function() {
	    if (this.value.length >= 6) {
	        return false;
	    }
	});

	//MASK VALOR
	$(function(){
        $("#valor").maskMoney();
    });

	$( "#formEnvia" ).submit(function( event ) {

		 $.ajax({
		 	url: 'clientes.json',
		 	dataType: 'json',
		 	type: 'post',
		 	cache: false,
		 	success: function(data){
		 		$(data).each(function(index, value){
		 			$('.agencia-errorbox').hide();
				  	$('.conta-errorbox').hide();
				  	$('.valor-errorbox').hide();

				  	var agOrigem = $('.conta #agencia').val();
				  	var cOrigem = $('.conta #conta').val();

			  		var agDestino = $('#agenciaDestino').val();

			  		var agDestinoCheck = $('#agenciaDestino').val();
				  	var cDestino = $('#contaDestino').val();

					var agencias = value.agencia;


					var valor = $('#valor').val();

					//COMPARA SE A AGENCIA DE DESTINO EXISTE NO JSON
					if(agDestino == agencias){
						$('.checkAgencia').show();
						var numeroConta = data[index].numero;
						if(numeroConta == cDestino){
							$('.checkConta').show();

							//BUSCAR SALDO DO USUARIO POR BACK END
							var saldo = data[5].saldo;
							

							//COMPARA O VALOR COM O SALDO DO USUARIO
							if(valor <= saldo){
								$('.valor-sucessbox').html('Efetuar transação').show();
								$('.valor-errorbox').html('Saldo insuficiente').hide();
								//BACK END EFETUA TRANSACAO
							}
							else{
								$('.valor-errorbox').html('Saldo insuficiente').show();
								$('.valor-sucessbox').html('Efetuar transação').hide();
							}
						}
						else{
							$('.conta-errorbox').html('Conta invalida').show();
							$('.checkConta').hide();
							$('.valor-sucessbox').html('Efetuar transação').hide();
						}

						return false;
					}
					else{
						$('.agencia-errorbox').html('Agencia invalida').show();
						$('.checkAgencia').hide();
						$('.valor-sucessbox').html('Efetuar transação').hide();
					}

		 		});return false;
		 	}
		 });
		

	});
});