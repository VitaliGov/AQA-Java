package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckMoreAboutServiceLinkTest extends BaseTest {

    @Test
    public void checkMoreAboutServiceLink() {
        try {
            WebElement moreAboutServiceLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class, 'pay')]//a[contains(@href, '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey')]")));
            System.out.println("Ссылка 'Подробнее о сервисе' найдена");

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreAboutServiceLink);

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).click(moreAboutServiceLink).keyUp(Keys.CONTROL).build().perform();
            System.out.println("Ссылка 'Подробнее о сервисе' открыта в новой вкладке");

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            wait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            System.out.println("Проверка перехода по ссылке 'Подробнее о сервисе' прошла успешно");

            driver.close();
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            System.out.println("Ошибка при проверке ссылки 'Подробнее о сервисе': " + e.getMessage());
        }
    }
}
