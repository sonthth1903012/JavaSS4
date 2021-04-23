package com.example.jpa_web_demo2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter

@Entity
@Table(name = "book_publisher")
public class BookPublisher {
    @EmbeddedId
    private BookPublisherId id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @MapsId("publisherId")
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "publish_date")
    private Date publishDate;

    public BookPublisher() {
    }

    public BookPublisher(Book book, Publisher publisher, Date publishDate) {
        this.id = new BookPublisherId(book.getId(), publisher.getId());
        this.book = book;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }
}
