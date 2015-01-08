package com.sopride.core.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "workingdays")

public class WorkdayBE {
	public WorkdayBE(boolean lundi, boolean mardi, boolean mercredi,
			boolean jeudi, boolean vendredi, boolean samedi, boolean dimanche) {
		super();
		this.lundi = lundi;
		this.mardi = mardi;
		this.mercredi = mercredi;
		this.jeudi = jeudi;
		this.vendredi = vendredi;
		this.samedi = samedi;
		this.dimanche = dimanche;
	}
	public  WorkdayBE(){

	}
	@Id
	@GeneratedValue
	private int id_workingdays;
	@Type(type="boolean")
	@Column(name="lundi")
	private boolean lundi;
	@Type(type="boolean")
	@Column(name="mardi")
	private boolean mardi;
	@Type(type="boolean")
	@Column(name="mercredi")
	private boolean mercredi;
	@Type(type="boolean")
	@Column(name="jeudi")
	private boolean jeudi;
	@Type(type="boolean")
	@Column(name="vendredi")
	private boolean vendredi;
	@Type(type="boolean")
	@Column(name="samedi")
	private boolean samedi;
	@Type(type="boolean")
	@Column(name="dimanche")
	private boolean dimanche;
	public boolean isLundi() {
		return lundi;
	}
	public void setLundi(boolean lundi) {
		this.lundi = lundi;
	}
	public boolean isMardi() {
		return mardi;
	}
	public void setMardi(boolean mardi) {
		this.mardi = mardi;
	}
	public boolean isMercredi() {
		return mercredi;
	}
	public void setMercredi(boolean mercredi) {
		this.mercredi = mercredi;
	}
	public boolean isJeudi() {
		return jeudi;
	}
	public void setJeudi(boolean jeudi) {
		this.jeudi = jeudi;
	}
	public boolean isVendredi() {
		return vendredi;
	}
	public void setVendredi(boolean vendredi) {
		this.vendredi = vendredi;
	}
	public boolean isSamedi() {
		return samedi;
	}
	public void setSamedi(boolean samedi) {
		this.samedi = samedi;
	}
	public boolean isDimanche() {
		return dimanche;
	}
	public void setDimanche(boolean dimanche) {
		this.dimanche = dimanche;
	}
	public int getId_workingdays() {
		return id_workingdays;
	}
	public void setId_workingdays(int id_workingdays) {
		this.id_workingdays = id_workingdays;
	}

	public int toInt() {
		int res = 0 ; 
		if (isLundi())    res+= 1 ; 
		if (isMardi())    res+= 10 ; 
		if (isMercredi()) res+= 100 ; 
		if (isJeudi())    res+= 1000 ;
		if (isVendredi()) res+= 10000 ; 
		if (isSamedi())   res+= 100000 ; 
		if (isDimanche()) res+= 1000000 ;
		return res ; 
	}

}
