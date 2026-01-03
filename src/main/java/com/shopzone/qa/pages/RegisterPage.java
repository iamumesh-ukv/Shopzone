package com.shopzone.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	DashboardPage dashboardPage;
	WebDriver driver;

	// Objects
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement maleRadioButton;
	@FindBy(xpath = "//input[@id='gender-female']")
	WebElement femaleRadioButton;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameField;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameField;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmPasswordField;
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement registerButton;
	// validation objects
	@FindBy(xpath = "//span[@data-valmsg-for='FirstName']")
	WebElement firstNameWarning;
	@FindBy(xpath = "//span[@for='LastName']")
	WebElement lastNameWarning;
	@FindBy(xpath = "//span[@for='Email']")
	WebElement emailWarning;
	@FindBy(xpath = "//span[@for='Email']")
	WebElement invalidEmailAddressWarning;
	@FindBy(xpath = "//li[normalize-space()='The specified email already exists']")
	WebElement duplicateEmailAddressWarning;

	@FindBy(xpath = "//span[@for='Password']")
	WebElement passwordWarning;
	@FindBy(xpath = "//span[@for='ConfirmPassword']")
	WebElement passwordNotMatchingWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Generic reusable method (ONLY ONCE)
	public String getWarningText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed() ? element.getText().trim() : "";
		} catch (Exception e) {
			System.out.println("Warning not displayed: " + element);
			return "";
		}
	}

	public String retrieveFirstNameWarning() {
		return getWarningText(firstNameWarning);
	}

	// Last Name warning
	public String retrieveLastNameWarning() {
		return getWarningText(lastNameWarning);
	}

	// Email warning
	public String retrieveEmailWarning() {
		return getWarningText(emailWarning);
	}

//	public String retrieveInvalidEmailAddressWarning() {
//		return getWarningText(invalidEmailAddressWarning);
//	}
	public String retrieveDuplicateEmailAddressWarning() {
		return getWarningText(duplicateEmailAddressWarning);
	}

	// Password empty warning
	public String retrievePasswordWarning() {
		return getWarningText(passwordWarning);
	}

	// Password mismatch warning
	public String retrievePasswordNotMatchingWarning() {
		return getWarningText(passwordNotMatchingWarning);
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleRadioButton.click();
		} else if (gender.equalsIgnoreCase("female")) {
			femaleRadioButton.click();
		}
	}

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmailAddress(String emailAddressText) {
		emailField.sendKeys(emailAddressText);
	}

	public void enterPassword(String firstNameText) {
		passwordField.sendKeys(firstNameText);
	}

	public void enterConfirmPassword(String lastNameText) {
		confirmPasswordField.sendKeys(lastNameText);
	}

	public void clickOnRegisterButton() {
		registerButton.click();
	}

	public DashboardPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText,
			String passwordText, String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		registerButton.click();
		return new DashboardPage(driver);
	}

	public DashboardPage registerWithAllFields(String gender, String firstNameText, String lastNameText,
			String emailText, String passwordText, String confirmPasswordText) {
		selectGender(gender);
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		registerButton.click();
		return new DashboardPage(driver);
	}

	public boolean displayStatusOfWarningMessages(String expectedFirstNameWarning, String expectedLastNameWarning,
			String expectedEmailWarning, String expectedPasswordWarning, String expectedConfirmPasswordWarning) {

		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarning);
		boolean confirmPasswordWarningStatus = passwordNotMatchingWarning.getText()
				.equals(expectedConfirmPasswordWarning);
		return firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && passwordWarningStatus
				&& confirmPasswordWarningStatus;
	}

}
