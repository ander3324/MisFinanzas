package orm;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import orm.Gastos;
import orm.Ingresos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-13T11:56:21")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Integer> pkIdUsu;
    public static volatile SingularAttribute<Usuarios, String> pass;
    public static volatile SingularAttribute<Usuarios, String> usu;
    public static volatile ListAttribute<Usuarios, Gastos> gastosList;
    public static volatile ListAttribute<Usuarios, Ingresos> ingresosList;

}