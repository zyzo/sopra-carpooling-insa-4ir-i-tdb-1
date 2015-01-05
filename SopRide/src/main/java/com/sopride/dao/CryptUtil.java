package com.sopride.dao;

import org.jasypt.util.password.StrongPasswordEncryptor;


public class CryptUtil {
	private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();	

	public static String cryptPassword(String password){
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		return encryptedPassword;
	}
	
	public static boolean checkPassword(String encrypt, String password){
		if (passwordEncryptor.checkPassword(password, encrypt)) {	
			return true;
		}
		else{
			return false;
		}
		}
}
