<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!--    ----------------------------------------------------------------------------------------------------------------------  -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ventas</h1>
                    <a href="formularios/agregar/frmVenta.jsp" class="btn btn-primary btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-flag"></i>
                        </span>
                        <span class="text">Agregar Venta</span>
                    </a>
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Tabla de Ventas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id Venta</th>
                                            <th>Producto</th>
                                            <th>IMEI</th>
                                            <th>Detalle</th>
                                            <th>Precio de Venta</th>
                                            <th>Cliente</th>
                                            <th>Fecha de Venta</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id Venta</th>
                                            <th>Producto</th>
                                            <th>IMEI</th>
                                            <th>Detalle</th>
                                            <th>Precio de Venta</th>
                                            <th>Cliente</th>
                                            <th>Fecha de Venta</th>
                                            <th colspan="2">Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>A23 ULTRA</td>
                                            <td>369321654987</td>
                                            <td>Sin regalo</td>
                                            <td>$520,800</td>
                                            <td>75825936</td>
                                            <td>2011/04/25</td>
                                            <td>
                                                <a href="formularios/editar/frmVentaE.jsp" class="btn btn-info btn-circle">
                                                    <i class="fas fa-info-circle"></i>
                                                </a>

                                                <button class="btn btn-danger btn-circle">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
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