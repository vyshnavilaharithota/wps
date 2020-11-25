package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

	public Connection connect() {
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.print("errors");
			return con;
		}
		catch(Exception ex)
		{
			System.out.print("error");
			ex.printStackTrace();
			return null;
		}
	}

}
