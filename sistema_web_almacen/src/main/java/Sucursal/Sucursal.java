package Sucursal;

import Empresa.Empresa;
import java.io.Serializable;
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

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String nombreSucursal, String direccionSucursal, String correoSucursal, String celularSucursal, Empresa empresa) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.correoSucursal = correoSucursal;
        this.celularSucursal = celularSucursal;
        this.empresa = empresa;
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
