package orm;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import orm.Categorias;
import orm.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-13T11:56:21")
@StaticMetamodel(Gastos.class)
public class Gastos_ { 

    public static volatile SingularAttribute<Gastos, Integer> pkIdGas;
    public static volatile SingularAttribute<Gastos, BigDecimal> val;
    public static volatile SingularAttribute<Gastos, Usuarios> fkIdUsu;
    public static volatile SingularAttribute<Gastos, Categorias> fkIdCat;
    public static volatile SingularAttribute<Gastos, Date> fec;
    public static volatile SingularAttribute<Gastos, String> gas;

}