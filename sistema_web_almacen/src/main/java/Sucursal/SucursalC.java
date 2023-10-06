package Sucursal;

import java.util.List;

/**
 *
 * @author kevin
 */
public class SucursalC {
    SucursalJpa controlJpa = new SucursalJpa();

    public SucursalC() {
    }
    
    public List<Sucursal> consultarSucursal(){
        return controlJpa.consultarSucursal();
    }
    
    public Sucursal consultarSucursalId(int id){
        return controlJpa.consultarSucursalId(id);
    }
    
    public void agregarSucursal(Sucursal sucursal){
        controlJpa.agregarSucursal(sucursal);
    }
    
    public void editarSucursal(Sucursal sucursal){
        controlJpa.editarSucursal(sucursal);
    }
    
    public void eliminarSucursalId(int id){
        controlJpa.eliminarSucursalId(id);
    }
}
