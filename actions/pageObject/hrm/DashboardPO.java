package pageObject.hrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;


import commons.BasePage;
import utilities.SQLJTDSConnection;


public class DashboardPO extends BasePage {
	WebDriver driver;
	
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getEmployeeListSizeInUI() {
		//count employee
		return 18;
	}

	public int getEmployeeListSizeInDatabase() throws SQLException {
		ArrayList<String> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM [automationfc].[dbo].[EMPLOYEE]";
		Connection conn = null;
		try {
			conn = SQLJTDSConnection.getMySQLConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				employeeList.add(rs.getString("EMP_ID"));
				System.out.println("" + rs.getString("FIRST_NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				conn.close();
			}
		}
	
		return employeeList.size();
	}
	
	

}
