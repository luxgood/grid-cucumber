package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverManager extends DriverManager{

    @Override
    protected void createRemoteDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new RemoteWebDriver(hubURL, options);
    }

    @Override
    protected void createLocalDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}
