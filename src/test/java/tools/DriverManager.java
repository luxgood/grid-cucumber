package tools;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class DriverManager {

    public static final String USERNAME = "ukaszomnicki1";
    public static final String AUTOMATE_KEY = "xKPUxzpMTJCJsDrX4GYU";

    protected WebDriver driver;
    protected URL hubURL;

    protected abstract void createRemoteDriver();
    protected abstract void createLocalDriver();

    public DriverManager setHubHost(String hubHost) throws MalformedURLException {
        this.hubURL = new URL("http://" + hubHost + ":4444/wd/hub");
        return this;
    }

    public DriverManager setHubURLasBrowserstack() {
        try {
            this.hubURL = new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getRemoteDriver() {
        if (null == driver) {
            createRemoteDriver();
        }
        return driver;
    }

    public WebDriver getLocalDriver() {
        if (null == driver) {
            createLocalDriver();
        }
        return driver;
    }

}
