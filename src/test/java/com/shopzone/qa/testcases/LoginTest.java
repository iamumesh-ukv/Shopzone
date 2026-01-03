package com.shopzone.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.shopzone.qa.baseclass.BaseClass;
import com.shopzone.qa.pages.DashboardPage;
import com.shopzone.qa.pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	public WebDriver driver;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		dashboardPage = new DashboardPage(driver);
		loginPage = dashboardPage.navigateToLoginPage();
	}
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}
}