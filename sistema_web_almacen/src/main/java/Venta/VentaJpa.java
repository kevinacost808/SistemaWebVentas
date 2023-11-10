package Venta;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaJpa {

    public VentaJpa() {
    }
    
    VentaJpaController ventaJpa = new VentaJpaController();
    
    public List<Venta> consultarVenta(){
        return ventaJpa.findVentaEntities();
    }
    
    public Venta consultarVentaId(int id){
        return ventaJpa.findVenta(id);
    }
    
    public void agregarVenta(Venta venta){
        ventaJpa.create(venta);
    }
    
    public void editarUsuario(Venta venta){
        try {
            ventaJpa.edit(venta);
        } catch (Exception ex) {
            Logger.getLogger(VentaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarVentaId(int id){
        try {
            ventaJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(VentaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
