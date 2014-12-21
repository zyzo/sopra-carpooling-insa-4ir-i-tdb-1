package com.sopride.core.beans;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressBE {

    @Id
    @GeneratedValue
    @Column(name = "idAdress")
    private int id;

    @Column(name = "postcode")
    private int postCode;

    @Column(name = "city")
    private int city;

    @Column(name = "street")
    private int street;

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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

}
