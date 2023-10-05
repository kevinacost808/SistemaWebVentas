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
            
            <form action="action">

                <div class="card-body">
                    <div class="form-group" hidden>
                        <label for="idEmpresa">ID</label>
                        <input type="text" class="form-control" id="idEmpresa" name="idEmpresa" required>
                    </div>
                    <div class="form-group">
                        <label for="nombreEmpresa">Nombre</label>
                        <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa" placeholder="Ingrese el nombre de la empresa" required>
                    </div>
                    <div class="form-group">
                        <label for="rucEmpresa">RUC</label>
                        <input type="text" class="form-control" id="rucEmpresa" name="rucEmpresa" placeholder="Ingrese el RUC de la empresa">
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="p form-control" id="correo" name="correo" placeholder="Ingrese el correo" required>
                    </div>
                    <div class="form-group">
                        <label for="celular">Celular</label>
                        <input type="text" class="p form-control" id="celular" name="celular" placeholder="Ingrese el celular" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaInicio">Fecha de Inicio</label>
                        <input type="date" class="p form-control" id="fechaInicio" name="fechaInicio" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaFin">Fecha de Fin</label>
                        <input type="date" class="p form-control" id="fechaFin" name="fechaFin" required>
                    </div>
                    <button type="submit" class="btn btn-primary">MODIFICAR</button>
                    <a href="empresa.jsp" class="btn btn-danger">DESABILITAR</a>
                </div>
                
            </form>  
        </div>
        <br>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>
