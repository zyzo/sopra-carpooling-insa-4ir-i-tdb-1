package com.sopride.dao;

import com.sopride.core.beans.UserBE;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

	public UserBE findByEmail(String email) {
		session.beginTransaction();
		Query query = session.getNamedQuery(UserBE.FIND_BY_EMAIL);
		query.setParameter("email", email);
		session.getTransaction().commit();
		return (UserBE) query.uniqueResult();
	}
	
	

}
