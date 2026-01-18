package com.shopzone.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopzone.qa.baseclass.BaseClass;
import com.shopzone.qa.pages.DashboardPage;
import com.shopzone.qa.pages.LoginPage;
import com.shopzone.qa.utilities.Utilities;

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
	public void teatDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {

		// loginPage = loginPage.login(email, password);
		loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertEquals(
				loginPage.getAccountEmailText(),
			    "adam_arik@yopmail.com",
			    "Logged-in user email is incorrect"
			);

	}

	/*
	 * @DataProvider(name = "validCredentialsSupplier") public Object[][]
	 * supplyTestData() {
	 * 
	 * Object[][] data = Utilities.getTestDataFromExcel("Login"); return data; }
	 */
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Email/Password mismatch warning message is NOT displayed");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.login(dataProp.getProperty("invalidEmail"), prop.getProperty("validPassword"));

		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Email/Password mismatch warning message is NOT displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Email/Password mismatch warning message is NOT displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
		loginPage.clickOnLoginButton();
		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Email/Password mismatch warning message is NOT displayed");

		Assert.assertTrue(
				loginPage.retrieveNoCustomerAccountFoundWarning()
						.contains(dataProp.getProperty("cutomerNotFoundWarning")),
				"No customer account found warning message is NOT displayed");
	}

}