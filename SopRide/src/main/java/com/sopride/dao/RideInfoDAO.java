package com.sopride.dao;

import java.sql.Time;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;

public class RideInfoDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private static RideInfoDAO instance;
	
	private RideInfoDAO() {		
	}
	
	public static RideInfoDAO getInstance(){
		if(instance==null){
			instance=new RideInfoDAO();
		}
		return instance;
	}
	
	public void registerRideInfo(RideInfoBE rideinfo){
		session.beginTransaction();
		session.save(rideinfo);
		session.getTransaction().commit();
	}
	
	public RideInfoBE getRideInfo(int id){
		session.beginTransaction();
		RideInfoBE rideinfo = (RideInfoBE) session.load(RideInfoBE.class, id);
		session.getTransaction().commit();
		return rideinfo;
	}
	
	public void removeRideshare(int id){
		session.beginTransaction();
		RideInfoBE rideshare = (RideInfoBE) session.load(RideInfoBE.class, id);
		session.delete(rideshare);
		session.getTransaction().commit();
	}
	
	public List<RideInfoBE> getAllRideInfoBE(){
        session.beginTransaction();
        Query query = session.createQuery("from com.sopride.core.beans.RideInfoBE");
        List<RideInfoBE> ul = query.list();
        session.getTransaction().commit();
        return ul;
	}
	
	public static void main(String[] argc){
		
	}

	public void update(RideInfoBE rideInfo) {
		session.beginTransaction();
		RideInfoBE rideshare = (RideInfoBE) session.load(RideInfoBE.class, rideInfo.getId());
		session.update(rideshare);
		session.getTransaction().commit();
	}
	

}
