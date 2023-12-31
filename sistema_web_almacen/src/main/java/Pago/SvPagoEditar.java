package Pago;

import Empresa.Empresa;
import Empresa.EmpresaC;
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
@WebServlet(name = "SvPagoEditar", urlPatterns = {"/SvPagoEditar"})
public class SvPagoEditar extends HttpServlet {

    PagoC pagoC = new PagoC();
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        
        Pago pagoEditar = pagoC.consultarPagoId(idPago);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pagoEditar", pagoEditar);
        
        response.sendRedirect("administrador/pagoFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        String tipoP = request.getParameter("tipoPago");
        String tipoPago = tipoP.toUpperCase();
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Pago pago = new Pago();
        pago.setIdPago(idPago);
        pago.setTipoPago(tipoPago);
        pago.setEmpresa(empresa);
        
        pagoC.EditarPago(pago);
        
        response.sendRedirect("SvPago");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
