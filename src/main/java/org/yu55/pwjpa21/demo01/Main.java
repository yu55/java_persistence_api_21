package org.yu55.pwjpa21.demo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo01-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        JournalService journalService = new JournalService(em);

        tx.begin();
        Journal journal = journalService.createJournal(1022L, "CHIP", 167, new Date(), Genre.IT);
        tx.commit();
        System.out.println("added journal = " + journal);

        journal = journalService.findJournal(1022L);
        System.out.println("find journal = " + journal);

        tx.begin();
        journal = journalService.updateTitle(1022L, "CHIP Magazine");
        tx.commit();
        System.out.println("updated journal = " + journal);

        tx.begin();
        journalService.removeJournal(1022L);
        tx.commit();
        journal = journalService.findJournal(1022L);
        System.out.println("removed journal = " + journal);
    }

}
