package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyBlockTitleTest extends BaseTest {

    @Test
    public void verifyBlockTitle() {
        WebElement blockTitleElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class, 'pay')]//h2")));
        String actualBlockTitle = blockTitleElement.getText().replace("\n", "").replace("\r", "").trim().replace("без комиссии", " без комиссии");
        Assert.assertEquals(actualBlockTitle, "Онлайн пополнение без комиссии");
    }
}
