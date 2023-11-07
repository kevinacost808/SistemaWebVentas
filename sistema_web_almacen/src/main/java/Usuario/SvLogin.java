package Usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    UsuarioC usuarioC = new UsuarioC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        List<Usuario> usu = usuarioC.consultarUsuario();
        boolean usuarioValido = false; // Indicador de usuario válido

        for (Usuario usuari : usu) {
            if (usuario.equals(usuari.getNombreUsuario()) && password.equals(usuari.getPassword())) {
                String rol = usuari.getRol().getNombreRol();
                int idSucursal = usuari.getSucursal().getIdSucursal();
                int idEmpresa = usuari.getSucursal().getEmpresa().getIdEmpresa();
                String nombreUsuario = usuari.getNombreUsuario();
                HttpSession sesion = request.getSession();
                sesion.setAttribute("idSucursal", idSucursal);
                sesion.setAttribute("idEmpresa", idEmpresa);
                sesion.setAttribute("nombreUsuario", nombreUsuario);
                switch (rol) {
                    case "ADMINISTRADOR":
                        response.sendRedirect("administrador/index.jsp");
                        usuarioValido = true; // Usuario válido encontrado
                        break;
                    case "ALMACEN":
                        response.sendRedirect("almacen/index.jsp");
                        usuarioValido = true; // Usuario válido encontrado
                        break;
                    case "VENDEDOR":
                        response.sendRedirect("vendedor/index.jsp");
                        usuarioValido = true; // Usuario válido encontrado
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                        break;
                }
                break; // Salir del bucle, ya que se encontró un usuario válido
            }
        }

        if (!usuarioValido) {
            response.sendRedirect("login.jsp"); // Redirección si no se encontró un usuario válido
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
