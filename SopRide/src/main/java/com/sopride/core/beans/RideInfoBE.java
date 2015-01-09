package com.sopride.core.beans;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "car_pooling_infos")
public class RideInfoBE {
	
	@Id
	@GeneratedValue
	private int id_carpooling_infos;
	
	@OneToOne
	@JoinColumn(name="home")
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private AddressBE home;
	@ManyToOne
	@JoinColumn(name="id_user")
	private UserBE user;
	@OneToOne
	@JoinColumn(name="car_pooling_workplace")
	private WorkplaceBE car_pooling_workplace;
	@Column(name="morning_hour")
	private Time morning_hour;
	@Column(name="night_hour")
	private Time night_hour;
	@OneToOne
	@JoinColumn(name="days")
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})	
	private WorkdayBE days;
	@Type(type="boolean")
	@Column(name="notify")
	private boolean notify;
	@Type(type="boolean")
	@Column(name="driver")
	private boolean driver;
	
	
	public AddressBE getHome() {
		return home;
	}
	
	public void setHome(AddressBE home) {
		this.home = home;
	}
	
	public WorkplaceBE getCar_pooling_workplace() {
		return car_pooling_workplace;
	}
	
	public void setCar_pooling_workplace(WorkplaceBE car_pooling_workplace) {
		this.car_pooling_workplace = car_pooling_workplace;
	}
	
	public Time getMorning_hour() {
		return morning_hour;
	}
	
	public void setMorning_hour(Time morning_hour) {
		this.morning_hour = morning_hour;
	}
	
	public Time getNight_hour() {
		return night_hour;
	}
	
	public void setNight_hour(Time night_hour) {
		this.night_hour = night_hour;
	}
	public WorkdayBE getDays() {
		return days;
	}
	
	public void setDays(WorkdayBE days) {
		this.days = days;
	}
	
	public boolean isNotify() {
		return notify;
	}
	public void setNotify(boolean notify) {
		this.notify = notify;
	}
	
	public boolean isDriver() {
		return driver;
	}
	
	public void setDriver(boolean driver) {
		this.driver = driver;
	}
	
	public UserBE getUser() {
		return user;
	}
	
	public int getId() {
		return id_carpooling_infos;
	}
	
	public void setUser(UserBE user) {
		this.user = user;
	}
	
}
