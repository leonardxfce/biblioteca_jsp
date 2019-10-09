<%-- 
    Document   : inventario2
    Created on : 11/06/2019, 14:03:20
    Author     : Tommy
--%>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Inventario</title>

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
          <center><h1>Inventario</h1></center>
        </div>
      </div>
        <div class="scrolleable">
            <% if(session.getAttribute("type") == null){%>
            <table  class="table">
                <thead>
                    <tr>
                        <th>Libro</th>
                        <th>Autor</th>
                        <th>Tema</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <tbody id="tablaCompletaAlumnos">
                </tbody>
            </table>
            <%} else {%>
            <table  class="table">
                <thead>
                    <tr>
                        <th>Libro</th>
                        <th>Autor</th>
                        <th>Tema</th>
                        <th>Cantidad</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody id="tablaCompletaVedeles">
                </tbody>
            </table>
            <% } %>
        </div>
        </div>
    </div>
        
        <div class="alert_position" id="container-alert">

        </div>
    <!-- /.container -->
            <!-- Modal Eliminar-->
    <div id="Eliminar" class="modal fade" role="dialog">
        <div class="modal-dialog" style="margin: 7rem auto;">

        <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Confirmar eliminación</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="cod-lib">Seleccione el Codigo del Libro a eliminar</label>
                                <select id='codigos' class='form-control'></select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" >No</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="eliminarLibro()">Si</button>
                </div>
            </div>

        </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/abm.js" onload="<%if(session.getAttribute("type") == null){%>inventarioLibros('2')<%} 
else {%>inventarioLibros('1')<%}%>"></script>

  </body>
</html>

