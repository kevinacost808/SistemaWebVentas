<%@page import="Comprobante.Comprobante"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Tipo de Comprobante</h1>
                    <a href="comprobanteFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Comprobantepan</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tipos de Comprobante</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tipo de Comprobante</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Tipo de Comprobante</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                        List<Comprobante> listaComprobante = (List)request.getSession().getAttribute("listaComprobante");
                                        if(listaComprobante==null){
                                                response.sendRedirect("/sistema_web_almacen/SvComprobante");
                                            }else{
                                                for(Comprobante comprobante : listaComprobante){
                                            
                                        %>
                                        <tr>
                                            <td name="tipoComprobante"><%=comprobante.getTipoComprobante()%></td>
                                            <td>
                                                    <form name="editar" action="/sistema_web_almacen/SvComprobanteEditar" method="get">
                                                        <button type="submit" class="btn btn-info btn-circle">
                                                            <i class="fas fa-info-circle"></i>
                                                        </button>     
                                                        <input type="hidden" name="idComprobante" value="<%=comprobante.getIdComprobante()%>">
                                                    </form>

                                                    <!-- Agrega el idComprobante como un identificador único para el botón y el modal -->
                                                    <form name="eliminar" action="/sistema_web_almacen/SvComprobanteEliminar" method="post">
                                                        <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModal('<%=comprobante.getIdComprobante()%>')">
                                                            <i class="fas fa-trash"></i>
                                                        </button>
                                                        <input type="hidden" name="idComprobante" value="<%=comprobante.getIdComprobante()%>">
                                                    </form>

                                                    <div class="modal fade" id="logoutModal_<%=comprobante.getIdComprobante()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Comprobante</h5>
                                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <p>¿Está seguro de que desea eliminar este comprobante?</p>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                                    <a class="btn btn-primary" href="#" onclick="eliminarComprobante('<%=comprobante.getIdComprobante()%>')">Eliminar</a>
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
                function mostrarModal(idComprobante) {
                    // Muestra el modal correspondiente al botón de eliminar
                    $('#logoutModal_' + idComprobante).modal('show');

                    // Si el usuario confirma la eliminación, envía la solicitud al servidor
                    $('#logoutModal_' + idComprobante + ' .btn-primary').click(function () {
                        // Realiza la solicitud de eliminación al servidor usando AJAX
                        $.ajax({
                            type: 'POST',
                            url: '/sistema_web_almacen/SvComprobanteEliminar',
                            data: { idComprobante: idComprobante },
                            success: function (data) {
                                // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                                // Por ejemplo, recargar la página o actualizar la lista de comprobantes
                                location.reload();
                            }
                        });
                    });
                }
            </script>
<%@include file="componentes/bodyFinal.jsp" %>