package PedidoProveedor;

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
@WebServlet(name = "SvPedidoProveedorEliminar", urlPatterns = {"/SvPedidoProveedorEliminar"})
public class SvPedidoProveedorEliminar extends HttpServlet {

    PedidoProveedorC pedidoProveedorC = new PedidoProveedorC();
    
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
        int idPedidoProveedor = Integer.parseInt(request.getParameter("idPedidoProveedor"));
        
        pedidoProveedorC.eliminarPedidoId(idPedidoProveedor);
        
        response.sendRedirect("SvPedidoProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
