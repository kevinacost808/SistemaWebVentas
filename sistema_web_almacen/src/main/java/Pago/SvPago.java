package Pago;

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

@WebServlet(name = "SvPago", urlPatterns = {"/SvPago"})
public class SvPago extends HttpServlet {

    PagoC pagoC = new PagoC();
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
        
        List<Pago> pago = new ArrayList<Pago>();
        pago = pagoC.consultarPago();
        
        List<Pago> listaPago = new ArrayList<Pago>();
        
        if (pago != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Pago p : pago) {    
                Empresa empresa = p.getEmpresa();
                if (empresa != null && empresa.getIdEmpresa() == idEmpresa) {
                    listaPago.add(p);
                }
            }
        }
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPago",listaPago);
        
        response.sendRedirect("administrador/pago.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipoP = request.getParameter("tipoPago");
        String tipoPago = tipoP.toUpperCase();
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Pago pago = new Pago();
        pago.setTipoPago(tipoPago);
        pago.setEmpresa(empresa);
        
        pagoC.agregarPago(pago);
        
        response.sendRedirect("SvPago");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
