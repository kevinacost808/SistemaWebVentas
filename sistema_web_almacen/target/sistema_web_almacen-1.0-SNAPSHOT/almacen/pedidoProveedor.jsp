<%@page import="PedidoProveedor.PedidoProveedor"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Pedidos Proveedor</h1>
                    <a href="pedidoProveedorFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Pedido</span>
                    </a>
                    <br><br>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Pedidos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>idPedido</th>
                                            <th>Nombre</th>
                                            <th>Cantidad</th>
                                            <th>Precio Unidad</th>
                                            <th>Total S/</th>
                                            <th>Fecha de Pedido</th>
                                            <th>Proveedor</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>idPedido</th>
                                            <th>Nombre</th>
                                            <th>Cantidad</th>
                                            <th>Precio Unidad</th>
                                            <th>Total S/</th>
                                            <th>Fecha de Pedido</th>
                                            <th>Proveedor</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        
                                        <%
                                            List<PedidoProveedor> listaPedidoProveedor = (List) request.getSession().getAttribute("listaPedidoProveedor");
                                            if(listaPedidoProveedor==null){
                                                response.sendRedirect("/sistema_web_almacen/SvPedidoProveedor");
                                            }else{
                                                for(PedidoProveedor pedidoProveedor: listaPedidoProveedor){
                                        %>
                                        
                                        <tr>
                                            <td><%=pedidoProveedor.getIdPedidoProveedor()%></td>
                                            <td><%=pedidoProveedor.getNombre()%></td>
                                            <td><%=pedidoProveedor.getCantidad()%></td>
                                            <td><%=pedidoProveedor.getPrecioUnidad()%></td>
                                            <td><%=pedidoProveedor.getCantidad()*pedidoProveedor.getPrecioUnidad()%></td>
                                            <td><%=pedidoProveedor.getFechaPedido()%></td>
                                            <td><%=pedidoProveedor.getProveedor().getNombreProveedor()%></td>
                                            <td>
                                                <form name="editar" action="/sistema_web_almacen/SvPedidoProveedorEditar" method="get">
                                                    <button type="submit" class="btn btn-info btn-circle">
                                                        <i class="fas fa-info-circle"></i>
                                                    </button>     
                                                   <input type="hidden" name="idPedidoProveedor" value="<%=pedidoProveedor.getIdPedidoProveedor()%>">
                                                </form>

                                                <form name="eliminarPedidoProveedor" action="/sistema_web_almacen/SvPedidoProveedorEliminar" method="post">
                                                    <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalPedidoProveedor('<%=pedidoProveedor.getIdPedidoProveedor()%>')">
                                                        <i class="fas fa-trash"></i>
                                                    </button>
                                                    <input type="hidden" name="idPedidoProveedor" value="<%=pedidoProveedor.getIdPedidoProveedor()%>">
                                                </form>

                                                <!-- Logout Modal con id único para los pedidos de proveedores -->
                                                <div class="modal fade" id="logoutModalPedidoProveedor_<%=pedidoProveedor.getIdPedidoProveedor()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Eliminar Pedido de Proveedor</h5>
                                                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <p>¿Está seguro de que desea eliminar este pedido de proveedor?</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                                <a class="btn btn-primary" href="#" onclick="eliminarPedidoProveedor('<%=pedidoProveedor.getIdPedidoProveedor()%>')">Eliminar</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        
                                        <%  }}%>
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
                function mostrarModalPedidoProveedor(idPedidoProveedor) {
                    // Muestra el modal correspondiente al botón de eliminar pedido de proveedor
                    $('#logoutModalPedidoProveedor_' + idPedidoProveedor).modal('show');

                    // Si el usuario confirma la eliminación, envía la solicitud al servidor
                    $('#logoutModalPedidoProveedor_' + idPedidoProveedor + ' .btn-primary').click(function () {
                        // Realiza la solicitud de eliminación al servidor usando AJAX
                        $.ajax({
                            type: 'POST',
                            url: '/sistema_web_almacen/SvPedidoProveedorEliminar',
                            data: { idPedidoProveedor: idPedidoProveedor },
                            success: function (data) {
                                // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                                // Por ejemplo, recargar la página o actualizar la lista de pedidos de proveedores
                                location.reload();
                            }
                        });
                    });
                }
            </script>
<%@include file="componentes/bodyFinal.jsp" %>