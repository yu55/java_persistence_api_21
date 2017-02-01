package org.yu55.pwjpa21.demo01;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/*
"The entity class must be annotated with the Entity annotation or denoted in the XML descriptor as an
entity."
"The entity class must be a top-level class. An enum or interface must not be designated as an entity."
"The entity class must not be final. No methods or persistent instance variables of the entity class may be
final."
"Both abstract and concrete classes can be entities. Entities may extend non-entity classes as well as
entity classes, and non-entity classes may extend entity classes."
Entity may be an abstract class - persistence provider will create a table for this enetity. It's just from Java point
of view it's not possible to instantiate abstract entity.
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

    @Column(name = "TITLE_FULL", length = 100, nullable = false)
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
    @OneToMany uses by default join table strategy.
    Cascade parameter means that given event (parameter value) is propagated to dependent entities, e.g. persisting
    Journal will persist all dependent CDs. Cascade parameter is an array and may contain more events:
    'cascade = { PERSIST, REMOVE, MERGE }' or 'cascade = ALL'. There is no 'FIND' event.
    Fetch type may be LAZY (deferred) or EAGER (immediately). LAZY - won't fill up memory but access db every time.
    EAGER brings all data into memory reducing database access. LAZY is default to @OneToMany and @ManyToMany. EAGER is
    default to @OneToOne and @ManyToOne.
    @JoinColumn changes this strategy to join column (T_CD.JOURNAL_FK)
     */
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_fk")
    private Set<CD> cds;

    /*
    "The entity class must have a no-arg constructor. The entity class may have other constructors as well.
    The no-arg constructor must be public or protected."
     */
    protected Journal() {
    }

    Journal(Long id, String title, Integer numberOfPages, Date releaseDate, Genre genre, Set<CD> cds) {
        this.id = id;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.cds = cds;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Set<CD> getCds() {
        return cds;
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
                ", cds=" + cds +
                '}';
    }
}
