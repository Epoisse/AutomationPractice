package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.andreinc.mockneat.MockNeat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializers {
    public static WebDriver driver;
    public static MockNeat mockNeat;

    public static void openBrowserAndLaunchApp() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObject();

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static WebDriverWait getWait() {
        WebDriverWait driverWait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return driverWait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void selectOptionFromDD(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        try {
            element.sendKeys(text);
        } catch (IllegalArgumentException e) {
            element.sendKeys("");
        }
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] takesScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getRandomEmail() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.emails().val();
    }

    public static String getRandomFirstName() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.names().first().val();
    }

    public static String getRandomLastName() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.names().last().val();
    }

    public static String getRandomPassword() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.passwords().valStr();
    }

    public static String getRandomString() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.strings().valStr();
    }

    public static String getRandomCity() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.cities().us().val();
    }

    public static String getRandomState() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.usStates().valStr();
    }


    public static String getFakeZipcode() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.ints().bound(5).valStr();
    }

/*    public static String getFakePhoneNumber() {
        mockNeat = MockNeat.threadLocal();
        return mockNeat.getRandom().nextInt();
    }*/

    public static void tearDown() {
        driver.quit();
    }
}
