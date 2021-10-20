package com.sam.b3.TrainingAssessement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationMeassge {
	public WebDriver driver;

	public ConfirmationMeassge(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By amount=By.xpath("//tbody/tr[3]/td[2]");
	By cardNumber=By.xpath("//tbody/tr[4]/td[2]");
	By expirationDate=By.xpath("//tbody/tr[5]/td[2]");
	

	public WebElement GetAmount()
    {
    	return driver.findElement(amount);
    }
	public WebElement GetNumber()
    {
    	return driver.findElement(cardNumber);
    }
	public WebElement GetExpiryDate()
    {
    	return driver.findElement(expirationDate);
    }

}
