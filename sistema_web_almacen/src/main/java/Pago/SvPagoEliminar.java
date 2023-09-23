package Pago;

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
@WebServlet(name = "SvPagoEliminar", urlPatterns = {"/SvPagoEliminar"})
public class SvPagoEliminar extends HttpServlet {

    PagoC pagoC = new PagoC();
    
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
        
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        
        pagoC.eliminarPago(idPago);
        
        response.sendRedirect("SvPago");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
