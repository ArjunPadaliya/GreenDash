import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
	
	Connection conn;
	Statement st;
	private String db_url, db_user, db_name, db_pass, db_host, db_port, db_driver; 

	public Connector(Properties props, String pass) {
		db_name = props.getProperty("db_name");
		db_user = props.getProperty("db_user", "root");
		db_pass = pass;
		db_host = props.getProperty("db_host");
		db_port = props.getProperty("db_port");
		db_driver = "com.mysql.cj.jdbc.Driver";
		db_url = "jdbc:mysql://"+db_host+":"+db_port+"/"+db_name+"?serverTimezone=UTC";
		
		System.out.println(db_url);
	}
	
	public boolean connect()
	{
		try {
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
			
			st = conn.createStatement();
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			if(conn == null)
				return false;	
		}
		
		System.out.println("Connected to the database");
		return true;
		
	}
}
