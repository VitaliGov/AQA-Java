package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBlockTitleTest extends BaseTest {

    @Test
    public void checkBlockTitle() {
        try {
            // Найти заголовок блока с использованием XPath
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class, 'pay')]//h2")));
            String actualTitle = blockTitle.getText().replace("\n", "").replace("\r", "").trim().replace("без комиссии", " без комиссии");
            System.out.println("Фактический заголовок блока: " + actualTitle);
            Assert.assertEquals(actualTitle, "Онлайн пополнение без комиссии");
        } catch (Exception e) {
            System.out.println("Ошибка при проверке заголовка блока: " + e.getMessage());
        }
    }
}
