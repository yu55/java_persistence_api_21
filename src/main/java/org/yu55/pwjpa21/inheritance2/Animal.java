package org.yu55.pwjpa21.inheritance2;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
@MappedSuperclass - a superclass which is not an entity but other entities inherit mapping annotations. This superclass
will NOT have corresponding table in database. It will not be managed by persistence provider. It's a common data
structure for entities.
*/
@MappedSuperclass
class Animal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
