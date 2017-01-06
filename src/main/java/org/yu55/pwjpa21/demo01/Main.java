package org.yu55.pwjpa21.demo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo01-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        JournalService journalService = new JournalService(em);

        tx.begin();
        journalService.createJournal(System.currentTimeMillis(), "CHIP", 167);
        tx.commit();
    }

}
