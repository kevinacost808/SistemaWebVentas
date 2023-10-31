<%@page import="Usuario.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Sucursal.Sucursal"%>
<%@page import="Sucursal.SucursalC"%>
<%@page import="Empresa.Empresa"%>
<%@page import="Empresa.EmpresaC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="componentes/header.jsp" %>
<%@include file="componentes/bodyInicial.jsp" %>

<!-- Begin Page Content -->
    <div class="container-fluid">

        <%
            int idEmpresa = (int)request.getSession().getAttribute("idEmpresa");
            EmpresaC empresaC = new EmpresaC();
            Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
            
            int idSucursal = (int)request.getSession().getAttribute("idSucursal");
            SucursalC sucursalC = new SucursalC();
            Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        %>
        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">EMPRESA: <%=empresa.getNombreEmpresa()%> - SUCURSAL: <%=sucursal.getNombreSucursal()%></h1>   
        
        <a href="usuarioFrm.jsp" class="btn btn-primary btn-icon-split">
            <span class="icon text-white-50">
                <i class="fas fa-flag"></i>
            </span>
            <span class="text">Agregar Usuario</span>
        </a>
            
        <br><br>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista de Usuarios</h6>
            </div>
            <br>
            <div class="card-group m-3">
                <div class="row">
                    <%
                        List<Usuario> listaUsuario = (List) request.getSession().getAttribute("listaUsuario");
                        if(listaUsuario==null){
                        }else{
                            for(Usuario usuario: listaUsuario){
                        
                    %>
                    <div class="col-12 col-ms-8 mb-3">
                        <div class="card">
                            <div class="card-body">
                              <h5 class="card-title font-weight-bold"><%=usuario.getNombreUsuario()%></h5>

                              <ul class="list-group list-group-flush">
                                <li class="list-group-item"> Password: <%=usuario.getPassword()%></li>
                              </ul>
                              
                              <ul class="list-group list-group-flush">
                                <li class="list-group-item"> Rol: <%=usuario.getRol()%></li>
                              </ul>
                            </div>
                            <div class="p-4">
                                <div class="mt-2"> 
                                <form name="editar" action="/sistema_web_almacen/SvSucursalEditar" method="get">
                                    <button type="submit" class="btn btn-outline-info">USUARIOS</button>     
                                    <input type="hidden" name="idSucursal" value="<%=usuario.getIdUsuario()%>">
                                </form>
                                </div>
                                <div class="mt-4"> 
                                <form name="editar" action="/sistema_web_almacen/SvSucursalEditar" method="get">
                                    <button type="submit" class="btn btn-outline-warning">ACTUALIZAR</button>     
                                    <input type="hidden" name="idSucursal" value="<%=usuario.getIdUsuario()%>">
                                </form>
                                </div>
                                <div class="mt-4"> 
                                <form name="eliminar" action="/sistema_web_almacen/SvSucursalEliminar" method="post">
                                    <button type="submit" class="btn btn-outline-danger">HABILITAR</button>     
                                   <input type="hidden" name="idEmpresa" value="<%=usuario.getIdUsuario()%>">
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

