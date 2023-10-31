<%@page import="Rol.RolC"%>
<%@page import="Rol.Rol"%>
<%@page import="java.util.List"%>
<%@page import="Sucursal.Sucursal"%>
<%@page import="Sucursal.SucursalC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- -------------------------------------------------------------------------------------------------------------------------- -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <%
                        int idSucursal = (int)request.getSession().getAttribute("idSucursal");
                        SucursalC sucursalC = new SucursalC();
                        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
                    %>
        
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Agregar Usuario - SUCURSAL: <%=sucursal.getNombreSucursal()%></h1>
                    <br>
                    <form action="/sistema_web_almacen/SvUsuario" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Usuario</h6>
                            </div>
                            <div class="card-body">
                                
                                <div class="form-group">
                                    <label for="nombre">Nombre del Usuario</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                                </div>

                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="text" class="form-control" id="password" name="password" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="idRol">Rol:</label>
                                    <select class="form-control" id="idRol" name="idRol">
                                        <%
                                            List<Rol> listaRol = (List<Rol>)request.getSession().getAttribute("listaRol");
                                            if (listaRol == null) {
                                                RolC rolC = new RolC();
                                                // La lista de proveedores no está en la sesión, obténla de la base de datos
                                                listaRol = rolC.consultarRol();
                                                // Al obtenerla, guárdala en la sesión para futuros accesos
                                                request.getSession().setAttribute("listaRol", listaRol);
                                            }
                                            for(Rol rol : listaRol ){
                                        %>
                                            <option value="<%=rol.getIdRol()%>"><%=rol.getNombreRol()%></option>
                                        <%  }%>
                                    </select>
                                </div>
                                    
                                <div class="form-group" hidden>
                                    <label for="idSucursal">Sucursal</label>
                                    <input type="text" class="form-control" id="idSucursal" name="idSucursal" value="<%=sucursal.getIdSucursal()%>" required>
                                </div>
                                    
                                <div class="form-group">
                                    <button type="reset" class="btn btn-warning btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-exclamation-triangle"></i>
                                        </span>
                                        <span class="text">Limpiar</span>
                                    </button>

                                    <button type="submit" class="btn btn-success btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                                        <span class="text">GUARDAR</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
<%@include file="componentes/bodyFinal.jsp" %>
