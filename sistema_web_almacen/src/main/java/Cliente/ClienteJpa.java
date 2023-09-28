
package Cliente;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class ClienteJpa {
    ClienteJpaController clienteJpa = new ClienteJpaController();

    public ClienteJpa() {
    }
    
    public List<Cliente> consultarCliente(){
        return clienteJpa.findClienteEntities();
    }
    
    public Cliente consultarClienteId(int id){
        return clienteJpa.findCliente(id);
    }
    
    public void agregarCliente(Cliente cliente){
        clienteJpa.create(cliente);
    }
    
    public void editarCliente(Cliente cliente){
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCliente(int id){
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
