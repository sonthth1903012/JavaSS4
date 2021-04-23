package com.example.jpamanytomanyprimarykey.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Date publishDate;

    public BookPublisher(Book book, Publisher publisher, Date publishDate) {
        this.book = book;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }

    public BookPublisher() {
    }
}
