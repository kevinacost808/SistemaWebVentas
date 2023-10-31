package Rol;

import java.util.List;

public class RolC {
    
    RolJpa rolControler = new RolJpa();

    public RolC() {
    }
    
    public List<Rol> consultarRol(){
        return rolControler.consultarRol();
    }
    
    public Rol consultarRolId(int id){
        return rolControler.consultarRolId(id);
    }
    
    public void agregarRol(Rol rol){
        rolControler.agregarRol(rol);
    }
    
    public void editarRol(Rol rol){
        rolControler.editarRol(rol);
    }
    
    public void eliminarRol(int id){
        rolControler.eliminarRol(id);
    }
    
}
