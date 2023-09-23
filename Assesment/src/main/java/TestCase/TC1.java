package TestCase;

import Pages.*;
import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class TC1 extends BaseClass {
    @BeforeClass
    public void setupDriver() {
        setUp();
    }

    @Test(priority = 1)
    public void isItHomeScreen() {
        try {
            boolean hasHomeScreenOpened = Home.isItHomeScreen();
            Assert.assertTrue(hasHomeScreenOpened, "User doesn't appear on the home screen. ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }

    }

    @Test(priority = 2)
    public void addProductsToCart() throws InterruptedException {
        Home.scrollToProducts();
        Thread.sleep(10000);
        Home.addProductToCart();
        Thread.sleep(10000);

    }

    @Test(priority = 3)
    public void clickCartButton() throws InterruptedException {

        Home.scrollToCarts();
        Thread.sleep(10000);
        Home.clickCarts();
        Thread.sleep(10000);

    }

    @Test(priority = 4)
    public void isItCartsScreen() {
        try {
            boolean hasCartsScreenOpened = Home.isItCartsScreen();
            Assert.assertTrue(hasCartsScreenOpened, "User doesn't appear on the carts screen. ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
    }

    @Test(priority = 5)
    public void clickProceedToCheckouttButton() throws InterruptedException {
        Cart.clickProceedToCheckout();
        Thread.sleep(10000);
    }

    @Test(priority = 6)
    public void clickRegisterButton() throws InterruptedException {
        Cart.clickRegister();
        Thread.sleep(20000);
    }

    @Test(priority = 7)
    public void userRegistration() throws InterruptedException {
        Register.registrationProcess();
        Thread.sleep(10000);
    }

    @Test(priority = 8)
    public void registrationConfirm() throws InterruptedException {
        Register.confirmregistration();
        Thread.sleep(15000);
    }

    @Test(priority = 9)
    public void verfiyUserName() throws InterruptedException {
        try {
            boolean userNameMatched = Home.verifyUserName();
            Assert.assertTrue(userNameMatched, "User name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        Thread.sleep(15000);
    }

    @Test(priority = 10)
    public void clickCartButtonAgain() throws InterruptedException {

        Home.clickCarts();
        Thread.sleep(10000);

    }

    @Test(priority = 11)
    public void clickProceedToCheckouttButtonAgain() throws InterruptedException {
        Cart.clickProceedToCheckout();
        Thread.sleep(10000);
    }

    @Test(priority = 12)
    public void verfiyDeliveryAddress() throws InterruptedException {
        try {
            boolean deliveryNameMatched = Checkout.verifyDeliveryUserName();
            Assert.assertTrue(deliveryNameMatched, "User name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryCompanyNameMatched = Checkout.verifyDeliveryCompany();
            Assert.assertTrue(deliveryCompanyNameMatched, "Company name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryAddress1NameMatched = Checkout.verifyDeliveryUserAddress1();
            Assert.assertTrue(deliveryAddress1NameMatched, "Addresss1 name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryAddress2NameMatched = Checkout.verifyDeliveryUserAddress2();
            Assert.assertTrue(deliveryAddress2NameMatched, "Addresss2 name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryStateCityZipMatched = Checkout.verifyDeliveryStateCityZip();
            Assert.assertTrue(deliveryStateCityZipMatched, "state,city and zipcode don't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryCountryNameMatched = Checkout.verifyDeliveryCountry();
            Assert.assertTrue(deliveryCountryNameMatched, "Country name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean deliveryMobileNumberMatched = Checkout.verifyDeliveryMobile();
            Assert.assertTrue(deliveryMobileNumberMatched, "Mobile number doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }

        Thread.sleep(5000);
    }

    @Test(priority = 13)
    public void verfiyBillingAddress() throws InterruptedException {
        try {
            boolean billingNameMatched = Checkout.verifyBillingUserName();
            Assert.assertTrue(billingNameMatched, "User name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingCompanyNameMatched = Checkout.verifyBillingCompany();
            Assert.assertTrue(billingCompanyNameMatched, "Company name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingAddress1NameMatched = Checkout.verifyBillingUserAddress1();
            Assert.assertTrue(billingAddress1NameMatched, "Addresss1 name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingAddress2NameMatched = Checkout.verifyBillingUserAddress2();
            Assert.assertTrue(billingAddress2NameMatched, "Addresss2 name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingStateCityZipMatched = Checkout.verifyBillingStateCityZip();
            Assert.assertTrue(billingStateCityZipMatched, "state,city and zipcode don't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingCountryNameMatched = Checkout.verifyBillingCountry();
            Assert.assertTrue(billingCountryNameMatched, "Country name doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }
        try {
            boolean billingMobileNumberMatched = Checkout.verifyBillingMobile();
            Assert.assertTrue(billingMobileNumberMatched, "Mobile number doesn't match ");
        } catch (Exception exception) {
            Assert.fail("The test is failed because of some unhandled exception. " + exception.getMessage());

        }

        Thread.sleep(5000);
    }

    @Test(priority = 14)
    public void addComment() throws InterruptedException {
        Checkout.writeComment();
        //Thread.sleep(10000);
    }

    @Test(priority = 15)
    public void clickPlaceOrder() throws InterruptedException {
        Checkout.clickPlaceOrder();
        Thread.sleep(10000);
    }

    @Test(priority = 16)
    public void enterCardDetails() throws InterruptedException {
        Payment.enterPaymentDetails();
        Thread.sleep(10000);
    }

    @Test(priority = 17)
    public void doPayment() throws InterruptedException {
        Payment.clickPay();
    }

    @Test(priority = 18)
    public void paymentConfirm() throws InterruptedException {
        Payment.verifyPaymentSuccessMsg();

    }

    @AfterTest
    public void testCaseTearDown() {
        tearDown();
    }

}