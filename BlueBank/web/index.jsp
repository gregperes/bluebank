<%-- 
    Document   : login
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/assets/css/bootstrap.css">

    <!-- Bootstrap CSS -->
    <link href="assets/css/materialize.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
  
  </head>
  <body class="login-bg">
    <div class="container">

      <div class="login-logo">
        <img src="assets/img/logo.png" alt="Blue Bank">
      </div>

      <form id="formularioLogin" class="col-md-6 col-md-offset-3">
          
        <div class="input-field login-label">
          <input placeholder="" id="agencia" type="text" class="validate login-input" required>
          <label for="agencia" class="active login-label">Agência</label>
        </div>

        <div class="input-field">
          <input placeholder="" id="conta" type="text" class="validate login-input" required>
          <label for="conta" class="active login-label">Conta</label>
        </div>

        <div class="input-field">
          <input placeholder="" id="senha" type="password" class="validate login-input" required>
          <label for="senha" class="active login-label">Senha</label>
        </div>
            

        <div id="LogErro"></div>

        <div class="row">

          <div class="col-xs-4"></div>
          <!-- 
          <div class="col-xs-4"><br>
            <button class="btn btn-default btn-block grey" onclick="loginUsuario()">Logar</button>
          </div>
          -->
        </form>

        <div class="col-xs-4"><br>
          <button class="btn btn-default btn-block grey" onclick="loginUsuario()">Logar</button>
        </div>
        
      </div>
    </div>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/materialize.js"></script>

    <script>
        function loginUsuario () {
            location.href="home.jsp";
        }
    </script>
   
  </body>
</html>
