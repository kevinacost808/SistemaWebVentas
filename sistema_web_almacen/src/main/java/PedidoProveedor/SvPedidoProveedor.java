package PedidoProveedor;

import Proveedor.Proveedor;
import Proveedor.ProveedorC;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvPedidoProveedor", urlPatterns = {"/SvPedidoProveedor"})
public class SvPedidoProveedor extends HttpServlet {

    PedidoProveedorC pedidoProveedorC = new PedidoProveedorC();
    ProveedorC proveedorC = new ProveedorC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PedidoProveedor> listaPedidoProveedor = new ArrayList<PedidoProveedor>();
        listaPedidoProveedor = pedidoProveedorC.consultarPedido();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPedidoProveedor", listaPedidoProveedor);
        
        response.sendRedirect("almacen/pedidoProveedor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomb = request.getParameter("nombre");
        String nombre = nomb.toUpperCase();
        
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        Float precioUnidad = Float.parseFloat(request.getParameter("precioUnidad"));
        String fechaPedidoStr = request.getParameter("fechaPedido");
        
        Date fechaPedido = null; // Inicializa la fecha como null
    
        try {
            if (fechaPedidoStr != null && !fechaPedidoStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // Ajusta el formato según tu entrada
                fechaPedido = dateFormat.parse(fechaPedidoStr);
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace(); // Manejar la excepción si la conversión falla
        }
        
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedor = proveedorC.consultarProveedorId(idProveedor);
    
        PedidoProveedor pedidoProveedor = new PedidoProveedor();
        pedidoProveedor.setNombre(nombre);
        pedidoProveedor.setCantidad(cantidad);
        pedidoProveedor.setPrecioUnidad(precioUnidad);
        pedidoProveedor.setFechaPedido(fechaPedido);
        pedidoProveedor.setProveedor(proveedor);
        
        pedidoProveedorC.agregarPedido(pedidoProveedor);
        
        response.sendRedirect("SvPedidoProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
