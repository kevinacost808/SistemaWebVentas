package Sucursal;

import Empresa.Empresa;
import Empresa.EmpresaC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvSucursalEditar", urlPatterns = {"/SvSucursalEditar"})
public class SvSucursalEditar extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal SucursalEditar = sucursalC.consultarSucursalId(idSucursal);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("SucursalEditar",SucursalEditar);
        
        response.sendRedirect("gerencia/sucursalFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        
        String nomb = request.getParameter("nombreSucursal");
        String nombreSucursal = nomb.toUpperCase();
        
        String direccionSucursal = request.getParameter("direccionSucursal");
        String correoSucursal = request.getParameter("correoSucursal");
        String celularSucursal = request.getParameter("celularSucursal");
        
        
        int idEmpresa = (int)request.getSession().getAttribute("idEmpresa");
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Sucursal sucursal = (Sucursal)request.getSession().getAttribute("SucursalEditar");
        sucursal.setIdSucursal(idSucursal);
        sucursal.setNombreSucursal(nombreSucursal);
        sucursal.setDireccionSucursal(direccionSucursal);
        sucursal.setCorreoSucursal(correoSucursal);
        sucursal.setCelularSucursal(celularSucursal);
        
        sucursal.setEmpresa(empresa);
        
        sucursalC.editarSucursal(sucursal);
        
        response.sendRedirect("SvSucursal");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
