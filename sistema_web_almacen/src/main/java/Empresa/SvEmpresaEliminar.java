
package Empresa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvEmpresaEliminar", urlPatterns = {"/SvEmpresaEliminar"})
public class SvEmpresaEliminar extends HttpServlet {
    
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        empresaC.eliminarEmpresa(idEmpresa);
        
        response.sendRedirect("SvEmpresa");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
