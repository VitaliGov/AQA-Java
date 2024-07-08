package pages.mts_home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

public class MtsHomePageCard extends BasePage {

    // Локаторы для элементов во всплывающем окне
    private final By iframeElement = By.cssSelector("iframe.bepaid-iframe");
    private final By amountElement = By.cssSelector("div.pay-description__cost span");
    private final By payButton = By.xpath("//button[contains(text(), 'Оплатить')]");
    private final By phoneNumberElement = By.cssSelector("div.pay-description__text span");
    private final By cardNumberLabel = By.id("cc-number");
    private final By expirationDateLabel = By.cssSelector("div.content.ng-tns-c46-4 label");
    private final By cvcLabel = By.cssSelector("div.content.ng-tns-c46-5 label");
    private final By cardholderNameLabel = By.cssSelector("div.content.ng-tns-c46-3 label");
    private final By mastercardIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private final By visaIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    private final By belkartIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private final By mirIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");
    private final By yandexPayButton = By.cssSelector("div#yandex-button button[aria-label='Yandex Pay']");
    private final By googlePayButton = By.cssSelector("button[aria-label='Google Pay']");

    // Конструктор
    public MtsHomePageCard(WebDriver driver) {
        super(driver);
    }

    public void enterOnlinePaymentSection() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Находим блок Онлайн оплата без комиссии и переходим на него
        WebElement onlinePaymentSectionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", onlinePaymentSectionElement);
        onlinePaymentSectionElement.click();
        System.out.println("Перешли в блок Онлайн оплата без комиссии.");

        // Выбираем вкладку Услуги связи
        WebElement servicesTabElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay']/option[1]")));
        servicesTabElement.click();
        System.out.println("Выбрана вкладка Услуги связи.");

        // Вводим номер телефона
        WebElement phoneInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-phone")));
        phoneInputElement.sendKeys("297777777");
        System.out.println("Введен номер телефона.");

        // Вводим сумму
        WebElement sumInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#connection-sum")));
        sumInputElement.sendKeys("5");
        System.out.println("Введена сумма.");

        // Нажимаем кнопку Продолжить
        WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButtonElement.click();
        System.out.println("Нажата кнопка Продолжить.");

        // Ждем появления iframe и переходим на всплывающее окно с данными карты
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeElement));
        System.out.println("iframe найден: " + iframe.isDisplayed());

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
        System.out.println("Переход на всплывающее окно с данными карты.");

        // Проверяем корректность отображения суммы
        WebElement amountElementElement = wait.until(ExpectedConditions.visibilityOfElementLocated(amountElement));
        System.out.println("Сумма на экране оплаты: " + amountElementElement.getText());

        // Проверяем корректность отображения номера телефона
        WebElement phoneNumberElementElement = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberElement));
        System.out.println("Номер телефона на экране оплаты: " + phoneNumberElementElement.getText());

        // Проверяем наличие иконок платёжных систем
        wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mirIcon));
        System.out.println("Иконки платёжных систем присутствуют.");

        // Проверяем наличие названий полей в незаполненных полях для ввода реквизитов карты
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel));
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDateLabel));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabel));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardholderNameLabel));
        System.out.println("Названия полей для ввода реквизитов карты отображены.");

        // Проверяем наличие кнопок Yandex Pay и Google Pay
        wait.until(ExpectedConditions.visibilityOfElementLocated(yandexPayButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(googlePayButton));
        System.out.println("Кнопки Yandex Pay и Google Pay отображены.");

        // Переключаемся обратно на основной контент страницы
        driver.switchTo().defaultContent();
    }

}
