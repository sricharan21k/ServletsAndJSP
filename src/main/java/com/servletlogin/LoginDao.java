package com.servletlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

	private Connection connection;

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/servlet";
		String username = "root";
		String password = "Shree@123";

		return connection = DriverManager.getConnection(url, username, password);
	}

	public boolean checkUser(String username, String password) {

		try {
			connection = getConnection();
			String query = "select * from users where username = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, username);

				try (ResultSet result = statement.executeQuery()) {
					while (result.next()) {
						if (result.getString("username").equals(username)
								&& result.getString("password").equals(password)) {
							return true;
						}
					}
				}
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public List<Person> getUsers(){
		List<Person> persons = new ArrayList<>();
		
		try {
			connection = getConnection();
			try(Statement statement = connection.createStatement()){
				
				ResultSet result = statement.executeQuery("select * from person");
				
				while(result.next()) {
					Person person = new Person(result.getString("name"),
							result.getInt("age"), result.getString("city"));
					
					persons.add(person);
				}
				result.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
		
	}

}
