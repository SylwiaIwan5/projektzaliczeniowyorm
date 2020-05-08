package pl.hibernate.orm.entities;

import lombok.*;
import pl.hibernate.orm.embedded.Address;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Author")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
    public Author(String name, String surname, Date birthDate, Address address) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_gen")
    @SequenceGenerator(name = "author_seq_gen", sequenceName = "AUTHOR_SEQ", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    @Transient
    private Date birthDate;

    @Embedded
    private Address address;
}
