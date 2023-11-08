package Producto;

import java.io.IOException;
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
        Producto listaProductoBuscar = productoC.consultarProductoId(codigoProducto);
        System.out.println(listaProductoBuscar.getNombreProducto());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProductoBuscar",listaProductoBuscar);
        
        response.sendRedirect("vendedor/ventaFrm.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
