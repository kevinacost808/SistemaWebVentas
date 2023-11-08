<%@page import="Sucursal.Sucursal"%>
<%@page import="Sucursal.SucursalC"%>
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
                    <%
                        int id = (int)request.getSession().getAttribute("idSucursal");
                        SucursalC sucursalC = new SucursalC();
                        Sucursal sucursal = sucursalC.consultarSucursalId(id);
                    %>
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">INVENTARIO - SUCURSAL: <%=sucursal.getNombreSucursal()%></h1>
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
                                            <th>Precio Compra</th>
                                            <th>Precio Venta</th>
                                            <th>ESTADO</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Marca</th>
                                            <th>Nombre</th>
                                            <th>Categoria</th>
                                            <th>Precio Compra</th>
                                            <th>Precio Venta</th>
                                            <th>ESTADO</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                            List<Producto> listaProducto = (List) request.getSession().getAttribute("listaProducto");
                                            if(listaProducto==null){
                                                response.sendRedirect("/sistema_web_almacen/SvProducto");
                                            }else{
                                                for(Producto producto: listaProducto){

                                        %>
                                        <tr>
                                                <td name="codigoProducto"><%= producto.getCodigoProducto()%></td>
                                                <td name="marcaProducto"><%= producto.getMarcaProducto()%></td>
                                                <td name="nombreProducto"><%= producto.getNombreProducto()%></td>
                                                <td name="idCategoria"><%= producto.getCategoria().getNombreCategoria()%></td>
                                                <td name="precioCompra"><%= producto.getPrecioCompra()%></td>
                                                <td name="precioVenta"><%= producto.getPrecioVenta()%></td>
                                                <%
                                                String estado=null;
                                                if(producto.isVendido()==false){
                                                    estado = "En almacen"; 
                                                    }else{
                                                    estado = "VENDIDO"; 
                                                    }
                                                %>
                                                <td name="estado"><%=estado%></td>
                                                <%}
                                                }   
                                                %>
                                            </tr>
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