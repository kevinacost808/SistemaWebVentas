package Pago;

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
public class Pago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPago;
    
    private String tipoPago;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Pago() {
    }

    public Pago(int idPago, String tipoPago, Empresa empresa) {
        this.idPago = idPago;
        this.tipoPago = tipoPago;
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
}
