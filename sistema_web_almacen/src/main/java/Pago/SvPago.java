package Pago;

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Pago> listaPago = new ArrayList<Pago>();
        listaPago = pagoC.consultarPago();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPago",listaPago);
        
        response.sendRedirect("administrador/pago.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipoPago = request.getParameter("tipoPago");
        
        Pago pago = new Pago();
        pago.setTipoPago(tipoPago);
        
        pagoC.agregarPago(pago);
        
        response.sendRedirect("SvPago");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
