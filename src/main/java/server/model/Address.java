package server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String city;
    private String street;
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @Column(name = "HOME_NO")
    private String homeNumber;

    public Address(Long id) {
        this.id = id;
    }

    public Address(String city, String street, String streetNumber, String homeNumber) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.homeNumber = homeNumber;
    }

}