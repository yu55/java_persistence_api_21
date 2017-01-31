package org.yu55.pwjpa21.inheritance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Vehicle {

    private Long id;
    private String name;

    @Id
    @GeneratedValue
    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
