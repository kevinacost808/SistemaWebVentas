<%@page import="Pago.Pago"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>
<!-- -------------------------------------------------------------------------------------------------------------------------- -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tipo de Pago</h1>
                    <a href="pagoFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Pago</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tipos de pagos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tipo de pago</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Tipo de pago</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                        List<Pago> listaPago = (List)request.getSession().getAttribute("listaPago");
                                        if(listaPago==null){
                                                response.sendRedirect("/sistema_web_almacen/SvPago");
                                            }else{
                                                for(Pago pago: listaPago){
                                        %>
                                        <tr>
                                            <td name="tipoPago"><%=pago.getTipoPago()%></td>
                                            <td>
                                                    <form name="editar" action="/sistema_web_almacen/SvPagoEditar" method="get">
                                                        <button type="submit" class="btn btn-info btn-circle">
                                                            <i class="fas fa-info-circle"></i>
                                                        </button>     
                                                        <input type="hidden" name="idPago" value="<%=pago.getIdPago()%>">
                                                    </form>

                                                    <form name="eliminarPago" action="/sistema_web_almacen/SvPagoEliminar" method="post">
                                                        <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalPago('<%=pago.getIdPago()%>')">
                                                            <i class="fas fa-trash"></i>
                                                        </button>
                                                        <input type="hidden" name="idPago" value="<%=pago.getIdPago()%>">
                                                    </form>

                                                    <!-- Logout Modal con id único para los pagos -->
                                                    <div class="modal fade" id="logoutModalPago_<%=pago.getIdPago()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Pago</h5>
                                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <p>¿Está seguro de que desea eliminar este pago?</p>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                                    <a class="btn btn-primary" href="#" onclick="eliminarPago('<%=pago.getIdPago()%>')">Eliminar</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                            </td>
                                        </tr>
                                        <%
                                            }}
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
                function mostrarModalPago(idPago) {
                    // Muestra el modal correspondiente al botón de eliminar pago
                    $('#logoutModalPago_' + idPago).modal('show');

                    // Si el usuario confirma la eliminación, envía la solicitud al servidor
                    $('#logoutModalPago_' + idPago + ' .btn-primary').click(function () {
                        // Realiza la solicitud de eliminación al servidor usando AJAX
                        $.ajax({
                            type: 'POST',
                            url: '/sistema_web_almacen/SvPagoEliminar',
                            data: { idPago: idPago },
                            success: function (data) {
                                // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                                // Por ejemplo, recargar la página o actualizar la lista de pagos
                                location.reload();
                            }
                        });
                    });
                }
            </script>
<%@include file="componentes/bodyFinal.jsp" %>