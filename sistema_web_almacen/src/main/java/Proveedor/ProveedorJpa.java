package Proveedor;

import Proveedor.ProveedorJpaController;
import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Proveedor.Proveedor;

public class ProveedorJpa {
    
    ProveedorJpaController proveedorJpa = new ProveedorJpaController();

    public ProveedorJpa() {
    }
    
    public void agregarProveedor(Proveedor proveedor){
        proveedorJpa.create(proveedor);
    }
    
    public List<Proveedor> consultarProveedor(){
        return proveedorJpa.findProveedorEntities();
    }
    
    public void eliminarProveedor(int id){
        try {
            proveedorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProveedorJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Proveedor consultarProveedorId(int id){
        return proveedorJpa.findProveedor(id);
    }
    
    public void editarProveedor(Proveedor proveedor){
        try {
            proveedorJpa.edit(proveedor);
        } catch (Exception ex) {
            Logger.getLogger(ProveedorJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
