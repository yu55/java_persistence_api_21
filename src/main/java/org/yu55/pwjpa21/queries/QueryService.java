package org.yu55.pwjpa21.queries;

import org.yu55.pwjpa21.basics.Journal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

class QueryService {

    private EntityManager entityManager;

    QueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void queryJournals() {
        Query query = entityManager.createQuery("SELECT j FROM Journal j");
        List journals = query.getResultList();

        for (int i=0; i<journals.size(); i++) {
            Journal journal = (Journal)journals.get(i);
            System.out.println(journal.getCds().size());
            System.out.println(journal);
        }
    }
}
