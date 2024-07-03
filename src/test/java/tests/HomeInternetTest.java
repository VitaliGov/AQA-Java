package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeInternetTest extends BaseTest {

    @Test
    public void testSwitchToHomeInternetAndCheckPlaceholders() {
        try {
            selectOptionAndCheckPlaceholders("домашний интернет", "Номер абонента", "Сумма", "E-mail для отправки чека");

            WebElement phoneField = driver.findElement(By.id("internet-phone"));
            WebElement amountField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));

            String phonePlaceholder = phoneField.getAttribute("placeholder");
            String amountPlaceholder = amountField.getAttribute("placeholder");
            String emailPlaceholder = emailField.getAttribute("placeholder");

            Assert.assertEquals(phonePlaceholder, "Номер абонента", "Placeholder для поля номера абонента верен");
            Assert.assertEquals(amountPlaceholder, "Сумма", "Placeholder для поля суммы верен");
            Assert.assertEquals(emailPlaceholder, "E-mail для отправки чека", "Placeholder для поля e-mail верен");

            System.out.println("Все надписи в незаполненных полях проверены и верны.");
            System.out.println("Проверенные надписи:");
            System.out.println(" - Номер абонента: " + phonePlaceholder);
            System.out.println(" - Сумма: " + amountPlaceholder);
            System.out.println(" - E-mail для отправки чека: " + emailPlaceholder);

        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста: " + e.getMessage());
        }
    }
}
