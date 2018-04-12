package com.vironit.pharmacy.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/*@Entity
@Table(name = \12)*/
public class Address extends BaseEntity implements Serializable {

    private String country;
    private String city;
    private String street;
    private String house;
    private User user;

    public Address(String country, String city, String street, String house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }

}
