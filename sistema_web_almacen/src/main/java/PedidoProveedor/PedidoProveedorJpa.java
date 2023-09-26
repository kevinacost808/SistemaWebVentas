package PedidoProveedor;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoProveedorJpa {
    
    PedidoProveedorJpaController pedidoProveedorJpa = new PedidoProveedorJpaController();

    public PedidoProveedorJpa() {
    }
    
    public List<PedidoProveedor> consultarPedido(){
        return pedidoProveedorJpa.findPedidoProveedorEntities();
    }
    
    public PedidoProveedor consultarPedidoId(int id){
        return pedidoProveedorJpa.findPedidoProveedor(id);
    }
    
    public void agregarPedido(PedidoProveedor pedidoProveedor){
        pedidoProveedorJpa.create(pedidoProveedor);
    }
    
    public void editarPedido(PedidoProveedor pedidoProveedor){
        try {
            pedidoProveedorJpa.edit(pedidoProveedor);
        } catch (Exception ex) {
            Logger.getLogger(PedidoProveedorJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPedidoId(int id){
        try {
            pedidoProveedorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PedidoProveedorJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
