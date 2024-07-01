package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckPaymentSystemLogosTest extends BaseTest {

    @Test
    public void checkPaymentSystemLogos() {
        try {
            List<String[]> expectedLogos = new ArrayList<>();
            expectedLogos.add(new String[]{"Visa", "/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg"});
            expectedLogos.add(new String[]{"Verified By Visa", "/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg"});
            expectedLogos.add(new String[]{"MasterCard", "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg"});
            expectedLogos.add(new String[]{"MasterCard Secure Code", "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg"});
            expectedLogos.add(new String[]{"Белкарт", "/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"});

            for (String[] logo : expectedLogos) {
                String altText = logo[0];
                String srcPath = logo[1];

                WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='" + altText + "']")));
                String actualSrc = logoElement.getAttribute("src");

                System.out.println("Проверка логотипа: " + altText);
                Assert.assertTrue(actualSrc.endsWith(srcPath), "Путь к изображению не соответствует ожидаемому для " + altText);
                System.out.println("Логотип " + altText + " проверен успешно");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при проверке логотипов платёжных систем: " + e.getMessage());
        }
    }
}
