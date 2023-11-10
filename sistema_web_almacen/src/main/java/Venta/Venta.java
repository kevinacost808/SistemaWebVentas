package Venta;

import Cliente.Cliente;
import Comprobante.Comprobante;
import Pago.Pago;
import Producto.Producto;
import Sucursal.Sucursal;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idVenta;
    
    @OneToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "codigoProducto")
    private Producto producto;
    
    @OneToOne
    @JoinColumn(name = "idComproante")
    private Comprobante comprobante;
    
    @OneToOne
    @JoinColumn(name = "idPago")
    private Pago pago;
    
    @OneToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    public Venta() {
    }

    public Venta(int idVenta, Cliente cliente, Producto producto, Comprobante comprobante, Pago pago, Sucursal sucursal) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.producto = producto;
        this.comprobante = comprobante;
        this.pago = pago;
        this.sucursal = sucursal;
    }
    

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    
}
