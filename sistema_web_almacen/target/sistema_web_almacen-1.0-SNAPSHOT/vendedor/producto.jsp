<%@page import="Producto.Producto"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Productos</h1>
                    <a href="productoFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Producto</span>
                    </a>
                    <br><br>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Productos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Marca</th>
                                            <th>Nombre</th>
                                            <th>Categoria</th>
                                            <th>Precio Venta</th>
                                            <th>Fecha Ingreso</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Marca</th>
                                            <th>Nombre</th>
                                            <th>Categoria</th>
                                            <th>Precio Venta</th>
                                            <th>Fecha Ingreso</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                            List<Producto> listaProducto = (List) request.getSession().getAttribute("listaProducto");
                                            if(listaProducto==null){
                                            }else{
                                                for(Producto producto: listaProducto){

                                        %>
                                        <tr>
                                                <td name="codigoProducto"><%= producto.getCodigoProducto()%></td>
                                                <td name="marcaProducto"><%= producto.getMarcaProducto()%></td>
                                                <td name="nombreProducto"><%= producto.getNombreProducto()%></td>
                                                <td name="idCategoria"><%= producto.getCategoria().getNombreCategoria()%></td>
                                                <td name="precioVenta"><%= producto.getPrecioVenta()%></td>
                                                <td name="fechaIngreso"><%= producto.getFechaIngreso()%></td>
                                                <td>
                                                    
                                                    <form name="editar" action="/sistema_web_almacen/SvProductoEditar" method="get">
                                                        <button type="submit" class="btn btn-info btn-circle">
                                                            <i class="fas fa-info-circle"></i>
                                                        </button>     
                                                        <input type="hidden" name="codigoProducto" value="<%=producto.getCodigoProducto()%>">
                                                    </form>

                                                    <form name="eliminar" action="/sistema_web_almacen/SvProductoEliminar" method="post">
                                                        <button type="submit" class="btn btn-danger btn-circle">
                                                            <i class="fas fa-trash"></i>
                                                        </button>     
                                                        <input type="hidden" name="codigoProducto" value="<%=producto.getCodigoProducto()%>">
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

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; SIV 2023</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

<%@include file="componentes/bodyFinal.jsp" %>