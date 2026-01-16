package com.shopzone.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	LoginPage loginPage;
	WebDriver driver;

	// Objects
	@FindBy(xpath = "//input[@id='Email']")
	WebElement EmailField;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement rememberMeCheckBox;
	@FindBy(xpath = "//a[normalize-space()='Forgot password?']")
	WebElement forgotPasswordLink;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	@FindBy(xpath = "//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")
	WebElement emailPasswordNoMatchWarning;
	@FindBy(xpath = "(//li[normalize-space()='No customer account found'])[1]")
	WebElement noCustomerAccountFoundWarning;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Generic reusable method (ONLY ONCE)
	public String getWarningText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed() ? element.getText().trim() : "";
		} catch (Exception e) {
			System.out.println("Warning not displayed: " + element);
			return "";
		}
	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		return getWarningText(emailPasswordNoMatchWarning);
	}

	public String retrieveNoCustomerAccountFoundWarning() {
		return getWarningText(noCustomerAccountFoundWarning);
	}

	public void enterEmailAddress(String emailText) {
		EmailField.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);

	}

	public LoginPage clickOnLoginButton() {

		loginButton.click();
		return new LoginPage(driver);

	}

	public LoginPage login(String emailText, String passwordText) {
		EmailField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new LoginPage(driver);

	}
}
