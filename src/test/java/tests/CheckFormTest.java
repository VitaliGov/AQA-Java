package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckFormTest extends BaseTest {

    @Test
    public void checkFormFunctionality() {
        try {

            WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='services']")));
            serviceOption.click();
            System.out.println("Вариант 'Услуги связи' выбран");

            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone-number")));
            phoneNumberField.sendKeys("297777777");
            System.out.println("Номер телефона введен");

            WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-amount")));

            amountField.clear();
            amountField.sendKeys("-100");
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue-button")));
            continueButton.click();
            WebElement amountError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount-error")));
            Assert.assertEquals(amountError.getText(), "Недопустимое значение суммы");
            System.out.println("Проверка отрицательного значения суммы прошла успешно");

            amountField.clear();
            amountField.sendKeys("1");
            continueButton.click();
            amountError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount-error")));
            Assert.assertEquals(amountError.getText(), "Минимальная сумма оплаты - 10");
            System.out.println("Проверка минимального значения суммы прошла успешно");

            amountField.clear();
            amountField.sendKeys("1000000");
            continueButton.click();
            amountError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount-error")));
            Assert.assertEquals(amountError.getText(), "Максимальная сумма оплаты - 100000");
            System.out.println("Проверка максимального значения суммы прошла успешно");

            amountField.clear();
            amountField.sendKeys("abc");
            continueButton.click();
            amountError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount-error")));
            Assert.assertEquals(amountError.getText(), "Недопустимые символы в поле суммы");
            System.out.println("Проверка недопустимых символов в сумме прошла успешно");

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

            emailField.clear();
            emailField.sendKeys("test@.com");
            continueButton.click();
            WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-error")));
            Assert.assertEquals(emailError.getText(), "Недопустимый электронный адрес");
            System.out.println("Проверка недопустимых символов в электронном адресе прошла успешно");

            emailField.clear();
            emailField.sendKeys("");
            continueButton.click();
            emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-error")));
            Assert.assertEquals(emailError.getText(), "Электронный адрес не может быть пустым");
            System.out.println("Проверка отсутствия символов в электронном адресе прошла успешно");

            emailField.clear();
            emailField.sendKeys("test@example.com");
            amountField.clear();
            amountField.sendKeys("50");
            continueButton.click();

            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
            Assert.assertEquals(successMessage.getText(), "Оплата успешно выполнена");
            System.out.println("Проверка формы прошла успешно");
        } catch (Exception e) {
            System.out.println("Ошибка при проверке формы: " + e.getMessage());
        }
    }
}
