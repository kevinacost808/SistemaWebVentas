<%@page import="Categoria.Categoria"%>
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
        <h1 class="h3 mb-2 text-gray-800">Categorias</h1>
        <a href="categoriaFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Agregar Categoria</span>
        </a>
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Tabla de Categoria</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nombre Categoria</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nombre Categoria</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <%
                            List<Categoria> listaCategoria = (List)request.getSession().getAttribute("listaCategoria");
                            if(listaCategoria==null){
                                response.sendRedirect("/sistema_web_almacen/SvCategoria");
                            }else{
                                for(Categoria categoria: listaCategoria){
                            %>
                            <tr>
                                <td name="nombreCategoria"><%=categoria.getNombreCategoria()%></td>
                                <td>
                                        <form name="editar" action="/sistema_web_almacen/SvCategoriaEditar" method="get">
                                            <button type="submit" class="btn btn-info btn-circle">
                                                <i class="fas fa-info-circle"></i>
                                            </button>     
                                            <input type="hidden" name="idCategoria" value="<%=categoria.getIdCategoria()%>">
                                        </form>

                                        <form name="eliminarCategoria" action="/sistema_web_almacen/SvCategoriaEliminar" method="post">
                                            <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalCategoria('<%=categoria.getIdCategoria()%>')">
                                                <i class="fas fa-trash"></i>
                                            </button>
                                            <input type="hidden" name="idCategoria" value="<%=categoria.getIdCategoria()%>">
                                        </form>

                                        <!-- Logout Modal con id único para las categorías -->
                                        <div class="modal fade" id="logoutModalCategoria_<%=categoria.getIdCategoria()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Eliminar Categoría</h5>
                                                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>¿Está seguro de que desea eliminar esta categoría?</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                        <a class="btn btn-primary" href="#" onclick="eliminarCategoria('<%=categoria.getIdCategoria()%>')">Eliminar</a>
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
    function mostrarModalCategoria(idCategoria) {
        // Muestra el modal correspondiente al botón de eliminar categoría
        $('#logoutModalCategoria_' + idCategoria).modal('show');

        // Si el usuario confirma la eliminación, envía la solicitud al servidor
        $('#logoutModalCategoria_' + idCategoria + ' .btn-primary').click(function () {
            // Realiza la solicitud de eliminación al servidor usando AJAX
            $.ajax({
                type: 'POST',
                url: '/sistema_web_almacen/SvCategoriaEliminar',
                data: { idCategoria: idCategoria },
                success: function (data) {
                    // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                    // Por ejemplo, recargar la página o actualizar la lista de categorías
                    location.reload();
                }
            });
        });
    }
</script>
<%@include file="componentes/bodyFinal.jsp" %>