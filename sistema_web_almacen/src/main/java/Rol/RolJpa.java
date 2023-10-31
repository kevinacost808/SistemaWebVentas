package Rol;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolJpa {
    
    RolJpaController rolJpa = new RolJpaController();

    public RolJpa() {
    }
    
    public List<Rol> consultarRol(){
        return rolJpa.findRolEntities();
    }
    
    public Rol consultarRolId(int id){
        return rolJpa.findRol(id);
    }
    
    public void agregarRol(Rol rol){
        rolJpa.create(rol);
    }
    
    public void editarRol(Rol rol){
        try {
            rolJpa.edit(rol);
        } catch (Exception ex) {
            Logger.getLogger(RolJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarRol(int id){
        try {
            rolJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RolJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
