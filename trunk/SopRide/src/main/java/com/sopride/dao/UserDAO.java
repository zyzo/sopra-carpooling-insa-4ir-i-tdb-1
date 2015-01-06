package com.sopride.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

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
	private static final String SQL_USER_IS_ADMIN = "select count(*) from admin where id = :userId";

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
			throw new DaoException("Email d�j� utilis�");
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
		UserBE user = (UserBE) query.uniqueResult();
		session.getTransaction().commit();
		return user;
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

	public boolean isAdmin(UserBE user) {
		session.beginTransaction();
		Query query = session.createSQLQuery(SQL_USER_IS_ADMIN)
					.setParameter("userId", user.getId());
		BigInteger count = (BigInteger) query.uniqueResult();
		System.out.println(count);
		session.getTransaction().commit();
		return count.intValue() == 1;
	}
}
