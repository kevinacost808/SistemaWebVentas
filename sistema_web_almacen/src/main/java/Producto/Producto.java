package Producto;

import Categoria.Categoria;
import Sucursal.Sucursal;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Producto implements Serializable {
    
    @Id
    private String codigoProducto;
    
    private String marcaProducto;
    private String nombreProducto;
    
    
    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    
    private double precioVenta;
    private double precioCompra;
    private Date fechaIngreso;
    
    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;

    private boolean vendido;
    
    public Producto() {
    }

    public Producto(String marcaProducto, String nombreProducto, String codigoProducto, Categoria categoria, double precioVenta, double precioCompra, Date fechaIngreso, Sucursal sucursal, boolean vendido) {
        this.marcaProducto = marcaProducto;
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.categoria = categoria;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.fechaIngreso = fechaIngreso;
        this.sucursal = sucursal;
        this.vendido = vendido;
    }

    
    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
