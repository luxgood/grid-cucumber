package steps;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java8.Pl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.DriverManagerFactory;
import tools.DriverType;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BasicSteps implements Pl {

    WebDriver driver;

    @Before
    public void setupDriver() throws MalformedURLException {
        String hub_host = System.getProperty("hub_host", "localhost");
        String hub_driver = System.getProperty("hub_driver", String.valueOf(DriverType.CHROME));

        System.out.println("setupDriver");

        this.driver =
                new DriverManagerFactory(hub_driver)
                        .getManager()
                        .setHubHost(hub_host) // .getLocalDriver();
                        .getRemoteDriver();
    }

    @After
    public void quitDriver() {
        System.out.println("quitDriver");
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }

    public BasicSteps() {
    System.out.println("Basic steps");

        Gdy("^użytkownik wpisze adres$", () -> {

            driver.get("https://www.warhammer-community.com/");
        });

        Wtedy("^zobaczy logo warhammer-community$", () -> {
            WebElement logo = driver.findElement(By.cssSelector(".site-nav__logo-img"));
            Assert.assertTrue("Logo nie jest widoczne!", logo.isDisplayed());
        });
    }
}
