package tests.mts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.mts_home.MtsHomePageCard;
import tests.base.BaseTest;

import static constants.Constant.Url.MTS_HOME_PAGE;

public class PaymentMTS extends BaseTest {


    @Test(priority = 1, groups = "setup")
    @Description("Find text on the home page")
    public void findTextOnHomePage() {
        basePage.open(MTS_HOME_PAGE);
        mtsHomePage.findText();
    }

    @Test(priority = 2, groups = "setup")
    @Description("Check placeholders for communication services")
    public void checkCommunicationServicePlaceholders() {
        basePage.open(MTS_HOME_PAGE);
        mtsHomePage.checkPlaceholdersForCommunicationServices();
    }

    @Test(priority = 3, groups = "setup")
    @Description("Check placeholders for arrears")
    public void checkArrearsPlaceholders() {
        basePage.open(MTS_HOME_PAGE);
        mtsHomePage.checkPlaceholdersForArrears();
    }

    @Test(priority = 4, groups = "setup")
    @Description("Check placeholders for Home Internet")
    public void checkHomeInternetPlaceholders() {
        basePage.open(MTS_HOME_PAGE);
        mtsHomePage.checkPlaceholdersForHomeInternet();
    }

    @Test(priority = 5, groups = "setup")
    @Description("Check placeholders for Instalment")
    public void checkInstalmentPlaceholders() {
        basePage.open(MTS_HOME_PAGE);
        mtsHomePage.checkPlaceholdersForInstalment();
    }

    @Test(priority = 6, groups = "setup")
    @Description("Enter online payment section with card details")
    public void enterOnlinePaymentSectionWithCardDetails() {
        basePage.open(MTS_HOME_PAGE);

        MtsHomePageCard mtsHomePageCard = new MtsHomePageCard(driver);
        mtsHomePageCard.enterOnlinePaymentSection();

    }
}
