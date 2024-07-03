package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\IdeaProjects\\Lesson_15vvv\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://mts.by");
        webDriverWait = new WebDriverWait(webDriver, 20);

        WebElement cookieAgreeButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        if (cookieAgreeButton != null) {
            cookieAgreeButton.click();
        }

        WebElement paySectionElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.pay")));
        if (paySectionElement != null) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", paySectionElement);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
