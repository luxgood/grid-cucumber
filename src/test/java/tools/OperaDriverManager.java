package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperaDriverManager extends DriverManager{

    @Override
    protected void createRemoteDriver() {
        //DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
        OperaOptions options = new OperaOptions();
        options.setCapability("browserName", BrowserType.OPERA_BLINK);
        driver = new RemoteWebDriver(hubURL, options);
    }

    @Override
    protected void createLocalDriver() {
        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();
        driver = new OperaDriver(options);
    }
}
