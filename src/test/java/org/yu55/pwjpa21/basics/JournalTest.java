package org.yu55.pwjpa21.basics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class JournalTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEntityManager() {
        emf = Persistence.createEntityManagerFactory("basics-pu-test");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    @Test
    public void testRelationship() {
        // given
        CD cd1 = new CD("CHIP CD 12/2004", Genre.IT, "Zone Alarm Free; DoctorTweak XP; OpenOffice.org");
        CD cd2 = new CD("CHIP SPECIAL 2004", Genre.IT, "Avast FULL");
        Set<CD> cds = new HashSet<>(Arrays.asList(cd1, cd2));
        Journal journal = new Journal(1000L, "CHIP 12/2004", 120, new Date(), Genre.IT, cds);

        // when
        tx.begin();
        em.persist(journal);
        /*
        Below loop is necessary when there is no 'cascade' attribute in Journal.csc @OneToMany annotation.
         */
//        for(CD cd : journal.getCds()) {
//            em.persist(cd);
//        }
        tx.commit();

        // then
        tx.begin();
        journal = em.find(Journal.class, 1000L);
        assertEquals("CHIP 12/2004", journal.getTitle());
        assertEquals(2, journal.getCds().size());
        tx.commit();
    }
}