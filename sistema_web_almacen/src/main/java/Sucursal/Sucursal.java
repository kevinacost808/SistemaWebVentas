package Sucursal;

import Categoria.Categoria;
import Cliente.Cliente;
import Comprobante.Comprobante;
import Empresa.Empresa;
import Pago.Pago;
import PedidoProveedor.PedidoProveedor;
import Proveedor.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author kevin
 */

@Entity
public class Sucursal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSucursal;
    
    private String nombreSucursal;
    private String direccionSucursal;
    private String correoSucursal;
    private String celularSucursal;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categoria;
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> cliente;
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comprobante> comprobante;
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pago;
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoProveedor> pedidoProveedor;
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proveedor> proveedor;
    
    public Sucursal() {
    }

    public Sucursal(int idSucursal, String nombreSucursal, String direccionSucursal, String correoSucursal, String celularSucursal, Empresa empresa, List<Categoria> categoria, List<Cliente> cliente, List<Comprobante> comprobante, List<Pago> pago, List<PedidoProveedor> pedidoProveedor, List<Proveedor> proveedor) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.correoSucursal = correoSucursal;
        this.celularSucursal = celularSucursal;
        this.empresa = empresa;
        this.categoria = categoria;
        this.cliente = cliente;
        this.comprobante = comprobante;
        this.pago = pago;
        this.pedidoProveedor = pedidoProveedor;
        this.proveedor = proveedor;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    public List<PedidoProveedor> getPedidoProveedor() {
        return pedidoProveedor;
    }

    public void setPedidoProveedor(List<PedidoProveedor> pedidoProveedor) {
        this.pedidoProveedor = pedidoProveedor;
    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    

    public List<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(List<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    
    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getCorreoSucursal() {
        return correoSucursal;
    }

    public void setCorreoSucursal(String correoSucursal) {
        this.correoSucursal = correoSucursal;
    }

    public String getCelularSucursal() {
        return celularSucursal;
    }

    public void setCelularSucursal(String celularSucursal) {
        this.celularSucursal = celularSucursal;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    
    
}
