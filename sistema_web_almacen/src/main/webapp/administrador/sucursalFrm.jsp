<%-- 
    Document   : sucursalFrm
    Created on : 6 oct. 2023, 10:42:51
    Author     : kevin
--%>

<%@page import="java.util.List"%>
<%@page import="Empresa.Empresa"%>
<%@page import="Sucursal.Sucursal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Sucursal</h1>
        <br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Agregar Sucursal</h6>
            </div>
            <br>
            <%
                int id = (int)request.getSession().getAttribute("idEmpresa");
            %>
            <form action="/sistema_web_almacen/SvSucursal" method="post">
                                            
                <div class="card-body">
                    <div class="form-group">
                        <label for="nombreSucursal">Nombre</label>
                        <input type="text" class="form-control" id="nombreSucursal" name="nombreSucursal" placeholder="Ingrese el nombre de la sucursal" required>
                    </div>
                    <div class="form-group">
                        <label for="direccionSucursal">Direccion</label>
                        <input type="text" class="form-control" id="direccionSucursal" name="direccionSucursal" placeholder="Ingrese la dirección de la sucursal">
                    </div>
                    <div class="form-group">
                        <label for="correoSucursal">Correo</label>
                        <input type="text" class="form-control" id="correoSucursal" name="correoSucursal" placeholder="Ingrese el correo de la sucursal">
                    </div>
                    <div class="form-group">
                        <label for="celularSucursal">Celular</label>
                        <input type="text" class="form-control" id="celularSucursal" name="celularSucursal" placeholder="Ingrese el celular de la sucursal">
                    </div>
                    <div class="form-group" hidden>
                        <label for="idEmpresa">Empresa</label>
                        <input type="text" class="p form-control" id="idEmpresa" name="idEmpresa" value="<%=id%>" required>
                    </div>
                    <button type="submit" class="btn btn-success">Agregar</button>
                    <a href="empresa.jsp" class="btn btn-warning">Cancelar</a>
                </div>
                
            </form>  
        </div>
        <br>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>
