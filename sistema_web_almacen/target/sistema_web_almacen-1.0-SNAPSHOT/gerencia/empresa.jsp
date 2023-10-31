<%@page import="Empresa.Empresa"%>
<%@page import="java.util.List"%>
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
                <h6 class="m-0 font-weight-bold text-primary">Lista de empresas registradas</h6>
            </div>
            <br>
            <div class="card-group m-3">
                <div class="row">
                    <%
                        List<Empresa> listaEmpresa = (List) request.getSession().getAttribute("listaEmpresa");
                        if(listaEmpresa==null){
                            response.sendRedirect("/sistema_web_almacen/SvEmpresa");
                        }else{
                            for(Empresa empresa: listaEmpresa){
                        
                    %>
                    <div class="col-12 col-ms-8 mb-3">
                        <div class="card">
                            <div class="card-body">
                              <h5 class="card-title font-weight-bold"><%=empresa.getNombreEmpresa()%></h5>

                              <ul class="list-group list-group-flush">
                                <li class="list-group-item">RUC: <%=empresa.getRucEmpresa()%></li>
                                <li class="list-group-item">Correo: <%=empresa.getCorreo()%></li>
                                <li class="list-group-item">Celular: <%=empresa.getCelular()%></li>
                                <li class="list-group-item">Inicio: <%=empresa.getFechaInicio()%></li>
                                <li class="list-group-item">Fin: <%=empresa.getFechaFin()%></li>
                              </ul>
                            </div>
                            <div class="p-4">  
                                <div> 
                                <form name="sucursales" action="/sistema_web_almacen/SvEmpresaSucursal" method="post">
                                    <button type="submit" class="btn btn-outline-info">SUCURSALES</button>     
                                    <input type="hidden" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>">
                                </form>
                                </div>
                                
                                <div class="mt-4"> 
                                <form name="editar" action="/sistema_web_almacen/SvEmpresaEditar" method="get">
                                    <button type="submit" class="btn btn-outline-warning">CONFIGURACIÓN</button>     
                                    <input type="hidden" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>">
                                </form>
                                </div>
                                
                                <div class="mt-4"> 
                                <form name="habilitar" action="/sistema_web_almacen/aaaaa" method="post">
                                    <button type="submit" class="btn btn-outline-danger">HABILITAR</button>     
                                   <input type="hidden" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>">
                                </form>
                                </div>
                            </div> 
                                
                            <div class="card-footer my-4">
                              <small class="text-body-secondary">Last updated 3 mins ago</small>
                            </div>
                            
                        </div>
                    </div> 
                    <%  }}%>
                </div>
            </div>
            <br>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->



<%@include file="componentes/bodyFinal.jsp" %>

