package com.hrm.employee;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGeneratorManager;
import pageObject.hrm.MyInfoPO;

public class Level_22_Database_UI extends BaseTest {
	String projectLocation = System.getProperty("user.dir");
	String empUsername, empPassword;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		empUsername = "dinhtam123";
		empPassword = "dinhtam123";

		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystemHRM(driver, empUsername, empPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() throws SQLException {
		log.info("Add_New - Step 01: Get employee size in UI");
		int employeeSizeUI = dashboardPage.getEmployeeListSizeInUI();
		
		log.info("Add_New - Step 02: Get employee size in Database");
		int employeeSizeDB = dashboardPage.getEmployeeListSizeInDatabase();
		
		log.info("Add_New - Step 03: Verify employee size in UI and DB are equal");
		verifyEquals(employeeSizeUI, employeeSizeDB);	
				
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver();
	}

	WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	EmployeeListPO employeePage;
	MyInfoPO myInfoPage;
	AddEmployeePO addEmployeePage;
}
