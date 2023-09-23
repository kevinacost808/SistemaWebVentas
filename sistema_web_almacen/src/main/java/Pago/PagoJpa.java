
package Pago;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagoJpa {

    PagoJpaController pagoJpa = new PagoJpaController();
    
    public PagoJpa() {
    }
    
    public List<Pago> consultarPago (){
        return pagoJpa.findPagoEntities();
    }
    
    public Pago consultarPagoId(int id){
        return pagoJpa.findPago(id);
    }
    
    public void agregarPago(Pago pago){
        pagoJpa.create(pago);
    }
    
    public void editarPago(Pago pago){
        try {
            pagoJpa.edit(pago);
        } catch (Exception ex) {
            Logger.getLogger(PagoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPago(int id){
        try {
            pagoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
