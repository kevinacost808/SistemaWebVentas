package PedidoProveedor;

import Proveedor.Proveedor;
import Proveedor.ProveedorC;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "SvPedidoProveedorEditar", urlPatterns = {"/SvPedidoProveedorEditar"})
public class SvPedidoProveedorEditar extends HttpServlet {

    PedidoProveedorC pedidoProveedorC = new PedidoProveedorC();
    ProveedorC proveedorC = new ProveedorC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPedidoProveedor = Integer.parseInt(request.getParameter("idPedidoProveedor"));
        PedidoProveedor PedidoProveedorEditar = pedidoProveedorC.consultarPedidoId(idPedidoProveedor);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("PedidoProveedorEditar",PedidoProveedorEditar);
        
        response.sendRedirect("almacen/pedidoProveedorFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPedidoProveedor = Integer.parseInt(request.getParameter("idPedidoProveedor"));
        String nombre = request.getParameter("nombre");
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
            e.printStackTrace();
        }
        
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedor = proveedorC.consultarProveedorId(idProveedor);
        
        PedidoProveedor pedidoProveedor = (PedidoProveedor)request.getSession().getAttribute("PedidoProveedorEditar");
        pedidoProveedor.setIdPedidoProveedor(idPedidoProveedor);
        pedidoProveedor.setNombre(nombre);
        pedidoProveedor.setCantidad(cantidad);
        pedidoProveedor.setPrecioUnidad(precioUnidad);
        pedidoProveedor.setFechaPedido(fechaPedido);
        pedidoProveedor.setProveedor(proveedor);
        
        pedidoProveedorC.editarPedido(pedidoProveedor);
        
        response.sendRedirect("SvPedidoProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
