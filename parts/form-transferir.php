<?php
/**

*/

?>

<div class="col-md-6">
  <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title">Transferência entre contas</h5>
      <form class="">
        <input id="id" onfocusout="busca(this.value)" placeholder="Id*" name="id" type="text" class="col-md-2 form-control"><p class="text-muted">Busque os dados pelo Id</p>
        <div id="busca">
	        <input id="nome" disabled  placeholder="Nome*" name="nome" type="text" maxlength="45" class="mb-2 form-control">
	        <input id="CPF" disabled placeholder="CPF: somente números*" type="text" name="CPF" maxlength="11" class="mb-2 form-control">
	        <input id="agencia" disabled  placeholder="Agência*" type="text" name="agencia" class="mb-2 form-control">
	        <input id="conta" disabled placeholder="Conta*" type="text" name="conta" class="mb-2 form-control">	        
        </div>
        <input id="valor" required placeholder="Valor*" type="text" name="valor" class="mb-2 form-control">
        <div class="divider"></div>  
      </form>
      <div id="botao"><button onclick="transferir()" class="mb-2 mr-2 btn btn-primary">Transferir</button> 
      <p>O envio dos dados mostra que você concorda com nosso <a href="javascript:void(0)">Termo de Uso</a>.</p>  </div>
        <div id="mensagem"></div>
    </div>
  </div>
</div> 