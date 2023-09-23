<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Almacen General</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Almacen General de productos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Marca</th>
                                            <th>Nombre</th>
                                            <th>Proveedor</th>
                                            <th>Cantidad</th>
                                            <th>Fecha Ingreso</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Marca</th>
                                            <th>Nombre</th>
                                            <th>Proveedor</th>
                                            <th>Cantidad</th>
                                            <th>Fecha Ingreso</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>SAMSUNG</td>
                                            <td>A23</td>
                                            <td>Celulandia</td>
                                            <td>20</td>
                                            <td>2023-05-01</td>
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
