
package Comprobante;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class ComprobanteJpa {
    
    ComprobanteJpaController comprobanteJpa = new ComprobanteJpaController();

    public ComprobanteJpa() {
    }
    
    public List<Comprobante> consultarComprobante (){
        return comprobanteJpa.findComprobanteEntities();
    }
    
    public Comprobante consultarComprobanteId(int id){
        return comprobanteJpa.findComprobante(id);
    }
    
    public void agregarComprobante(Comprobante comprobante){
        comprobanteJpa.create(comprobante);
    }
    
    public void editarComprobante(Comprobante comprobante){
        try {
            comprobanteJpa.edit(comprobante);
        } catch (Exception ex) {
            Logger.getLogger(ComprobanteJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarComprobante(int id){
        try {
            comprobanteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComprobanteJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
