package Producto;

import Categoria.Categoria;
import Sucursal.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-16T12:14:31")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> marcaProducto;
    public static volatile SingularAttribute<Producto, Date> fechaIngreso;
    public static volatile SingularAttribute<Producto, Sucursal> sucursal;
    public static volatile SingularAttribute<Producto, Categoria> categoria;
    public static volatile SingularAttribute<Producto, Double> precioCompra;
    public static volatile SingularAttribute<Producto, Boolean> vendido;
    public static volatile SingularAttribute<Producto, String> codigoProducto;
    public static volatile SingularAttribute<Producto, Double> precioVenta;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}