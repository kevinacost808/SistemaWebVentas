package Producto;

import Empresa.Empresa;
import Empresa.EmpresaC;
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

    EmpresaC empresaC = new EmpresaC();
    ProductoC productoC = new ProductoC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idEmpresaStr = request.getParameter("idEmpresa");
        int idEmpresa =0;
        
        // Verificar si idEmpresaStr no es nulo ni está vacío
        if (idEmpresaStr != null && !idEmpresaStr.isEmpty()) {
            try {
                // Intentar convertir idEmpresaStr a un entero
                idEmpresa = Integer.parseInt(idEmpresaStr);
            } catch (NumberFormatException e) {
                // Manejar la excepción si idEmpresaStr no es un número válido
                System.out.println("idEmpresa no es un número válido.");
            }
        }else{
            HttpSession sesion = request.getSession();
            idEmpresa = (int) sesion.getAttribute("idEmpresa");
        }
        
        List<Producto> producto = new ArrayList<Producto>();
        producto = productoC.consultarProducto();
        
        List<Producto> listaProducto = new ArrayList<>();
        
        if (producto != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Producto p : producto) {    
                Empresa empresa = p.getEmpresa();
                if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                    listaProducto.add(p);
                }
            }
        }
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProducto",listaProducto);
        
        response.sendRedirect("administrador/producto.jsp");
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
        producto.setMarcaProducto(marcaProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoProducto(codigoProducto);
        producto.setPrecioCompra(precioVenta);
        producto.setPrecioCompra(precioCompra);
        producto.setFechaIngreso(fechaIngreso);
        producto.setEmpresa(empresa);
        
        productoC.agregarProducto(producto);
        
        response.sendRedirect("SvProducto");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
