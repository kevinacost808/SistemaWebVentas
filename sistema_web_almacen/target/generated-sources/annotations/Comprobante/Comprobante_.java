package Comprobante;

import Empresa.Empresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-04T23:54:29")
@StaticMetamodel(Comprobante.class)
public class Comprobante_ { 

    public static volatile SingularAttribute<Comprobante, Integer> idComprobante;
    public static volatile SingularAttribute<Comprobante, String> tipoComprobante;
    public static volatile SingularAttribute<Comprobante, Empresa> empresa;

}