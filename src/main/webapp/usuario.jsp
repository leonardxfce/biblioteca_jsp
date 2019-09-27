<%-- 
    Document   : historial_prestamos
    Created on : 09-nov-2018, 15:34:40
    Author     : Tomas Camargo
--%>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("login.jsp");
    }
    if(session.getAttribute("type") == null){
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Usuarios</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/logo-nav.css" rel="stylesheet">

  </head>
    <body>
        <jsp:include page="nav-bar.jsp"/>
        <div class="container">
    <div class="container"  id="form">
      <div class="row mt-5">
        <div class="col-12">
          <center><h1>Usuarios</h1></center>
        </div>
      </div>
        
       <!-- <center><div class="col-2 mb-3">
                <select id="tipoUsuario" class="form-control" onchange="llenarTablaUsuarios()">
                <option value="0">Elegir opción</option>
                <option value="alumno">Alumnos</option>
                <option value="vedel">Vedeles</option>
            </select>
                <button type="button" class="btn btn-primary" style="width: auto;" data-toggle='modal' data-target='#AñadirAdmin'>
                Añadir vedel
            </button>
            </div> 
            
            
        </center>-->

        <div class="scrolleable">
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre y Apellido</th>
                        <th>Último ingreso</th>
                        <th>DNI</th>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th style="width: 15%;">Editar</th>
                        <th style="width: 15%;">Eliminar</th>
                    </tr>
                </thead>
                <tbody id="ABMusuarios">

                </tbody>
            </table>
            
            
        </div>
       <center>
           <button type="button" class="btn btn-primary" style="width: auto;" onclick="BajaUsuariosAntiguos()">
                Borrar usuarios antiguos
            </button>
    </center>

        <br>
    </div>
        </div>
        
        <div class="alert_position" id="container-alert">

        </div>
        
    <!-- Modal Editar-->    
    <div id="Editar" class="modal fade" role="dialog">
        <div class="modal-dialog" style="margin: 3rem auto;">

        <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Editar usuario</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" id="nombreUser" name="user">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="nombre">Apellido</label>
                                <input type="text" class="form-control" id="apellidoUser" name="user">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="nombre">DNI (Sin puntos)</label>
                                <input type="text" class="form-control" id="dni" name="user">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="nombre">Usuario</label>
                                <input type="text" class="form-control" id="User" name="user">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="nombre">Contraseña</label>
                                <input type="text" class="form-control" id="Pass" name="user">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="editarUsuario('ControladorUsuario', 'user')">Editar</button>
                </div>
            </div>

        </div>
    </div>
    
        <!-- Modal Eliminar-->
    <div id="Eliminar" class="modal fade" role="dialog">
        <div class="modal-dialog" style="margin: 7rem auto;">

        <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Confirmar eliminación</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" >No</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="eliminarUsuario()">Si</button>
                </div>
            </div>

        </div>
    </div>      
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/PopUp.js"></script>
    <script type="text/javascript" src="js/ajax.js" onload="llenarABMUsuarios('ABMusuarios', 'ControladorUsuario')"></script>
    <script src="js/verificacion.js"></script>
    </body>
</html>


