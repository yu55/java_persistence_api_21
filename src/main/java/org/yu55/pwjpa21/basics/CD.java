package org.yu55.pwjpa21.basics;

import javax.persistence.*;

import static org.yu55.pwjpa21.basics.CD.FIND_ALL;
import static org.yu55.pwjpa21.basics.CD.FIND_BY_ID_AND_GENRE;

@Entity
@NamedQueries({
        @NamedQuery(name=FIND_ALL, query = "SELECT c FROM CD c"),
        @NamedQuery(name=FIND_BY_ID_AND_GENRE, query = "SELECT c FROM CD c WHERE c.id > :id AND c.genre = :genre")
})
@Table(name = "T_CD")
public class CD {

    public static final String FIND_ALL = "CD.ALL";

    public static final String FIND_BY_ID_AND_GENRE = "CD.FIND_BY_ID_AND_GENRE";

    private Long id;

    private String title;

    private Genre genre;

    private String content;

    protected CD() {
    }

    public CD(String title, Genre genre, String content) {
        this.title = title;
        this.genre = genre;
        this.content = content;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Column(length = 3000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", content='" + content + '\'' +
                '}';
    }
}
