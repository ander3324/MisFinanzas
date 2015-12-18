package orm;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import orm.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-13T11:56:21")
@StaticMetamodel(Ingresos.class)
public class Ingresos_ { 

    public static volatile SingularAttribute<Ingresos, BigDecimal> val;
    public static volatile SingularAttribute<Ingresos, Usuarios> fkIdUsu;
    public static volatile SingularAttribute<Ingresos, String> ing;
    public static volatile SingularAttribute<Ingresos, Date> fec;
    public static volatile SingularAttribute<Ingresos, Integer> pkIdIng;

}