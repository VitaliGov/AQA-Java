package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ArrearsMTS extends BaseTest {

    @Test
    public void ArrearsTest() {
        String optionText = "Задолженность";
        String[] expectedPlaceholders = {
                "Номер счета на 2073",
                "Сумма",
                "E-mail для отправки чека"
        };

        String accountNumberInputXPath = "//input[@data-mask='account-num-arrears']";
        String sumInputXPath = "//input[@id='arrears-sum']";
        String emailInputXPath = "//input[@id='arrears-email']";

        selectOptionAndCheckPlaceholders(optionText, expectedPlaceholders, accountNumberInputXPath, sumInputXPath, emailInputXPath);
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
