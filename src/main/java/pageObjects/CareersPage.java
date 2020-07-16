package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
	
	public WebDriver driver;
	
	private By careersTitle = By.xpath("//div[@name='careers']//h2");

	public CareersPage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
	}
	
	public WebElement getCareersTitle(){
		return driver.findElement(careersTitle);
	}

}
