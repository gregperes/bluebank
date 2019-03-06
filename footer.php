<?php
/*
Arquivo responsável por gerar a parte do radape do site.
É carregado por meio da funcao get_footer()
https://codex.wordpress.org/Function_Reference/get_footer
*/
?>
<div class="app-wrapper-footer">
    <div class="app-footer">
        <div class="app-footer__inner">
            <div class="app-footer-left">
                <ul class="nav">
                    <li class="nav-item">
                        <a href="javascript:void(0);" class="nav-link">
                            Política de privacidade
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="javascript:void(0);" class="nav-link">
                            Termo de Uso
                        </a>
                    </li>
                </ul>
            </div> 
        </div>
    </div>
</div>    
</div>
</div>
</div>
<script type="text/javascript" src="<?php echo get_template_directory_uri(); ?>/assets/scripts/main.js"></script>
<script type="text/javascript" src="<?php echo get_template_directory_uri(); ?>/scripts.js"></script> 

<?php wp_footer(); /* hook para adicionar coisar no footer sem precisar mexer no codigo fonte */ ?>
</body>
</html>