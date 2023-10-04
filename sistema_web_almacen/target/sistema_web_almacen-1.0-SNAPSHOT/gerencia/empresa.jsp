<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Empresas</h1>
        <a href="empresaFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Agregar empresa</span>
        </a>
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Empresa</h6>
            </div>
            <br>
            <div class="card-group m-3">
                
                <div class="row">
                    
                    <div class="col-sm-6 mb-3 mb-sm-0">
                      <div class="card">
                          <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">EMPRESA N</h5>
                          <p class="card-text">Ubi</p>
                          
                          <ul class="list-group list-group-flush">
                            <li class="list-group-item">Correo</li>
                            <li class="list-group-item">Celular</li>
                            <li class="list-group-item">A third item</li>
                          </ul>
                          <a href="#" class="btn btn-primary">CONFIGURACIÓN</a>
                          <a href="#" class="btn btn-warning">HABILITAR</a>
                        </div>
                          <div class="card-footer">
                            <small class="text-body-secondary">Last updated 3 mins ago</small>
                          </div>
                      </div>
                    </div> 
                    
                    <div class="col-sm-6 mb-3 mb-sm-0" >
                      <div class="card">
                          <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">EMPRESA N</h5>
                          <p class="card-text">Ubi</p>
                          
                          <ul class="list-group list-group-flush">
                            <li class="list-group-item">Correo</li>
                            <li class="list-group-item">Celular</li>
                            <li class="list-group-item">A third item</li>
                          </ul>
                          <a href="#" class="btn btn-primary">CONFIGURACIÓN</a>
                          <a href="#" class="btn btn-warning">HABILITAR</a>
                        </div>
                          <div class="card-footer">
                            <small class="text-body-secondary">Last updated 3 mins ago</small>
                          </div>
                      </div>
                    </div>
                    
                    
                </div>
            </div>
            <br>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->



<%@include file="componentes/bodyFinal.jsp" %>

