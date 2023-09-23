package Proveedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Proveedor.Proveedor;
import Proveedor.ProveedorC;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvProveedor", urlPatterns = {"/SvProveedor"})
public class SvProveedor extends HttpServlet {

    ProveedorC proveedorC = new ProveedorC();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        
        listaProveedores = proveedorC.consultarProveedor();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProveedores",listaProveedores);
        
        response.sendRedirect("admin/proveedores.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreProveedor = request.getParameter("nombreProveedor");
        String rucProveedor = request.getParameter("rucProveedor");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setRucProveedor(rucProveedor);
        proveedor.setDireccion(direccion);
        proveedor.setCelular(celular);
        proveedor.setCorreo(correo);
        
        proveedorC.agregarProveedor(proveedor);
        
        response.sendRedirect("SvProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
