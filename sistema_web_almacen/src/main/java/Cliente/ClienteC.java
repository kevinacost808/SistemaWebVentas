package Cliente;

import java.util.List;

/**
 *
 * @author kevin
 */
public class ClienteC {
    ClienteJpa clienteControler = new ClienteJpa();

    public ClienteC() {
    }
    
    public List<Cliente> consultarCliente(){
        return clienteControler.consultarCliente();
    }
    
    public Cliente consultarClienteId(int id){
        return clienteControler.consultarClienteId(id);
    }
    
    public void agregarCliente(Cliente cliente){
        clienteControler.agregarCliente(cliente);
    }
    
    public void editarCliente(Cliente cliente){
        clienteControler.editarCliente(cliente);
    }
    
    public void eliminarCliente(int id){
        clienteControler.eliminarCliente(id);
    }
}
