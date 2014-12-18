package com.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.core.beans.Suggestion;
import com.example.dao.DAOFactory;
import com.example.dao.SuggestionDAO;

@WebServlet("/suggest")
public class SuggestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SuggestionDAO suggestionDAO;
	
	@Override
	public void init() {
		suggestionDAO = DAOFactory.getInstance().getSuggestionDAO();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/suggestion.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		Suggestion suggestion = new Suggestion(email, message);
		suggestionDAO.save(suggestion);
		request.getServletContext().getRequestDispatcher("/WEB-INF/suggestionDone.jsp").forward(request, response);
	}
}
