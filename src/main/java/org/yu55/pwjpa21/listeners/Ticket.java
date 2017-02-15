package org.yu55.pwjpa21.listeners;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityListeners({
        TicketValidationListener.class
})
class Ticket {

    @Id
    @GeneratedValue
    Long id;

    int seatNumber;

    String description;

    Ticket(int seatNumber, String description) {
        this.seatNumber = seatNumber;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
