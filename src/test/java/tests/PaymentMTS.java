package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentMTS extends BaseTest {

    @Test
    public void verifyCommunicationServicesTab() {
        String optionText = "Услуги связи";
        String phoneInputXPath = "//input[@id='connection-phone']";
        String sumInputXPath = "//input[@id='connection-sum']";

        selectOptionAndFillFields(optionText, phoneInputXPath, sumInputXPath);
        interactWithPopup();
    }

    protected void selectOptionAndFillFields(String optionText, String phoneInputXPath, String sumInputXPath) {
        try {
            WebElement paySection = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.pay")));
            js.executeScript("arguments[0].scrollIntoView(true);", paySection);

            WebElement serviceDropdown = paySection.findElement(By.cssSelector(".select__header"));
            serviceDropdown.click();

            WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select__now' and text()='" + optionText + "']")));
            serviceOption.click();

            WebElement phoneInput = driver.findElement(By.xpath(phoneInputXPath));
            phoneInput.sendKeys("297777777");

            WebElement sumInput = driver.findElement(By.xpath(sumInputXPath));
            sumInput.sendKeys("2");

            WebElement continueButton = paySection.findElement(By.cssSelector("button[type='submit']"));
            continueButton.click();

        } catch (Exception e) {
            Assert.fail("Ошибка при выполнении теста: " + e.getMessage());
        }
    }

    protected void interactWithPopup() {
        try {
            WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
            driver.switchTo().frame(iframeElement);

            WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pay-description__cost span")));
            String amountText = amountElement.getText();
            Assert.assertEquals(amountText, "2.00 BYN", "Сумма отображается некорректно.");

            WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оплатить  2.00 BYN')]")));
            String payButtonText = payButton.getText().trim();
            Assert.assertEquals(payButtonText, "Оплатить 2.00 BYN", "Сумма на кнопке отображается некорректно.");

            WebElement phoneNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pay-description__text span")));
            String phoneNumberText = phoneNumberElement.getText();
            Assert.assertTrue(phoneNumberText.contains("Номер:375297777777"), "Номер телефона отображается некорректно.");

            WebElement cardNumberLabel = driver.findElement(By.cssSelector("div.content.ng-tns-c46-1 label"));
            Assert.assertEquals(cardNumberLabel.getText(), "Номер карты", "Текст для поля 'Номер карты' отображается некорректно.");

            WebElement expirationDateLabel = driver.findElement(By.cssSelector("div.content.ng-tns-c46-4 label"));
            Assert.assertEquals(expirationDateLabel.getText(), "Срок действия", "Текст для поля 'Срок действия' отображается некорректно.");

            WebElement cvcLabel = driver.findElement(By.cssSelector("div.content.ng-tns-c46-5 label"));
            Assert.assertEquals(cvcLabel.getText(), "CVC", "Текст для поля 'CVC' отображается некорректно.");

            WebElement cardholderNameLabel = driver.findElement(By.cssSelector("div.content.ng-tns-c46-3 label"));
            Assert.assertEquals(cardholderNameLabel.getText(), "Имя держателя (как на карте)", "Текст для поля 'Имя держателя (как на карте)' отображается некорректно.");

            WebElement mastercardIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
            WebElement visaIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
            WebElement belkartIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
            WebElement mirIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
            WebElement yandexPayButton = driver.findElement(By.cssSelector("div#yandex-button button[aria-label='Yandex Pay']"));
            WebElement googlePayButton = driver.findElement(By.cssSelector("button[aria-label='Google Pay']"));

            Assert.assertTrue(mastercardIcon.isDisplayed(), "Иконка MasterCard не отображается.");
            Assert.assertTrue(visaIcon.isDisplayed(), "Иконка Visa не отображается.");
            Assert.assertTrue(belkartIcon.isDisplayed(), "Иконка Белкарт не отображается.");
            Assert.assertTrue(mirIcon.isDisplayed(), "Иконка Мир не отображается.");
            Assert.assertTrue(yandexPayButton.isDisplayed(), "Кнопка Yandex Pay не отображается.");
            Assert.assertTrue(googlePayButton.isDisplayed(), "Кнопка Google Pay не отображается.");

            WebDriverWait animatedIconWait = new WebDriverWait(driver, 10);
            WebElement animatedMirIcon = animatedIconWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'cards-brands_random')]//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']")));
            WebElement animatedMaestroIcon = animatedIconWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'cards-brands_random')]//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")));

            Assert.assertTrue(animatedMirIcon.isDisplayed(), "Анимационная иконка Мир не отображается.");
            Assert.assertTrue(animatedMaestroIcon.isDisplayed(), "Анимационная иконка Maestro не отображается.");

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            Assert.fail("Ошибка при взаимодействии с всплывающим окном: " + e.getMessage());
        }
    }
}
