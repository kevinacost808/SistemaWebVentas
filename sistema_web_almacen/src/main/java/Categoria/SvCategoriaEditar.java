package Categoria;

import Categoria.CategoriaC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Categoria.Categoria;
import Empresa.Empresa;
import Empresa.EmpresaC;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvCategoriaEditar", urlPatterns = {"/SvCategoriaEditar"})
public class SvCategoriaEditar extends HttpServlet {

    CategoriaC categoriaC = new CategoriaC(); 
    EmpresaC empresaC = new EmpresaC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        
        Categoria categoriaEditar = categoriaC.consultarCategoriaId(idCategoria);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("categoriaEditar",categoriaEditar);
        
        response.sendRedirect("almacen/categoriaFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombreC = request.getParameter("nombreCategoria");
        String nombreCategoria = nombreC.toUpperCase();
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        Empresa empresa = empresaC.consultarEmpresaId(idEmpresa);
        
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setEmpresa(empresa);
        
        categoriaC.editarCategoria(categoria);
        
        response.sendRedirect("SvCategoria");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
