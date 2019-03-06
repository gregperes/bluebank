<?php
/*
Definição da página inicial.
*/
?>
<div class="app-page-title">
    <div class="page-title-wrapper">
        <div class="page-title-heading">
            <div class="page-title-icon">
                <i class="pe-7s-portfolio">
                </i>
            </div>
            <div>Conta Corrente
                <div class="page-title-subheading">Isto é só um exemplo.
                </div>
            </div>
        </div>
        <div class="page-title-actions">
            <button type="button" data-toggle="tooltip" title="Conta corrente" data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
                <i class="fa fa-star"></i>
            </button>
             
        </div>    </div>
</div> 

<div id="paginas" class="row">
	<?php if (is_user_logged_in()): ?>
	<div class="col-md-6 col-xl-4">
	    <div class="card mb-3 widget-content">
	        <div class="widget-content-outer">
	            <div class="widget-content-wrapper">
	                <div class="widget-content-left">
	                    <div class="widget-heading">Saldo</div>
	                    <div class="widget-subheading">Pode variar ao longo do dia</div>
	                </div>
	                <div class="widget-content-right">
	                    <div id="saldo" class="widget-numbers text-success"><?php echo wp_get_current_user()->saldo; ?></div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="col-md-6 col-xl-4">
	    <div class="card mb-3 widget-content">
	        <div class="widget-content-outer">
	            <div class="widget-content-wrapper">
	                <div class="widget-content-left">
	                    <div class="widget-heading">Realizar Tranferências</div>
	                    <div class="widget-subheading">Deve ter saldo em conta</div>
	                </div>
	                <div class="widget-content-right">
	                    <button id="bnt_transferencia"  onclick='pagina("form-transferir")' class="mb-2 mr-2 btn btn-secondary"><i class="fa fa-business-time pe-7s-refresh-2"></i> Transferência
	            </button>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<?php else:
		//echo '<p>Faça login para visualizar a página</p><br>';
		$args = array(
		'echo'           => true,
		'remember'       => true,
		'redirect'       => ( is_ssl() ? 'https://' : 'http://' ) . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'],
		'form_id'        => 'loginform',
		'id_username'    => 'user_login',
		'id_password'    => 'user_pass',
		'id_remember'    => 'rememberme',
		'id_submit'      => 'wp-submit',
		'label_username' => __( 'User/Email' ),
		'label_password' => __( 'Password  ' ),
		'label_remember' => __( 'Remember Me' ),
		'label_log_in'   => __( 'Log In' ),
		'value_username' => '',
		'value_remember' => false
	);
		wp_login_form( $args );
	endif; ?>
</div>