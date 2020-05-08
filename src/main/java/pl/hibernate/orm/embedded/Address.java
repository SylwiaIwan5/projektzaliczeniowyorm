package pl.hibernate.orm.embedded;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Table(name="Address")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    public Address(String street, String streetNumber, String flatNumber, String postCode, String city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    @Column(name = "addressStreet")
    private String street;

    @Column(name = "addressStreetNumber")
    private String streetNumber;

    @Column(name = "addressFlatNumber")
    private String flatNumber;

    @Column(name = "addressPostCode")
    private String postCode;

    @Column(name = "addressCity")
    private String city;

    @Column(name = "addressCountry")
    private String country;
}
