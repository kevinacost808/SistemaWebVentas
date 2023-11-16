package Usuario;

import Rol.Rol;
import Rol.RolC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
    RolC rolC = new RolC();
    UsuarioC usuarioC = new UsuarioC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSucursalStr = request.getParameter("idSucursal");
        int idSucursal =0;
        
        // Verificar si idEmpresaStr no es nulo ni está vacío
        if (idSucursalStr != null && !idSucursalStr.isEmpty()) {
            try {
                // Intentar convertir idEmpresaStr a un entero
                idSucursal = Integer.parseInt(idSucursalStr);
            } catch (NumberFormatException e) {
                // Manejar la excepción si idEmpresaStr no es un número válido
                System.out.println("idEmpresa no es un número válido.");
            }
        }else{
            HttpSession sesion = request.getSession();
            idSucursal = (int) sesion.getAttribute("idSucursal");
        }
        
        List<Usuario> usuario = new ArrayList<Usuario>();
        usuario = usuarioC.consultarUsuario();
        
        List<Usuario> listaUsuario = new ArrayList<>();
        
        if (usuario != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Usuario u : usuario) {    
                Sucursal sucursal = u.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaUsuario.add(u);
                }
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaUsuario", listaUsuario);
        
        int idRol = (int) sesion.getAttribute("idRol");
        if(idRol==1){
            response.sendRedirect("administrador/usuario.jsp");
        }else if(idRol==4){
            response.sendRedirect("gerencia/usuario.jsp");
        }else{
            response.sendRedirect("404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        
        String password = request.getParameter("password");
        
        int idRol = Integer.parseInt(request.getParameter("idRol"));
        Rol rol = rolC.consultarRolId(idRol);
        
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setPassword(password);
        usuario.setSucursal(sucursal);
        usuario.setRol(rol);
        
        usuarioC.agregarUsuario(usuario);
        
        response.sendRedirect("SvUsuario");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
