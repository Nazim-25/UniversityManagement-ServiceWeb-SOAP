package UnivServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//This class manages the database connection
public class Connexion {
	// Database connection and statement objects
	public static Connection con = null;
	public static Statement st = null;
	// Database connection parameters
	private final String url = "jdbc:postgresql://localhost:5432/University";
	private final String username = "postgres";
	private final String password = "";

	// Establishes a connection to the database
	public void connect() throws ClassNotFoundException {
		try {
			// Load the PostgreSQL driver
			Class.forName("org.postgresql.Driver");
			// Establish the connection using the provided URL, username, and password
			con = DriverManager.getConnection(url, username, password);
			// Check if the connection is successful or failed
			if (con != null)
				System.out.println("connection succeseful!");
			else
				System.out.println("connection failed!");
		} catch (SQLException e) {
			System.out.println(" SQLException!");
			e.printStackTrace();
		}
	}
}
