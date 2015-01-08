package com.sopride.dao;

import java.sql.Time;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.RideInfoBE;

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
	
	public static void main(String[] argc){
		RideInfoBE rideinfo = RideInfoDAO.getInstance().getRideInfo(2);
	}

	public void update(RideInfoBE rideInfo) {
		session.beginTransaction();
		RideInfoBE rideshare = (RideInfoBE) session.load(RideInfoBE.class, rideInfo.getId());
		session.update(rideshare);
		session.getTransaction().commit();
	}
	

}
