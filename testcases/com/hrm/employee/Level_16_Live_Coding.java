package com.hrm.employee;

import static org.testng.Assert.assertTrue;

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
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGeneratorManager;
import pageObject.hrm.PersonalDetailsPO;

public class Level_16_Live_Coding extends BaseTest{
	String projectLocation = System.getProperty("user.dir");
	String employeeID, statusValue;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Step 01: Open browser '"+ browserName + "' and navigate '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		statusValue = "Enable";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		loginPage.enterToTextboxByID(driver, "Admin", "txtUsername");
		loginPage.enterToTextboxByID(driver, "admin123", "txtPassword");
		loginPage.clickToButtonByID(driver, "btnLogin");
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
	}
	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeePage = PageGeneratorManager.getEmployeeListPage(driver);
		
		log.info("Add_New - Step 02: Click to 'Add' button");
		employeePage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);
				
		log.info("Add_New - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "Dinh", "firstName");
		
		log.info("Add_New - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "Tam", "lastName");
		
		log.info("Add_New - Step 05: Get value of 'Employee ID' textbox");
		employeeID = addEmployeePage.getValueInTextboxByID(driver, "employeeId");
	
		log.info("Add_New - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
		
		log.info("Add_New - Step 07: Enter valid info to 'Username' textbox");
		addEmployeePage.enterToTextboxByID(driver, "dinhtam123", "user_name");
		
		log.info("Add_New - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "dinhtam123", "user_password");
		
		log.info("Add_New - Step 09: Enter valid info to 'Confirm password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "dinhtam123", "re_password");;
		
		log.info("Add_New - Step 10: Select '" + statusValue + "' value in 'Status' dropndow");
		addEmployeePage.selectItemInDropdownByID(driver, "Enabled", "status");
		
		log.info("Add_New - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		personalPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		
		log.info("Add_New - Step 12: Open 'Employee List' page");
		personalPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeePage = PageGeneratorManager.getEmployeeListPage(driver);
		employeePage.sleepInsecond(5);
		
		log.info("Add_New - Step 13: Enter valid info to 'Employee Name' textbox");
		employeePage.enterToTextboxByID(driver, "Dinh Tam", "empsearch_employee_name_empName");
		employeePage.sleepInsecond(5);
		
		log.info("Add_New - Step 14: Click to 'Search' button");
		employeePage.clickToButtonByID(driver, "searchBtn");
		employeePage.sleepInsecond(5);
		
		log.info("Add_New - Step 15: Verify Employee Information displayed at 'Result Table'");
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "Id"), employeeID);
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "First (& Middle) Name"), "Dinh");
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "Last Name"), "Tam");
	}
	
	@Test
	public void Employee_02_Upload_Avatar() {
		
	}
	
	@Test
	public void Employee_03_Personal_Details() {
		
	}
	
	@Test
	public void Employee_04_Contact_Details() {
		
	}
	
	@Test
	public void Employee_05_Emergency_Details() {
		
	}
	
	@Test
	public void Employee_06_Assigned_Dependents() {
		
	}
	
	@Test
	public void Employee_07_Edit_View_Job() {
		
	}
	
	@Test
	public void Employee_08_Edit_View_Salary() {
		
	}
	
	@Test
	public void Employee_09_Edit_View_Tax() {
		
	}
	
	@Test
	public void Employee_10_Qualifications() {
		
	}
	
	@Test
	public void Employee_11_Search_Employee() {
		
	}

	
	@Parameters({"browser"})
	@AfterClass(alwaysRun=true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver();
	}
	WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	EmployeeListPO employeePage;
	PersonalDetailsPO personalPage;
	AddEmployeePO addEmployeePage;
}
