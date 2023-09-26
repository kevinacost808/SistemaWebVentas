package Proveedor;

import PedidoProveedor.PedidoProveedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idProveedor;
    
    private String nombreProveedor;
    private String rucProveedor;
    private String direccion;
    private String celular;
    private String correo;
    
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoProveedor> pedidosProveedor;
    
    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombreProveedor, String rucProveedor, String direccion, String celular, String correo, List<PedidoProveedor> pedidosProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.rucProveedor = rucProveedor;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.pedidosProveedor = pedidosProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<PedidoProveedor> getPedidosProveedor() {
        return pedidosProveedor;
    }

    public void setPedidosProveedor(List<PedidoProveedor> pedidosProveedor) {
        this.pedidosProveedor = pedidosProveedor;
    }
    
    
}
