package com.sopride.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.AddressBE;
import com.sopride.core.beans.WorkdayBE;
import com.sopride.core.beans.WorkplaceBE;

public class WorkPlaceDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private static WorkPlaceDAO instance;
	
	private WorkPlaceDAO(){
		
	}
	
	public static WorkPlaceDAO getInstance(){
		if(instance==null){
			instance=new WorkPlaceDAO();
		}
		return instance;
	}
	
	public void registerWorkplace(WorkplaceBE workplace){
		session.beginTransaction();
		session.save(workplace);
		session.getTransaction().commit();
	}
	
	public WorkplaceBE getWorkplace(int id){
		session.beginTransaction();
		WorkplaceBE worplace= (WorkplaceBE) session.load(WorkplaceBE.class, id);
		session.getTransaction().commit();
		return worplace;
	}
	
	public List<WorkplaceBE> getAllWorkplace(){
        session.beginTransaction();
        Query query = session.createQuery("from com.sopride.core.beans.WorkplaceBE");
        List<WorkplaceBE> ul = query.list();
        session.getTransaction().commit();
        return ul;
	}
	
}
