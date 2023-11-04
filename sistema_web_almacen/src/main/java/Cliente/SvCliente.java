
package Cliente;

import Sucursal.Sucursal;
import Sucursal.SucursalC;
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
        
        List<Cliente> cliente = new ArrayList<Cliente>();
        cliente = clienteC.consultarCliente();
        
        List<Cliente> listaCliente = new ArrayList<>();
        
        if (cliente != null) {
            // Itera a través de la lista para encontrar el elemento deseado
            for (Cliente c : cliente) {    
                Sucursal sucursal = c.getSucursal();
                if (sucursal != null && sucursal.getIdSucursal() == idSucursal) {
                    listaCliente.add(c);
                }
            }
        }
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
        int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
        Sucursal sucursal = sucursalC.consultarSucursalId(idSucursal);
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setCelular(celular);
        cliente.setCorreo(correo);
        cliente.setSucursal(sucursal);
        
        clienteC.agregarCliente(cliente);
        
        response.sendRedirect("SvCliente");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
