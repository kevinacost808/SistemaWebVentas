package Empresa;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class EmpresaJpa {
    EmpresaJpaController empresaJpa = new EmpresaJpaController();

    public EmpresaJpa() {
    }
    
    public List<Empresa> consultarEmpresa(){
        return empresaJpa.findEmpresaEntities();
    }
    
    public Empresa consultarEmpresaId(int id){
        return empresaJpa.findEmpresa(id);
    }
    
    public void agregarEmpresa(Empresa empresa){
        empresaJpa.create(empresa);
    }
    
    public void editarEmpresa(Empresa empresa){
        try {
            empresaJpa.edit(empresa);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEmpresa(int id){
        try {
            empresaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpresaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
