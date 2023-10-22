package Sucursal;

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
@WebServlet(name = "SvSucursalEliminar", urlPatterns = {"/SvSucursalEliminar"})
public class SvSucursalEliminar extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
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
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        sucursalC.eliminarSucursalId(idSucursal);
        
        response.sendRedirect("SvSucursal");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
