package Empresa;

import Sucursal.Sucursal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-31T15:57:16")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> rucEmpresa;
    public static volatile SingularAttribute<Empresa, Date> fechaInicio;
    public static volatile ListAttribute<Empresa, Sucursal> sucursal;
    public static volatile SingularAttribute<Empresa, String> correo;
    public static volatile SingularAttribute<Empresa, String> celular;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile SingularAttribute<Empresa, Date> fechaFin;
    public static volatile SingularAttribute<Empresa, String> nombreEmpresa;

}