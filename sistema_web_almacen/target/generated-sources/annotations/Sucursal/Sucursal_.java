package Sucursal;

import Empresa.Empresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-31T15:33:50")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, Integer> idSucursal;
    public static volatile SingularAttribute<Sucursal, String> direccionSucursal;
    public static volatile SingularAttribute<Sucursal, String> nombreSucursal;
    public static volatile SingularAttribute<Sucursal, String> correoSucursal;
    public static volatile SingularAttribute<Sucursal, String> celularSucursal;
    public static volatile SingularAttribute<Sucursal, Empresa> empresa;

}