
package Pago;

import java.util.List;

public class PagoC {
    
    PagoJpa pagoControler = new PagoJpa();

    public PagoC() {
    }
    
    public List<Pago> consultarPago(){
        return pagoControler.consultarPago();
    }
    
    public Pago consultarPagoId(int id){
        return pagoControler.consultarPagoId(id);
    }
    
    public void agregarPago(Pago pago){
        pagoControler.agregarPago(pago);
    }
    
    public void EditarPago(Pago pago){
        pagoControler.editarPago(pago);
    }
    
    public void eliminarPago(int id){
         pagoControler.eliminarPago(id);
    }
    
    
}
