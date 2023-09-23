package Base;

import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Operations {


    public static void scrollIntoElement(By locator, WebDriver driver) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    public static void click(By locator, WebDriver driver) {
        WebElement el = driver.findElement(locator);
        el.click();

    }

    public static boolean isPresent(By locator, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40000L));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static void enterText(String text, By locator, WebDriver driver) {
        WebElement el = driver.findElement(locator);
        el.sendKeys(text);
    }

    public static void clearText(By locator, WebDriver driver) {
        WebElement el = driver.findElement(locator);
        el.clear();
    }

    public static String getText(By locator, WebDriver driver) {
        WebElement el = driver.findElement(locator);
        return el.getText();
    }

    public static boolean matchText(String actualText, String expectedText) {
        boolean isTextPresent = actualText.matches(expectedText);
        return isTextPresent;
    }

    public static String randomPass() {
        String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String pwd = RandomStringUtils.random(10, symbol + cap_letter + symbol + small_letter + numbers);
        return pwd;
    }
    public static String indexValue = "";
    public static void randomDropdownSelect(By locator, WebDriver driver) {
        Select dropdown = new Select(driver.findElement(locator));
        List<WebElement> elementCount = dropdown.getOptions();
        int listNUmber = elementCount.size() - 1;

        Random rand = new Random();
        int indexNumber = rand.nextInt(listNUmber) + 1;

        dropdown.selectByIndex(indexNumber);
        WebElement o = dropdown.getFirstSelectedOption();
        indexValue = o.getText();
        System.out.println("Operation:"+indexValue);


    }

    public static String randomName() {
        LoremIpsum lorem = LoremIpsum.getInstance();
        String randString = lorem.getName();
        return randString;

    }

    public static String randomAddress() {
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String address = RandomStringUtils.random(10, cap_letter + small_letter + numbers);
        return address;
    }

    public static String randomNumber(int length) {
        Random rnd = new Random();
        int number = rnd.nextInt(length);
        String randNum = String.format("%08d", number);
        return randNum;

    }

    public static String randomString(int length) {
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String randString = RandomStringUtils.random(length, cap_letter + small_letter);
        return randString;
    }


}


