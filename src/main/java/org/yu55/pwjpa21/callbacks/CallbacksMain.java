package org.yu55.pwjpa21.callbacks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CallbacksMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basics-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Invoice invoice = new Invoice(BigDecimal.TEN, "CHIP 8/2005");
        System.out.println("Invoice before: " + invoice);
        tx.begin();
        em.persist(invoice);
        tx.commit();
        System.out.println("Invoice after: " + invoice);
    }
}
