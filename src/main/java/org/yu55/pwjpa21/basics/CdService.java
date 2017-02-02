package org.yu55.pwjpa21.basics;

import javax.persistence.EntityManager;

public class CdService {

    private EntityManager entityManager;

    CdService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    CD createCd(String title, Genre genre, String content) {
        CD cd = new CD(title, genre, content);
        entityManager.persist(cd);
        return cd;
    }

}
