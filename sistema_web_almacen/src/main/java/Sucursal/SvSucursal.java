
package Sucursal;

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

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvSucursal", urlPatterns = {"/SvSucursal"})
public class SvSucursal extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
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
        
        List<Sucursal> sucursal = new ArrayList<Sucursal>();
        sucursal = sucursalC.consultarSucursal();
        
        List<Sucursal> listaSucursal = new ArrayList<>();
        
        if (sucursal != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Sucursal s : sucursal) {    
                Empresa empresa = s.getEmpresa();
                if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                    listaSucursal.add(s);
                }
            }
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaSucursal", listaSucursal);
        response.sendRedirect("gerencia/sucursal.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomb = request.getParameter("nombreSucursal");
        String nombreSucursal = nomb.toUpperCase();
        
        String direc = request.getParameter("direccionSucursal");
        String direccionSucursal = direc.toUpperCase();
        
        String correoSucursal = request.getParameter("correoSucursal");
        String celularSucursal = request.getParameter("celularSucursal");
        
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
    
        Sucursal sucursal = new Sucursal();
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setDireccionSucursal(direccionSucursal);
        sucursal.setCorreoSucursal(correoSucursal);
        sucursal.setCelularSucursal(celularSucursal);
        
        sucursal.setEmpresa(empresa);
        
        sucursalC.agregarSucursal(sucursal);
        
        response.sendRedirect("SvSucursal");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
