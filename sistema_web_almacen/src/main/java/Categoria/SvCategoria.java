package Categoria;

import Categoria.CategoriaC;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Categoria.Categoria;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvCategoria", urlPatterns = {"/SvCategoria"})
public class SvCategoria extends HttpServlet {

    CategoriaC categoriaC = new CategoriaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        listaCategoria = categoriaC.consultarCategoria();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCategoria",listaCategoria);
        
        response.sendRedirect("admin/categoria.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreCategoria = request.getParameter("nombreCategoria");
        
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombreCategoria);
        
        categoriaC.agregarCategoria(categoria);
        
        response.sendRedirect("SvCategoria");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
