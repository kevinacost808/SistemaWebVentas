package Usuario;

import java.util.List;

public class UsuarioC {

    public UsuarioC() {
    }
    
    UsuarioJpa controlJpa = new UsuarioJpa();
    
    public List<Usuario> consultarUsuario(){
        return controlJpa.consultarUsuario();
    }
    
    public Usuario consultarUsuarioId(int id){
        return controlJpa.consultarUsuarioId(id);
    }
    
    public void agregarUsuario(Usuario usuario){
        controlJpa.agregarUsuario(usuario);
    }
    
    public void editarUsuario(Usuario usuario){
        controlJpa.editarUsuario(usuario);
    }
    
    public void eliminarUsuarioId(int id){
        controlJpa.eliminarUsuarioId(id);
    }
}
