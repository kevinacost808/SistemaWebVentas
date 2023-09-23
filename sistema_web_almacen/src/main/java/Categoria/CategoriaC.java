
package Categoria;

import java.util.List;
import Categoria.Categoria;

public class CategoriaC {

    CategoriaJpa categoriaControler = new CategoriaJpa();
    
    public CategoriaC() {
    }
    
    public List<Categoria> consultarCategoria(){
        return categoriaControler.consultarCategoria();
    }
    
    public Categoria consultarCategoriaId(int id){
        return categoriaControler.consultarCategoriaId(id);
    }
    
    public void agregarCategoria(Categoria categoria){
        categoriaControler.agregarCategoria(categoria);
    }
    
    public void editarCategoria(Categoria categoria){
        categoriaControler.editarCategoria(categoria);
    }
    
    public void eliminarCategoria(int id){
        categoriaControler.eliminarCategoria(id);
    }
}
