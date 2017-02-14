package org.yu55.pwjpa21.callbacks;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
class Invoice {

    @Id
    @GeneratedValue
    Long id;

    BigDecimal amount;

    String description;

    @Temporal(TemporalType.TIMESTAMP)
    Date issueDate;

    Invoice(BigDecimal amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    //@PostLoad
    //@PostUpdate
    //@PostPersist
    //@PostRemove
    //@PreRemove
    //@PreUpdate
    @PrePersist
    private void issueDate() {
        issueDate = new Date();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }
}
