package com.sopride.core.beans;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class UserBE {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "number_connections")
    private Integer numberOfConnections;

    @Column(name = "last_connected_date")
    private Timestamp lastConnected;

    @OneToOne
    @JoinColumn(name="id_car_pooling_infos", referencedColumnName="id_carpooling_infos")
    private RideInfoBE rideInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getNumberOfConnections() {
        return numberOfConnections;
    }

    public void setNumberOfConnections(Integer numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    public Timestamp getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(Timestamp lastConnected) {
        this.lastConnected = lastConnected;
    }

    public RideInfoBE getRideInfo() {
        return rideInfo;
    }

    public void setRideInfo(RideInfoBE rideInfo) {
        this.rideInfo = rideInfo;
    }
}
