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

                                                <form name="eliminar" action="/sistema_web_almacen/SvPedidoProveedorEliminar" method="post">
                                                    <button type="submit" class="btn btn-danger btn-circle">
                                                        <i class="fas fa-trash"></i>
                                                    </button>     
                                                    <input type="hidden" name="idPedidoProveedor" value="<%=pedidoProveedor.getIdPedidoProveedor()%>">
                                                </form>
                                            </td>
                                        </tr>
                                        
                                        <%  }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<%@include file="componentes/bodyFinal.jsp" %>