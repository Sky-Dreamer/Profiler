/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skyid
 */
@Entity
@Table(name = "t_compte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCompte.findAll", query = "SELECT t FROM TCompte t")
    , @NamedQuery(name = "TCompte.findByPkCompte", query = "SELECT t FROM TCompte t WHERE t.pkCompte = :pkCompte")
    , @NamedQuery(name = "TCompte.findByEmail", query = "SELECT t FROM TCompte t WHERE t.email = :email")
    , @NamedQuery(name = "TCompte.findByPassword", query = "SELECT t FROM TCompte t WHERE t.password = :password")
    , @NamedQuery(name = "TCompte.findByNom", query = "SELECT t FROM TCompte t WHERE t.nom = :nom")
    , @NamedQuery(name = "TCompte.findByPrenom", query = "SELECT t FROM TCompte t WHERE t.prenom = :prenom")
    , @NamedQuery(name = "TCompte.findByRue", query = "SELECT t FROM TCompte t WHERE t.rue = :rue")
    , @NamedQuery(name = "TCompte.findByNumRue", query = "SELECT t FROM TCompte t WHERE t.numRue = :numRue")
    , @NamedQuery(name = "TCompte.findByDateNaissance", query = "SELECT t FROM TCompte t WHERE t.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "TCompte.findByEntreprise", query = "SELECT t FROM TCompte t WHERE t.entreprise = :entreprise")
    , @NamedQuery(name = "TCompte.findByTelPrive", query = "SELECT t FROM TCompte t WHERE t.telPrive = :telPrive")
    , @NamedQuery(name = "TCompte.findByTelProf", query = "SELECT t FROM TCompte t WHERE t.telProf = :telProf")})
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_compte")
    private Integer pkCompte;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rue")
    private String rue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "num_rue")
    private String numRue;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 50)
    @Column(name = "entreprise")
    private String entreprise;
    @Size(max = 15)
    @Column(name = "tel_prive")
    private String telPrive;
    @Size(max = 15)
    @Column(name = "tel_prof")
    private String telProf;
    @JoinColumn(name = "fk_localite", referencedColumnName = "pk_localite")
    @ManyToOne(optional = false)
    private Localite fkLocalite;

    public Compte() {
    }

    public Compte(Integer pkCompte) {
        this.pkCompte = pkCompte;
    }

    public Compte(Integer pkCompte, String email, String password, String nom, String prenom, String rue, String numRue, Date dateNaissance) {
        this.pkCompte = pkCompte;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.numRue = numRue;
        this.dateNaissance = dateNaissance;
    }

    public Integer getPkCompte() {
        return pkCompte;
    }

    public void setPkCompte(Integer pkCompte) {
        this.pkCompte = pkCompte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumRue() {
        return numRue;
    }

    public void setNumRue(String numRue) {
        this.numRue = numRue;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getTelPrive() {
        return telPrive;
    }

    public void setTelPrive(String telPrive) {
        this.telPrive = telPrive;
    }

    public String getTelProf() {
        return telProf;
    }

    public void setTelProf(String telProf) {
        this.telProf = telProf;
    }

    public Localite getFkLocalite() {
        return fkLocalite;
    }

    public void setFkLocalite(Localite fkLocalite) {
        this.fkLocalite = fkLocalite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCompte != null ? pkCompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.pkCompte == null && other.pkCompte != null) || (this.pkCompte != null && !this.pkCompte.equals(other.pkCompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profiler.beans.TCompte[ pkCompte=" + pkCompte + " ]";
    }
    
}
