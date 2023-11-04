package Comprobante;

import Sucursal.Sucursal;
import Sucursal.SucursalC;
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
@WebServlet(name = "SvComprobante", urlPatterns = {"/SvComprobante"})
public class SvComprobante extends HttpServlet {

    ComprobanteC comprobanteC = new ComprobanteC();
    SucursalC sucursalC = new SucursalC();
    
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
        
        List<Comprobante> comprobante = new ArrayList<Comprobante>();
        comprobante = comprobanteC.consultarComprobante();
        
        List<Comprobante> listaComprobante = new ArrayList<>();
        
        if (comprobante != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Comprobante c : comprobante) {    
                Sucursal sucursal = c.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaComprobante.add(c);
                }
            }
        }
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaComprobante",listaComprobante);
        
        response.sendRedirect("administrador/comprobante.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoC = request.getParameter("tipoComprobante");
        String tipoComprobante = tipoC.toUpperCase();
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Comprobante comprobante = new Comprobante();
        comprobante.setTipoComprobante(tipoComprobante);
        comprobante.setSucursal(sucursal);
        
        comprobanteC.agregarComprobante(comprobante);
        
        response.sendRedirect("SvComprobante");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
