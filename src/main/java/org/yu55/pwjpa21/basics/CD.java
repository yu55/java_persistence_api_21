package org.yu55.pwjpa21.basics;

import javax.persistence.*;

@Entity
@Table(name = "T_CD")
public class CD {

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
