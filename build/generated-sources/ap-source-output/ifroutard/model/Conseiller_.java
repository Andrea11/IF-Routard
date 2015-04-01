package ifroutard.model;

import ifroutard.model.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-01T11:35:44")
@StaticMetamodel(Conseiller.class)
public class Conseiller_ { 

    public static volatile SingularAttribute<Conseiller, Integer> id;
    public static volatile SingularAttribute<Conseiller, String> prenom;
    public static volatile SingularAttribute<Conseiller, String> username;
    public static volatile SingularAttribute<Conseiller, String> email;
    public static volatile SingularAttribute<Conseiller, String> password;
    public static volatile SingularAttribute<Conseiller, String> nom;
    public static volatile ListAttribute<Conseiller, Client> myClients;

}