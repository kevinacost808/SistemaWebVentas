
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

/**
 *
 * @author kevin
 */
@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

    ClienteC clienteC = new ClienteC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        listaCliente = clienteC.consultarCliente();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCliente",listaCliente);
        
        response.sendRedirect("vendedor/cliente.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setCelular(celular);
        cliente.setCorreo(correo);
        
        clienteC.agregarCliente(cliente);
        
        response.sendRedirect("SvCliente");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
