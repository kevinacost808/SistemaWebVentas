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

@WebServlet(name = "SvEmpresaSucursal", urlPatterns = {"/SvEmpresaSucursal"})
public class SvEmpresaSucursal extends HttpServlet {

    SucursalC sucursalC = new SucursalC();
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        HttpSession sesion = request.getSession();
        sesion.setAttribute("idEmpresa", idEmpresa);
        
        response.sendRedirect("SvSucursal");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
