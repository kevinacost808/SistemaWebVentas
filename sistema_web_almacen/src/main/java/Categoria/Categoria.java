package Categoria;

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
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idCategoria;
    
    private String nombreCategoria;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;
    
    public Categoria() {
    }

    public Categoria(int idCategoria, String nombreCategoria, Empresa empresa) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
