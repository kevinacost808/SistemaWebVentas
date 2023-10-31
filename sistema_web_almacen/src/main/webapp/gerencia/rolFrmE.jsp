<%@page import="Rol.Rol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>
<!-- -------------------------------------------------------------------------------------------------------------------------- -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Editar Rol</h1>
                    <br>
                    <% Rol rol = (Rol)request.getSession().getAttribute("rolEditar");%>
                    <form action="/sistema_web_almacen/SvRolEditar" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Rol</h6>
                            </div>
                            <div class="card-body">
                                <div class="form-group" hidden>
                                    <label for="idRol">ID</label>
                                    <input type="text" class="form-control" id="idRol" name="idRol" value="<%=rol.getIdRol()%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="nombreRol">Nombre</label>
                                    <input type="text" class="form-control" id="nombreRol" name="nombreRol" value="<%=rol.getNombreRol()%>" required>
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
                                        <span class="text">ACTUALIZAR</span>
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