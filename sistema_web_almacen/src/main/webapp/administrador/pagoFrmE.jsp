
<%@page import="Pago.Pago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>
<!-- -------------------------------------------------------------------------------------------------------------------------- -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Editar Categoria</h1>
                    <br>
                    <% Pago pagoEditar = (Pago)request.getSession().getAttribute("pagoEditar");%>
                    <form action="/sistema_web_almacen/SvPagoEditar" method="post">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Formulario de Pago</h6>
                            </div>
                            <div class="card-body">
                                <div class="form-group" hidden>
                                    <label for="idPago">ID</label>
                                    <input type="text" class="form-control" id="idPago" name="idPago" value="<%=pagoEditar.getIdPago()%>" required>
                                </div>

                                <div class="form-group">
                                    <label for="tipoPago">Tipo Pago</label>
                                    <input type="text" class="form-control" id="tipoPago" name="tipoPago" value="<%=pagoEditar.getTipoPago()%>" required>
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