package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	
	public WebDriver driver;
	
	private By blogHeader = By.xpath("//header[@class='header']");
	private By blogTitle = By.xpath("//h1[@class='custom']");
	private By blogSubtitle = By.xpath("//body/div/div/div/div/div/p[1]");
	

	public BlogPage(WebDriver driver) {
		// TODO Auto-generated method stub
        this.driver = driver;
	}
	
	public WebElement getBlogHeader(){
		return driver.findElement(blogHeader);
	}
	
	public WebElement getBlogTitle(){
		return driver.findElement(blogTitle);
	}
	
	public WebElement getBlogSubtitle(){
		return driver.findElement(blogSubtitle);
	}

}
