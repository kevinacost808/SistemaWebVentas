package Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvClienteBuscar", urlPatterns = {"/SvClienteBuscar"})
public class SvClienteBuscar extends HttpServlet {

    ClienteC clienteC = new ClienteC();
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        
        List<Cliente> cliente = new ArrayList<Cliente>();
        cliente = clienteC.consultarCliente();
        
        String clienteBuscarDni = null;
        String clienteBuscar = null;
        
        if(dni!= null && cliente!=null){
            for(Cliente clien: cliente){
                if(clien.getDni().equals(dni)){
                    System.out.println("a");
                    clienteBuscarDni = clien.getDni();
                    clienteBuscar = clien.getNombre() + " " + clien.getApellido();
                    break;
                }
            }
            System.out.println(clienteBuscarDni);
            System.out.println(clienteBuscar);
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clienteBuscarDni",clienteBuscarDni);
        sesion.setAttribute("clienteBuscar",clienteBuscar);
        
        response.sendRedirect("vendedor/ventaFrm.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
