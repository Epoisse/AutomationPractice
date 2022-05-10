package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ForgotPasswordPage extends CommonMethods {

    @FindBy(css = "a.home")
    public WebElement returnToHomeIcon;

    @FindBy(linkText = "Authentication")
    public WebElement authenticationBtn;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//span[text()='Retrieve Password']")
    public WebElement retrievePasswordBtn;

    @FindBy(xpath = "//span[text()='Back to Login']")
    public WebElement backToLoginBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    public WebElement errorMessage;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successMessage;

    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }
}
