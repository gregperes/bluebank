<%-- 
    Document   : transferencia 
    Created on : 22/02/2017, 16:29:56
    Author     : davi_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Blue Bank - Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link href="assets/css/materialize.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    
     <!-- Fonts -->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
  

  </head>
  <body>

    <nav class="blue darken-2">
      <div class="nav-wrapper container">
        <a href="#" class="brand-logo">Blue Bank</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><span>Agência: <strong id="num-agencia"> 0001 </strong></span></li>
            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li><span>Conta: <strong id="num-conta"> 000111 - 1 </strong></span></li>
        </ul>
      </div>
    </nav>

    <section class="container">
      
      <div class="row">
        <div class="col-md-12">
            <br>
            <ol class="breadcrumb bb-breadcrumb">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="#">Transferência</a></i></li>
                <span class="pull-right black-text" id="nome">
                    Davi Melk
                </span>
            </ol>
        </div>
    </div>

    <div class="row">
        
        <div class="col-md-5">
           <div class="card-panel blue-grey darken-1 white-text">
                Saldo disponivel CC: <span class="saldo pull-right" id="saldo">R$ 500,00</span>
            </div>
        </div>
        <div class="col-md-2 title center"><i class="fa fa-exchange"></i></div>
        <div class="col-md-5">
            <div class="card-panel blue-grey darken-1 white-text center">
                 <big><b>Transferir para </b></big>
            </div>
        </div>

        
    </div>

    <div class="row">
    <div class="col s12">
      <ul class="tabs">
        <li class="tab col s3"><a class="active" href="#contatos">Contatos</a></li>
        <li class="tab col s3"><a href="#outro-contato">Outra Conta</a></li>
      </ul>
    </div>
    <div id="contatos" class="col s12"><br>
         
        <div class="card horizontal card-contato">
            <div class="card-image">
                <img src="http://lorempixel.com/output/people-q-c-70-70-9.jpg">
            </div>
            <div class="card-stacked">
                <div class="card-content">
                    <p>Liliana da Silva Sauro</p>
                </div>
            </div>
        </div>

        <div class="card horizontal card-contato">
            <div class="card-image">
                <img src="http://lorempixel.com/output/people-q-c-70-70-1.jpg">
            </div>
            <div class="card-stacked">
                <div class="card-content">
                    <p>Maria Joana</p>
                </div>
            </div>
        </div>



    </div>
    <div id="outro-contato" class="col s12"><br>
        <form>
            <div class="row">
                <div class="input-field col s12">
                <input disabled value="Blue Bank" id="disabled" type="text" class="validate">
                <label for="disabled">Banco</label>
                </div>
            </div>
            
            <div class="row">
                <div class="input-field col s6">
                    <input id="nome" type="text" class="validate">
                    <label for="nome">Nome</label>
                </div>
                <div class="input-field col s6">
                    <input id="cpf" type="text" class="validate">
                    <label for="cpf">CPF</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s6">
                    <input id="agencia" type="text" class="validate">
                    <label for="agencia">AgÃªncia</label>
                </div>
                <div class="input-field col s6">
                    <input id="conta" type="text" class="validate">
                    <label for="conta">Conta</label>
                </div>
            </div>

            <div class="row">
                
            </div>
        </form>
    </div>
  </div>
      
    </section>
    
    



<footer class="page-footer blue darken-2">
    <div class="container">
    <div class="row">
        <div class="col l6 s12">
        <h5 class="white-text">Blue Bank</h5>
        <p class="grey-text text-lighten-4">
            O Blue Bank tem o orgulho de ser o maior, melhor e com os melhores serviÃ§os de banco onlide do mundo.
        </p>
        </div>
        <div class="col l4 offset-l2 s12">
        <h5 class="white-text">Links</h5>
        <ul>
            <li><a class="grey-text text-lighten-3" href="#!">Fale Conosco</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Quem Somos</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Termos de Uso</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Politica de Privacidade</a></li>
        </ul>
        </div>
    </div>
    </div>
    <div class="footer-copyright">
    <div class="container">
    Â© 2017 Copyright Text
    <a class="grey-text text-lighten-4 right" href="#!">Mapa do Site</a>
    </div>
    </div>
</footer>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/materialize.js"></script>

    <script>
        $(document).ready(function(){
            $('.carousel').carousel();
        });
    </script>
   
  </body>
</html>
