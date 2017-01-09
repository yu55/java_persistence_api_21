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
        Journal journal = journalService.createJournal(1022L, "CHIP", 167);
        tx.commit();
        System.out.println("journal = " + journal);

        journal = journalService.findJournal(1022L);
        System.out.println("journal = " + journal);

        tx.begin();
        journal = journalService.updateTitle(1022L, "CHIP Magazine");
        tx.commit();
        System.out.println("journal = " + journal);
    }

}
