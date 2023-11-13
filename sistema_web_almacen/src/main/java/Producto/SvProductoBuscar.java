package Producto;

import Categoria.Categoria;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvProductoBuscar", urlPatterns = {"/SvProductoBuscar"})
public class SvProductoBuscar extends HttpServlet {
    ProductoC productoC = new ProductoC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoProducto = request.getParameter("codigoProducto");
        Producto listaProductoBuscar = productoC.consultarProductoId(codigoProducto);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProductoBuscar",listaProductoBuscar);
        
        response.sendRedirect("vendedor/ventaFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigoProducto = request.getParameter("codigoProducto");
        
        Producto productoBuscar = productoC.consultarProductoId(codigoProducto);
        String marcaProducto = productoBuscar.getMarcaProducto();
        String nombreProducto = productoBuscar.getNombreProducto();
        Categoria categoria = productoBuscar.getCategoria();
        Double precioCompra = productoBuscar.getPrecioCompra();
        Double precioVenta = productoBuscar.getPrecioVenta();
        Date fechaIngreso = productoBuscar.getFechaIngreso();
        Boolean estado = productoBuscar.isVendido();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("codigoProducto",codigoProducto);
        sesion.setAttribute("marcaProducto",marcaProducto);
        sesion.setAttribute("nombreProducto",nombreProducto);
        sesion.setAttribute("categoria",categoria);
        sesion.setAttribute("precioCompra",precioCompra);
        sesion.setAttribute("precioVenta",precioVenta);
        sesion.setAttribute("fechaIngreso",fechaIngreso);
        sesion.setAttribute("estado",estado);
        
        
        response.sendRedirect("vendedor/ventaFrm.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
