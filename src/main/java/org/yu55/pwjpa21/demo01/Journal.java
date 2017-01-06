package org.yu55.pwjpa21.demo01;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journal {

    @Id
    private Long id;
    private String title;
    private Integer numberOfPages;

    public Journal(Long id, String title, Integer numberOfPages) {
        this.id = id;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
