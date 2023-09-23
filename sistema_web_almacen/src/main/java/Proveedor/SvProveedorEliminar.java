package Proveedor;

import Proveedor.ProveedorC;
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
@WebServlet(name = "SvProveedorEliminar", urlPatterns = {"/SvProveedorEliminar"})
public class SvProveedorEliminar extends HttpServlet {

    ProveedorC proveedorC = new ProveedorC();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        
        proveedorC.eliminarProveedor(idProveedor);
        
        response.sendRedirect("SvProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
