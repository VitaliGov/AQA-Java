package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement paySection;
    protected WebElement dropdown;
    protected JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\IdeaProjects\\Lesson_16\\chromedriver-win64\\chromedriver.exe");
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

            paySection = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.pay")));
            Assert.assertNotNull(paySection, "Блок 'Онлайн пополнение без комиссии' найден");
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paySection);

            dropdown = paySection.findElement(By.tagName("select"));
            js = (JavascriptExecutor) driver;

        } catch (Exception e) {
            System.out.println("Ошибка при настройке теста: " + e.getMessage());
        }
    }

    protected void selectOptionAndCheckPlaceholders(String optionText, String... expectedPlaceholders) {
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                System.out.println("Выбор опции: " + optionText);
                js.executeScript("arguments[0].click();", dropdown);
                js.executeScript("arguments[0].click();", option);

                List<WebElement> inputFields = paySection.findElements(By.cssSelector("input[type='text'], input[type='number']"));

                for (WebElement inputField : inputFields) {
                    String placeholderText = inputField.getAttribute("placeholder");
                    String inputValue = inputField.getAttribute("value");

                    Assert.assertTrue(inputValue.isEmpty(), "Поле '" + placeholderText + "' пустое для опции '" + optionText + "'");
                    System.out.println("Placeholder text: " + placeholderText + " for option: " + optionText + " is empty and correct.");

                    boolean isPlaceholderCorrect = false;
                    for (String expectedPlaceholder : expectedPlaceholders) {
                        if (placeholderText.equals(expectedPlaceholder)) {
                            isPlaceholderCorrect = true;
                            break;
                        }
                    }
                    Assert.assertTrue(isPlaceholderCorrect, "Автонадпись '" + placeholderText + "' верна для опции '" + optionText + "'");
                    if (isPlaceholderCorrect) {
                        System.out.println("Автонадпись '" + placeholderText + "' верна для опции '" + optionText + "'");
                    } else {
                        System.out.println("Автонадпись '" + placeholderText + "' НЕ соответствует для опции '" + optionText + "'");
                    }
                }
                break;
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
