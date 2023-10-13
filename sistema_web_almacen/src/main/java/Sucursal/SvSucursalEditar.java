package Sucursal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvSucursalEditar", urlPatterns = {"/SvSucursalEditar"})
public class SvSucursalEditar extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal UsuarioEditar = sucursalC.consultarSucursalId(idSucursal);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("UsuarioEditar",UsuarioEditar);
        
        response.sendRedirect("gerencia/sucursalFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
