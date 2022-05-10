package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MyAccountPage extends CommonMethods {

    public @FindBy(css = "p.info-account")
    WebElement welcomeMessage;

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

}
