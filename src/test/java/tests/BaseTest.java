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
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\IdeaProjects\\Lesson_15\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        wait = new WebDriverWait(driver, 20);

        try {

            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            if (acceptCookiesButton != null) {
                System.out.println("Кнопка 'Принять' найдена");
                acceptCookiesButton.click();
                System.out.println("Кнопка 'Принять' нажата");
            } else {
                System.out.println("Кнопка 'Принять' не найдена");
            }


            WebElement paySection = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.pay")));
            if (paySection != null) {
                System.out.println("Блок 'Онлайн пополнение без комиссии' найден");
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paySection);
            } else {
                System.out.println("Блок 'Онлайн пополнение без комиссии' не найден");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при настройке теста: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
