package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tools.DriverManagerFactory;
import tools.DriverType;

import java.net.MalformedURLException;

public class BaseTest {

  protected WebDriver driver;

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
    this.driver.quit();
  }
}
