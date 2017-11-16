package profiler.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import profiler.beans.Localite;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-16T15:33:02")
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile SingularAttribute<Compte, String> rue;
    public static volatile SingularAttribute<Compte, String> numRue;
    public static volatile SingularAttribute<Compte, Date> dateNaissance;
    public static volatile SingularAttribute<Compte, byte[]> photo;
    public static volatile SingularAttribute<Compte, String> nom;
    public static volatile SingularAttribute<Compte, String> telProf;
    public static volatile SingularAttribute<Compte, String> password;
    public static volatile SingularAttribute<Compte, String> entreprise;
    public static volatile SingularAttribute<Compte, Localite> fkLocalite;
    public static volatile SingularAttribute<Compte, Integer> pkCompte;
    public static volatile SingularAttribute<Compte, String> prenom;
    public static volatile SingularAttribute<Compte, String> email;
    public static volatile SingularAttribute<Compte, String> telPrive;

}