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
                <div class="row">
                    <div class="col-12 col-ms-8 mb-3">
                        <table class="table table-hover ">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre Usuario</th>
                                    <th scope="col">Password</th>
                                    <th scope="col">Rol</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                List<Usuario> listaUsuario = (List) request.getSession().getAttribute("listaUsuario");
                                if(listaUsuario==null){
                                    response.sendRedirect("/sistema_web_almacen/SvUsuario");
                                }else{
                                    for(Usuario usuario: listaUsuario){
                            %>
                                <tr>
                                   <td><%=usuario.getNombreUsuario()%></td>
                                   <td><%=usuario.getPassword()%></td>
                                   <td><%=usuario.getRol().getNombreRol()%></td>
                                   <td>
                                       <form name="editar" action="/sistema_web_almacen/SvUsuarioEditar" method="get">
                                            <button type="submit" class="btn btn-info">ACTUALIZAR</button>     
                                            <input type="hidden" name="idUsuario" value="<%=usuario.getIdUsuario()%>">
                                        </form>
                                   </td>
                                   <td>
                                       <form name="editar" action="/sistema_web_almacen/SvUsuarioEliminar" method="post">
                                            <button type="submit" class="btn btn-danger">Eliminar</button>     
                                            <input type="hidden" name="idUsuario" value="<%=usuario.getIdUsuario()%>">
                                        </form>
                                   </td>
                                </tr>
                            <%  }}%>
                            </tbody>
                        </table>
                </div>
            <br>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->



<%@include file="componentes/bodyFinal.jsp" %>

