package org.yu55.pwjpa21.demo01;

import javax.persistence.EntityManager;

public class JournalService {

    private EntityManager entityManager;

    JournalService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    Journal createJournal(Long id, String title, Integer numberOfPages) {
        Journal journal = new Journal(id, title, numberOfPages);
        entityManager.persist(journal);
        return journal;
    }
}
