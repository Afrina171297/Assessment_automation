package Pages;

import Base.BaseClass;
import Base.Operations;
import org.openqa.selenium.By;

public class Cart extends BaseClass {
    private static class Locator {
        private static By proceedToChkOutBtn = By.cssSelector("#do_action > div.container > div > div > a");
        private static By regBtn = By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a");
    }

    public static void clickProceedToCheckout() {
        Operations.click(Locator.proceedToChkOutBtn, driver);
    }

    public static void clickRegister() {
        if (Operations.isPresent(Locator.regBtn, driver)) {

            Operations.click(Locator.regBtn, driver);
        }

    }
}
