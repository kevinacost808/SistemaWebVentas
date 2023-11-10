package Venta;
import java.util.List;

public class VentaC {

    public VentaC() {
    }
    
    VentaJpa ventaJpa = new VentaJpa();
    
    public List<Venta> consultarVenta(){
        return ventaJpa.consultarVenta();
    }
    
    public Venta consultarVentaId(int id){
        return ventaJpa.consultarVentaId(id);
    }
    
    public void agregarVenta(Venta venta){
        ventaJpa.agregarVenta(venta);
    }
    
    public void editarUsuario(Venta venta){
        ventaJpa.editarUsuario(venta);
    }
    
    public void eliminarVentaId(int id){
        ventaJpa.eliminarVentaId(id);
    }
}
