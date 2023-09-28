<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>
<!--    ----------------------------------------------------------------------------------------------------------------------  -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Agregar Cliente</h1>
                    <br>
                    <form>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Cliente</h6>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="dni">DNI</label>
                                    <input type="text" class="form-control" id="dni" name="dni" >
                                    <br>
                                    <button class="btn btn-info btn-circle">
                                        <i class="fas fa-fw fa-search"></i>
                                    </button>
                                </div>
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre">
                                </div>
                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" class="form-control" id="apellido" name="apellido" >
                                </div>
                                <div class="form-group">
                                    <label for="fechaNacimiento">Fecha de Nacimiento</label>
                                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" >
                                </div>
                                <div class="form-group">
                                    <div class="form-group">
                                        <button type="reset" class="btn btn-warning btn-icon-split">
                                            <span class="icon text-white-50">
                                                <i class="fas fa-exclamation-triangle"></i>
                                            </span>
                                            <span class="text">Limpiar</span>
                                        </button>
    
                                        <a href="#" class="btn btn-success btn-icon-split">
                                            <span class="icon text-white-50">
                                                <i class="fas fa-check"></i>
                                            </span>
                                            <span class="text">GUARDAR</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>