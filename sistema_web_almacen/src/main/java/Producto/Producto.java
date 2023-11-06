package Producto;

import Empresa.Empresa;
import Sucursal.Sucursal;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idProducto;
    private String marcaProducto;
    private String nombreProducto;
    private String codigoProducto;
    private double precioVenta;
    private double precioCompra;
    private Date fechaIngreso;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Producto() {
    }

    public Producto(int idProducto, String marcaProducto, String nombreProducto, String codigoProducto, double precioVenta, double precioCompra, Date fechaIngreso, Empresa empresa) {
        this.idProducto = idProducto;
        this.marcaProducto = marcaProducto;
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.fechaIngreso = fechaIngreso;
        this.empresa = empresa;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
}
