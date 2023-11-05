package Proveedor;

import Empresa.Empresa;
import Empresa.EmpresaC;
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
    EmpresaC empresaC = new EmpresaC(); 
    
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
        
        List<Proveedor> proveedor = new ArrayList<Proveedor>();
        proveedor = proveedorC.consultarProveedor();
        
        List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        
        if (proveedor != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Proveedor p : proveedor) {    
                Empresa empresa = p.getEmpresa();
                if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                    listaProveedores.add(p);
                }
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaProveedores",listaProveedores);
        
        response.sendRedirect("almacen/proveedor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreP = request.getParameter("nombreProveedor");
        String nombreProveedor = nombreP.toUpperCase();
        
        String rucProveedor = request.getParameter("rucProveedor");
        String direcc = request.getParameter("direccion");
        String direccion = direcc.toUpperCase();
        
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProveedor(nombreProveedor);
        proveedor.setRucProveedor(rucProveedor);
        proveedor.setDireccion(direccion);
        proveedor.setCelular(celular);
        proveedor.setCorreo(correo);
        proveedor.setEmpresa(empresa);
        
        proveedorC.agregarProveedor(proveedor);
        
        response.sendRedirect("SvProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
