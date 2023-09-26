package PedidoProveedor;

import Proveedor.Proveedor;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author kevin
 */

@Entity
public class PedidoProveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPedidoProveedor;
    
    private String nombre;
    private int cantidad;
    private float precioUnidad;
    private Date fechaPedido;
    
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    public PedidoProveedor() {
    }

    public PedidoProveedor(int idPedidoProveedor, String nombre, int cantidad, float precioUnidad, Date fechaPedido, Proveedor proveedor) {
        this.idPedidoProveedor = idPedidoProveedor;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.fechaPedido = fechaPedido;
        this.proveedor = proveedor;
    }

    public int getIdPedidoProveedor() {
        return idPedidoProveedor;
    }

    public void setIdPedidoProveedor(int idPedidoProveedor) {
        this.idPedidoProveedor = idPedidoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
}
