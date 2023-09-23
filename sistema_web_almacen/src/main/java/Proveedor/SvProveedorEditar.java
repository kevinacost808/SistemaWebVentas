
package Proveedor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Proveedor.Proveedor;
import Proveedor.ProveedorC;

@WebServlet(name = "SvProveedorEditar", urlPatterns = {"/SvProveedorEditar"})
public class SvProveedorEditar extends HttpServlet {

    ProveedorC proveedorC = new ProveedorC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedorEditar = proveedorC.consultarProveedorId(idProveedor);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("proveedorEditar",proveedorEditar);
        
        response.sendRedirect("almacen/frmProveedorE.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        String nombreProveedor = request.getParameter("nombreProveedor");
        String rucProveedor = request.getParameter("rucProveedor");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        
        Proveedor proveedor = (Proveedor)request.getSession().getAttribute("proveedorEditar");
        proveedor.setIdProveedor(idProveedor);
        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setRucProveedor(rucProveedor);
        proveedor.setDireccion(direccion);
        proveedor.setCelular(celular);
        proveedor.setCorreo(correo);
        
        proveedorC.editarProveedor(proveedor);
        
        response.sendRedirect("SvProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
