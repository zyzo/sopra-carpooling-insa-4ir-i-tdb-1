package com.sopride.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.sopride.core.beans.AddressBE;

public class AddressDAO {
		private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		private Session session = sessionFactory.openSession();
		private static AddressDAO instance;
		
		private AddressDAO(){
			
		}
		public static AddressDAO getInstance(){
			if(instance==null){
				instance = new AddressDAO();
				}
			return instance;
		}

		public void registerAddress(AddressBE address) {
			session.beginTransaction();
			session.save(address);
			session.getTransaction().commit();
		}
		public AddressBE getAddressBE(int id){
			session.beginTransaction();
			AddressBE address = (AddressBE) session.load(AddressBE.class, id);
			session.getTransaction().commit();
			return address;
		}
		

}
