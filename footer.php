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
                    </div>    </div>
                <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        </div>
    </div>
<script type="text/javascript" src="/wp-content/themes/bluebank/assets/scripts/main.js"></script>
<script>
    function transferir(){

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
               console.log(xhttp.responseText);
            }
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=transferir", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("id=3&CPF=testCPF&conta=123&agencia=555&valor=100");
    }

</script>
<?php wp_footer(); /* hook para adicionar coisar no footer sem precisar mexer no codigo fonte */ ?>
</body>
</html>