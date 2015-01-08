package com.sopride.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopride.core.beans.WorkplaceBE;
import com.sopride.core.exception.AddressException;
import com.sopride.dao.WorkPlaceDAO;
import com.sopride.web.util.WebConstants;
import com.sopride.web.util.WebUtils;

/**
 * Servlet implementation class ModifyWorkplaceServlet
 */
@WebServlet(WebConstants.PATH_MODIFY_WORKPLACE)
public class ModifyWorkplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyWorkplaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();	
		String id = request.getParameter("id");
		WorkplaceBE workplace = DAO.getWorkplace(Integer.parseInt(id)); 
		request.setAttribute("workplace", workplace);
		WebUtils.forward(request, response, "modifyworkplace.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try  {
		int Postcode = Integer.parseInt(request.getParameter("postcode"));
		String City = request.getParameter("city");
		String Street = request.getParameter("street");
		int id = Integer.parseInt(request.getParameter("id"));
		
		WorkPlaceDAO DAO = WorkPlaceDAO.getInstance();
		
		WorkplaceBE workplace = new WorkplaceBE();	
		workplace.setCity(City);
		workplace.setId(id);
		workplace.setPostCode(Postcode);
		workplace.setStreet(Street);
		
		DAO.updateWorkPlace(workplace); 		
		WebUtils.forward(request, response, "workplacemodified.jsp");
		}catch(NumberFormatException e1){
			throw new AddressException("addworkplace.jsp", "Code postal non valide");
		} 
		
		catch (Exception e) {
			WebUtils.forward(request, response, "index.jsp");
		}
	}

}
