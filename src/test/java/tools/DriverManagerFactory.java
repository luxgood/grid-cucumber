package tools;

import java.util.NoSuchElementException;

public class DriverManagerFactory {

    private DriverManager driverManager;
    private String browser;

    public DriverManagerFactory(String browser){
        this.browser = browser;
    }

    public DriverManager getManager() {

        if(browser.equalsIgnoreCase("chrome")){
            driverManager = new ChromeDriverManager();
        }else if (browser.equalsIgnoreCase("firefox")){
            driverManager = new FirefoxDriverManager();
        }else if (browser.equalsIgnoreCase("opera")){
            driverManager = new OperaDriverManager();
        }else if ( browser.equalsIgnoreCase("edge")){
            driverManager = new EdgeDriverManager();
        }else{
            throw new NoSuchElementException("Wrong driver chosen: " + browser);
        }

        return driverManager;

    }

}
