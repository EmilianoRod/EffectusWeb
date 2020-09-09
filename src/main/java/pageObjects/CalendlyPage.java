package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendlyPage {
    public WebDriver driver;

    private By calendar = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");

    public CalendlyPage(WebDriver driver){
        // TODO Auto-generated constructor stub
        this.driver=driver;
    }

    public WebElement getCalendar(){
        return driver.findElement(calendar);
    }
}
