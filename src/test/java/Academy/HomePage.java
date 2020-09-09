package Academy;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

import pageObjects.*;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	WebDriverWait wait;
	public static Logger log =LogManager.getLogger(base.class.getName());
	LandingPage landing;
	CareersPage careers;
	BlogPage blog;
	CalendlyPage calendly;
	TeamPage teamPage;
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		basePageNavigation();
	}

	public void basePageNavigation() throws IOException{
		driver.get(prop.getProperty("url"));
		landing = new LandingPage(driver);
	}
	
    @Test
	public void validateAppNavBar() throws IOException{
		//one is inheritance
		// creating object to that class and invoke methods of it
		//LandingPage landing = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
	    Assert.assertTrue(landing.getNavigationBar().isDisplayed());
	    log.info("Navigation Bar is displayed");
		System.out.println("Test completed");
	    //Assert.assertFalse(false);
		}

	@Test
	public void validateAppTitle() throws IOException{
		//one is inheritance
		// creating object to that class and invoke methods of it
		// landing = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(landing.getTitle().getText(), "High Quality Software Development");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
		}
	
	@Test
	public void validateNavigationBarHome() throws InterruptedException{
		landing.getNavigationBarButtons(1).click();
		Thread.sleep(3000);
		Assert.assertTrue(isVisibleInViewport(landing.getTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}
	
	@Test
	public void validateNavigationBarServices() throws InterruptedException{
		landing.getNavigationBarButtons(2).click();
		Thread.sleep(3000);
		Assert.assertTrue(isVisibleInViewport(landing.getServicesTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}

	@Test
	public void validateNavigationBarWork() throws InterruptedException{
		landing.getNavigationBarButtons(3).click();
		Thread.sleep(6000);
		Assert.assertTrue(isVisibleInViewport(landing.getWorkTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}
	
    @Test
	public void validateNavigationBarCareers() throws InterruptedException{
		landing.getNavigationBarButtons(4).click();
		careers = new CareersPage(driver);
		Thread.sleep(2000);
		Assert.assertTrue(isVisibleInViewport(careers.getCareersTitle()));
		log.info("Successfully validated");
		System.out.println("Test completed");
	}

	@Test
	public void validateUnderlinedNavigationBar() throws InterruptedException {
		Set<Integer> a = new HashSet<Integer>();
		a.addAll(Arrays.asList(new Integer[] {1, 2, 3, 4, 6}));
		for(int i : a) {
			landing.getNavigationBarButtons(i).click();
			Thread.sleep(2000);
			Assert.assertEquals(landing.getNavigationBarButtons(i).getAttribute("class"), "isSelected");
		}
		log.info("Successfully validated");
		System.out.println("Test completed");
	}

	@Test
	public void validateLetsTalkButton() throws InterruptedException {
		Thread.sleep(2000);
		landing.getLetsTalkButton().click();
		Thread.sleep(2000);
		Set<String> handles = landing.driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		landing.driver.switchTo().window(childWindowId);
		calendly = new CalendlyPage(driver);
		Assert.assertTrue(calendly.getCalendar().isDisplayed());
		landing.driver.close();
		landing.driver.switchTo().window(parentWindowId);
		log.info("Successfully validated");
		System.out.println("Test completed");
	}

	@Test
	public void validateOurWorkCarousel() throws InterruptedException {
		landing.getNavigationBarButtons(3).click();
		String[] array = {"Honeypot", "Silbo", "OnPace+", "APunta Taxi", "AskMe", "FPS", "Rivelin"};
		for(int i=0; i<6 ; i++){
			Thread.sleep(2000);
			Assert.assertEquals(landing.getWorkCarouselTitle().getText(), array[i]);
			landing.getWorkCarouselRightButton().click();
		}
		log.info("Successfully validated");
		System.out.println("Test completed");
	}

	@Test
	public void validateTeamImagesDisplayed() throws InterruptedException {
		landing.getNavigationBarButtons(1).click();
		Thread.sleep(2000);
		landing.getMeetOurTeamButton().click();
		teamPage = new TeamPage(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 1 ; i<24 ; i++){
			Assert.assertTrue(teamPage.getOutTeamImages(i).isDisplayed());
			js.executeScript("window.scrollBy(0,220)", "");
		}
		log.info("Successfully validated");
		System.out.println("Test completed");
	}



	@Test
	public void validateNavigationBarContact() throws InterruptedException{
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
	}
	
/*
	public void validateNavigationBarBlog() throws InterruptedException{
		landing.getNavigationBarButtons(5).click();
		Thread.sleep(3000);
		blog = new BlogPage(driver);
		Assert.assertTrue(isVisibleInViewport(blog.getBlogHeader()));
		Assert.assertTrue(isVisibleInViewport(blog.getBlogTitle()));
		Assert.assertTrue(isVisibleInViewport(blog.getBlogSubtitle()));
		blog.driver.navigate().back();
		log.info("Successfully validated");
		System.out.println("Test completed");
	}
	*/
	
	@AfterTest
	public void teardown(){
		driver.close();
	}

}
