<%@page import="Empresa.EmpresaC"%>
<%@page import="Empresa.Empresa"%>
<%@page import="Sucursal.Sucursal"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- Begin Page Content -->
    <div class="container-fluid">

        <%
            int id = (int)request.getSession().getAttribute("idEmpresa");
            EmpresaC empresaC = new EmpresaC();
            Empresa empresa = empresaC.consultarEmpresaId(id);
        %>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">EMPRESA: <%=empresa.getNombreEmpresa()%></h1>   
        
        <a href="sucursalFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Agregar sucursal</span>
        </a>
            
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista de sucursales</h6>
            </div>
            <br>
            <div class="card-group m-3">
                <div class="row">
                    <%
                        List<Sucursal> listaSucursal = (List) request.getSession().getAttribute("listaSucursal");
                        if(listaSucursal==null){
                        }else{
                            for(Sucursal sucursal: listaSucursal){
                        
                    %>
                    <div class="col-12 col-ms-8 mb-3">
                        <div class="card">
                            <img src="..." class="card-img-top" alt="...">
                            <div class="card-body">
                              <h5 class="card-title font-weight-bold"><%=sucursal.getNombreSucursal()%></h5>

                              <ul class="list-group list-group-flush">
                                <li class="list-group-item"><%=sucursal.getDireccionSucursal()%></li>
                                <li class="list-group-item"><%=sucursal.getEmpresa().getNombreEmpresa()%></li>
                              </ul>
                            </div>
                            <div class="p-4">
                                <div class="mt-4"> 
                                <form name="editar" action="/sistema_web_almacen/SvSucursalEditar" method="get">
                                    <button type="submit" class="btn btn-outline-secondary">ACTUALIZAR</button>     
                                    <input type="hidden" name="idSucursal" value="<%=sucursal.getIdSucursal()%>">
                                </form>
                                </div>
                                <div class="mt-4"> 
                                <form name="eliminar" action="/sistema_web_almacen/SvSucursalEliminar" method="post">
                                    <button type="submit" class="btn btn-outline-info">HABILITAR</button>     
                                   <input type="hidden" name="idSucursal" value="<%=sucursal.getIdSucursal()%>">
                                </form>
                                </div>
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