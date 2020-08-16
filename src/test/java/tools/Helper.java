package tools;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Helper {

    public static void typeIn(WebElement element, String text){
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
        }
    }

}
