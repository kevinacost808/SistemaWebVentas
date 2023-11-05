<%@page import="PedidoProveedor.PedidoProveedor"%>
<%@page import="Proveedor.ProveedorC"%>
<%@page import="Proveedor.Proveedor"%>
<%@page import="java.util.List"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Editar Pedido Proveedor</h1>
                    <br>
                    <%
                        PedidoProveedor pedidoProveedor = (PedidoProveedor)request.getSession().getAttribute("PedidoProveedorEditar");
                        int idEmpresa = (int)request.getSession().getAttribute("idEmpresa");
                    %>
                    <form action="/sistema_web_almacen/SvPedidoProveedorEditar" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Pedido</h6>
                            </div>
                            <div class="card-body">
                                
                                <div class="form-group" hidden>
                                    <label for="idPedidoProveedor">ID Pedido</label>
                                    <input type="text" class="form-control" id="idPedidoProveedor" name="idPedidoProveedor" value="<%=pedidoProveedor.getIdPedidoProveedor()%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="nombre">Nombre del producto</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%=pedidoProveedor.getNombre()%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="cantidad">Cantidad</label>
                                    <input type="text" class="form-control" id="cantidad" name="cantidad" value="<%=pedidoProveedor.getCantidad()%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="precioUnidad">Precio Unidad</label>
                                    <input type="text" class="form-control" id="precioUnidad" name="precioUnidad" value="<%=pedidoProveedor.getPrecioUnidad()%>" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="fechaPedido">Fecha de Pedido</label>
                                    <input type="date" class="form-control" id="fechaPedido" name="fechaPedido" required>
                                </div>

                                <div class="form-group">
                                    <label for="idProveedor">Proveedor</label>
                                    <select class="form-control" id="idProveedor" name="idProveedor" >
                                        <%
                                            List<Proveedor> listaProveedores = (List<Proveedor>)request.getSession().getAttribute("listaProveedores");
                                            if (listaProveedores == null) {
                                                ProveedorC proveedorC = new ProveedorC();
                                                // La lista de proveedores no está en la sesión, obténla de la base de datos
                                                listaProveedores = proveedorC.consultarProveedor();
                                                // Al obtenerla, guárdala en la sesión para futuros accesos
                                                request.getSession().setAttribute("listaProveedores", listaProveedores);
                                            }
                                            for(Proveedor proveedor : listaProveedores ){
                                                boolean seleccionado = (pedidoProveedor.getProveedor() != null && pedidoProveedor.getProveedor().getIdProveedor() == proveedor.getIdProveedor());
                                        %>
                                            <option value="<%=proveedor.getIdProveedor()%>" <%= seleccionado ? "selected" : "" %>><%=proveedor.getNombreProveedor()%></option>
                                        <%  }%>
                                    </select>
                                </div>
                                
                                <div class="form-group" hidden>
                                    <label for="idEmpresa">Empresa</label>
                                    <input type="text" class="form-control" id="idEmpresa" name="idEmpresa" value="<%=idEmpresa%>" required>
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