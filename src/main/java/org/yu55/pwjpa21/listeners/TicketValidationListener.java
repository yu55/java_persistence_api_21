package org.yu55.pwjpa21.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TicketValidationListener {

    @PrePersist
    @PreUpdate
    void validate(Ticket ticket) {
        if (ticket.seatNumber <= 0) {
            throw new IllegalArgumentException("seat number must be a positive number");
        }
        if (ticket.description == null || ticket.description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        System.out.println(ticket + " validation OK");
    }
}
