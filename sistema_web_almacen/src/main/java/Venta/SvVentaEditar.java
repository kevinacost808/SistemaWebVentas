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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvVentaEditar", urlPatterns = {"/SvVentaEditar"})
public class SvVentaEditar extends HttpServlet {

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
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        Venta ventaEditar = ventaC.consultarVentaId(idVenta);
        
        Cliente clienteEditar = ventaEditar.getCliente();
        String codigoProductoEditar = ventaEditar.getProducto().getCodigoProducto();
        String marcaProductoEditar = ventaEditar.getProducto().getMarcaProducto();
        String nombreProductoEditar = ventaEditar.getProducto().getNombreProducto();
        Categoria categoriaEditar = ventaEditar.getProducto().getCategoria();
        double precioCompraEditar = ventaEditar.getProducto().getPrecioCompra();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ventaEditar", ventaEditar);
        sesion.setAttribute("clienteEditar", clienteEditar);
        sesion.setAttribute("codigoProductoEditar", codigoProductoEditar);
        sesion.setAttribute("marcaProductoEditar", marcaProductoEditar);
        sesion.setAttribute("nombreProductoEditar", nombreProductoEditar);
        sesion.setAttribute("categoriaEditar", categoriaEditar);
        sesion.setAttribute("precioCompraEditar", precioCompraEditar);
        
        response.sendRedirect("vendedor/ventaFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        
        int idSucursal = (int) sesion.getAttribute("idSucursal");
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Cliente cliente = (Cliente) sesion.getAttribute("clienteEditar");
        
        String codigoProducto = (String)sesion.getAttribute("codigoProductoEditar");
        Producto prod = productoC.consultarProductoId(codigoProducto);
        
        double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
        
        Producto producto = new Producto();
        String marcaProducto = (String)sesion.getAttribute("marcaProductoEditar");
        String nombreProducto = (String)sesion.getAttribute("nombreProductoEditar");
        Categoria categoria = (Categoria)sesion.getAttribute("categoriaEditar");
        double precioCompra = (double)sesion.getAttribute("precioCompraEditar");
        
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
        venta.setIdVenta(idVenta);
        venta.setCliente(cliente);
        venta.setProducto(prod);
        venta.setComprobante(comprobante);
        venta.setPago(pago);
        venta.setSucursal(sucursal);
        
        ventaC.editarVenta(venta);
        response.sendRedirect("SvVenta");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
