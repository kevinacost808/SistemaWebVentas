<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenido!</h1>
                                    </div>
                                    <%
                                    Boolean inicioSesionExitoso = (Boolean) session.getAttribute("inicioSesionExitoso");
                                    if (inicioSesionExitoso != null) {
                                        if (inicioSesionExitoso) {
                                    %>
                                            <div class="alert alert-success" role="alert">
                                                Inicio de sesión exitoso.
                                            </div>
                                    <%
                                        } else {
                                    %>
                                            <div class="alert alert-danger" role="alert">
                                                Datos incorrectos. Por favor, intente nuevamente.
                                            </div>
                                    <%
                                        }
                                        session.removeAttribute("inicioSesionExitoso"); // Limpiar el atributo de la sesión después de mostrar el mensaje
                                    }
                                    %>
                                    <form action="/sistema_web_almacen/SvLogin" method="post" id="loginForm">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="usuario" name="usuario" aria-describedby="emailHelp"
                                                placeholder="Ingrese usuario...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-user btn-block" onclick="iniciarSesion()">
                                            <span class="text">Login</span>
                                        </button>
                                        <hr>
                                        <div id="mensajeInicioSesion" style="display:none;">
                                            <!-- Mensaje de "Iniciando sesión" o "Datos incorrectos" -->
                                        </div>
                                        <!-- Modal de carga -->
                                        <div class="modal" id="cargandoModal" style="display:none;">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <!-- Icono de carga -->
                                                    <div class="spinner-border text-primary" role="status">
                                                        <span class="sr-only">Loading...</span>
                                                    </div>
                                                    <!-- Mensaje opcional -->
                                                    <div class="modal-body">
                                                        Iniciando sesión...
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <script>
    function mostrarMensajeInicioSesion() {
        var mensajeDiv = document.getElementById("mensajeInicioSesion");
        mensajeDiv.style.display = "block";
        mensajeDiv.innerHTML = "Iniciando sesión..."; // Puedes personalizar el mensaje según tus necesidades
    }
    function iniciarSesion() {
        // Mostrar el modal de carga
        $('#cargandoModal').modal('show');

        // Enviar el formulario después de un breve retraso para que el modal tenga tiempo de mostrarse
        setTimeout(function() {
            document.getElementById('loginForm').submit();
        }, 500);
    }
    
    </script>
</body>

</html>