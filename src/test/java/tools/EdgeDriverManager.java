package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverManager extends DriverManager{

    @Override
    protected void createRemoteDriver() {
        EdgeOptions options = new EdgeOptions();
        driver = new RemoteWebDriver(hubURL, options);
    }

    @Override
    protected void createLocalDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
    }
}
