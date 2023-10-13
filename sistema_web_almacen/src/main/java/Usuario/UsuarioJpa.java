package Usuario;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class UsuarioJpa {

    public UsuarioJpa() {
    }
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
    public List<Usuario> consultarUsuario(){
        return usuarioJpa.findUsuarioEntities();
    }
    
    public Usuario consultarUsuarioId(int id){
        return usuarioJpa.findUsuario(id);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarioJpa.create(usuario);
    }
    
    public void editarUsuario(Usuario usuario){
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarUsuarioId(int id){
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
