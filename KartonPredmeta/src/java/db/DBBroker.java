/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Katedra;
import domen.Korisnik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sara
 */
public class DBBroker {
    private static DBBroker objekat;
    private EntityManagerFactory emf;
   
    private EntityManager em;

    public static DBBroker getInstance() {
        if (objekat == null) {
            objekat = new DBBroker();
        }
        return objekat;
    }


    private DBBroker() {
       emf= Persistence.createEntityManagerFactory("KartonPredmetaPU");
       
    }

    public void zapocniTransakciju() {

      em=emf.createEntityManager();
        em.getTransaction().begin();
       
    }

    public void zatvoriEntityManager() {
       
        em.close();
    }

    public void commit() throws Exception {
        try {
           em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Greska prilikom commit-a transakcije!");
        }
    }

    public void rollback() throws Exception {
       
        try {
         
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            throw new Exception("Nastala je greska prilikom rollback-a!");
        }
    }

    public List<Katedra> vratiSveKatedre(Katedra katedra) {
 
          List<Katedra> lista = em.createNamedQuery("Katedra.findAll").getResultList();
        
        return lista;
    }

    public Katedra vratiKatedru(Katedra katedra) {
        Katedra k = new Katedra();
        System.out.println("uslo u vrati katedru");
        Query q = em.createNamedQuery("Katedra.findBySifraKatedre");
        q.setParameter("katedraID", katedra.getSifraKatedre());
        k = (Katedra) q.getSingleResult();
        if (k == null) {
            System.out.println("Katedre nema");
        } else {

            System.out.println("Katedra iz baze: " + k.getNazivKatedre() +k.getSifraKatedre());
        }

        return k;
    }
    
    public Korisnik vratiObjekat(Korisnik korisnik) {

        System.out.println("Broker: " + korisnik.getKorisnickoIme() + korisnik.getLozinka());
        Korisnik k = new Korisnik();
        Query q = em.createQuery("SELECT k FROM Korisnik k WHERE k.korisnickoIme =:korisnickoIme and k.lozinka =:lozinka");
        q.setParameter("korisnickoIme", korisnik.getKorisnickoIme());
        q.setParameter("lozinka", korisnik.getLozinka());
        k = (Korisnik) q.getSingleResult();
        if (k == null) {
            System.out.println("Korisnik nije autentifikovan. Pogresno korisnicko ime i/ili sifra");
        } else {

            System.out.println("Korisnik iz baze: " + k.getKorisnickoIme());
        }

        return k;
    }
}
