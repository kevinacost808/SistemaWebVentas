package Comprobante;

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Comprobante> listaComprobante = new ArrayList<Comprobante>();
        listaComprobante = comprobanteC.consultarComprobante();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaComprobante",listaComprobante);
        
        response.sendRedirect("administrador/comprobante.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoComprobante = request.getParameter("tipoComprobante");
        
        Comprobante comprobante = new Comprobante();
        comprobante.setTipoComprobante(tipoComprobante);
        
        comprobanteC.agregarComprobante(comprobante);
        
        response.sendRedirect("SvComprobante");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
