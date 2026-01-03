package com.shopzone.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	DashboardPage dashboardPage;
	WebDriver driver;

	// Objects
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerOption;
	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement loginOption;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public RegisterPage selectRegisterOption() {
		return new RegisterPage(driver);
	}

	public RegisterPage navigateToRegisterPage() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	public LoginPage selectLoginOption() {
		return new LoginPage(driver);
	}

	public LoginPage navigateToLoginPage() {
		loginOption.click();
		return new LoginPage(driver);
	}
}
