package org.yu55.pwjpa21.demo01;

import javax.persistence.*;
import java.util.Date;

/*
"The entity class must be annotated with the Entity annotation or denoted in the XML descriptor as an
entity."
"The entity class must be a top-level class. An enum or interface must not be designated as an entity."
"The entity class must not be final. No methods or persistent instance variables of the entity class may be
final."
"Both abstract and concrete classes can be entities. Entities may extend non-entity classes as well as
entity classes, and non-entity classes may extend entity classes."
 */
@Entity
@Table(name = "T_JOURNAL")
public class Journal {

    /*
    "The persistent state of an entity is represented by instance variables, which may correspond to Java-
    Beans properties. An instance variable must be directly accessed only from within the methods of the
    entity by the entity instance itself. Instance variables must not be accessed by clients of the entity. The
    state of the entity is available to clients only through the entity’s methods—i.e., accessor methods (getter/
    setter methods) or other business methods."
     */

    /*
    "Every entity must have a primary key."
     */
    @Id
    private Long id;

    @Column(name = "TITLE_FULL", length = 100)
    private String title;

    @Column(name = "NO_OF_PAGES")
    private Integer numberOfPages;

    @Column(name = "RELEASED")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    /*
    "The entity class must have a no-arg constructor. The entity class may have other constructors as well.
    The no-arg constructor must be public or protected."
     */
    protected Journal() {
    }

    Journal(Long id, String title, Integer numberOfPages, Date releaseDate, Genre genre) {
        this.id = id;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", releaseDate=" + releaseDate +
                ", age=" + age +
                ", genre=" + genre +
                '}';
    }
}
