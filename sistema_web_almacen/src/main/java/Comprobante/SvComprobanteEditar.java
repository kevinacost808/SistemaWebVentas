package Comprobante;

import Sucursal.Sucursal;
import Sucursal.SucursalC;
import java.io.IOException;
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
@WebServlet(name = "SvComprobanteEditar", urlPatterns = {"/SvComprobanteEditar"})
public class SvComprobanteEditar extends HttpServlet {

    ComprobanteC comprobanteC = new ComprobanteC();
    SucursalC sucursalC = new SucursalC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idComprobante = Integer.parseInt(request.getParameter("idComprobante"));
        Comprobante comprobanteEditar = comprobanteC.consultarComprobanteId(idComprobante);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("comprobanteEditar", comprobanteEditar);
        
        response.sendRedirect("administrador/comprobanteFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idComprobante = Integer.parseInt(request.getParameter("idComprobante"));
        String tipoC = request.getParameter("tipoComprobante");
        String tipoComprobante = tipoC.toUpperCase();
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Comprobante comprobante = new Comprobante();
        comprobante.setIdComprobante(idComprobante);
        comprobante.setTipoComprobante(tipoComprobante);
        comprobante.setSucursal(sucursal);
        
        comprobanteC.editarComprobante(comprobante);
        
        response.sendRedirect("SvComprobante");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
