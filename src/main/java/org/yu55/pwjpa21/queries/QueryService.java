package org.yu55.pwjpa21.queries;

import org.yu55.pwjpa21.basics.CD;
import org.yu55.pwjpa21.basics.Genre;
import org.yu55.pwjpa21.basics.Journal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

class QueryService {

    private EntityManager entityManager;

    QueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void queryJournals() {
        Query query = entityManager.createQuery("SELECT j FROM Journal j");
        List journals = query.getResultList();

        System.out.println("queryJournals");
        for (int i=0; i<journals.size(); i++) {
            Journal journal = (Journal)journals.get(i);
            System.out.println(journal);
        }
    }

    void queryCDs() {
        TypedQuery<CD> journalTypedQuery = entityManager.createQuery("SELECT c FROM CD c WHERE c.id > ?1 AND c.genre = ?2", CD.class);
        journalTypedQuery.setParameter(1, 1L);
        journalTypedQuery.setParameter(2, Genre.IT);
        List<CD> cds = journalTypedQuery.getResultList();
        System.out.println("queryCDs");
        for (int i=0; i<cds.size(); i++) {
            CD cd = cds.get(i);
            System.out.println(cd);
        }
    }
}
