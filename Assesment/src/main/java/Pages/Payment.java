package Pages;

import Base.BaseClass;
import Base.Operations;
import org.openqa.selenium.By;

public class Payment extends BaseClass {


    private static class Locator {
        private static By cardNameInput = By.name("name_on_card");
        private static By cardNumberInput = By.name("card_number");
        private static By cardCVCInput = By.name("cvc");
        private static By cardExpireyMonthInput = By.name("expiry_month");
        private static By cardExpireyYearInput = By.name("expiry_year");
        private static By paymentConfirmBtn = By.id("submit");
        private static By paymentSuccessMsg = By.id("success_message");
        private static String successmsgText = "Your order has been placed successfully!";

    }

    public static void enterPaymentDetails() {
        Operations.enterText(BaseClass.properties.getProperty("cardName"), Locator.cardNameInput, driver);
        Operations.enterText(BaseClass.properties.getProperty("cardNumber"), Locator.cardNumberInput, driver);
        Operations.enterText(BaseClass.properties.getProperty("cvc"), Locator.cardCVCInput, driver);
        Operations.enterText(BaseClass.properties.getProperty("cardExpireyMonth"), Locator.cardExpireyMonthInput, driver);
        Operations.enterText(BaseClass.properties.getProperty("cardExpireyYear"), Locator.cardExpireyYearInput, driver);


    }

    public static void clickPay() {

        Operations.click(Locator.paymentConfirmBtn, driver);
    }

    public static void verifyPaymentSuccessMsg() {
        //if (Operations.isPresent(Locator.paymentSuccessMsg, driver)) {
        String actualSuccessMsgText = Operations.getText(Locator.paymentSuccessMsg, driver);
        System.out.println(actualSuccessMsgText);
        boolean matches = Operations.matchText(actualSuccessMsgText, Locator.successmsgText);
        System.out.println(matches);


    }
}


