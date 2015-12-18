package orm;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import orm.Gastos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-13T11:56:21")
@StaticMetamodel(Categorias.class)
public class Categorias_ { 

    public static volatile SingularAttribute<Categorias, Integer> pkIdCat;
    public static volatile SingularAttribute<Categorias, String> cat;
    public static volatile ListAttribute<Categorias, Gastos> gastosList;

}