package ifroutard.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-01T11:35:44")
@StaticMetamodel(Depart.class)
public class Depart_ { 

    public static volatile SingularAttribute<Depart, Integer> idDepart;
    public static volatile SingularAttribute<Depart, String> moyenTransport;
    public static volatile SingularAttribute<Depart, String> lieuDepart;
    public static volatile SingularAttribute<Depart, Integer> prix;
    public static volatile SingularAttribute<Depart, String> description;
    public static volatile SingularAttribute<Depart, Date> dateDepart;
    public static volatile SingularAttribute<Depart, String> lieuArrivee;
    public static volatile SingularAttribute<Depart, String> codeDepart;
    public static volatile SingularAttribute<Depart, Date> dateArrivee;
    public static volatile SingularAttribute<Depart, Integer> version;

}