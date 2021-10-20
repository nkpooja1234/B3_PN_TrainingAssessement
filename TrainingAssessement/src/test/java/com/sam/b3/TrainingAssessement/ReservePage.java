package com.sam.b3.TrainingAssessement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservePage {
	
	public WebDriver driver;

	public ReservePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By chooseFlight=By.xpath("//tbody/tr[2]/td[1]/input[1]");
	
	public WebElement SelectFilght()
    {
    	return driver.findElement(chooseFlight);
    }

}
