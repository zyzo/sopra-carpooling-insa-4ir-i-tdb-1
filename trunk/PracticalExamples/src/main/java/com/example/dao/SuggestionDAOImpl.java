package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.core.beans.Suggestion;

public class SuggestionDAOImpl implements SuggestionDAO {
	
	private static final String SQL_INSERT = "INSERT INTO T_SUGGESTION (email, content) VALUES (?, ?)";
	
	private DAOFactory daoFactory;
	public SuggestionDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void save(Suggestion suggestion) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.NO_GENERATED_KEYS);
			preparedStatement.setString(1, suggestion.getEmail());
			preparedStatement.setString(2, suggestion.getMessage());
			int statut = preparedStatement.executeUpdate();
			if (statut == 0) {
				throw new RuntimeException("Cannot save Suggestion to database");
			}
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	
	}
}
