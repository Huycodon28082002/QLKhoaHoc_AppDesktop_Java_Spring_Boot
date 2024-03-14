package DAL;


import java.sql.Connection;

import java.sql.DriverManager;


import java.sql.SQLException;

import com.mysql.cj.jdbc.StatementImpl;


public class DataBaseAccess {


	public DataBaseAccess()
    {
        
    }
	public static  Connection Connect() throws SQLException {
		Connection c=null;
		StatementImpl s;
		String host = "localhost",
        port = "3306",
        dbUser = "root",
        dbName = "school",
        dbPassword = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
		
		try {
			c = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
			s =  (StatementImpl) c.createStatement();
//			System.out.print("Connected");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
		return c;

	}

	
	



}