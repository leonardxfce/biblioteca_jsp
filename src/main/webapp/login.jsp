<%-- 
    Document   : historial_prestamos
    Created on : 09-nov-2018, 15:34:40
    Author     : Tomas Camargo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if(session.getAttribute("user") != null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Biblioteca IES 9-024</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/logo-nav.css" rel="stylesheet">

  </head>
    <body>
        <div class="container">
            <div class="container login" id="form">
                <center><img src="img/LOGO_NUEVO_2017_IES9024.png" id="img-login"></center>
                <center><h3 class="h3">Iniciar Sesión</h3></center>
                
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-6">
                                <div class="form-group">
                                    <label for="user" id="text-user">Usuario</label>
                                    <input type="text" class="form-control" id="user" 
                                           name="user">
                                </div>
                        </div>
                        <div class="col-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="col-6">
                                <div class="form-group">
                                    <label for="pass" id="text-pass">Contraseña</label>
                                    <input type="password" class="form-control" id="pass" name="pass">
                                </div>
                        </div>
                        <div class="col-3"></div>
                    </div>
                    <center><button type="button" class="btn btn-info" id="login">Ingresar</button></center>
                
                <br>
            </div>
        </div>
      
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/sesion.js"></script>
    
    <style>
        .form-control::placeholder { 
            color: red; 
        }
    </style>
    </body>
</html>

