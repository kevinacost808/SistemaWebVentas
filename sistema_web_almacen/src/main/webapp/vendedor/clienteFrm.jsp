<%@page import="Sucursal.Sucursal"%>
<%@page import="Sucursal.SucursalC"%>
<%@page import="java.util.List"%>
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
        
        <div class="card shadow mb-4">
            
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario de Cliente</h6>
            </div>

            <%
                List<String> listaClienteDni = (List)request.getSession().getAttribute("listaClienteDni");
                int idSucursal = (int)request.getSession().getAttribute("idSucursal");
                SucursalC sucursalC = new SucursalC();
                Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
            %>
                
            <form action="/sistema_web_almacen/SvClienteDni" method="post">
                <div class="card-body">
                    <div class="form-group">
                        <label for="dni">DNI</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=listaClienteDni!=null?listaClienteDni.get(0):""%>">
                        <br>
                        <button id="cargarDni" type="submit" class="btn btn-info btn-circle">
                            <i class="fas fa-fw fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            
            <form action="/sistema_web_almacen/SvCliente" method="post">

                <div class="card-body">

                    <div class="form-group" hidden>
                        <label for="dni">Dni</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=listaClienteDni!=null?listaClienteDni.get(0):""%>" readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="<%=listaClienteDni!=null?listaClienteDni.get(1):""%>" readonly>
                    </div>

                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="<%=listaClienteDni!=null?listaClienteDni.get(2):""%>" readonly>
                    </div>

                    <div class="form-group">
                        <label for="celular">Celular</label>
                        <input type="text" class="form-control" id="celular" name="celular" >
                    </div>
                    
                    <div class="form-group">
                        <label for="correo">Correo Electrónico</label>
                        <input type="email" class="form-control" id="correo" name="correo" >
                    </div>
                    
                    <div class="form-group" hidden>
                        <label for="idSucursal">Sucursal</label>
                        <input type="text" class="form-control" id="idSucursal" name="idSucursal" value="<%=sucursal.getIdSucursal()%>" required>
                    </div>

                    <div class="form-group">
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
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="componentes/bodyFinal.jsp" %>