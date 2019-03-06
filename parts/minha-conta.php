<?php
/**
Exibe dos dados da conta.
*/
?>

<div class="col-md-6">
  <div class="main-card mb-3 card">
    <div class="card-body"><h5 class="card-title">Minha Conta</h5>
      <form class="">
        <input disabled value="Id: <?php echo wp_get_current_user()->ID; ?>" class="col-md-2 form-control"> 
        <div id="busca">
	        <input disabled value="Nome: <?php echo wp_get_current_user()->first_name.' '.wp_get_current_user()->last_name; ?>" class="mb-2 form-control">
	        <input disabled  value="CPF: <?php echo wp_get_current_user()->CPF; ?>"  class="mb-2 form-control">
	        <input disabled value="Agência: <?php echo wp_get_current_user()->agencia; ?>" type="text" name="agencia" class="mb-2 form-control">
	        <input disabled id="conta"  value="Conta: <?php echo wp_get_current_user()->conta; ?>" class="mb-2 form-control">	        
        </div>
        <input disabled id="valor" value="Saldo: <?php echo wp_get_current_user()->saldo ?>" class="mb-2 form-control">
        <div class="divider"></div>  
      </form>
        
    </div>
  </div>
</div> 