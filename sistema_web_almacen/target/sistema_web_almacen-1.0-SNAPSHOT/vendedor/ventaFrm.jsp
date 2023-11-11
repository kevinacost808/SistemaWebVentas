<%@page import="Pago.PagoC"%>
<%@page import="Pago.Pago"%>
<%@page import="Comprobante.ComprobanteC"%>
<%@page import="Comprobante.Comprobante"%>
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
            request.getSession().getAttribute("idSucursal");
        %>

        <form action="/sistema_web_almacen/SvClienteBuscar" method="post">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario Cliente</h6>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" value="<%=request.getSession().getAttribute("clienteBuscarDni")!=null?request.getSession().getAttribute("clienteBuscarDni"):""%>">
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
                    <input type="text" class="form-control" id="codigoProducto" name="codigoProducto" value="<%=request.getSession().getAttribute("codigoProducto")!=null?request.getSession().getAttribute("codigoProducto"):""%>">
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
                    
                    <div class="form-group">
                        <label for="dni">Nombre Cliente</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=request.getSession().getAttribute("clienteBuscar")!=null?request.getSession().getAttribute("clienteBuscar"):""%>" required readonly>
                    </div>
                    <hr>
                    
                    <div class="form-group">
                        <label for="marcaProducto">Marca Producto</label>
                        <input type="text" class="form-control" id="marcaProducto" name="marcaProducto" value="<%=request.getSession().getAttribute("marcaProducto")!=null?request.getSession().getAttribute("marcaProducto"):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="nombreProducto">Nombre Producto</label>
                        <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="<%=request.getSession().getAttribute("nombreProducto")!=null?request.getSession().getAttribute("nombreProducto"):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="precioCompra">Precio de Compra</label>
                        <input type="text" class="form-control" id="precioCompra" name="precioCompra" value="<%=request.getSession().getAttribute("precioCompra")!=null?request.getSession().getAttribute("precioCompra"):""%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="precioVenta">Precio de Venta</label>
                        <input type="text" class="form-control" id="precioVenta" name="precioVenta" value="<%=request.getSession().getAttribute("precioVenta")!=null?request.getSession().getAttribute("precioVenta"):""%>" required>
                    </div>
                    
                    <%
                        Boolean estado = (Boolean) request.getSession().getAttribute("estado");
                        String estadoo = null;
                        if (estado != null && estado == false) {
                            estadoo = "EN ALMACEN";
                        } else {
                            estadoo = "VENDIDO";
                        }
                    %>
                    
                    <div class="form-group">
                        <label for="estado">Estado Producto</label>
                        <input type="text" class="form-control" id="estado" name="estado" value="<%=estadoo!=null?estadoo:""%>" required readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="idComprobante">Tipo Comprobante</label>
                        <select class="form-control" id="idComprobante" name="idComprobante">
                            <%
                                List<Comprobante> listaComprobante = (List<Comprobante>)request.getSession().getAttribute("listaComprobante");
                                if (listaComprobante == null) {
                                    ComprobanteC comprobanteC = new ComprobanteC();
                                    // La lista de proveedores no está en la sesión, obténla de la base de datos
                                    listaComprobante = comprobanteC.consultarComprobante();
                                    // Al obtenerla, guárdala en la sesión para futuros accesos
                                    request.getSession().setAttribute("listaComprobante", listaComprobante);
                                }
                                for(Comprobante comprobante : listaComprobante ){
                            %>
                                <option value="<%=comprobante.getIdComprobante()%>"><%=comprobante.getTipoComprobante()%></option>
                            <%  }%>
                        </select>
                    </div>
                        
                    <div class="form-group">
                        <label for="idComprobante">Tipo Pago</label>
                        <select class="form-control" id="idComprobante" name="idComprobante">
                            <%
                                List<Pago> listaPago = (List<Pago>)request.getSession().getAttribute("listaPago");
                                if (listaPago == null) {
                                    PagoC pagoC = new PagoC();
                                    // La lista de proveedores no está en la sesión, obténla de la base de datos
                                    listaPago = pagoC.consultarPago();
                                    // Al obtenerla, guárdala en la sesión para futuros accesos
                                    request.getSession().setAttribute("listaPago", listaPago);
                                }
                                for(Pago pago : listaPago ){
                            %>
                                <option value="<%=pago.getIdPago()%>"><%=pago.getTipoPago()%></option>
                            <%  }%>
                        </select>
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