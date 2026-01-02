package com.shopzone.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	RegisterPage registerPage;
	DashboardPage dashboardPage;
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstNameField;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastNameField;
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailField;
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordField;
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordField;
	@FindBy(xpath="//input[@id='register-button']")
	WebElement registerButton;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
