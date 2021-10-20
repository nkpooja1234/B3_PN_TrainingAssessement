package com.sam.b3.TrainingAssessement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestScenarios extends Base
{
     @Test
	public void TS001() throws Exception
	{
		//Call function for browser Initialization
		BrowserCall();
		//To get URL value from property file
		driver.get(prop.getProperty("URL"));
		//Set default timeout for locating and element in the DOM (10 seconds)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Validate user navigated to a Blaze Demo Page
		Assert.assertEquals(driver.getTitle(), prop.getProperty("WelcomeTitle"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WelComePage home=new WelComePage(driver);
	    //Choose departure city
		home.AddDepartureCity().click();
		//Choose destination city
		home.AddDestinationCity().click();
		//Find Flights
		home.AddButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //Validate user navigated to a Reserve page
		Assert.assertEquals(driver.getTitle(), prop.getProperty("ReserveTitle"));
		System.out.println("Title :" + driver.getTitle());
		ReservePage res=new ReservePage(driver);
		//Validate user Navigated to a Purchase Page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		res.SelectFilght().click();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("PurchaseTitle"));
		System.out.println("Title :" + driver.getTitle());
		vPath="C:\\Users\\00003983\\eclipse-workspace\\TrainingAssessement\\AmazonDataFrameworks.xls";
		//call function to Read excel files using Apache POI
		xlRead(vPath);
		//Purchase flight and fill out form
		for(int i=1;i<xlRows;i++)
		{
		  if(xData[i][1].equalsIgnoreCase("Y"))
		  {
			driver.findElement(By.id("inputName")).sendKeys(xData[i][2]);
			driver.findElement(By.id("creditCardNumber")).sendKeys(xData[i][3]);
			driver.findElement(By.id("nameOnCard")).sendKeys(xData[i][4]);
			if(xData[i][5].equalsIgnoreCase("Yes"))
			{
			   driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
			}
			
				
			
		  }
		}
		//Click purchase flight
		driver.findElement(By.xpath("//body/div[2]/form[1]/div[11]/div[1]/input[1]")).click();
		//Validate user navigated to a confirmation page
		Assert.assertEquals(driver.getTitle(), prop.getProperty("ConfirmationTitle"));
		System.out.println("Title :" + driver.getTitle());
		//To display Amount, Card Number and Expiration
		ConfirmationMeassge msg=new ConfirmationMeassge(driver);
		System.out.println("Amount :" + msg.GetAmount().getText());
		System.out.println("Card Number: "+ msg.GetNumber().getText());
		System.out.println("Expiry Date: "+ msg.GetExpiryDate().getText());
		
		
	}
     //To close the browser
     @AfterTest
 	public void TearDown()
 	{
 		driver.close();
 	}
 	
}
