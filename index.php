<?php
/*
Este é o primeiro arquivo a ser carregado. É responsável por definir a página inicial.
*/


get_header(); // carraga o arquivo header.php
?>      
        <div class="app-main">
                <div class="app-sidebar sidebar-shadow">
                    <div class="app-header__logo">
                        <div class="logo-src"></div>
                        <div class="header__pane ml-auto">
                            <div>
                                <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                    <span class="hamburger-box">
                                        <span class="hamburger-inner"></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <?php get_template_part('parts/menu', 'lateral'); ?>
                    
                </div>   
                 <div class="app-main__outer">
                    
                    <div class="app-main__inner">
          
                      <?php get_template_part('parts/home'); ?>
                     
                         
                    </div>
<?php get_footer(); // carraga o arquivo footer.php
