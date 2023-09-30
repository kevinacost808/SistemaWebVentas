package Cliente;

import java.io.IOException;
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
@WebServlet(name = "SvClienteEditar", urlPatterns = {"/SvClienteEditar"})
public class SvClienteEditar extends HttpServlet {

    ClienteC clienteC = new ClienteC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        Cliente clienteEditar = clienteC.consultarClienteId(idCliente);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clienteEditar",clienteEditar);
        
        response.sendRedirect("vendedor/clienteFrmE.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        
        Cliente clienteEditar =  new Cliente();
        clienteEditar.setIdCliente(idCliente);
        clienteEditar.setNombre(nombre);
        clienteEditar.setApellido(apellido);
        clienteEditar.setDni(dni);
        clienteEditar.setCelular(celular);
        clienteEditar.setCorreo(correo);
        
        clienteC.editarCliente(clienteEditar);
        
        response.sendRedirect("SvCliente");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
