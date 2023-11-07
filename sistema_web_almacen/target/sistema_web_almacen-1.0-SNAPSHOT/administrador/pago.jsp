<%@page import="Pago.Pago"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Tipo de Pago</h1>
                    <a href="pagoFrm.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Pago</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tipos de pagos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tipo de pago</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Tipo de pago</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%
                                        List<Pago> listaPago = (List)request.getSession().getAttribute("listaPago");
                                        if(listaPago==null){
                                                response.sendRedirect("/sistema_web_almacen/SvPago");
                                            }else{
                                                for(Pago pago: listaPago){
                                        %>
                                        <tr>
                                            <td name="tipoPago"><%=pago.getTipoPago()%></td>
                                            <td>
                                                    <form name="editar" action="/sistema_web_almacen/SvPagoEditar" method="get">
                                                        <button type="submit" class="btn btn-info btn-circle">
                                                            <i class="fas fa-info-circle"></i>
                                                        </button>     
                                                        <input type="hidden" name="idPago" value="<%=pago.getIdPago()%>">
                                                    </form>

                                                    <form name="eliminar" action="/sistema_web_almacen/SvPagoEliminar" method="post">
                                                        <button type="submit" class="btn btn-danger btn-circle">
                                                            <i class="fas fa-trash"></i>
                                                        </button>     
                                                        <input type="hidden" name="idPago" value="<%=pago.getIdPago()%>">
                                                    </form>
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
<%@include file="componentes/bodyFinal.jsp" %>