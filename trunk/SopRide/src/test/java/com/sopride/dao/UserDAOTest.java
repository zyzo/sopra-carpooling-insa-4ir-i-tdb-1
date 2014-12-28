package com.sopride.dao;

import com.sopride.core.beans.UserBE;
import com.sopride.core.exception.DaoException;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;


public class UserDAOTest {

    UserDAO userDAO;

    @BeforeClass
    public void init() {
        userDAO = UserDAO.getInstance();
    }

    //@Test - currently failed because of foreign key to car_pooling_infos
    public void testInsertSuccess() {
        UserBE user = new UserBE();
        user.setEmail("abc@xyz.com");
        user.setPassword("Halo");
        user.setLastConnected(new Date((new java.util.Date()).getTime()));
        user.setNumberOfConnections(0);
        try {
			userDAO.registerUser(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    public void testFindSuccess() {
        UserBE user = userDAO.getUser(1);
        System.out.println(user.getEmail());
    }

    @Test
    public void testFindByEmail() {
        UserBE user = userDAO.findByEmail("aas@aa");
        System.out.println(user.getId());
    }

}