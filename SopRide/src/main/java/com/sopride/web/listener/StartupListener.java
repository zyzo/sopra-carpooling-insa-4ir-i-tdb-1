package com.sopride.web.listener;

import com.sopride.dao.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Initializing SopRide app...");
        // Load hibernate session factory
        HibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Closing SopRide app...");
        // Properly close hibernate session factory before shutdown app
        HibernateUtil.closeSessionFactory();
    }
}
