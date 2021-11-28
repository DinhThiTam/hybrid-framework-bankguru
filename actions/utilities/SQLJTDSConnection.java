package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {
	
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLExpress";
		String dbName = "automationfc";
		String userName = "sa";
		String password = "Vinhtam2012";
		return getSQLServerConnection(hostName,sqlInstanceName, dbName, userName, password);
	}
	
	public static Connection getSQLServerConnection(String hostName,String sqlInstanceName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL,userName,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
