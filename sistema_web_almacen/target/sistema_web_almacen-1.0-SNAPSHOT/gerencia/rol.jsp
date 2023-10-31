<%@page import="Rol.Rol"%>
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
        <h1 class="h3 mb-2 text-gray-800">Rol</h1>
        <a href="rolFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text" >Agregar Rol</span>
        </a>
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Tabla de Roles</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nombre Rol</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nombre Rol</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <%
                            List<Rol> listaRol = (List)request.getSession().getAttribute("listaRol");

                                for(Rol rol: listaRol){
                            %>
                            <tr>
                                <td name="nombreRol"><%=rol.getNombreRol()%></td>
                                <td>
                                        <form name="editar" action="/sistema_web_almacen/SvRolEditar" method="get">
                                            <button type="submit" class="btn btn-info btn-circle">
                                                <i class="fas fa-info-circle"></i>
                                            </button>     
                                            <input type="hidden" name="idRol" value="<%=rol.getIdRol()%>">
                                        </form>

                                        <form name="eliminar" action="/sistema_web_almacen/SvRolEliminar" method="post">
                                            <button type="submit" class="btn btn-danger btn-circle">
                                                <i class="fas fa-trash"></i>
                                            </button>     
                                            <input type="hidden" name="idRol" value="<%=rol.getIdRol()%>">
                                        </form>
                                </td>
                            </tr>
                            <%
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
<%@include file="componentes/bodyFinal.jsp" %>