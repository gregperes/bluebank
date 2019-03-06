<?php
/*
Formulário que é exibido na página de condastro.
*/
?>
<div class="col-md-6">
  <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title">Abertura de conta corrente</h5>
      <p>Ao abrir uma conta será creditado um valor de 250 para realização dos testes.</p>
      <form class="">
        <input id="first_name" placeholder="Primeiro nome*" name="first_name" type="text" maxlength="11" class="mb-2 form-control">
        <input id="last_name" placeholder="Sobre nome*" name="last_name" type="text" maxlength="30" class="mb-2 form-control">
        <input id="CPF" placeholder="CPF: somente números*" type="text" name="CPF" maxlength="11" class="mb-2 form-control">
        <input id="user_email" placeholder="Email*" type="email" name="user_email" class="mb-2 form-control">
        <input id="user_pass" placeholder="Senha*" type="text" name="user_pass" class="mb-2 form-control"> 
        <div class="divider"></div>  
      </form>
      <div id="botao"><button onclick="abrirConta()" class="mb-2 mr-2 btn btn-primary">Abra uma conta</button> 
      <p>O envio dos dados mostra que você concorda com nosso <a href="javascript:void(0)">Termo de Uso</a>.</p>  </div>
        <div id="mensagem"></div>
    </div>
  </div>
</div> 