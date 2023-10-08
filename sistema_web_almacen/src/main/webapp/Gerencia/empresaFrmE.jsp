<%@page import="Empresa.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Empresas</h1>
        <br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Editar Empresa</h6>
            </div>
            <br>
            
            <%
                Empresa empresa = (Empresa)request.getSession().getAttribute("EmpresaEditar");
            %>
                    
            <form action="/sistema_web_almacen/SvEmpresaEditar" method="post">

                <div class="card-body">
                    <div class="form-group" hidden>
                        <label for="idEmpresa">ID</label>
                        <input type="text" class="form-control" id="idEmpresa" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="nombreEmpresa">Nombre</label>
                        <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa" placeholder="Ingrese el nombre de la empresa" value="<%=empresa.getNombreEmpresa()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="rucEmpresa">RUC</label>
                        <input type="text" class="form-control" id="rucEmpresa" name="rucEmpresa" placeholder="Ingrese el RUC de la empresa" value="<%=empresa.getRucEmpresa()%>">
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="p form-control" id="correo" name="correo" placeholder="Ingrese el correo" value="<%=empresa.getCorreo()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="celular">Celular</label>
                        <input type="text" class="p form-control" id="celular" name="celular" placeholder="Ingrese el celular" value="<%=empresa.getCelular()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaInicio">Fecha de Inicio</label>
                        <input type="date" class="p form-control" id="fechaInicio" name="fechaInicio" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaFin">Fecha de Fin</label>
                        <input type="date" class="p form-control" id="fechaFin" name="fechaFin" required>
                    </div>
                    <button type="submit" class="btn btn-primary">ACTUALIZAR</button>
                    <a href="empresa.jsp" class="btn btn-warning">CANCELAR</a>
                    
                </div>
                
            </form>  
                    
            <div class="p-4 "> 
                <form name="eliminar" action="/sistema_web_almacen/SvEmpresaEliminar" method="post">
                    <button type="submit" class="btn btn-danger">Eliminar</button>     
                   <input type="hidden" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>">
                </form>
            </div>
        </div>
        <br>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>
