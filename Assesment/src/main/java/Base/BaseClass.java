package Base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {

    public static WebDriver driver;

    public static Properties properties;


    public BaseClass() {

        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/main/java/Resources/properties";
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver(options);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    public void tearDown() {

        driver.close();

    }


}

