package Venta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvVentaEditar", urlPatterns = {"/SvVentaEditar"})
public class SvVentaEditar extends HttpServlet {

    VentaC ventaC = new VentaC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        Venta ventaEditar = ventaC.consultarVentaId(idVenta);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ventaEditar", ventaEditar);
        
        response.sendRedirect("vendedor/ventaFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
