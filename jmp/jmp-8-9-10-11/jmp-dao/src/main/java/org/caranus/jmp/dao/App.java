package org.caranus.jmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Hello world!
 */
public class App
{
	public static void main(String[] args)
	{
		String jdbcURL = "jdbc:h2:mem:test";
		try (Connection connection = DriverManager.getConnection(jdbcURL))
		{
			System.out.println("Connected to H2 in-memory database.");
			String studentsInsertSQL = "Create table students (ID int primary key, name varchar(50))";
			Statement statement = connection.createStatement();
			statement.execute(studentsInsertSQL);
			System.out.println("Created table students.");
			studentsInsertSQL = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";
			int rows = statement.executeUpdate(studentsInsertSQL);
			if (rows > 0)
			{
				System.out.println("Inserted a new row.");
			}
			String studentsSelectSQL = "SELECT * FROM students";

			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(studentsSelectSQL);

			int count = 0;

			while (resultSet.next())
			{
				count++;

				int ID = resultSet.getInt("ID");
				String name = resultSet.getString("name");
				System.out.println("Student #" + count + ": " + ID + ", " + name);
			}
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
