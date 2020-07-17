package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Recaptcha2Page;
import resources.base;

import java.io.IOException;

public class Recaptcha2Test extends base {
    private Recaptcha2Page recaptcha2Page;

    @BeforeTest
    public void init() {
        recaptcha2Page = new Recaptcha2Page(driver);
    }

    @Test
    public void googleRecaptcha2DemoTest() throws InterruptedException, IOException {
        recaptcha2Page
                .setResponseForRecaptchaWithSelenium();
    }

}
