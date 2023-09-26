package PedidoProveedor;

import java.util.List;

/**
 *
 * @author kevin
 */

public class PedidoProveedorC {
    
    PedidoProveedorJpa controlJpa = new PedidoProveedorJpa();

    public PedidoProveedorC() {
    }
    
    public List<PedidoProveedor> consultarPedido(){
        return controlJpa.consultarPedido();
    }
    
    public PedidoProveedor consultarPedidoId(int id){
        return controlJpa.consultarPedidoId(id);
    }
    
    public void agregarPedido(PedidoProveedor pedidoProveedor){
        controlJpa.agregarPedido(pedidoProveedor);
    }
    
    public void editarPedido(PedidoProveedor pedidoProveedor){
        controlJpa.editarPedido(pedidoProveedor);
    }
    
    public void eliminarPedidoId(int id){
        controlJpa.eliminarPedidoId(id);
    }
    
}
