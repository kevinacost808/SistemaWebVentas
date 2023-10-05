package Empresa;

import java.util.List;

/**
 *
 * @author kevin
 */
public class EmpresaC {
    
    EmpresaJpa empresaControler = new EmpresaJpa();

    public EmpresaC() {
    }
    
    public List<Empresa> consultarEmpresa(){
        return empresaControler.consultarEmpresa();
    }
    
    public Empresa consultarEmpresaId(int id){
        return empresaControler.consultarEmpresaId(id);
    }
    
    public void agregarEmpresa(Empresa empresa){
        empresaControler.agregarEmpresa(empresa);
    }
    
    public void editarEmpresa(Empresa empresa){
        empresaControler.editarEmpresa(empresa);
    }
    
    public void eliminarEmpresa(int id){
        empresaControler.eliminarEmpresa(id);
    }
}
