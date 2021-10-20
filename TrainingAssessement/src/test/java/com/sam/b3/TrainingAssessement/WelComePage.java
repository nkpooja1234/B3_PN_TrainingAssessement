package com.sam.b3.TrainingAssessement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelComePage {
	
	public WebDriver driver;

	public WelComePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
    By departureCity=By.xpath("//select[@name='fromPort']/option[text()='Boston']");
    By destinationCity=By.xpath("//select[@name='toPort']/option[text()='New York']");
    By buttonName=By.xpath("//body/div[3]/form[1]/div[1]/input[1]");
    
    
    public WebElement AddDepartureCity()
    {
    	return driver.findElement(departureCity);
    }
    public WebElement AddDestinationCity()
    {
    	return driver.findElement(destinationCity);
    }
    public WebElement AddButton()
    {
    	return driver.findElement(buttonName);
    }
    
}
