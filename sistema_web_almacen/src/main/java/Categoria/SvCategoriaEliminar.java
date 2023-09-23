package Categoria;

import Categoria.CategoriaC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvCategoriaEliminar", urlPatterns = {"/SvCategoriaEliminar"})
public class SvCategoriaEliminar extends HttpServlet {

    CategoriaC categoriaC = new CategoriaC();
    
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
        
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        
        categoriaC.eliminarCategoria(idCategoria);
        
        response.sendRedirect("SvCategoria");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
