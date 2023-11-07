package Producto;

import Categoria.Categoria;
import Categoria.CategoriaC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvProductoEditar", urlPatterns = {"/SvProductoEditar"})
public class SvProductoEditar extends HttpServlet {
    
    ProductoC productoC = new ProductoC();
    SucursalC sucursalC = new SucursalC();
    CategoriaC categoriaC = new CategoriaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoProducto = request.getParameter("codigoProducto");
        Producto productoEditar = productoC.consultarProductoId(codigoProducto);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productoEditar", productoEditar);
        
        response.sendRedirect("vendedor/productoFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String marcaP = request.getParameter("marcaProducto");
        String marcaProducto = marcaP.toUpperCase();
        
        String nombreP = request.getParameter("nombreProducto");
        String nombreProducto = nombreP.toUpperCase();
        
        String codigoProducto = request.getParameter("codigoProducto");
        
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaC.consultarCategoriaId(idCategoria);
        
        double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
        
        double precioCompra = Double.parseDouble(request.getParameter("precioCompra"));
        
        String fechaIngresoStr = request.getParameter("fechaIngreso");
        
        Date fechaIngreso = null;
        
        try {
            if (fechaIngresoStr != null && !fechaIngresoStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // Ajusta el formato según tu entrada
                fechaIngreso = dateFormat.parse(fechaIngresoStr);
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        boolean vendido = false;
        
        Producto producto = new Producto();
        
        producto.setCodigoProducto(codigoProducto);
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCategoria(categoria);
        producto.setPrecioVenta(precioVenta);
        producto.setPrecioCompra(precioCompra);
        producto.setFechaIngreso(fechaIngreso);
        producto.setSucursal(sucursal);
        producto.setVendido(vendido);
        
        productoC.editarProducto(producto);
        
        response.sendRedirect("SvProducto");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
