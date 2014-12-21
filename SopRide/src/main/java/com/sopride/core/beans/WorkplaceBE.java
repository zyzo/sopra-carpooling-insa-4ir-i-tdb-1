package com.sopride.core.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "workplaces")
@PrimaryKeyJoinColumn(name="workplace_name")
public class WorkplaceBE extends AddressBE{
	

}
