<%@page import="Categoria.CategoriaC"%>
<%@page import="Categoria.Categoria"%>
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
    <h1 class="h3 mb-2 text-gray-800">Agregar Venta</h1>
    <br>

    <div class="card shadow mb-4">
        
        <%
            List<String> clienteBuscarDni = (List)request.getSession().getAttribute("clienteBuscarDni");
            List<String> clienteBuscar = (List)request.getSession().getAttribute("clienteBuscar");
            
            List<String> listaProductoBuscar = (List)request.getSession().getAttribute("listaProductoBuscar");
            int idSucursal = (int)request.getSession().getAttribute("idSucursal");
        %>

        <form action="/sistema_web_almacen/SvClienteBuscar" method="post">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario Cliente</h6>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" value="<%=clienteBuscarDni!=null?clienteBuscarDni:""%>">
                    <br>
                    <button id="cargarDni" type="submit" class="btn btn-info btn-circle">
                        <i class="fas fa-fw fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
                    
        <form action="/sistema_web_almacen/SvProductoBuscar" method="post">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario Producto</h6>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="codigoProducto">Codigo</label>
                    <input type="text" class="form-control" id="codigoProducto" name="codigoProducto" value="<%=listaProductoBuscar!=null?listaProductoBuscar.get(0):""%>">
                    <br>
                    <button id="cargarCodigo" type="submit" class="btn btn-info btn-circle">
                        <i class="fas fa-fw fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <form action="/sistema_web_almacen/SvVenta" method="post">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Formulario de Venta</h6>
                </div>
                <div class="card-body">
                    
                    <div class="form-group" hidden>
                        <label for="dni">Dni</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=clienteBuscarDni!=null?clienteBuscarDni:""%>" required readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="dni">Nombre Cliente</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=clienteBuscar!=null?clienteBuscar:""%>" required readonly>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label for="marcaProducto">Marca</label>
                        <input type="text" class="form-control" id="marcaProducto" name="marcaProducto" value="<%=listaProductoBuscar!=null?listaProductoBuscar.get(1):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="nombreProducto">Nombre</label>
                        <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="<%=listaProductoBuscar!=null?listaProductoBuscar.get(2):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="precioCompra">Precio de Compra</label>
                        <input type="text" class="form-control" id="precioCompra" name="precioCompra" value="<%=listaProductoBuscar!=null?listaProductoBuscar.get(4):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="precioVenta">Precio de Venta</label>
                        <input type="text" class="form-control" id="precioVenta" name="precioVenta" value="<%=listaProductoBuscar!=null?listaProductoBuscar.get(5):""%>" required>
                    </div>

                    <div class="form-group" hidden>
                        <label for="idSucursal">Sucursal</label>
                        <input type="text" class="form-control" id="idSucursal" name="idSucursal" value="<%=idSucursal%>" required readonly>
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
</div>
                <!-- /.container-fluid -->

</div>
            <!-- End of Main Content -->
<%@include file="componentes/bodyFinal.jsp" %>