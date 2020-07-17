package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public  WebDriver driver;
	
	private By title=By.xpath("//h1[@class='c0139 c0141']");
	private By subTitle = By.xpath("//h4[@class='c0139 c0142']");
	private By navigationBar = By.xpath("//body//header//div[1]//div[1]//ul[1]");
	private By letsTalkButton = By.xpath("//button[@class='c01210 c01211']");
	private By servicesTitle = By.xpath("//div[@name='services']//div//div//h2");
	private By workTitle = By.xpath("//div[@name='work']//div//div//h1");
	private By careersButton = By.xpath("//a[@id='careers-linkItem']");
	private By contactFormTitle = By.xpath("//body//div[@name='contact']//div//div//div[1]//div[1]//h1[1]");
	private By contactTitle = By.xpath("//body/div[@id='root']/div[@name='contact']/div/div/div[3]/div[1]/h1[1]");
	private By contactNameInput = By.xpath("//input[@id='name']");
	private By contactEmailInput = By.xpath("//input[@id='email']");
	private By contactMessageInput = By.xpath("//textarea[@id='message']");
	private By contactSendButton = By.xpath("//form[@id='contactForm']//div//button");
	private By contactMeetingButton = By.xpath("//div[@name='contact']//div//div//div//div//ul//li//button");
	
	public LandingPage(WebDriver driver){
		// TODO Auto-generated constructor stub
			this.driver=driver;		
	}

	public WebElement getTitle(){
		return driver.findElement(title);
	}
	
	public WebElement getSubTitle(){
		return driver.findElement(subTitle);
	}
	
	public WebElement getNavigationBar(){
		return driver.findElement(navigationBar);
	}
	
	public WebElement getNavigationBarButtons(int i){  // i = 1..6
		return driver.findElement(By.xpath("//body//header//div[1]//div[1]//ul[1]//li[" + i +"]"));
	}
	
	public WebElement letsTalkButton(){
		return driver.findElement(letsTalkButton);
	}
	
	public WebElement getServicesTitle(){
		return driver.findElement(servicesTitle);
	}
	
	public WebElement getWorkTitle(){
		return driver.findElement(workTitle);
	}
	
	public WebElement getCareersButton(){
		return driver.findElement(careersButton);
	}
	
	public WebElement getContactNameInput(){
		return driver.findElement(contactNameInput);
	}
	
	public WebElement getContactFormEmailInput(){
		return driver.findElement(contactEmailInput);
	}

	public WebElement getContactFormMessageInput(){
		return driver.findElement(contactMessageInput);
	}
	
	public WebElement getContactFormTitle(){
		return driver.findElement(contactFormTitle);
	}

	public WebElement getContactFormSendButton(){
		return driver.findElement(contactSendButton);
	}
	
	public WebElement getContactFormMeetingButton(){
		return driver.findElement(contactMeetingButton);
	}
	
	public WebElement getContactFormTitle2(){
		return driver.findElement(contactTitle);
	}
	

}

