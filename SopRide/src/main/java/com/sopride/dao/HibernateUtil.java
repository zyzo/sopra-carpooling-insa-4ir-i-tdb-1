package com.sopride.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static ServiceRegistry serviceRegistry;
    
    //Ex�cuter qu'une seule fois
    private static SessionFactory buildSessionFactory() {
        try {        	
            
        	// Create the SessionFactory from hibernate.cfg.xml            
            Configuration configuration = new Configuration();
			configuration.configure();
			configuration.setProperty( "hibernate.jdbc.factory_class", "org.hibernate.jdbc.NonBatchingBatcherFactory" );
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					
			configuration.getProperties()).buildServiceRegistry();
			// on retourne la sessionFactory
			return configuration.buildSessionFactory(serviceRegistry);         
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    
    // on peut acc�der � la session UNIQUE (Singleton Pattern) 
    // pour faire des requetes depuis n'importe o� dans l'application 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
