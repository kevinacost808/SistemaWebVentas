package Proveedor;

import java.util.List;

public class ProveedorC {
    ProveedorJpa controlJpa = new ProveedorJpa();

    public ProveedorC() {
    }
    
    public void agregarProveedor(Proveedor proveedor){
        controlJpa.agregarProveedor(proveedor);
    }
    
    public List<Proveedor> consultarProveedor(){
        return controlJpa.consultarProveedor();
    }
    
    public void eliminarProveedor(int id){
        controlJpa.eliminarProveedor(id);
    }
    
    public Proveedor consultarProveedorId(int id){
        return controlJpa.consultarProveedorId(id);
    }
    
    public void editarProveedor(Proveedor proveedor){
        controlJpa.editarProveedor(proveedor);
    }
}
