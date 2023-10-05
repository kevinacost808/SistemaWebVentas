package Empresa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "SvEmpresaEditar", urlPatterns = {"/SvEmpresaEditar"})
public class SvEmpresaEditar extends HttpServlet {

    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa EmpresaEditar = empresaC.consultarEmpresaId(idEmpresa);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("EmpresaEditar",EmpresaEditar);
        
        response.sendRedirect("gerencia/empresaFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        
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
            e.printStackTrace();
        }
        
        try {
            if (fechaFinStr != null && !fechaFinStr.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // Ajusta el formato según tu entrada
                fechaFin = dateFormat.parse(fechaFinStr);
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        
        Empresa empresa = (Empresa)request.getSession().getAttribute("EmpresaEditar");
        empresa.setIdEmpresa(idEmpresa);
        empresa.setNombreEmpresa(nombreEmpresa);
        empresa.setRucEmpresa(rucEmpresa);
        empresa.setCorreo(correo);
        empresa.setCelular(celular);
        empresa.setFechaFin(fechaFin);
        empresa.setFechaFin(fechaFin);
        
        empresaC.editarEmpresa(empresa);
        
        response.sendRedirect("SvEmpresa");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
