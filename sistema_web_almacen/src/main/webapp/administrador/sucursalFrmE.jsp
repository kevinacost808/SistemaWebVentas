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
                <h6 class="m-0 font-weight-bold text-primary">Editar Sucursal</h6>
            </div>
            <br>
            <%
                Sucursal sucursal = (Sucursal)request.getSession().getAttribute("SucursalEditar");
            %>
            <form action="/sistema_web_almacen/SvSucursalEditar" method="post">
                                            
                <div class="card-body">
                    <div class="form-group">
                        <label for="nombreSucursal">Nombre</label>
                        <input type="text" class="form-control" id="nombreSucursal" name="nombreSucursal" value="<%=sucursal.getNombreSucursal()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="direccionSucursal">Direccion</label>
                        <input type="text" class="form-control" id="direccionSucursal" name="direccionSucursal" value="<%=sucursal.getDireccionSucursal()%>">
                    </div>
                    <div class="form-group">
                        <label for="correoSucursal">Correo</label>
                        <input type="text" class="form-control" id="correoSucursal" name="correoSucursal" value="<%=sucursal.getCorreoSucursal()%>">
                    </div>
                    <div class="form-group">
                        <label for="celularSucursal">Celular</label>
                        <input type="text" class="form-control" id="celularSucursal" name="celularSucursal" value="<%=sucursal.getCelularSucursal()%>"> 
                    </div>
                    <div class="form-group" hidden>
                        <label for="idSucursal">Empresa</label>
                        <input type="text" class="p form-control" id="idSucursal" name="idSucursal" value="<%=sucursal.getIdSucursal()%>" required>
                    </div>
                    <button type="submit" class="btn btn-success">Actualizar</button>
                    <a href="sucursal.jsp" class="btn btn-warning">Cancelar</a>
                </div>
                
            </form>  
                    
            <div class="p-4 "> 
                <form name="eliminar" action="/sistema_web_almacen/SvSucursalEliminar" method="post">
                    <button type="submit" class="btn btn-danger">Eliminar</button>     
                   <input type="hidden" name="idSucursal" value="<%=sucursal.getIdSucursal()%>">
                </form>
            </div>

            
            </div>       
        </div>
        <br>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>
