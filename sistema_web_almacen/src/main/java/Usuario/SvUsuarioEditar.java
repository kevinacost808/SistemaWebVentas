package Usuario;

import Rol.Rol;
import Rol.RolC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuarioEditar", urlPatterns = {"/SvUsuarioEditar"})
public class SvUsuarioEditar extends HttpServlet {

    UsuarioC usuarioC = new UsuarioC(); 
    SucursalC sucursalC = new SucursalC();
    RolC rolC = new RolC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        Usuario usuarioEditar = usuarioC.consultarUsuarioId(idUsuario);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarioEditar",usuarioEditar);
        int idRol = (int) sesion.getAttribute("idRol");
        if(idRol==1){
            response.sendRedirect("administrador/usuarioFrmE.jsp");
        }else if(idRol==4){
            response.sendRedirect("gerencia/usuarioFrmE.jsp");
        }else{
            response.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nomb = request.getParameter("nombre");
        String nombre = nomb.toUpperCase();
        
        String pass = request.getParameter("password");
        String password = pass.toUpperCase();
        
        int idRol = Integer.parseInt(request.getParameter("idRol"));
        Rol rol = rolC.consultarRolId(idRol);
        
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombreUsuario(nombre);
        usuario.setPassword(password);
        usuario.setSucursal(sucursal);
        usuario.setRol(rol);
        
        usuarioC.editarUsuario(usuario);
        
        response.sendRedirect("SvUsuario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
