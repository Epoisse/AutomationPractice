package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SignInPage extends CommonMethods {

    public @FindBy(css = "a.home")
    WebElement returnToHomeIcon;

    // Create an account
    public @FindBy(id = "email_create")
    WebElement createEmailField;

    public @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    public @FindBy(xpath = "//div[@id='create_account_error']//li")
    WebElement createAccountErrorMessage;

    // Registration
    public @FindBy(id = "email")
    WebElement emailField;

    public @FindBy(id = "passwd")
    WebElement passwordField;

    public @FindBy(partialLinkText = "Forgot")
    WebElement forgotPasswordLink;

    public @FindBy(id = "SubmitLogin")
    WebElement signInBtn;

    public @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    WebElement errorMessage;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

}
