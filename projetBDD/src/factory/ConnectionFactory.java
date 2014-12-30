package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance;
	private Connection c;
	
	public ConnectionFactory() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora", "buchart",                    "M1MIAGE2");
		
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public final static ConnectionFactory getInstance(){
		if(instance == null)
			instance = new ConnectionFactory();
		return instance;
	}
	
	public Connection getConnection(){
		return c;
	}
	
	public void close(){
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
