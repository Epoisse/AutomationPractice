package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class HomePage extends CommonMethods {

    public @FindBy(linkText = "Contact us")
    WebElement contactUsBtn;

    public @FindBy(linkText = "Sign in")
    WebElement signInBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

}
