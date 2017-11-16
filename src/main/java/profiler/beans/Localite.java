/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author skyid
 */
@Entity
@Table(name = "t_localite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localite.findAll", query = "SELECT l FROM Localite l")
    , @NamedQuery(name = "Localite.findByPkLocalite", query = "SELECT l FROM Localite l WHERE l.pkLocalite = :pkLocalite")
    , @NamedQuery(name = "Localite.findByNom", query = "SELECT l FROM Localite l WHERE l.nom = :nom")})
public class Localite implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLocalite")
    private List<Compte> tCompteList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_localite")
    private Integer pkLocalite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLocalite")
    private List<Compte> compteList;

    public Localite() {
    }

    public Localite(Integer pkLocalite) {
        this.pkLocalite = pkLocalite;
    }

    public Localite(Integer pkLocalite, String nom) {
        this.pkLocalite = pkLocalite;
        this.nom = nom;
    }

    public Integer getPkLocalite() {
        return pkLocalite;
    }

    public void setPkLocalite(Integer pkLocalite) {
        this.pkLocalite = pkLocalite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Compte> getCompteList() {
        return compteList;
    }

    public void setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLocalite != null ? pkLocalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localite)) {
            return false;
        }
        Localite other = (Localite) object;
        if ((this.pkLocalite == null && other.pkLocalite != null) || (this.pkLocalite != null && !this.pkLocalite.equals(other.pkLocalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profiler.beans.Localite[ pkLocalite=" + pkLocalite + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<Compte> getTCompteList() {
        return tCompteList;
    }

    public void setTCompteList(List<Compte> tCompteList) {
        this.tCompteList = tCompteList;
    }
    
}
