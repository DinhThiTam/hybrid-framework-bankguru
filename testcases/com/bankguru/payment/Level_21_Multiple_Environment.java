package com.bankguru.payment;


import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import environmentConfig.Environment;

public class Level_21_Multiple_Environment extends BaseTest{
	Environment environment;
	
	@Parameters({"envName","serverName","browser","ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void initBrowser(@Optional("local")String envName, @Optional("dev")String serverName, @Optional("firefox")String browserName, @Optional("localhost")String ipAddress, @Optional("4444")String portNumber, @Optional("Windows")String osName, @Optional("94")String osVersion) {
		log.info("Pre-Condition - Step 01: Open browser '"+ browserName + "' and navigate '" + serverName + "'");
		ConfigFactory.setProperty("env", "serverName");
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(envName, environment.applicationUrl(), browserName, ipAddress, portNumber, osName, osVersion);
		System.out.println(driver.getCurrentUrl());
	}
	@Test
	public void Employee_01_Add_New_Employee() {
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

	
	@Parameters({"envName", "browser"})
	@AfterClass(alwaysRun=true)
	public void cleanBrowser(@Optional("local")String envName, String browserName) {
		log.info("Post-Condition - Close Browser - " + browserName + "");
		cleanBrowserAndDriver(envName);
	}
	WebDriver driver;
}
