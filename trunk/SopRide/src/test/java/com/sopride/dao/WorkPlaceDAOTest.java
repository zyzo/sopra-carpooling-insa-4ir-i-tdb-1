package com.sopride.dao;
public class WorkPlaceDAOTest {

	public static void main (String[] args){

		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		//		List<WorkplaceBE> List = DAO.getAllWorkplace();
		//		for(WorkplaceBE obj : List){
		//		    System.out.println(obj.getCity());
		//		}
		//	   }

		DAO.removeWorkPlace(1);
		//System.out.println("Ligne supprim�e");

	}

}
