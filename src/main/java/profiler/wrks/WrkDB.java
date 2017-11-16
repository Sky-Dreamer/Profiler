/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.wrks;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import profiler.beans.Compte;

/**
 *
 * @author skyid
 */
public class WrkDB {

    private EntityManager em;

    public WrkDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProfilerPU");
        em = emf.createEntityManager();
    }

    public boolean createUser(Compte compte) {
        em.getTransaction().begin();
        em.persist(compte);
        em.getTransaction().commit();

        return true;
    }

    public boolean addFriend(int id1, int id2) {
        int order1;
        int order2;

        if (id1 < id2) {
            order1 = id1;
            order2 = id2;
        } else {
            order1 = id2;
            order2 = id1;
        }

        if ((Long) em.createNativeQuery("SELECT count(*) FROM r_contact WHERE fk_compte1 = ?1 AND fk_compte2 = ?2").setParameter(1, order1).setParameter(2, order2).getResultList().get(0) == 0) {
            Query query = em.createNativeQuery("INSERT INTO r_contact VALUES (?1, ?2, 1)");

            query.setParameter(1, order1);
            query.setParameter(2, order2);
            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();

            return true;
        } else {
            return false;
        }

    }

    public Compte getCompte(int id) {
        return em.find(Compte.class, id);
    }

//    public Localite getLocalite(int npa) {    
//        return em.find(Localite.class, npa);
//    }

    public ArrayList<Compte> getContacts(int id) {
        ArrayList<Compte> contacts = null;
        contacts = new ArrayList<>(em.createNativeQuery("SELECT pk_compte, Nom, Prenom, tel_prive, tel_prof FROM t_compte WHERE pk_compte IN (SELECT fk_compte1 FROM r_contact WHERE fk_compte2 = ?1 UNION ALL SELECT fk_compte2 FROM r_contact WHERE fk_compte1 = ?1)", Compte.class).setParameter(1, id).getResultList());

        return contacts;
    }

}