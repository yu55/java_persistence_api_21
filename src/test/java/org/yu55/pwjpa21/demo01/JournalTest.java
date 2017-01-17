package org.yu55.pwjpa21.demo01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class JournalTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    private CdService cdService;

    @Before
    public void initEntityManager() {
        emf = Persistence.createEntityManagerFactory("demo01-pu-test");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        cdService = new CdService(em);
    }

    @After
    public void closeEntityManager() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    @Test
    public void testSomething() {
        // when
        tx.begin();
        CD cd = cdService.createCd("CHIP CD 12/2004", Genre.IT, "Zone Alarm Free; DoctorTweak XP; OpenOffice.org");
        Long id = cd.getId();
        tx.commit();

        // then
        tx.begin();
        cd = em.find(CD.class, id);
        assertEquals("CHIP CD 12/2004", cd.getTitle());
        assertEquals(Genre.IT, cd.getGenre());
        assertEquals("Zone Alarm Free; DoctorTweak XP; OpenOffice.org", cd.getContent());
        tx.commit();
    }
}