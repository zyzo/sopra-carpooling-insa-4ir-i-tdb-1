package com.sopride.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.WorkdayBE;
import com.sopride.core.beans.WorkplaceBE;

public class WorkdayDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private static WorkdayDAO instance;
	
	private WorkdayDAO(){
		
	}
	
	public static WorkdayDAO getInstance(){
		if(instance==null){
			instance=new WorkdayDAO();
		}
		return instance;
	}
	
	public void registerWorkday(WorkdayBE workday){
		session.beginTransaction();
		session.save(workday);
		session.getTransaction().commit();
	}
	
	public WorkdayBE getWorkday(int id){
		session.beginTransaction();
		WorkdayBE workday = (WorkdayBE) session.load(WorkdayBE.class, id);
		session.getTransaction().commit();
		return workday;
	}

	public void removeWorkday(int id){
		session.beginTransaction();
		WorkdayBE wd = (WorkdayBE) session.load(WorkdayBE.class, id);
		session.delete(wd);
		session.getTransaction().commit();
	}
	
}
