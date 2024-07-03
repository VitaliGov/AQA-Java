package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ValidateFormTest extends BaseTest {

    @Test
    public void validateFormFunctionality() {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        WebElement paySection = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.pay")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", paySection);

        WebElement serviceDropdown = paySection.findElement(By.cssSelector(".select__header"));
        serviceDropdown.click();

        String optionText = "Услуги связи";

        WebElement serviceOption = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select__now' and text()='" + optionText + "']")));
        serviceOption.click();

        String phoneInputXPath = "//input[@id='connection-phone']";
        WebElement phoneInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(phoneInputXPath)));
        phoneInput.sendKeys("297777777");

        String sumInputXPath = "//input[@id='connection-sum']";
        WebElement sumInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sumInputXPath)));
        sumInput.clear();
        sumInput.sendKeys("10");

        WebElement continueButton = paySection.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
    }
}
