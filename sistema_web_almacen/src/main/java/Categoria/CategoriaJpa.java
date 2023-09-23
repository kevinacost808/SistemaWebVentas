package Categoria;

import Excepcion.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Categoria.Categoria;

/**
 *
 * @author kevin
 */
public class CategoriaJpa {

    CategoriaJpaController categoriaJpa = new CategoriaJpaController();
    
    public CategoriaJpa() {
    }
    
    public List<Categoria> consultarCategoria(){
        return categoriaJpa.findCategoriaEntities();
    }
    
    public Categoria consultarCategoriaId(int id){
        return categoriaJpa.findCategoria(id);
    }
    
    public void agregarCategoria(Categoria categoria){
        categoriaJpa.create(categoria);
    }
    
    public void editarCategoria(Categoria categoria){
        try {
            categoriaJpa.edit(categoria);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCategoria(int id){
        try {
            categoriaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CategoriaJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
