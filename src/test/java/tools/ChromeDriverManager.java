package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverManager extends DriverManager{

    private ChromeOptions options = new ChromeOptions();

    @Override
    protected void createRemoteDriver() {
        driver = new RemoteWebDriver(hubURL, options);
    }

    @Override
    protected void createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
}
