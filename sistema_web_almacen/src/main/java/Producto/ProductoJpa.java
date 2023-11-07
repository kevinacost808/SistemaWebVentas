package Producto;

import Excepcion.NonexistentEntityException;
import Excepcion.PreexistingEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoJpa {
    
    ProductoJpaController productoJpa = new ProductoJpaController();

    public ProductoJpa() {
    }
    
    public List<Producto> consultarProducto (){
        return productoJpa.findProductoEntities();
    }
    
    public Producto consultarProductoId(String codigoProducto){
        return productoJpa.findProducto(codigoProducto);
    }
    
    public void agregarProducto(Producto producto){
        try {
            productoJpa.create(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarProducto(Producto producto){
        try {
            productoJpa.edit(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarProducto(String codigoProducto){
        try {
            productoJpa.destroy(codigoProducto);
        } catch (Excepcion.NonexistentEntityException ex) {
            Logger.getLogger(ProductoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
