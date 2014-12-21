package com.sopride.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkdayBE;

public class UserDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private static UserDAO instance;
	
	private UserDAO(){
		
	}
	
	public static UserDAO getInstance(){
		if(instance==null){
			instance=new UserDAO();
		}
		return instance;
	}
	
	public void registerUser(UserBE user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	
	public UserBE getUser(int id){
		session.beginTransaction();
		UserBE user = (UserBE)session.load(UserBE.class, id);
		session.getTransaction().commit();
		return user;
	}
	
	

}
