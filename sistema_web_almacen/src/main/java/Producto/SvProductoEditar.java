package Producto;

import Empresa.Empresa;
import Empresa.EmpresaC;
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
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto productoEditar = productoC.consultarProductoId(idProducto);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productoEditar", productoEditar);
        
        response.sendRedirect("administrador/productoFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String marcaP = request.getParameter("marcaProducto");
        String marcaProducto = marcaP.toUpperCase();
        
        String nombreP = request.getParameter("nombreProducto");
        String nombreProducto = nombreP.toUpperCase();
        
        String codigoP = request.getParameter("codigoProducto");
        String codigoProducto = codigoP.toUpperCase();
        
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
        
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoProducto(codigoProducto);
        producto.setPrecioCompra(precioVenta);
        producto.setPrecioCompra(precioCompra);
        producto.setFechaIngreso(fechaIngreso);
        producto.setEmpresa(empresa);
        
        productoC.editarProducto(producto);
        
        response.sendRedirect("SvProducto");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
