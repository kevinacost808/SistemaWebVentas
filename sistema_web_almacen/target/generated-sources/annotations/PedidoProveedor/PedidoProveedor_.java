package PedidoProveedor;

import Empresa.Empresa;
import Proveedor.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-07T09:58:26")
@StaticMetamodel(PedidoProveedor.class)
public class PedidoProveedor_ { 

    public static volatile SingularAttribute<PedidoProveedor, Integer> idPedidoProveedor;
    public static volatile SingularAttribute<PedidoProveedor, Float> precioUnidad;
    public static volatile SingularAttribute<PedidoProveedor, Date> fechaPedido;
    public static volatile SingularAttribute<PedidoProveedor, Proveedor> proveedor;
    public static volatile SingularAttribute<PedidoProveedor, Integer> cantidad;
    public static volatile SingularAttribute<PedidoProveedor, Empresa> empresa;
    public static volatile SingularAttribute<PedidoProveedor, String> nombre;

}