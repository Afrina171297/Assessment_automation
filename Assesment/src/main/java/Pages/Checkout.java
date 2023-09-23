package Pages;

import Base.BaseClass;
import Base.Operations;
import org.openqa.selenium.By;

public class Checkout extends BaseClass {
    private static class Locator {
        private static By reviewOrder = By.cssSelector("#cart_items > div > div:nth-child(4) > h2");
        private static By commentInput = By.cssSelector("#ordermsg > textarea");
        private static By placeOrderBtn = By.cssSelector("#cart_items > div > div:nth-child(7) > a");
        private static By deliveryUserName = By.cssSelector("#address_delivery > li.address_firstname.address_lastname");
        private static By deliveryCompanyName = By.cssSelector("#address_delivery > li:nth-child(3)");
        private static By deliveryUserAddress1 = By.cssSelector("#address_delivery > li:nth-child(4)");
        private static By deliveryUserAddress2 = By.cssSelector("#address_delivery > li:nth-child(5)");
        private static By deliveryStateCityZipcode = By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode");
        private static By deliveryCountryName = By.cssSelector("#address_delivery > li.address_country_name");
        private static By deliveryMobileNumber = By.cssSelector("#address_delivery > li.address_phone");

        private static By userName = By.cssSelector("#address_invoice > li.address_firstname.address_lastname");
        private static By companyName = By.cssSelector("#address_invoice > li:nth-child(3)");
        private static By userAddress1 = By.cssSelector("#address_invoice > li:nth-child(4)");
        private static By userAddress2 = By.cssSelector("#address_invoice > li:nth-child(5)");
        private static By stateCityZipcode = By.cssSelector("#address_invoice > li.address_city.address_state_name.address_postcode");
        private static By countryName = By.cssSelector("#address_invoice > li.address_country_name");
        private static By mobileNumber = By.cssSelector("#address_invoice > li.address_phone");


    }

    public static boolean verifyDeliveryUserName() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryUserName, driver);

        if (Operations.matchText(actualText, Register.genderText + " " + Register.firstName + " " + Register.lastName)) {
            verified = true;
        }
        System.out.println(actualText);
        System.out.println(Register.genderText + " " + Register.firstName + " " + Register.lastName);
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingUserName() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.userName, driver);

        if (Operations.matchText(actualText, Register.genderText + " " + Register.firstName + " " + Register.lastName)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryCompany() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryCompanyName, driver);

        if (Operations.matchText(actualText, Register.companyName)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingCompany() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.companyName, driver);

        if (Operations.matchText(actualText, Register.companyName)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryUserAddress1() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryUserAddress1, driver);

        if (Operations.matchText(actualText, Register.address1)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryUserAddress2() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryUserAddress2, driver);

        if (Operations.matchText(actualText, Register.address2)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingUserAddress1() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.userAddress1, driver);

        if (Operations.matchText(actualText, Register.address1)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingUserAddress2() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.userAddress2, driver);

        if (Operations.matchText(actualText, Register.address2)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryStateCityZip() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryStateCityZipcode, driver);

        if (Operations.matchText(actualText, Register.city + " " + Register.state + " " + Register.zipCode)) {
            verified = true;
        }

        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingStateCityZip() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.stateCityZipcode, driver);

        if (Operations.matchText(actualText, Register.city + " " + Register.state + " " + Register.zipCode)) {
            verified = true;
        }
        System.out.println(actualText);
        System.out.println(Register.city + " " + Register.state + " " + Register.zipCode);
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryCountry() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryCountryName, driver);

        if (Operations.matchText(actualText, Register.countryName)) {
            verified = true;
        }
        System.out.println("In Checkout -- actualText: " + actualText);
        System.out.println("In Checkout -- countryName: " + Register.countryName);
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingCountry() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.countryName, driver);

        if (Operations.matchText(actualText, Register.countryName)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyDeliveryMobile() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.deliveryMobileNumber, driver);

        if (Operations.matchText(actualText, Register.mobileNumber)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static boolean verifyBillingMobile() {

        Boolean verified = false;

        String actualText = Operations.getText(Locator.mobileNumber, driver);

        if (Operations.matchText(actualText, Register.mobileNumber)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }

    public static void writeComment() {
        Operations.scrollIntoElement(Locator.commentInput, driver);
        Operations.enterText(Operations.randomString(20), Locator.commentInput, driver);
    }

    public static void clickPlaceOrder() {
        if (Operations.isPresent(Locator.placeOrderBtn, driver)) {

            Operations.click(Locator.placeOrderBtn, driver);
        }

    }

}
