package Rol;

import java.io.IOException;
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
@WebServlet(name = "SvRolEditar", urlPatterns = {"/SvRolEditar"})
public class SvRolEditar extends HttpServlet {

    RolC rolC = new RolC(); 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRol = Integer.parseInt(request.getParameter("idRol"));
        
        Rol rolEditar = rolC.consultarRolId(idRol);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rolEditar",rolEditar);
        
        response.sendRedirect("gerencia/rolFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRol = Integer.parseInt(request.getParameter("idRol"));
        String nombreR = request.getParameter("nombreRol");
        String nombreRol = nombreR.toUpperCase();
        
        Rol rol = new Rol();
        rol.setIdRol(idRol);
        rol.setNombreRol(nombreRol);
        
        rolC.editarRol(rol);
        
        response.sendRedirect("SvRol");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
