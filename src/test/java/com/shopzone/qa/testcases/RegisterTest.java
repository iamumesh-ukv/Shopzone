package com.shopzone.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.shopzone.qa.baseclass.BaseClass;
import com.shopzone.qa.pages.DashboardPage;
import com.shopzone.qa.pages.RegisterPage;
import com.shopzone.qa.utilities.Utilities;

public class RegisterTest extends BaseClass {
	RegisterPage registerPage;
	DashboardPage dashboardPage;
	public WebDriver driver;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		dashboardPage = new DashboardPage(driver);
		registerPage = dashboardPage.navigateToRegisterPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		dashboardPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("password"), dataProp.getProperty("confirmPassword"));
		Assert.assertEquals(registerPage.retrieveRegistrantionCompletedSuccessfullyHeading(),
				dataProp.getProperty("registrationCompletedSuccessfully"),
				"registration completed successfully page not displayed");

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		dashboardPage = registerPage.registerWithAllFields("Male", dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("password"), dataProp.getProperty("confirmPassword"));
		Assert.assertEquals(registerPage.retrieveRegistrantionCompletedSuccessfullyHeading(),
				dataProp.getProperty("registrationCompletedSuccessfully"),
				"registration completed successfully page not displayed");

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {

		dashboardPage = registerPage.registerWithAllFields("Male", dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), dataProp.getProperty("email"), dataProp.getProperty("password"),
				dataProp.getProperty("confirmPassword"));
		Assert.assertTrue(
				registerPage.retrieveDuplicateEmailAddressWarning()
						.contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning message regarding duplicate email address is not displayed");
	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		registerPage.clickOnRegisterButton();
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("firstNameWarning"),
				dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"),
				dataProp.getProperty("passwordWarning"), dataProp.getProperty("confirmPasswordWarning")));
	}

}
