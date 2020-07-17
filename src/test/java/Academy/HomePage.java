package Academy;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pages.Recaptcha2Page;
import resources.base;
import pageObjects.CareersPage;

public class HomePage extends base{
	public WebDriver driver;
	WebDriverWait wait;
	public static Logger log =LogManager.getLogger(base.class.getName());
	LandingPage landing;
	CareersPage careers;
    Recaptcha2Page recaptcha2Page;

	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void basePageNavigation() throws IOException{
		 driver.get(prop.getProperty("url"));
		 recaptcha2Page = new Recaptcha2Page(driver);
		 landing = new LandingPage(driver);

		}
	
	/*
	public void validateAppNavBar() throws IOException{
		//one is inheritance
		// creating object to that class and invoke methods of it
		//LandingPage landing = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
	    Assert.assertTrue(landing.getNavigationBar().isDisplayed());
	    log.info("Navigation Bar is displayed");
		System.out.println("Test completed");
	    //Assert.assertFalse(false);
		}*/

	/*
	public void validateAppTitle() throws IOException{
		//one is inheritance
		// creating object to that class and invoke methods of it
		// landing = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(landing.getTitle().getText(), "High Quality Software Development");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
		}
	

	public void validateNavigationBarHome() throws InterruptedException{
		landing.getNavigationBarButtons(1).click();
		Thread.sleep(3000);
		Assert.assertTrue(isVisibleInViewport(landing.getTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}
	*/
	
	/*public void validateNavigationBarServices() throws InterruptedException{
		landing.getNavigationBarButtons(2).click();
		Thread.sleep(3000);
		Assert.assertTrue(isVisibleInViewport(landing.getServicesTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}*/
	
	
	/*public void validateNavigationBarWork() throws InterruptedException{
		landing.getNavigationBarButtons(3).click();
		Thread.sleep(3000);
		Assert.assertTrue(isVisibleInViewport(landing.getWorkTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}*/
	
	
	/*public void validateNavigationBarCareers() throws InterruptedException{
		landing.getNavigationBarButtons(4).click();
		careers = new CareersPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(isVisibleInViewport(careers.getCareersTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}*/
	

	/*public void validateNavigationBarContact() throws InterruptedException{
		landing.getNavigationBarButtons(6).click();
		Thread.sleep(2000);
		Assert.assertTrue(isVisibleInViewport(landing.getCareersButton()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormEmailInput()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormMeetingButton()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormMessageInput()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormSendButton()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormTitle()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactFormTitle2()));
		Assert.assertTrue(isVisibleInViewport(landing.getContactNameInput()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}*/
	
	@Test(dataProvider = "getData")
	public void testContactForm(String name, String email, String message) throws InterruptedException, IOException {
		landing.getNavigationBarButtons(6).click();
		Thread.sleep(3000);
		
		
		//landing.getContactNameInput().sendKeys(name);
		//landing.getContactFormEmailInput().sendKeys(email);
		//landing.getContactFormMessageInput().sendKeys(message);
		recaptcha2Page
        .setResponseForRecaptchaWithSelenium();
	}
	

	
	
	@AfterTest
	public void teardown(){
		driver.close();	
	}
	
	@DataProvider
	
	public Object[][] getData(){
		// Row stands for how many different data types test should run
	   //coloumn stands for how many values per each test		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Prueba1";
		data[0][1] = "erodriguez@effectussofware.com";
		data[0][2] = "Message";
		
		
		return data;
	}
}
