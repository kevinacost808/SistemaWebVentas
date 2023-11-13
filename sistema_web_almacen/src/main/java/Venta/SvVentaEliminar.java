package Venta;

import Categoria.Categoria;
import Producto.Producto;
import Producto.ProductoC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvVentaEliminar", urlPatterns = {"/SvVentaEliminar"})
public class SvVentaEliminar extends HttpServlet {

    VentaC ventaC = new VentaC();
    ProductoC productoC = new ProductoC();
    SucursalC sucursalC = new SucursalC();
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
        
        HttpSession sesion = request.getSession();
        
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        
        Venta listaVentaEliminar = ventaC.consultarVentaId(idVenta);
        String codigoProducto = listaVentaEliminar.getProducto().getCodigoProducto();
        String marcaProducto = listaVentaEliminar.getProducto().getMarcaProducto();
        String nombreProducto = listaVentaEliminar.getProducto().getNombreProducto();
        double precioCompra = (double)listaVentaEliminar.getProducto().getPrecioCompra();
        double precioVenta = (double)listaVentaEliminar.getProducto().getPrecioVenta();
        Date fechaIngreso = (Date)listaVentaEliminar.getProducto().getFechaIngreso();
        Categoria categoria = (Categoria)listaVentaEliminar.getProducto().getCategoria();
        
        Producto producto = new Producto();
        
        int idSucursal = (int) sesion.getAttribute("idSucursal");
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        producto.setCodigoProducto(codigoProducto);
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCategoria(categoria);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioCompra(precioCompra);
        producto.setFechaIngreso(fechaIngreso);
        producto.setSucursal(sucursal);
        producto.setVendido(false);
        productoC.editarProducto(producto);
        
        ventaC.eliminarVentaId(idVenta);
        response.sendRedirect("SvVenta");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
