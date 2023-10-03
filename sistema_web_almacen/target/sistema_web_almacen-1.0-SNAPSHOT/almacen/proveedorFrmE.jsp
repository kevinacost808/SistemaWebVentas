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
                    <h1 class="h3 mb-2 text-gray-800">Editar Proveedor</h1>
                    <br>
                    <form action="/sistema_web_almacen/SvProveedorEditar" method="post">
                        <%
                            Proveedor proveedor = (Proveedor)request.getSession().getAttribute("proveedorEditar");
                        %>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Proveedor</h6>
                            </div>
                            <div class="card-body">
                                
                                <div class="form-group" hidden>
                                    <label for="idProveedor">ID</label>
                                    <input type="hidden" class="form-control" id="idProveedor" name="idProveedor" value="<%=proveedor.getIdProveedor()%>">
                                </div>
                                
                                <div class="form-group">
                                    <label for="nombreProveedor">Nombre:</label>
                                    <input type="text" class="form-control" id="nombreProveedor" name="nombreProveedor" value="<%=proveedor.getNombreProveedor()%>">
                                </div>
                                
                                <div class="form-group">
                                    <label for="rucProveedor">Ruc:</label>
                                    <input type="text" class="form-control" id="rucProveedor" name="rucProveedor" value="<%=proveedor.getRucProveedor()%>">
                                </div>

                                <div class="form-group">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" class="form-control" id="direccion" name="direccion" value="<%=proveedor.getDireccion()%>">
                                </div>

                                <div class="form-group">
                                    <label for="celular">Celular</label>
                                    <input type="text" class="form-control" id="celular" name="celular" value="<%=proveedor.getCelular()%>">
                                </div>

                                <div class="form-group">
                                    <label for="correo">Correo</label>
                                    <input type="text" class="form-control" id="correo" name="correo" value="<%=proveedor.getCorreo()%>">
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
                                        <span class="text">MODIFICAR</span>
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