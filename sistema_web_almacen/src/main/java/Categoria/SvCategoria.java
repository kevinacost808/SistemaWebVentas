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
import Sucursal.Sucursal;
import Sucursal.SucursalC;

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvCategoria", urlPatterns = {"/SvCategoria"})
public class SvCategoria extends HttpServlet {

    CategoriaC categoriaC = new CategoriaC();
    SucursalC sucursalC = new SucursalC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSucursalStr = request.getParameter("idSucursal");
        int idSucursal =0;
        
        // Verificar si idEmpresaStr no es nulo ni está vacío
        if (idSucursalStr != null && !idSucursalStr.isEmpty()) {
            try {
                // Intentar convertir idEmpresaStr a un entero
                idSucursal = Integer.parseInt(idSucursalStr);
            } catch (NumberFormatException e) {
                // Manejar la excepción si idEmpresaStr no es un número válido
                System.out.println("idEmpresa no es un número válido.");
            }
        }else{
            HttpSession sesion = request.getSession();
            idSucursal = (int) sesion.getAttribute("idSucursal");
        }
        
        List<Categoria> categoria = new ArrayList<Categoria>();
        categoria = categoriaC.consultarCategoria();
        
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        if (categoria != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Categoria c : categoria) {    
                Sucursal sucursal = c.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaCategoria.add(c);
                }
            }
        }
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCategoria",listaCategoria);
        
        response.sendRedirect("almacen/categoria.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreC = request.getParameter("nombreCategoria");
        String nombreCategoria = nombreC.toUpperCase();
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setSucursal(sucursal);
        
        categoriaC.agregarCategoria(categoria);
        
        response.sendRedirect("SvCategoria");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
