<?php
/*
Este arquivo só compoe a página. Não nada de especial nele.
*/
?>
  <div class="app-header__mobile-menu">
    <div>
        <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
            <span class="hamburger-box">
                <span class="hamburger-inner"></span>
            </span>
        </button>
    </div>
</div>
<div class="app-header__menu">
    <span>
        <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
            <span class="btn-icon-wrapper">
                <i class="fa fa-ellipsis-v fa-w-6"></i>
            </span>
        </button>
    </span>
</div>  
<div class="scrollbar-sidebar">
    <div class="app-sidebar__inner">
        <ul class="vertical-nav-menu">
            <li class="app-sidebar__heading">Dashboard</li>
            <li>
                <a href="<?php echo home_url(); ?>" class="mm-active">
                    <i class="metismenu-icon pe-7s-home"></i>
                    Home
                </a>
            </li>
            <li>
                <a href="javascript:void(0)" onclick='pagina("form-transferir")' class="mm-active">
                    <i class="metismenu-icon pe-7s-cash"></i>
                    Realizar Transferência
                </a>
            </li>
        </ul>
    </div>
</div>