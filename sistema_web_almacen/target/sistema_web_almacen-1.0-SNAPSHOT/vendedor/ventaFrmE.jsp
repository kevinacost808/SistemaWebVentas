<%@page import="Venta.Venta"%>
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
    <h1 class="h3 mb-2 text-gray-800">Editar Venta</h1>
    <br>

    <div class="card shadow mb-4">
        
        <%
            Venta venta = (Venta)request.getSession().getAttribute("ventaEditar");
            int idSucursal = (int)request.getSession().getAttribute("idSucursal");
            int idEmpresa = (int)request.getSession().getAttribute("idEmpresa");
        %>

        <form id="formCliente" action="/sistema_web_almacen/SvClienteBuscar" method="post">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario Cliente</h6>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" value="<%=venta.getCliente().getDni()%>" readonly>
                    <br>
                    <button id="cargarDni" type="submit" class="btn btn-info btn-circle">
                        <i class="fas fa-fw fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
                    
        <form id="formProducto" action="/sistema_web_almacen/SvProductoBuscar" method="post">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Formulario Producto</h6>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="codigoProducto">Codigo</label>
                    <input type="text" class="form-control" id="codigoProducto" name="codigoProducto" value="<%=venta.getProducto().getCodigoProducto()%>" readonly>
                    <br>
                    <button id="cargarCodigo" type="submit" class="btn btn-info btn-circle">
                        <i class="fas fa-fw fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

          <form id="formVenta" action="/sistema_web_almacen/SvVentaEditar" method="post">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Formulario de Venta</h6>
                </div>
                <div class="card-body" id="card-red">
                    <div class="form-group" hidden>
                        <label for="idVenta">Id Venta</label>
                        <input type="text" class="form-control" id="idVenta" name="idVenta" value="<%=venta.getIdVenta()%>" required readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="dni">Nombre Cliente</label>
                        <input type="text" class="form-control" id="dni" name="dni" value="<%=venta.getCliente().getNombre()%> <%=venta.getCliente().getApellido()%>" required readonly>
                    </div>
                    <hr>
                    
                    <div class="form-group">
                        <label for="marcaProducto">Marca Producto</label>
                        <input type="text" class="form-control" id="marcaProducto" name="marcaProducto" value="<%=venta.getProducto().getMarcaProducto()%>" required readonly>
                    </div>

                    <div class="form-group">
                        <label for="nombreProducto">Nombre Producto</label>
                        <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="<%=venta.getProducto().getNombreProducto()%>" required readonly>
                    </div>

                    

                    <div class="form-group">
                        <label for="precioVenta">Precio de Venta</label>
                        <input type="text" class="form-control" id="precioVenta" name="precioVenta" value="<%=venta.getProducto().getPrecioVenta()%>" required>
                    </div>
                    
                    <%
                        Boolean estado = venta.getProducto().isVendido();
                        String estadoo = null;
                        if (estado != null && estado == false) {
                            estadoo = "EN ALMACEN";
                        } else {
                            estadoo = "VENDIDO";
                        }
                    %>
                    
                    <div class="form-group" id="estadoprod">
                        <label for="estado">Estado Producto</label>
                        <input type="text" class="form-control" id="estado" name="estado" value="<%=estadoo%>" required readonly>
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
                                            <option value="<%=venta.getComprobante().getIdComprobante()%>"><%=c.getTipoComprobante()%></option>
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

                    <div class="form-group" >
                        <button type="reset" class="btn btn-warning btn-icon-split">
                            <span class="icon text-white-50">
                                <i class="fas fa-exclamation-triangle"></i>
                            </span>
                            <span class="text">Limpiar</span>
                        </button>

                        <button onclick="generarPDF()"  type="submit" class="btn btn-success btn-icon-split" >
                            <span class="icon text-white-50">
                                <i class="fas fa-check"></i>
                            </span>
                            <span  class="text">GUARDAR</span>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.1/html2pdf.bundle.js"></script>

<!-- Script para generar PDF con html2pdf -->
<script>
    function generarPDF() {
    var element = document.getElementById("card-red"); // Obtén el elemento que deseas convertir a PDF

    // Crea un elemento de título y añádelo al inicio del contenido
    var titulo = document.createElement("h1");
    titulo.textContent = "COMPROBANTE";
    element.prepend(titulo);
    
    // Cambia el color del texto a negro
    element.style.color = "black";
    // Opciones para html2pdf
    var options = {
        margin: 10, // Márgenes del PDF en píxeles
        filename: 'comprobante.pdf', // Nombre del archivo PDF
        image: { type: 'jpeg', quality: 0.98 }, // Tipo y calidad de la imagen (si hay imágenes en la página)
        html2canvas: { scale: 2 }, // Escala para la conversión de HTML a lienzo
        jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' } // Configuración específica de jsPDF
    };
    
    var filaOcultar = document.getElementById("estadoprod");
       
        if (filaOcultar) {
            filaOcultar.style.visibility = 'hidden';
        }
   

    var botones = element.querySelectorAll("button");

    // Oculta temporalmente los botones
    botones.forEach(function (boton) {
        boton.style.visibility = 'hidden';
    });

    // Llama a html2pdf con el elemento y opciones
    html2pdf().from(element).set(options).toPdf().save().then(function() {
        // Restaura la visibilidad de los botones después de generar el PDF
        botones.forEach(function (boton) {
            boton.style.visibility = 'visible';
        });
        
         if (filaOcultar) {
                filaOcultar.style.visibility = 'visible';
            }
    });
    
}
</script>