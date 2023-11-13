package Producto;

import Categoria.Categoria;
import Categoria.CategoriaC;
import Sucursal.Sucursal;
import Sucursal.SucursalC;
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

@WebServlet(name = "SvProducto", urlPatterns = {"/SvProducto"})
public class SvProducto extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
    ProductoC productoC = new ProductoC();
    CategoriaC categoriaC = new CategoriaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        List<Producto> producto = new ArrayList<>();
        producto = productoC.consultarProducto();
        
        List<Producto> listaProducto = new ArrayList<>();
        
        if (producto != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Producto p : producto) {    
                Sucursal sucursal = p.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaProducto.add(p);
                }
            }
        }
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProducto",listaProducto);
        
        response.sendRedirect("vendedor/producto.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String marcaP = request.getParameter("marcaProducto");
        String marcaProducto = marcaP.toUpperCase();
        
        String nombreP = request.getParameter("nombreProducto");
        String nombreProducto = nombreP.toUpperCase();
        
        String codigoP = request.getParameter("codigoProducto");
        String codigoProducto = codigoP.toUpperCase();
        
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
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoProducto(codigoProducto);
        producto.setPrecioCompra(precioCompra);
        producto.setCategoria(categoria);
        producto.setPrecioVenta(precioVenta);
        producto.setFechaIngreso(fechaIngreso);
        producto.setSucursal(sucursal);
        producto.setVendido(vendido);
        
        productoC.agregarProducto(producto);
        
        response.sendRedirect("SvProducto");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
