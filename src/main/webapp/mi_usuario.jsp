
<!DOCTYPE html>
<html>
    <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Mi usuario</title>

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
          <center><h1>Mi usuario</h1></center>
        </div>
      </div>
       
       <div class="row">
          <div class="col-2"></div>
          <div class="col-6">
            <div class="form-group">
              <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" id="nombreUser" name="user">
            </div>
          </div>
          <div class="col-3"></div>
      </div>
              <div class="row">
          <div class="col-2"></div>
          <div class="col-6">
            <div class="form-group">
              <label for="nombre">Apellido</label>
                                <input type="text" class="form-control" id="apellidoUser" name="user">
            </div>
          </div>
          <div class="col-3"></div>
      </div>
              <div class="row">
          <div class="col-2"></div>
          <div class="col-6">
            <div class="form-group">
            <label for="nombre">DNI (Sin puntos)</label>
                                <input type="text" class="form-control" id="dni" name="user">
            </div>
          </div>
          <div class="col-3"></div>
      </div>
       <div class="row">
          <div class="col-2"></div>
          <div class="col-6">
            <div class="form-group">
            <label for="nombre">Usuario</label>
                        <input type="text" class="form-control" id="User" name="user">
            </div>
          </div>
          <div class="col-3"></div>
      </div>
        <div class="row">
          <div class="col-2"></div>
          <div class="col-6">
            <div class="form-group">
            <label for="nombre">Contraseña</label>
            <input type="text" class="form-control" id="Pass" name="user">
            </div>
          </div>
          <div class="col-3"></div>
      </div>
       
      <div class="row">
        <div class="col-8"></div>
        <div class="col-3">
            <button class="btn btn-secondary btn-lg " type="button" id="editar" onclick="editarUsuario('ControladorUsuario', 'user')">Modificar</button>
        </div>
      </div>
       <div class="alert_position" id="container-alert">

        </div>
 
               
            </div>

        </div>
  
    
      
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/verificacion.js"></script>
    <script type="text/javascript"></script>
    </body>
</html>



