package Comprobante;

import java.util.List;

/**
 *
 * @author kevin
 */
public class ComprobanteC {
    
    ComprobanteJpa comprobanteControler = new ComprobanteJpa();

    public ComprobanteC() {
    }
    
    public List<Comprobante> consultarComprobante (){
        return comprobanteControler.consultarComprobante();
    }
    
    public Comprobante consultarComprobanteId(int id){
        return comprobanteControler.consultarComprobanteId(id);
    }
    
    public void agregarComprobante(Comprobante comprobante){
        comprobanteControler.agregarComprobante(comprobante);
    }
    
    public void editarComprobante(Comprobante comprobante){
        comprobanteControler.editarComprobante(comprobante);
    }
    
    public void eliminarComprobante(int id){
        comprobanteControler.eliminarComprobante(id);
    }
    
}
