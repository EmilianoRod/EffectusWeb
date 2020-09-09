package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamPage {
    public WebDriver driver;


    public TeamPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getOutTeamImages(int i){
        return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div["+i+"]/div[1]/div[1]/div[1]")); //i=1..23
    }

}
