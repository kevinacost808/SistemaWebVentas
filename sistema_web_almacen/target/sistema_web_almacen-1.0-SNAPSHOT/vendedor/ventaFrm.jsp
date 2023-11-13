<%@page import="java.util.ArrayList"%>
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
            int idEmpresa = (int)request.getSession().getAttribute("idEmpresa");
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
                                List<Comprobante> listaC = new ArrayList<Comprobante>();
                                List<Comprobante> comprobant = new ArrayList<Comprobante>();
                                listaC=null;
                                if (listaC == null) {
                                    ComprobanteC comprobanteC = new ComprobanteC();
                                    // La lista de proveedores no está en la sesión, obténla de la base de datos
                                    comprobant = comprobanteC.consultarComprobante();
                                    for(Comprobante c: comprobant){
                                        if(c.getEmpresa().getIdEmpresa() == idEmpresa){%>
                                            <option value="<%=c.getIdComprobante()%>"><%=c.getTipoComprobante()%></option>
                                        <%}
                                    }
                                }
                            %>
                                
                        </select>
                    </div>
                        
                    <div class="form-group">
                        <label for="idPago">Tipo Pago</label>
                        <select class="form-control" id="idPago" name="idPago">
                            <%
                                List<Pago> listaP = new ArrayList<Pago>();
                                List<Pago> pag = new ArrayList<Pago>();
                                listaP=null;
                                if (listaP == null) {
                                    PagoC pagoC = new PagoC();
                                    // La lista de proveedores no está en la sesión, obténla de la base de datos
                                    pag = pagoC.consultarPago();
                                    for(Pago p: pag){
                                        if(p.getEmpresa().getIdEmpresa()==idEmpresa){%>
                                            <option value="<%=p.getIdPago()%>"><%=p.getTipoPago()%></option>
                                        <%}
                                    }
                                }
                            %>

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