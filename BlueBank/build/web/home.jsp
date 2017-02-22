<%-- 
    Document   : home
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
                <li><a href="#">Home</a></li>
                <span class="pull-right black-text" id="nome">
                    Davi Melk
                </span>
            </ol>
        </div>
        
    </div>
   
    <div class="row">
        <div class="col-md-5">
            <div class="card-panel blue-grey darken-1 white-text">
                Saldo disponivel: <span class="saldo pull-right" id="saldo">R$ 500,00</span>
            </div>
        </div>

        <div class="col-md-7 inicio-botoes">

            <a class="btn waves-effect red darken-4 btn-lg btn-block btn-large"
                href="transferencia.jsp">
                Transferência
                <span class="glyphicon glyphicon-share-alt ico-btn-inicio" aria-hidden="true"></span>    
            </a>

            <a class="btn waves-effect red darken-4 btn-lg btn-block btn-large"
                href="#">
                Extrato da Conta
                <span class="glyphicon glyphicon-share-alt ico-btn-inicio" aria-hidden="true"></span>    
            </a>

            <a class="btn waves-effect red darken-4 btn-lg btn-block btn-large"
                href="#">
                Contatos Salvos
                <span class="glyphicon glyphicon-share-alt ico-btn-inicio" aria-hidden="true"></span>    
            </a>
            
        </div>
    </div>
    </section>
    
    
<section class="container">

    <div class="carousel"><h5>Nossos Planos</h5>
        <a class="carousel-item" href="#">
            <img src="http://lorempixel.com/250/250/nature/5">
            Tesouro Direto    
        </a>
        <a class="carousel-item" href="#">
            <img src="http://lorempixel.com/250/250/nature/2">
            CDB
        </a>
        <a class="carousel-item" href="#">
            <img src="http://lorempixel.com/250/250/nature/3">
            CaptalizaÃ§Ã£o 
        </a>
        <a class="carousel-item" href="#">
            <img src="http://lorempixel.com/250/250/nature/4">
            Bolsa de Valores
        </a>
        <a class="carousel-item" href="#">
            <img src="http://lorempixel.com/250/250/nature/5">
            Tesouro Direto    
        </a>
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
