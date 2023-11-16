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

                                                    <form name="eliminarProducto" action="/sistema_web_almacen/SvProductoEliminar" method="post">
                                                        <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalProducto('<%=producto.getCodigoProducto()%>')">
                                                            <i class="fas fa-trash"></i>
                                                        </button>
                                                        <input type="hidden" name="codigoProducto" value="<%=producto.getCodigoProducto()%>">
                                                    </form>

                                                    <!-- Modal de confirmación para eliminar producto -->
                                                    <div class="modal fade" id="logoutModalProducto_<%=producto.getCodigoProducto()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Producto</h5>
                                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <p>¿Está seguro de que desea eliminar este producto: <%=producto.getCodigoProducto()%>?</p>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                                    <a class="btn btn-primary" href="#" onclick="eliminarProducto('<%=producto.getCodigoProducto()%>')">Eliminar</a>
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
    <!-- End of Page Wrapper -->
    <!-- Script para mostrar el modal y realizar la acción de eliminación -->
<script>
    function mostrarModalProducto(codigoProducto) {
        // Muestra el modal correspondiente al botón de eliminar producto
        $('#logoutModalProducto_' + codigoProducto).modal('show');

        // Si el usuario confirma la eliminación, envía la solicitud al servidor
        $('#logoutModalProducto_' + codigoProducto + ' .btn-primary').click(function () {
            // Realiza la solicitud de eliminación al servidor usando AJAX
            $.ajax({
                type: 'POST',
                url: '/sistema_web_almacen/SvProductoEliminar',
                data: { codigoProducto: codigoProducto },
                success: function (data) {
                    // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                    // Por ejemplo, recargar la página o actualizar la lista de productos
                    location.reload();
                }
            });
        });
    }
</script>

<%@include file="componentes/bodyFinal.jsp" %>