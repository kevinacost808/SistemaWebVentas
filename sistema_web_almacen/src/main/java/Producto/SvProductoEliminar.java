package Producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvProductoEliminar", urlPatterns = {"/SvProductoEliminar"})
public class SvProductoEliminar extends HttpServlet {
    ProductoC productoC = new ProductoC();
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
        String codigoProducto = request.getParameter("codigoProducto");
        productoC.eliminarProducto(codigoProducto);
        response.sendRedirect("SvProducto");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
