package Venta;

import Cliente.Cliente;
import Comprobante.Comprobante;
import Pago.Pago;
import Producto.Producto;
import Sucursal.Sucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-16T12:04:40")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Sucursal> sucursal;
    public static volatile SingularAttribute<Venta, Comprobante> comprobante;
    public static volatile SingularAttribute<Venta, Producto> producto;
    public static volatile SingularAttribute<Venta, Pago> pago;
    public static volatile SingularAttribute<Venta, Integer> idVenta;

}