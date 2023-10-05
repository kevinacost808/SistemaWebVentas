package Empresa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "SvEmpresa", urlPatterns = {"/SvEmpresa"})
public class SvEmpresa extends HttpServlet {

    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empresa> listaEmpresa = new ArrayList<Empresa>();
        listaEmpresa = empresaC.consultarEmpresa();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEmpresa",listaEmpresa);
        
        response.sendRedirect("gerencia/empresa.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomb = request.getParameter("nombreEmpresa");
        String nombreEmpresa = nomb.toUpperCase();
        
        String rucEmpresa = request.getParameter("rucEmpresa");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("celular");
        
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");
        
        Date fechaInicio = null; // Inicializa la fecha como null
        Date fechaFin = null; // Inicializa la fecha como null
    
        try {
            if (fechaInicioStr != null && !fechaInicioStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // Ajusta el formato según tu entrada
                fechaInicio = dateFormat.parse(fechaInicioStr);
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace(); // Manejar la excepción si la conversión falla
        }
    
        try {
            if (fechaFinStr != null && !fechaFinStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // Ajusta el formato según tu entrada
                fechaFin = dateFormat.parse(fechaFinStr);
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace(); // Manejar la excepción si la conversión falla
        }
        
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa(nombreEmpresa);
        empresa.setRucEmpresa(rucEmpresa);
        empresa.setCorreo(correo);
        empresa.setCelular(celular);
        empresa.setFechaInicio(fechaInicio);
        empresa.setFechaFin(fechaFin);
        
        empresaC.agregarEmpresa(empresa);
        
        response.sendRedirect("SvEmpresa");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
