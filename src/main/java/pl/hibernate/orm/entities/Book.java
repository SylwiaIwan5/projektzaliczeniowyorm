package pl.hibernate.orm.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Book")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    public Book(String title, Date publicationDate, Long isbn) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publicationDate")
    @Temporal(TemporalType.DATE)
    @Transient
    private Date publicationDate;

    @Column(name = "isbn")
    private Long isbn;
}
