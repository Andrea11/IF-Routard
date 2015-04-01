package ifroutard.model;

import ifroutard.model.Client;
import ifroutard.model.Conseiller;
import ifroutard.model.Voyage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-01T11:35:44")
@StaticMetamodel(Devis.class)
public class Devis_ { 

    public static volatile SingularAttribute<Devis, Integer> id;
    public static volatile SingularAttribute<Devis, Client> client;
    public static volatile SingularAttribute<Devis, Integer> prix;
    public static volatile SingularAttribute<Devis, Voyage> voyage;
    public static volatile SingularAttribute<Devis, Conseiller> conseiller;
    public static volatile SingularAttribute<Devis, Date> dateDepart;

}