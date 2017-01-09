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

    Journal findJournal(Long id) {
        return entityManager.find(Journal.class, id);
    }

    Journal updateTitle(Long id, String newTitle) {
        Journal journal = entityManager.find(Journal.class, id);
        if (journal != null) {
            journal.setTitle(newTitle);
        }
        return journal;
    }

    void removeJournal(Long id) {
        Journal journal = entityManager.find(Journal.class, id);
        if (journal != null) {
            entityManager.remove(journal);
        }
    }
}
