package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InstallmentMTS extends BaseTest {

    @Test
    public void InstallmentTest() {
        String optionText = "Рассрочка";
        String[] expectedPlaceholders = {
                "Номер счета на 44",
                "Сумма",
                "E-mail для отправки чека"
        };

        String accountNumberInputXPath = "//input[@data-mask='account-num-instalment']";
        String sumInputXPath = "//input[@id='internet-sum']";
        String emailInputXPath = "//input[@id='connection-email']";

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
                boolean allPlaceholdersCorrect = true;

                for (int i = 0; i < xpaths.length; i++) {
                    WebElement inputField = driver.findElement(By.xpath(xpaths[i]));
                    String placeholderText = inputField.getAttribute("placeholder");
                    String inputValue = inputField.getAttribute("value");

                    Assert.assertTrue(inputValue.isEmpty(), "Поле '" + placeholderText + "' пустое для опции '" + optionText + "'");

                    boolean isPlaceholderCorrect = placeholderText.equals(expectedPlaceholders[i]);
                    placeholdersOutput.append(" - ").append(placeholderText);
                    if (isPlaceholderCorrect) {
                        placeholdersOutput.append(" - ПРАВИЛЬНО\n");
                    } else {
                        placeholdersOutput.append(" - НЕПРАВИЛЬНО\n");
                        allPlaceholdersCorrect = false;
                    }
                    Assert.assertTrue(isPlaceholderCorrect, "Автонадпись '" + placeholderText + "' верна для опции '" + optionText + "'");
                }

                System.out.println(placeholdersOutput.toString());
                Assert.assertTrue(allPlaceholdersCorrect, "Не все автонадписи корректны для опции '" + optionText + "'");
                break;
            }
        }
    }
}