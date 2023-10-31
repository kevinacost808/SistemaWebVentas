package Rol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvRol", urlPatterns = {"/SvRol"})
public class SvRol extends HttpServlet {

    RolC rolC = new RolC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Rol> listaRol = new ArrayList<Rol>();
        listaRol = rolC.consultarRol();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaRol",listaRol);
        
        response.sendRedirect("gerencia/rol.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreR = request.getParameter("nombreRol");
        String nombreRol = nombreR.toUpperCase();
                
        Rol rol = new Rol();
        rol.setNombreRol(nombreRol);
        
        rolC.agregarRol(rol);
        
        response.sendRedirect("SvRol");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
