<%@page import="Cliente.ClienteC"%>
<%@page import="Cliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!--    ----------------------------------------------------------------------------------------------------------------------  -->

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Clientes</h1>
        <a href="clienteFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Agregar Cliente</span>
        </a>
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Tabla de Clientes</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>DNI</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Celular</th>
                                <th>Correo</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>DNI</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Celular</th>
                                <th>Correo</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <%
                                List<Cliente> listaCliente = (List<Cliente>)request.getSession().getAttribute("listaCliente");
                                if(listaCliente==null){
                                    response.sendRedirect("/sistema_web_almacen/SvCliente");
                                }else{
                                    for(Cliente cliente: listaCliente){
                            %>
                            <tr>
                                <td><%=cliente.getDni()%></td>
                                <td><%=cliente.getNombre()%></td>
                                <td><%=cliente.getApellido()%></td>
                                <td><%=cliente.getCelular()%></td>
                                <td><%=cliente.getCorreo()%></td>
                                <td>
                                    <form name="editar" action="/sistema_web_almacen/SvClienteEditar" method="get">
                                       <button type="submit" class="btn btn-info btn-circle">
                                           <i class="fas fa-info-circle"></i>
                                        </button>     
                                        <input type="hidden" name="idCliente" value="<%=cliente.getIdCliente()%>">
                                    </form>

                                    <form name="eliminarCliente" action="/sistema_web_almacen/SvClienteEliminar" method="post">
                                        <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalCliente('<%=cliente.getIdCliente()%>')">
                                            <i class="fas fa-trash"></i>
                                        </button>
                                        <input type="hidden" name="idCliente" value="<%=cliente.getIdCliente()%>">
                                    </form>

                                    <!-- Modal de confirmación para eliminar cliente -->
                                    <div class="modal fade" id="logoutModalCliente_<%=cliente.getIdCliente()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Cliente</h5>
                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>¿Está seguro de que desea eliminar el cliente "<%=cliente.getDni()%>"?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                    <a class="btn btn-primary" href="#" onclick="eliminarCliente('<%=cliente.getIdCliente()%>')">Eliminar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <%      }   
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
    
<script>
    function mostrarModalCliente(idCliente) {
        // Muestra el modal correspondiente al botón de eliminar cliente
        $('#logoutModalCliente_' + idCliente).modal('show');

        // Si el usuario confirma la eliminación, envía la solicitud al servidor
        $('#logoutModalCliente_' + idCliente + ' .btn-primary').click(function () {
            // Realiza la solicitud de eliminación al servidor usando AJAX
            $.ajax({
                type: 'POST',
                url: '/sistema_web_almacen/SvClienteEliminar',
                data: { idCliente: idCliente },
                success: function (data) {
                    // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                    // Por ejemplo, recargar la página o actualizar la lista de clientes
                    location.reload();
                }
            });
        });
    }
</script>
<%@include file="componentes/bodyFinal.jsp" %>