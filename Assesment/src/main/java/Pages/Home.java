package Pages;

import Base.BaseClass;
import Base.Operations;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.WebElement;


public class Home extends BaseClass {
    private static final Color Orange = Color.fromString("rgb(255, 165, 0)");

    private static class Locator {
        private static WebElement homeBtn = driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(1) > a"));
        private static By brands = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-3 > div > div.brands_products > h2");

        private static By product1 = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
        private static By product2 = By.cssSelector("body > section:nth-child(3) > div.container > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > a");

        private static WebElement productImage1 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img"));
        private static WebElement productImage2 = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/img"));
        private static By continueBtn = By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[1]/div/div/div[3]/button");

        private static By scrollToCart = By.cssSelector("#header > div > div > div > div.col-sm-4 > div > a > img");
        private static By cartBtn = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
        private static By cartElement = By.cssSelector("#cart_items > div > div.breadcrumbs > ol > li.active");
        private static By loginUserName = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");


    }

    static Color homeButtonColour = Color.fromString(Locator.homeBtn.getCssValue("color"));
    //static WebElement productImage = driver.findElement(By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img"));

    public static boolean isItHomeScreen() {

        Boolean colorMatch = false;
        if (homeButtonColour.equals(Orange)) {
            colorMatch = true;
        }
        return colorMatch;
    }

    public static void scrollToProducts() {
        Operations.scrollIntoElement(Locator.brands, driver);


    }

    public static void addProductToCart() throws InterruptedException {
        Actions action = new Actions(driver);

        if (Operations.isPresent(Locator.product1, driver)) {

            action.moveToElement(Locator.productImage1);

            Operations.click(Locator.product1, driver);
        }
        Thread.sleep(20000);
        if (Operations.isPresent(Locator.continueBtn, driver)) {

            Operations.click(Locator.continueBtn, driver);
        }
        Thread.sleep(20000);

        if (Operations.isPresent(Locator.product2, driver)) {
            action.moveToElement(Locator.productImage2);
            Operations.click(Locator.product2, driver);
        }
        Thread.sleep(20000);
        if (Operations.isPresent(Locator.continueBtn, driver)) {

            Operations.click(Locator.continueBtn, driver);
        }

    }

    public static void scrollToCarts() {
        Operations.scrollIntoElement(Locator.scrollToCart, driver);
    }

    public static void clickCarts() {
        if (Operations.isPresent(Locator.cartBtn, driver)) {
            Operations.click(Locator.cartBtn, driver);
        }
    }

    public static boolean isItCartsScreen() {

        Boolean cartsScreen = false;
        if (Operations.isPresent(Locator.cartElement, driver)) {
            cartsScreen = true;
        }

        return cartsScreen;
    }

    public static boolean verifyUserName() {

        Boolean verified = false;
        String userName = Register.name;
        String actualUserName = Operations.getText(Locator.loginUserName, driver);

        if (Operations.matchText(actualUserName, userName)) {
            verified = true;
        }
        System.out.println(verified);

        return verified;
    }


}






