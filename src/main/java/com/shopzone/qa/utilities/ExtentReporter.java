package com.shopzone.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("MBTS Test Automaiton Result Report");
		sparkReporter.config().setDocumentTitle("MBTS Auotmation Result");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentReport.attachReporter(sparkReporter);

		Properties confiProp = new Properties();
		//File conFigProFile =new File(System.getProperty("user.dir")+"\\scr\\main\\java\\com\\progressional\\qa\\config\\config.properties");
		File conFigProFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\progressional\\qa\\config\\config.properties");

		try
		{
			FileInputStream fisConfigPro =new FileInputStream(conFigProFile);
			confiProp.load(fisConfigPro);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL", confiProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", confiProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email",confiProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password",confiProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		
		return extentReport;
		}
	}
	*/

