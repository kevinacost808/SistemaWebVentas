package Venta;

import Categoria.Categoria;
import Cliente.Cliente;
import Cliente.ClienteC;
import Comprobante.Comprobante;
import Comprobante.ComprobanteC;
import Pago.Pago;
import Pago.PagoC;
import Producto.Producto;
import Producto.ProductoC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {

    VentaC ventaC = new VentaC();
    ProductoC productoC = new ProductoC();
    SucursalC sucursalC = new SucursalC();
    ComprobanteC comprobanteC = new ComprobanteC();
    PagoC pagoC = new PagoC();
    ClienteC clienteC = new ClienteC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSucursalStr = request.getParameter("idSucursal");
        int idSucursal =0;
        
        // Verificar si idEmpresaStr no es nulo ni está vacío
        if (idSucursalStr != null && !idSucursalStr.isEmpty()) {
            try {
                // Intentar convertir idEmpresaStr a un entero
                idSucursal = Integer.parseInt(idSucursalStr);
            } catch (NumberFormatException e) {
                // Manejar la excepción si idEmpresaStr no es un número válido
                System.out.println("idEmpresa no es un número válido.");
            }
        }else{
            HttpSession sesion = request.getSession();
            idSucursal = (int) sesion.getAttribute("idSucursal");
        }
        
        List<Venta> venta = new ArrayList<Venta>();
        venta = ventaC.consultarVenta();
        
        List<Venta> listaVenta = new ArrayList<>();
        
        if (venta != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Venta v : venta) {    
                Sucursal sucursal = v.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaVenta.add(v);
                }
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaVenta",listaVenta);
        
        response.sendRedirect("vendedor/venta.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int idSucursal = (int) sesion.getAttribute("idSucursal");
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        int idCliente = (int) sesion.getAttribute("clienteId");
        Cliente cliente = clienteC.consultarClienteId(idCliente);
        
        String codigoProducto = (String)sesion.getAttribute("codigoProducto");
        Producto prod = productoC.consultarProductoId(codigoProducto);
        
        double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
        
        Producto producto = new Producto();
        String marcaProducto = (String)sesion.getAttribute("marcaProducto");
        String nombreProducto = (String)sesion.getAttribute("nombreProducto");
        Categoria categoria = (Categoria)sesion.getAttribute("categoria");
        double precioCompra = (double)sesion.getAttribute("precioCompra");
        
        producto.setCodigoProducto(codigoProducto);
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCategoria(categoria);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioCompra(precioCompra);
        producto.setSucursal(sucursal);
        producto.setVendido(true);
        productoC.editarProducto(producto);
        
        int idComprobante = Integer.parseInt(request.getParameter("idComprobante"));
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        
        Comprobante comprobante = comprobanteC.consultarComprobanteId(idComprobante);
        Pago pago = pagoC.consultarPagoId(idPago);
        
        
        
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setProducto(prod);
        venta.setComprobante(comprobante);
        venta.setPago(pago);
        venta.setSucursal(sucursal);
        
        ventaC.agregarVenta(venta);
        response.sendRedirect("SvVenta");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
