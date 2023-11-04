package Sucursal;

import Categoria.Categoria;
import Cliente.Cliente;
import Comprobante.Comprobante;
import Empresa.Empresa;
import Pago.Pago;
import PedidoProveedor.PedidoProveedor;
import Proveedor.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-04T00:09:29")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, Integer> idSucursal;
    public static volatile SingularAttribute<Sucursal, String> direccionSucursal;
    public static volatile ListAttribute<Sucursal, Cliente> cliente;
    public static volatile ListAttribute<Sucursal, PedidoProveedor> pedidoProveedor;
    public static volatile ListAttribute<Sucursal, Categoria> categoria;
    public static volatile ListAttribute<Sucursal, Comprobante> comprobante;
    public static volatile SingularAttribute<Sucursal, String> nombreSucursal;
    public static volatile SingularAttribute<Sucursal, String> correoSucursal;
    public static volatile SingularAttribute<Sucursal, String> celularSucursal;
    public static volatile ListAttribute<Sucursal, Proveedor> proveedor;
    public static volatile SingularAttribute<Sucursal, Empresa> empresa;
    public static volatile ListAttribute<Sucursal, Pago> pago;

}