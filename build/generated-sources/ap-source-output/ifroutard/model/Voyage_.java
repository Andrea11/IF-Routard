package ifroutard.model;

import ifroutard.model.Depart;
import ifroutard.model.Pays;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-01T11:35:44")
@StaticMetamodel(Voyage.class)
public abstract class Voyage_ { 

    public static volatile SingularAttribute<Voyage, Integer> id;
    public static volatile SingularAttribute<Voyage, String> description;
    public static volatile ListAttribute<Voyage, Pays> pays;
    public static volatile SingularAttribute<Voyage, String> code;
    public static volatile SingularAttribute<Voyage, Integer> duree;
    public static volatile SingularAttribute<Voyage, String> nom;
    public static volatile SingularAttribute<Voyage, Integer> version;
    public static volatile SingularAttribute<Voyage, String> gamme;
    public static volatile ListAttribute<Voyage, Depart> departs;

}