package com.sopride.core.beans;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Inheritance(strategy=InheritanceType.JOINED)
public class AddressBE {

    @Id
    @GeneratedValue
    @Column(name = "idAddress")
    private int id;

    @Column(name = "postcode")
    private int postCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
