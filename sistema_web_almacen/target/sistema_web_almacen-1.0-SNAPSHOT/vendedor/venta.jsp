<%@page import="java.util.List"%>
<%@page import="Venta.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!--    ----------------------------------------------------------------------------------------------------------------------  -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ventas</h1>
                    <a href="ventaFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Venta</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Ventas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Cliente</th>
                                            <th>Producto</th>
                                            <th>Precio Venta</th>
                                            <th>Comprobante</th>
                                            <th>Pago</th>
                                            <th>Fecha de Venta</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Cliente</th>
                                            <th>Producto</th>
                                            <th>Precio Venta</th>
                                            <th>Comprobante</th>
                                            <th>Pago</th>
                                            <th>Fecha de Venta</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                            List<Venta> listaVenta = (List) request.getSession().getAttribute("listaVenta");
                                            if(listaVenta==null){
                                                response.sendRedirect("/sistema_web_almacen/SvVenta");
                                            }else{
                                                for(Venta venta: listaVenta){

                                        %>
                                        <tr>
                                            <td name="cliente"><%=venta.getCliente().getNombre()%> <%=venta.getCliente().getApellido()%></td>
                                            <td name="producto"><%=venta.getProducto().getMarcaProducto()%> <%=venta.getProducto().getNombreProducto()%></td>
                                            <td name="precioVenta"><%=venta.getProducto().getPrecioVenta()%></td>
                                            <td name="comprobante"><%=venta.getComprobante().getTipoComprobante()%></td>
                                            <td name="pago"><%=venta.getPago().getTipoPago()%></td>
                                            <td>
                                                <form name="editar" action="/sistema_web_almacen/SvVentaEditar" method="get">
                                                    <button type="submit" class="btn btn-info btn-circle">
                                                        <i class="fas fa-info-circle"></i>
                                                    </button>     
                                                    <input type="hidden" name="idVenta" value="<%=venta.getIdVenta()%>">
                                                </form>

                                                <form name="eliminar" action="/sistema_web_almacen/SvVentaEliminar" method="post">
                                                    <button type="submit" class="btn btn-danger btn-circle">
                                                        <i class="fas fa-trash"></i>
                                                    </button>     
                                                    <input type="hidden" name="idVenta" value="<%=venta.getIdVenta()%>">
                                                </form>
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
            
<%@include file="componentes/bodyFinal.jsp" %>