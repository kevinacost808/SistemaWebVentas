<%@page import="java.util.List"%>
<%@page import="Venta.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

  
    
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!--    ----------------------------------------------------------------------------------------------------------------------  -->

                <!-- Begin Page Content -->
                <div class="container-fluid" >

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ventas</h1>
                    <a id="a1" href="ventaFrm.jsp" class="btn btn-primary btn-icon-split" >
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Venta</span>
                      
                    </a>
                    
                    <a id="a2">
                        
                                <button style=" margin-left: auto;display: flex; align-items: center;" type="submit" onclick="generarPDF()" class="btn btn-warning btn-icon-split">
                                    <span class="icon text-white-100">
                                                <i class="fas fa-print"></i>
                                    </span>
                                    <span class="text">Imprimir Reporte</span>
                               </button>     
                              
                    </a>
                    
                  
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4" >
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Ventas</h6>
                        </div>
                        <div class="card-body" id="card-1">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Cliente</th>
                                            <th>Producto</th>
                                            <th>Precio Venta</th>
                                            <th>Comprobante</th>
                                            <th>Pago</th>
                                            
                                            <th class="accion" colspan="2" >Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot class=" tf1">
                                        <tr>
                                            <th>Cliente</th>
                                            <th>Producto</th>
                                            <th>Precio Venta</th>
                                            <th>Comprobante</th>
                                            <th>Pago</th>
                                           
                                            <th class="accion1" colspan="2" >Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                            List<Venta> listaVenta = (List) request.getSession().getAttribute("listaVenta");
                                            if(listaVenta==null){
                                                response.sendRedirect("/sistema_web_almacen/SvVenta");
                                            }else{
                                                for(Venta venta: listaVenta){

                                        %>
                                        <tr>
                                            <td name="cliente"><%=venta.getCliente().getNombre()%> <%=venta.getCliente().getApellido()%></td>
                                            <td name="producto"><%=venta.getProducto().getMarcaProducto()%> <%=venta.getProducto().getNombreProducto()%></td>
                                            <td name="precioVenta"><%=venta.getProducto().getPrecioVenta()%></td>
                                            <td name="comprobante"><%=venta.getComprobante().getTipoComprobante()%></td>
                                            <td name="pago"><%=venta.getPago().getTipoPago()%></td>
                                            
                                            <td class="accion2">
                                                <form name="editar" action="/sistema_web_almacen/SvVentaEditar" method="get">
                                                    <button type="submit" class="btn btn-info btn-circle">
                                                        <i class="fas fa-info-circle"></i>
                                                    </button>     
                                                    <input type="hidden" name="idVenta" value="<%=venta.getIdVenta()%>">
                                                </form>
                                               
                                                 

                                                <form name="eliminarVenta" action="/sistema_web_almacen/SvVentaEliminar" method="post">
                                                    <button type="button" class="btn btn-danger btn-circle" onclick="mostrarModalVenta('<%=venta.getIdVenta()%>')">
                                                        <i class="fas fa-trash"></i>
                                                    </button>
                                                    <input type="hidden" name="idVenta" value="<%=venta.getIdVenta()%>">
                                                </form>

                                                <!-- Modal de confirmación para eliminar venta -->
                                                <div class="modal fade" id="logoutModalVenta_<%=venta.getIdVenta()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Eliminar Venta</h5>
                                                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <p>¿Está seguro de que desea eliminar esta venta? <br>El producto <%=venta.getProducto().getCodigoProducto()%> pasará a estar en estado "ALMACEN"</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                                                <a class="btn btn-primary" href="#" onclick="eliminarVenta('<%=venta.getIdVenta()%>')">Eliminar</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <%
                                                
                                                }}
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            <script>
    function mostrarModalVenta(idVenta) {
        // Muestra el modal correspondiente al botón de eliminar venta
        $('#logoutModalVenta_' + idVenta).modal('show');

        // Si el usuario confirma la eliminación, envía la solicitud al servidor
        $('#logoutModalVenta_' + idVenta + ' .btn-primary').click(function () {
            // Realiza la solicitud de eliminación al servidor usando AJAX
            $.ajax({
                type: 'POST',
                url: '/sistema_web_almacen/SvVentaEliminar',
                data: { idVenta: idVenta },
                success: function (data) {
                    // Puedes realizar acciones adicionales después de la eliminación, si es necesario
                    // Por ejemplo, recargar la página o actualizar la lista de ventas
                    location.reload();
                }
            });
        });
    }
    // Función para eliminar la venta

</script>
<%@include file="componentes/bodyFinal.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.1/html2pdf.bundle.js"></script>

<!-- Script para generar PDF con html2pdf -->
<script>
  function generarPDF() {
    var element = document.getElementById("card-1"); // Obtén el elemento que deseas convertir a PDF

    // Crea un elemento de título y añádelo al inicio del contenido
    var titulo = document.createElement("h1");
    titulo.textContent = "REPORTE DE VENTAS";
    element.prepend(titulo);

    // Cambia el color del texto a negro
    element.style.color = "black";

    // Opciones para html2pdf
    var options = {
        margin:0 , // Márgenes del PDF en píxeles
        filename: 'reporteVentas.pdf', // Nombre del archivo PDF
        image: { type: 'jpeg', quality: 0.98 }, // Tipo y calidad de la imagen (si hay imágenes en la página)
        html2canvas: { scale: 2 }, // Escala para la conversión de HTML a lienzo
        jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' } // Configuración específica de jsPDF
    };

    // Puedes excluir elementos específicos si es necesario
    // Por ejemplo, si deseas excluir un elemento con el id "elementoExcluir"
    var elementoExcluir = document.getElementById("elementoExcluir");
    if (elementoExcluir) {
        element.removeChild(elementoExcluir);
    }

    var botones = element.querySelectorAll("button");

    // Oculta temporalmente los botones
    botones.forEach(function (boton) {
        boton.style.visibility = 'hidden';
    });

    // Oculta las columnas que no quieres en el PDF
    var columnasOcultar2 = document.getElementsByClassName("accion2"); // Reemplaza "claseColumna" con la clase o id de las columnas que quieres ocultar
    var columnasOcultar1 = document.getElementsByClassName("tf1");
     var columnasOcultar = document.getElementsByClassName("accion");
    if (columnasOcultar2) {
        Array.from(columnasOcultar2).forEach(function(columna) {
            columna.style.visibility = 'hidden';
        });
    } if (columnasOcultar1){
        Array.from(columnasOcultar1).forEach(function(columna) {
            columna.style.visibility = 'hidden';
        });
    }if (columnasOcultar){
        Array.from(columnasOcultar).forEach(function(columna) {
            columna.style.visibility = 'hidden';
        });
    }

    // Llama a html2pdf con el elemento y opciones
    html2pdf().from(element).set(options).toPdf().save().then(function() {
        // Restaura la visibilidad de los botones después de generar el PDF
        botones.forEach(function (boton) {
            boton.style.visibility = 'visible';
        });

        // Restaura la visibilidad de las columnas después de generar el PDF
        if (columnasOcultar) {
            Array.from(columnasOcultar).forEach(function(columna) {
                columna.style.visibility = 'visible';
            });
        } if (columnasOcultar1) {
            Array.from(columnasOcultar1).forEach(function(columna) {
                columna.style.visibility = 'visible';
            });
        }if (columnasOcultar2){
             Array.from(columnasOcultar2).forEach(function(columna) {
                columna.style.visibility = 'visible';
            });
        }

        // Elimina el título del contenido original
        element.removeChild(titulo);

        // Restaura el color original del texto
        element.style.color = "";
    });
}
</script>