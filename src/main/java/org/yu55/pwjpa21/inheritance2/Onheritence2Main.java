package org.yu55.pwjpa21.inheritance2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Onheritence2Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo01-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Mammal mammal = new Mammal();
        mammal.setName("Dog");
        mammal.setHairLegth(5);
        em.persist(mammal);

        Reptile reptile = new Reptile();
        reptile.setName("Crocodile");
        reptile.setNumberOfEggs(40);
        em.persist(reptile);
        tx.commit();

        System.out.println("Mammal=" + em.find(Mammal.class, mammal.getId()));
        System.out.println("Reptile" + em.find(Reptile.class, reptile.getId()));
    }
}
