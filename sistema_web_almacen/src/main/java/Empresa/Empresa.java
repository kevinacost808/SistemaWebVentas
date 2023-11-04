package Empresa;

import Categoria.Categoria;
import Sucursal.Sucursal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author kevin
 */

@Entity
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idEmpresa;
    
    private String nombreEmpresa;
    private String rucEmpresa;
    private String correo;
    private String celular;
    
    private Date fechaInicio;
    private Date fechaFin;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sucursal> sucursal;
    
    public Empresa() {
    }

    public Empresa(int idEmpresa, String nombreEmpresa, String rucEmpresa, String correo, String celular, Date fechaInicio, Date fechaFin, List<Sucursal> sucursal) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.rucEmpresa = rucEmpresa;
        this.correo = correo;
        this.celular = celular;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sucursal = sucursal;
    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    public void setSucursal(List<Sucursal> sucursal) {
        this.sucursal = sucursal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
