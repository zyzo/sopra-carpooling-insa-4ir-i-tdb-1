package com.sopride.core.beans;

import javax.persistence.*;

import com.sopride.core.exception.UserException;
import com.sopride.dao.CryptUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQueries(
        @NamedQuery(name = UserBE.FIND_BY_EMAIL, query = "from UserBE where email = :email")
)

public class UserBE {

    public static final String FIND_BY_EMAIL = "com.sopride.core.beans.UserBE.FIND_BY_EMAIL";

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

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
    private Date lastConnected;

    @OneToMany(mappedBy="user")
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})	
    private List<RideInfoBE> ride_infos = new ArrayList<RideInfoBE>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public UserBE(){
    	this.lastConnected = new Date(Calendar.getInstance().getTimeInMillis());
    	this.numberOfConnections = 1; 
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

    public void setPassword(String password){
    		
        	this.password = CryptUtil.cryptPassword(password);
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

    public void setPhone(Integer phone) throws UserException {
    	try{
        this.phone = phone;
        
    	}catch(NumberFormatException e){
    	throw new UserException("Numéro de téléphone non valide");
    		
    	}
    }

    public Integer getNumberOfConnections() {
        return numberOfConnections;
    }

    public void setNumberOfConnections(Integer numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    public Date getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(Date date) {
        this.lastConnected = date;
    }

	public List<RideInfoBE> getRide_infos() {
		return ride_infos;
	}

	public void setRide_infos(List<RideInfoBE> ride_infos) {
		this.ride_infos = ride_infos;
	}
	
	public boolean passwordIsCorrect(String inputpassword){
		return CryptUtil.checkPassword(this.password, inputpassword);
	}


}
