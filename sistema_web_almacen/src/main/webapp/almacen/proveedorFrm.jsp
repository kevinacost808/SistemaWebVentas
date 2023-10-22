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
                    <h1 class="h3 mb-2 text-gray-800">Agregar Proveedor</h1>
                    <br>
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Formulario de Cliente</h6>
                    </div>

            <%
                List<String> listaProveedorRuc = (List)request.getSession().getAttribute("listaProveedorRuc");
            %>
                
            <form action="/sistema_web_almacen/SvProveedorRuc" method="post">
                <div class="card-body">
                    <div class="form-group">
                        <label for="dni">RUC</label>
                        <input type="text" class="form-control" id="ruc" name="ruc" value="<%=listaProveedorRuc!=null?listaProveedorRuc.get(0):""%>">
                        <br>
                        <button id="cargarRuc" type="submit" class="btn btn-info btn-circle">
                            <i class="fas fa-fw fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
                        
                    <form action="/sistema_web_almacen/SvProveedor" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Proveedor</h6>
                            </div>
                            <div class="card-body">
                                
                                <div class="form-group" hidden>
                                    <label for="rucProveedor">Ruc:</label>
                                    <input type="text" class="form-control" id="rucProveedor" name="rucProveedor" value="<%=listaProveedorRuc!=null?listaProveedorRuc.get(0):""%>" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="nombreProveedor">Nombre:</label>
                                    <input type="text" class="form-control" id="nombreProveedor" name="nombreProveedor" value="<%=listaProveedorRuc!=null?listaProveedorRuc.get(1):""%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="direccion">Direccion</label>
                                    <input type="text" class="form-control" id="direccion" name="direccion" required>
                                </div>

                                <div class="form-group">
                                    <label for="celular">Celular</label>
                                    <input type="text" class="form-control" id="celular" name="celular" required>
                                </div>

                                <div class="form-group">
                                    <label for="correo">Correo</label>
                                    <input type="email" class="form-control" id="correo" name="correo" required>
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
            
            <%
                listaProveedorRuc = null;
            %>
<%@include file="componentes/bodyFinal.jsp" %>