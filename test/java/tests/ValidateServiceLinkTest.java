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

public class ValidateServiceLinkTest extends BaseTest {

    @Test
    public void validateServiceLink() {
        WebElement serviceLinkElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class, 'pay')]//a[contains(@href, '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey')]")));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", serviceLinkElement);

        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).click(serviceLinkElement).keyUp(Keys.CONTROL).build().perform();

        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));

        webDriverWait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        webDriver.close();
        webDriver.switchTo().window(tabs.get(0));
    }
}
