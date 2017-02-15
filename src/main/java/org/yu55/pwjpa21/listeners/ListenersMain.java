package org.yu55.pwjpa21.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ListenersMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basics-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Ticket ticket = new Ticket(1, "Piano concert");
        tx.begin();
        em.persist(ticket);
        System.out.println("persisted ticket=" + ticket);
        ticket.description="Jazz concert";
        tx.commit();

        System.out.println("updated ticket=" + em.find(Ticket.class, 1L));
    }
}
