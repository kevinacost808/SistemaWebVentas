package Comprobante;

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
public class Comprobante implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idComprobante;
    
    private String tipoComprobante;

    @ManyToOne
    @JoinColumn(name = "idSucursal")
    private Sucursal sucursal;
    
    public Comprobante() {
    }

    public Comprobante(int idComprobante, String tipoComprobante, Sucursal sucursal) {
        this.idComprobante = idComprobante;
        this.tipoComprobante = tipoComprobante;
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }
    
    
    
    
}
