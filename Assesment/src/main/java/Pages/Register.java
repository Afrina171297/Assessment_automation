package Pages;

import Base.BaseClass;
import Base.Operations;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

public class Register extends BaseClass {
    static String name = Operations.randomString(5);
    static String firstName = Operations.randomName();
    static String lastName = Operations.randomName();
    static String companyName = RandomStringUtils.randomAlphanumeric(6);

    static String address1 = Operations.randomAddress();
    static String address2 = Operations.randomAddress();

    static String state = Operations.randomString(5);
    static String city = Operations.randomString(5);
    static String zipCode = Operations.randomNumber(4);
    static String mobileNumber = Operations.randomNumber(11);
    static String countryName = "";
    static String genderText = "Mrs.";


    private static class Locator {
        private static By nameInput = By.name("name");
        private static By emailInput = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");

        private static By signUpBtn = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");
        private static By errorMsg = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");
        private static String errorMstText = "Email Address already exist!";
        private static By genderBtn = By.id("id_gender2");
        private static By passwordInput = By.id("password");
        private static By dayInput = By.id("days");
        private static By monthInput = By.id("months");
        private static By yearInput = By.id("years");
        private static By newsChkBox = By.id("newsletter");

        private static By firstnameInput = By.id("first_name");
        private static By lastnameInput = By.id("last_name");
        private static By companyInput = By.id("company");
        private static By address1Input = By.id("address1");
        private static By address2Input = By.id("address2");
        private static By countryInput = By.id("country");
        private static By stateInput = By.id("state");
        private static By cityInput = By.id("city");
        private static By zipecodeInput = By.id("zipcode");
        private static By mobileInput = By.id("mobile_number");
        private static By createAccBtn = By.cssSelector("#form > div > div > div > div.login-form > form > button");
        private static By successMsg = By.cssSelector("#form > div > div > div > h2 > b");
        private static String successmsgText = "ACCOUNT CREATED!";
        private static By continueBtn = By.cssSelector("#form > div > div > div > div > a");


    }

    public static void registrationProcess() throws InterruptedException {

        Operations.enterText(name, Locator.nameInput, driver);
        String email = RandomStringUtils.randomAlphanumeric(6) + "@" + RandomStringUtils.randomAlphanumeric(3) + ".com";
        Operations.enterText(email, Locator.emailInput, driver);
        Operations.click(Locator.signUpBtn, driver);
       /* if(Operations.isPresent(Locator.errorMsg,driver)){
        if(Operations.matchText(Operations.getText(Locator.errorMsg,driver),Locator.errorMstText,driver)){
            Operations.clearText(Locator.emailInput, driver);
            String emailNew = RandomStringUtils.randomAlphanumeric(4)+"@"+RandomStringUtils.randomAlphanumeric(3)+".com";
            Operations.enterText(emailNew,Locator.emailInput, driver);
        }
        }*/

        Thread.sleep(10000);
        if (Operations.isPresent(Locator.address2Input, driver)) {
            Operations.click(Locator.genderBtn, driver);
            String genderText = Operations.getText(Locator.genderBtn, driver);
            String password = Operations.randomPass();
            System.out.println(password);
            Operations.enterText(password, Locator.passwordInput, driver);
            Operations.scrollIntoElement(Locator.passwordInput, driver);
            if (Operations.isPresent(Locator.dayInput, driver) && Operations.isPresent(Locator.monthInput, driver) && Operations.isPresent(Locator.yearInput, driver)) {
                Operations.randomDropdownSelect(Locator.dayInput, driver);
                Operations.randomDropdownSelect(Locator.monthInput, driver);
                Operations.randomDropdownSelect(Locator.yearInput, driver);
            }
            Operations.click(Locator.newsChkBox, driver);
            Operations.enterText(firstName, Locator.firstnameInput, driver);
            Operations.enterText(lastName, Locator.lastnameInput, driver);
            Operations.enterText(companyName, Locator.companyInput, driver);
            Operations.enterText(address1, Locator.address1Input, driver);
            Operations.enterText(address2, Locator.address2Input, driver);
        }
        Operations.scrollIntoElement(Locator.address1Input, driver);
        if (Operations.isPresent(Locator.createAccBtn, driver)) {
            Operations.randomDropdownSelect(Locator.countryInput, driver);
            countryName = Operations.indexValue;
            Operations.enterText(state, Locator.stateInput, driver);
            Operations.enterText(city, Locator.cityInput, driver);
            Operations.enterText(zipCode, Locator.zipecodeInput, driver);
            Operations.enterText(mobileNumber, Locator.mobileInput, driver);
            Operations.scrollIntoElement(Locator.countryInput, driver);
            Operations.click(Locator.createAccBtn, driver);
        }
    }

    public static void confirmregistration() throws InterruptedException {
        if (Operations.isPresent(Locator.continueBtn, driver)) {
            String actualSuccessMsgText = Operations.getText(Locator.successMsg, driver);
            System.out.println(actualSuccessMsgText);
            boolean matches = Operations.matchText(actualSuccessMsgText, Locator.successmsgText);
            System.out.println(matches);
            Operations.click(Locator.continueBtn, driver);
            Thread.sleep(10000);


        }
    }


}
