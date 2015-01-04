package com.sopride.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkplaceBE;
import com.sopride.core.exception.DaoException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

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
	
	public void registerUser(UserBE user) throws DaoException{
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(ConstraintViolationException e){
			throw new DaoException("Email déjà utilisé");
		}
	}
	
	public List<UserBE> getAllUser(){
        session.beginTransaction();
        Query query = session.createQuery("from com.sopride.core.beans.UserBE");
        List<UserBE> ul = query.list();
        session.getTransaction().commit();
        return ul;
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
	
	public void removeUser(int id){
		session.beginTransaction();
		UserBE user = (UserBE)session.load(UserBE.class, id);
		session.delete(user);
		session.getTransaction().commit();
	}
	

	public void updateUser(UserBE user){
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}

}
