package pages.mts_home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    private final By cookieBtn = By.id("cookie-agree");
    private final By paySection = By.cssSelector("section.pay");

    // Locators for "Услуги связи"
    private final By servicesTab = By.xpath("//*[@id='pay']/option[1]");
    private final By phoneInput = By.cssSelector("input#connection-phone");
    private final By sumInput = By.cssSelector("input#connection-sum");
    private final By emailInput = By.cssSelector("input#connection-email");
    private final By continueButton = By.xpath("//*[@id='pay-connection']/button");

    // Locators for "Домашний интернет"
    private final By homeInternetTab = By.xpath("//*[@id='pay']/option[2]");
    private final By internetPhoneInput = By.id("internet-phone");
    private final By internetSumInput = By.xpath("//input[@placeholder='Сумма']");
    private final By internetEmailInput = By.xpath("//input[@placeholder='E-mail для отправки чека']");

    // Locators for "Рассрочка"
    private final By instalmentTab = By.xpath("//*[@id='pay']/option[3]");
    private final By instalmentAccountNumberInput = By.xpath("//input[@data-mask='account-num-instalment']");
    private final By instalmentSumInput = By.xpath("//input[@id='internet-sum']");
    private final By instalmentEmailInput = By.xpath("//input[@id='connection-email']");

    // Locators for "Задолженность"
    private final By arrearsTab = By.xpath("//*[@id='pay']/option[4]");
    private final By accountNumberInput = By.xpath("//input[@data-mask='account-num-arrears']");
    private final By arrearsSumInput = By.xpath("//input[@id='arrears-sum']");
    private final By arrearsEmailInput = By.xpath("//input[@id='arrears-email']");

    public MtsHomePage checkBtn() {
        WebElement cookieButton = driver.findElement(cookieBtn);

        // Прокручиваем страницу к блоку "Онлайн оплата без комиссии" и переходим на него
        WebElement paySectionElement = driver.findElement(paySection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", paySectionElement);
        paySectionElement.click();

        // Нажимаем на кнопку принятия cookie (если это необходимо)
        if (cookieButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookieButton);
        }

        return this;
    }

    public MtsHomePage findText() {
        driver.findElement(paySection);
        return this;
    }

    public MtsHomePage selectDropdownOption(String optionText) {
        WebElement dropdownElement = driver.findElement(By.tagName("select"));
        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));

        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public MtsHomePage checkPlaceholdersForCommunicationServices() {
        WebElement phoneInputElement = driver.findElement(phoneInput);
        String actualPhonePlaceholder = phoneInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualPhonePlaceholder, "Номер телефона", "Phone placeholder text doesn't match!");

        WebElement sumInputElement = driver.findElement(sumInput);
        String actualSumPlaceholder = sumInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualSumPlaceholder, "Сумма", "Sum placeholder text doesn't match!");

        WebElement emailInputElement = driver.findElement(emailInput);
        String actualEmailPlaceholder = emailInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualEmailPlaceholder, "E-mail для отправки чека", "Email placeholder text doesn't match!");

        return this;
    }

    public MtsHomePage checkPlaceholdersForHomeInternet() {
        WebElement tabElement = driver.findElement(homeInternetTab);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabElement);

        WebElement phoneField = driver.findElement(internetPhoneInput);
        String actualPhonePlaceholder = phoneField.getAttribute("placeholder");
        Assert.assertEquals(actualPhonePlaceholder, "Номер абонента", "Phone placeholder text doesn't match!");

        WebElement sumField = driver.findElement(internetSumInput);
        String actualSumPlaceholder = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumPlaceholder, "Сумма", "Sum placeholder text doesn't match!");

        WebElement emailField = driver.findElement(internetEmailInput);
        String actualEmailPlaceholder = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailPlaceholder, "E-mail для отправки чека", "Email placeholder text doesn't match!");

        return this;
    }

    public MtsHomePage checkPlaceholdersForInstalment() {
        WebElement tabElement = driver.findElement(instalmentTab);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabElement);

        WebElement accountNumberField = driver.findElement(instalmentAccountNumberInput);
        String actualAccountNumberPlaceholder = accountNumberField.getAttribute("placeholder");
        Assert.assertEquals(actualAccountNumberPlaceholder, "Номер счета на 44", "Account number placeholder text doesn't match!");

        WebElement sumField = driver.findElement(instalmentSumInput);
        String actualSumPlaceholder = sumField.getAttribute("placeholder");
        Assert.assertEquals(actualSumPlaceholder, "Сумма", "Sum placeholder text doesn't match!");

        WebElement emailField = driver.findElement(instalmentEmailInput);
        String actualEmailPlaceholder = emailField.getAttribute("placeholder");
        Assert.assertEquals(actualEmailPlaceholder, "E-mail для отправки чека", "Email placeholder text doesn't match!");

        return this;
    }

    public MtsHomePage checkPlaceholdersForArrears() {
        WebElement tabElement = driver.findElement(arrearsTab);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabElement);

        WebElement accountNumberInputElement = driver.findElement(accountNumberInput);
        String actualAccountNumberPlaceholder = accountNumberInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualAccountNumberPlaceholder, "Номер счета на 2073", "Account number placeholder text doesn't match!");

        WebElement sumInputElement = driver.findElement(arrearsSumInput);
        String actualSumPlaceholder = sumInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualSumPlaceholder, "Сумма", "Sum placeholder text doesn't match!");

        WebElement emailInputElement = driver.findElement(arrearsEmailInput);
        String actualEmailPlaceholder = emailInputElement.getAttribute("placeholder");
        Assert.assertEquals(actualEmailPlaceholder, "E-mail для отправки чека", "Email placeholder text doesn't match!");

        return this;
    }

}
