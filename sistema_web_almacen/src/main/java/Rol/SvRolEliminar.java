package Rol;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvRolEliminar extends HttpServlet {

    RolC rolC = new RolC();
    
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
        int idRol = Integer.parseInt(request.getParameter("idRol"));
        
        rolC.eliminarRol(idRol);
        
        response.sendRedirect("SvRol");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
