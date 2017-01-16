package org.yu55.pwjpa21.demo01;

import javax.persistence.EntityManager;
import java.util.Date;

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
