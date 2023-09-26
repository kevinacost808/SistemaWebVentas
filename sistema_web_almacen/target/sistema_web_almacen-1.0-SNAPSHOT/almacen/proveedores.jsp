<%@page import="java.util.List"%>
<%@page import="Proveedor.Proveedor"%>
<%@page import="Proveedor.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- -------------------------------------------------------------------------------------------------------------------------- -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Proveedor</h1>
                    <a href="frmProveedor.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Proveedor</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Proveedores</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Ruc</th>
                                            <th>Direccion</th>
                                            <th>Celular</th>
                                            <th>Correo</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Ruc</th>
                                            <th>Direccion</th>
                                            <th>Celular</th>
                                            <th>Correo</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        
                                        <%
                                            List<Proveedor> listaProveedores = (List) request.getSession().getAttribute("listaProveedores");
                                            
                                            for(Proveedor proveedor: listaProveedores){
                                        %>
                                        
                                            <tr>
                                                <td name="nombreProveedor"><%= proveedor.getNombreProveedor()%></td>
                                                <td name="rucProveedor"><%= proveedor.getRucProveedor()%></td>
                                                <td name="direccion"><%= proveedor.getDireccion()%></td>
                                                <td name="celular"><%= proveedor.getCelular()%></td>
                                                <td name="correo"><%= proveedor.getCorreo()%></td>
                                                <td>
                                                    
                                                    <form name="editar" action="/sistema_web_almacen/SvProveedorEditar" method="get">
                                                        <button type="submit" class="btn btn-info btn-circle">
                                                            <i class="fas fa-info-circle"></i>
                                                        </button>     
                                                        <input type="hidden" name="idProveedor" value="<%=proveedor.getIdProveedor()%>">
                                                    </form>

                                                    <form name="eliminar" action="/sistema_web_almacen/SvProveedorEliminar" method="post">
                                                        <button type="submit" class="btn btn-danger btn-circle">
                                                            <i class="fas fa-trash"></i>
                                                        </button>     
                                                        <input type="hidden" name="idProveedor" value="<%=proveedor.getIdProveedor()%>">
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