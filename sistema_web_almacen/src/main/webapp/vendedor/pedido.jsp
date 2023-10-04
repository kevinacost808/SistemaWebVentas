<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>
<!--    ----------------------------------------------------------------------------------------------------------------------  -->

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Pedido</h1>
        <a href="formularios/agregar/frmPedido.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Solicitar Pedido</span>
        </a>
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Tabla de Pedidos</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nombre del producto</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nombre del producto</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <tr>
                                <td>SAMSUNG A23</td>
                                <td>
                                    <a href="formularios/editar/frmPedidoE.jsp" class="btn btn-info btn-circle">
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