package constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constant {

    public static class TimeoutVariable {

        public static final int IMPLICIT_WAIT = 10;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Url {
        public static final String MTS_HOME_PAGE = "https://www.mts.by/";
    }


    public static WebElement waitForElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
