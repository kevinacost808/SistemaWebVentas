
package Proveedor;

import Empresa.Empresa;
import Empresa.EmpresaC;
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
    EmpresaC empresaC = new EmpresaC();
    
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
        
        response.sendRedirect("almacen/proveedorFrmE.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        
        String nombreP = request.getParameter("nombreProveedor");
        String nombreProveedor = nombreP.toUpperCase();
        
        String rucProveedor = request.getParameter("rucProveedor");
        String direcc = request.getParameter("direccion");
        String direccion = direcc.toUpperCase();
        
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Proveedor proveedor = (Proveedor)request.getSession().getAttribute("proveedorEditar");
        proveedor.setIdProveedor(idProveedor);
        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setRucProveedor(rucProveedor);
        proveedor.setDireccion(direccion);
        proveedor.setCelular(celular);
        proveedor.setCorreo(correo);
        proveedor.setEmpresa(empresa);
        
        proveedorC.editarProveedor(proveedor);
        
        response.sendRedirect("SvProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
