package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class HomePage extends CommonMethods {

    @FindBy(linkText = "Contact us")
    public WebElement contactUsBtn;

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

}
