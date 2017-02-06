package org.yu55.pwjpa21.queries;

import org.yu55.pwjpa21.basics.CD;
import org.yu55.pwjpa21.basics.Genre;
import org.yu55.pwjpa21.basics.Journal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class QueryMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basics-pu-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        prepareData(em, tx);

        QueryService queryService = new QueryService(em);
        queryService.queryJournals();
        queryService.queryCDs();
    }

    static void prepareData(EntityManager em, EntityTransaction tx) {
        CD cd1 = new CD("CHIP CD 1/2016", Genre.IT, "Uninstaller 5");
        CD cd2 = new CD("CHIP SPECIAL 2016", Genre.IT, "Linux tools");
        Set<CD> cds = new HashSet<>(Arrays.asList(cd1, cd2));
        Journal journal = new Journal(1100L, "CHIP 12/2004", 120, new Date(), Genre.IT, cds);

        tx.begin();
        em.persist(journal);
        tx.commit();
    }

}
