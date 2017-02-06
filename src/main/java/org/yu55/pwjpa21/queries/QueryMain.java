package org.yu55.pwjpa21.queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class QueryMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basics-pu-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        QueryService queryService = new QueryService(em);

        queryService.queryJournals();
    }

}
