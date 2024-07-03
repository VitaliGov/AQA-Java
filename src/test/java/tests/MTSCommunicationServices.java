package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MTSCommunicationServices extends BaseTest {

    @Test
    public void ComServicesTest() {
        String optionText = "Услуги связи";
        String[] expectedPlaceholders = {
                "Номер телефона",
                "Сумма",
                "E-mail для отправки чека"
        };

        String phoneInputXPath = "//input[@id='connection-phone']";
        String sumInputXPath = "//input[@id='connection-sum']";
        String emailInputXPath = "//input[@id='connection-email']";

        selectOptionAndCheckPlaceholders(optionText, expectedPlaceholders, phoneInputXPath, sumInputXPath, emailInputXPath);
    }

    protected void selectOptionAndCheckPlaceholders(String optionText, String[] expectedPlaceholders, String... xpaths) {
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                System.out.println("Выбор опции: " + optionText);
                js.executeScript("arguments[0].click();", dropdown);
                js.executeScript("arguments[0].click();", option);

                StringBuilder placeholdersOutput = new StringBuilder("Проверенные надписи:\n");

                for (int i = 0; i < xpaths.length; i++) {
                    WebElement inputField = driver.findElement(By.xpath(xpaths[i]));
                    String placeholderText = inputField.getAttribute("placeholder");
                    String inputValue = inputField.getAttribute("value");

                    Assert.assertTrue(inputValue.isEmpty(), "Поле '" + placeholderText + "' пустое для опции '" + optionText + "'");

                    boolean isPlaceholderCorrect = placeholderText.equals(expectedPlaceholders[i]);
                    if (isPlaceholderCorrect) {
                        placeholdersOutput.append(" - ").append(placeholderText).append(" - ПРАВИЛЬНО\n");
                    } else {
                        placeholdersOutput.append(" - ").append(placeholderText).append(" - НЕПРАВИЛЬНО\n");
                    }
                    Assert.assertTrue(isPlaceholderCorrect, "Автонадпись '" + placeholderText + "' верна для опции '" + optionText + "'");
                }

                System.out.println(placeholdersOutput.toString());
                break;
            }
        }
    }
}