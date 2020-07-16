package resources;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.DeathByCaptcha.SocketClient;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException{
	
 prop= new Properties();
 //System.getProperty("user.dir")
 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");

prop.load(fis);
//mvn test -Dbrowser=chrome

//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
System.out.println(browserName);

if(browserName.contains("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//resources//chromedriver 7");
	 ChromeOptions options =new ChromeOptions();
	 if(browserName.contains("headless")){
	  options.addArguments("headless");
	 }
driver= new ChromeDriver(options);
		//execute in chrome driver
	
}else if (browserName.equals("firefox")){
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
    }

public Boolean isVisibleInViewport(WebElement element) {
	  WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

	  return (Boolean)((JavascriptExecutor)driver).executeScript(
	      "var elem = arguments[0],                 " +
	      "  box = elem.getBoundingClientRect(),    " +
	      "  cx = box.left + box.width / 2,         " +
	      "  cy = box.top + box.height / 2,         " +
	      "  e = document.elementFromPoint(cx, cy); " +
	      "for (; e; e = e.parentElement) {         " +
	      "  if (e === elem)                        " +
	      "    return true;                         " +
	      "}                                        " +
	      "return false;                            "
	      , element);
	}

public void verifyCaptcha(WebDriver driver) throws IOException{
	
	
	byte[] arrScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
	WebElement cap = driver.findElement(By.id("rc-anchor-container"));
	Dimension capDimension = cap.getSize();
	Point capLocation = cap.getLocation();
	BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	ImageIO.write(imgCap, "png", os);
	
	SocketClient client = new SocketClient("user", "password");
	Captcha res = client.decode(new ByteArrayInputStream(os.toByteArray()));
}

}