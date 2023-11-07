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
                    <h1 class="h3 mb-2 text-gray-800">Agregar Producto</h1>
                    <br>
                    
                    <%
                        int idSucursal = (int)request.getSession().getAttribute("idSucursal");
                    %>
                    
                    <form action="/sistema_web_almacen/SvProducto" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Producto</h6>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="codigoProducto">Codigo del Producto</label>
                                    <input type="text" class="form-control" id="codigoProducto" name="codigoProducto" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="marcaProducto">Marca</label>
                                    <input type="text" class="form-control" id="marcaProducto" name="marcaProducto" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="nombreProducto">Nombre</label>
                                    <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="idCategoria">Categoria</label>
                                    <select class="form-control" id="idCategoria" name="idCategoria">
                                        <%
                                            List<Categoria> listaCategoria = (List<Categoria>)request.getSession().getAttribute("listaCategoria");
                                            if (listaCategoria == null) {
                                                CategoriaC categoriaC = new CategoriaC();
                                                // La lista de proveedores no está en la sesión, obténla de la base de datos
                                                listaCategoria = categoriaC.consultarCategoria();
                                                // Al obtenerla, guárdala en la sesión para futuros accesos
                                                request.getSession().setAttribute("listaCategoria", listaCategoria);
                                            }
                                            for(Categoria categoria : listaCategoria ){
                                        %>
                                            <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNombreCategoria()%></option>
                                        <%  }%>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <label for="precioCompra">Precio de Compra</label>
                                    <input type="number" class="form-control" id="precioCompra" name="precioCompra" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="precioVenta">Precio de Venta</label>
                                    <input type="number" class="form-control" id="precioVenta" name="precioVenta" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="fechaIngreso">Fecha de Ingreso</label>
                                    <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso" required>
                                </div>
                                
                                <div class="form-group" hidden>
                                    <label for="idSucursal">Sucursal</label>
                                    <input type="text" class="form-control" id="idSucursal" name="idSucursal" value="<%=idSucursal%>" required>
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
<%@include file="componentes/bodyFinal.jsp" %>