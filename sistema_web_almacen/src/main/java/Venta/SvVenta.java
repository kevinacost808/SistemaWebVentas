package Venta;

import Producto.Producto;
import Producto.ProductoC;
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
@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {

    ProductoC productoC = new ProductoC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCliente = request.getParameter("clienteId");
        String codigoProducto = request.getParameter("codigoProducto");
        double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
        
        Producto producto = new Producto();
        producto.setCodigoProducto(codigoProducto);
        producto.setPrecioVenta(precioVenta);
        producto.setVendido(true);
        productoC.editarProducto(producto);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
