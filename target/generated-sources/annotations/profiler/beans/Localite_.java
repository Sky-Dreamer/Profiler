package profiler.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import profiler.beans.Compte;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-16T11:18:40")
@StaticMetamodel(Localite.class)
public class Localite_ { 

    public static volatile ListAttribute<Localite, Compte> tCompteList;
    public static volatile SingularAttribute<Localite, Integer> pkLocalite;
    public static volatile ListAttribute<Localite, Compte> compteList;
    public static volatile SingularAttribute<Localite, String> nom;

}