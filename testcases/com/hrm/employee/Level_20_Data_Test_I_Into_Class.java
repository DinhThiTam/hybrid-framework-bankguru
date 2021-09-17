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
import commons.GlobalConstants;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGeneratorManager;
import pageObject.hrm.MyInfoPO;

public class Level_20_Data_Test_I_Into_Class extends BaseTest{
	String projectLocation = System.getProperty("user.dir");
	String employeeID, statusValue, empUsername, empPassword, userName, password, firstName, lastName, fullName, avatarFilePath; 
	String editEmpFirstName, editEmpLastName, licenseExpiryDate, editEmpGender, maritalStatus;
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Step 01: Open browser '"+ browserName + "' and navigate '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		statusValue = "Enable";
		empUsername = "dinhtam123";
		empPassword = "dinhtam123";
		userName = "Admin";
		password = "admin123";
		firstName = "Dinh";
		lastName = "Tam";
		fullName = firstName + " " + lastName;
		avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "Adobe.jpg";
		
		editEmpFirstName = "Tue";
		editEmpLastName = "Linh";
		licenseExpiryDate = "2014-10-14";
		editEmpGender = "Male";
		maritalStatus = "Single";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystemHRM(driver, userName, password);
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
		addEmployeePage.enterToTextboxByID(driver, firstName, "firstName");
		
		log.info("Add_New - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, lastName, "lastName");
		
		log.info("Add_New - Step 05: Get value of 'Employee ID' textbox");
		employeeID = addEmployeePage.getValueInTextboxByID(driver, "employeeId");
	
		log.info("Add_New - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
		
		log.info("Add_New - Step 07: Enter valid info to 'Username' textbox");
		addEmployeePage.enterToTextboxByID(driver, empUsername, "user_name");
		
		log.info("Add_New - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, empPassword, "user_password");
		
		log.info("Add_New - Step 09: Enter valid info to 'Confirm password' textbox");
		addEmployeePage.enterToTextboxByID(driver, empPassword, "re_password");;
		
		log.info("Add_New - Step 10: Select '" + statusValue + "' value in 'Status' dropndow");
		addEmployeePage.selectItemInDropdownByID(driver, "Enabled", "status");
		
		log.info("Add_New - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);
		
		log.info("Add_New - Step 12: Open 'Employee List' page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeePage = PageGeneratorManager.getEmployeeListPage(driver);
		verifyTrue(employeePage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeePage.isJQueryAjaxLoadedSuccess(driver));
		employeePage.enterToTextboxByID(driver, fullName, "empsearch_employee_name_empName");
		
		log.info("Add_New - Step 14: Click to 'Search' button");
		employeePage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(employeePage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New - Step 15: Verify Employee Information displayed at 'Result Table'");
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "Id"), employeeID);
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "First (& Middle) Name"), firstName);
		verifyEquals(employeePage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "1", "Last Name"),lastName);
	}
	
	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login with Employee role");
		loginPage = employeePage.clickToLogoutLink(driver);
		dashboardPage = loginPage.loginToSystemHRM(driver, empUsername, empPassword);
		
		log.info("Upload_Avatar_02 - Step 02: Open 'Personal Details' Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGeneratorManager.getMyInfoPage(driver);
		
		log.info("Upload_Avatar_02 - Step 03: Click to 'Change Photo' Image");
		myInfoPage.clickToChangePhotoImage();
		
		log.info("Upload_Avatar_02 - Step 03: Upload new avatar 'Adobe.jpg' image ");
		myInfoPage.uploadImage(driver, avatarFilePath);
		
		log.info("Upload_Avatar_02 - Step 03: Click to Upload button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		myInfoPage.isJQueryAjaxLoadedSuccess(driver);
		
		log.info("Upload_Avatar_02 - Step 03: Verify new Avarta is display");
		verifyTrue(myInfoPage.isMessageSuccessDisplayed(driver, "Successfully Uploaded"));
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
	}
	
	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal Details - Step 01: Open 'Personal Details' form ");
		myInfoPage.openTabMenuByName("Personal Details");
		
		log.info("Personal Details - Step 02: Verify all fields disable at 'Personal Details' form");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtLicExpDate"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_DOB"));
		
		log.info("Personal Details - Step 03: Click to 'Edit' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal Details - Step 04: Verify 'Employee Id' field disable at 'Personal Details' form");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));
		
		log.info("Personal Details - Step 06: Verify 'SSN Number' disable at 'Personal Details' form");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtNICNo"));
		
		log.info("Personal Details - Step 07: Verify 'SIN Number' disable at 'Personal Details' form");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtNICNo"));
		
		log.info("Personal Details - Step 08: Verify 'Date of Birth' disable at 'Personal Details' form");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_DOB"));
		
		log.info("Personal Details - Step 09: Enter 'First Name' textbox");
		myInfoPage.enterToTextboxByID(driver, editEmpFirstName, "personal_txtEmpFirstName");
		
		log.info("Personal Details - Step 10: Enter 'Last Name' textbox");
		myInfoPage.enterToTextboxByID(driver, editEmpLastName, "personal_txtEmpLastName");
		
		log.info("Personal Details - Step 11: Enter 'License Expiry Date' textbox");
		myInfoPage.enterToTextboxByID(driver, licenseExpiryDate, "personal_txtLicExpDate");
		
		log.info("Personal Details - Step 12: Select 'Gender' radio button");
		myInfoPage.clickToRadioByLabel(driver, "Male");
		
		log.info("Personal Details - Step 13: Select 'Marital Status' dropdown");
		myInfoPage.selectItemInDropdownByID(driver,maritalStatus , "personal_cmbMarital");
		
		log.info("Personal Details - Step 14: Click to 'Save' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal Details - Step 15: Verify success message is displayed");
		verifyTrue(myInfoPage.isMessageSuccessDisplayed(driver, "Successfully Saved"));
		
		log.info("Personal Details - Step 16: Verify 'First Name' textbox is updated success");
		verifyEquals(myInfoPage.getValueInTextboxByID(driver,"personal_txtEmpFirstName"), editEmpFirstName);
		
		log.info("Personal Details - Step 16: Verify 'Last Name' textbox is updated success");
		verifyEquals(myInfoPage.getValueInTextboxByID(driver,"personal_txtEmpLastName"), editEmpLastName);
		
		log.info("Personal Details - Step 11: Verify 'License Expiry Date' textbox is updated success");
		verifyEquals(myInfoPage.getValueInTextboxByID(driver,"personal_txtLicExpDate"), licenseExpiryDate);
		
		log.info("Personal Details - Step 12: Verify 'Gender' radio button is updated success ");
		verifyTrue(myInfoPage.isSelectedItemInRadio(driver, "Male"));
		
		log.info("Personal Details - Step 13: Verify 'Marital Status' dropdown is updated success");
		verifyEquals(myInfoPage.getSelectItemInDropdownByID(driver, "personal_cmbMarital"),"Single");
		
		log.info("Personal Details - Step 13: Verify 'Marital Status' dropdown is updated success");
		verifyEquals(myInfoPage.getValueInTextboxByID(driver,"personal_txtEmployeeId"), employeeID);
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
	MyInfoPO myInfoPage;
	AddEmployeePO addEmployeePage;
}
