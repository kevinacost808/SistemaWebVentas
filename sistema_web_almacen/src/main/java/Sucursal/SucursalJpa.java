package Sucursal;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SucursalJpa {
    SucursalJpaController sucursalJpa = new SucursalJpaController();

    public SucursalJpa() {
    }
    
    public List<Sucursal> consultarSucursal(){
        return sucursalJpa.findSucursalEntities();
    }
    
    public Sucursal consultarSucursalId(int id){
        return sucursalJpa.findSucursal(id);
    }
    
    public void agregarSucursal(Sucursal sucursal){
        sucursalJpa.create(sucursal);
    }
    
    public void editarSucursal(Sucursal sucursal){
        try {
            sucursalJpa.edit(sucursal);
        } catch (Exception ex) {
            Logger.getLogger(SucursalJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarSucursalId(int id){
        try {
            sucursalJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SucursalJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
