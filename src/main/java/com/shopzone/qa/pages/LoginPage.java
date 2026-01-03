package com.shopzone.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
