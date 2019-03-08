
    var preload = '<button type="button" id="TooltipDemo" class="btn-open-options btn btn-warning">                <i class="fa fa-cog fa-w-16 fa-spin fa-2x"></i></button>';
    
    function transferir(){
        $$('#botao').innerHTML = preload;
        let id         = $$('#id').value;
        let CPF        = $$('#CPF').value;
        let agencia    = $$('#agencia').value;
        let conta      = $$('#conta').value;
        let valor      = $$('#valor').value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            $$('#botao').innerHTML = "";
            $$('#mensagem').innerHTML = xhttp.responseText;
            }
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=transferir", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send('id='+id+'&CPF='+CPF+'&conta='+conta+'&agencia='+agencia+'&valor='+valor);
    }


     function pagina(definePagina){
        $$('#paginas').innerHTML = preload;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
               console.log(xhttp.responseText);
               $$('#paginas').innerHTML = xhttp.responseText;
            }
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=paginas", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("pagina="+definePagina);
    }
    function cadastro(definePagina){
        $$('#paginas').innerHTML = preload;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
               console.log(xhttp.responseText);
               $$('#paginas').innerHTML = xhttp.responseText;
            }
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=cadastro", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();
    }
    
    function abrirConta(){ 
        var selId = function (id){
            return document.getElementById(id);
        }

        
        if ( selId("first_name").value.length < 1 || selId("last_name").value.length < 1 || selId("user_email").value.length < 1 || selId("user_pass").value.length < 1 ) {
            return selId("mensagem").innerHTML = '<p class="text-danger">Todos os campos são obrigatórios. Preencha o que estiver vazio.</p>';
        }
        if(selId("CPF").value.length < 11) return selId("mensagem").innerHTML = '<p class="text-danger">CPF deve ter 11 números.</p>';
        selId("botao").innerHTML = "";
        selId("mensagem").innerHTML = preload; 
        selId("first_name").disabled = true;
        selId("last_name").disabled = true;
        selId("CPF").disabled = true;
        selId("user_email").disabled = true;
        selId("user_pass").disabled = true;

        ///////////////////
        let first_name = selId("first_name").value;
        let last_name = selId("last_name").value;
        let CPF = selId("CPF").value;
        let user_email = selId("user_email").value;
        let user_pass = selId("user_pass").value;
        ////////////////////////////////
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
               $$('#mensagem').innerHTML = xhttp.responseText;
            }
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=cadastro", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("first_name="+first_name+"&last_name="+last_name+"&CPF="+CPF+"&user_email=@"+user_email+"&user_pass="+user_pass);
 
    }


     function busca(id){
        
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) { 
               
                $$('#busca').innerHTML = xhttp.responseText;
                
            }
            
        };
        // Send a POST to transferir function that load inside functions.php  file
        // Envia um POST na função transferir que carraga no arquivo functions.php
        xhttp.open("POST", "/wp-admin/admin-ajax.php?action=busca", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("busca="+id);
    }

    var out = function (){        
        window.location.href = "<?php echo wp_logout_url( get_site_url() ); ?>";
        }
