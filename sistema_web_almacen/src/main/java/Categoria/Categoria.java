package Categoria;

import Sucursal.Sucursal;
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
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idCategoria;
    
    private String nombreCategoria;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;
    
    public Categoria() {
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Categoria(int idCategoria, String nombreCategoria, Sucursal sucursal) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.sucursal = sucursal;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
    
}
