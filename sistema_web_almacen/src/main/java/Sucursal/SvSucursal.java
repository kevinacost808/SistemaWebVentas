
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
        List<Sucursal> listaSucursal = new ArrayList<Sucursal>();
        listaSucursal = sucursalC.consultarSucursal();
        
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
        String direccionSucursal = nomb.toUpperCase();
        
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
    
        Sucursal sucursal = new Sucursal();
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setDireccionSucursal(direccionSucursal);
        sucursal.setEmpresa(empresa);
        
        sucursalC.agregarSucursal(sucursal);
        
        response.sendRedirect("SvPedidoProveedor");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
