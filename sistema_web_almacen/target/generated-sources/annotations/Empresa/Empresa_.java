package Empresa;

import Categoria.Categoria;
import Comprobante.Comprobante;
import Pago.Pago;
import Proveedor.Proveedor;
import Sucursal.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-16T11:35:00")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> rucEmpresa;
    public static volatile SingularAttribute<Empresa, Date> fechaInicio;
    public static volatile ListAttribute<Empresa, Sucursal> sucursal;
    public static volatile SingularAttribute<Empresa, String> correo;
    public static volatile ListAttribute<Empresa, Categoria> categoria;
    public static volatile ListAttribute<Empresa, Comprobante> comprobante;
    public static volatile SingularAttribute<Empresa, String> celular;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile ListAttribute<Empresa, Proveedor> proveedor;
    public static volatile SingularAttribute<Empresa, Date> fechaFin;
    public static volatile ListAttribute<Empresa, Pago> pago;
    public static volatile SingularAttribute<Empresa, String> nombreEmpresa;

}