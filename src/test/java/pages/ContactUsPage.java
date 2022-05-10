package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactUsPage extends CommonMethods {

    public @FindBy(css = "a.home")
    WebElement returnToHomeIcon;

    public @FindBy(id = "id_contact")
    WebElement subjectHeadingDD;

    public @FindBy(id = "email")
    WebElement emailField;

    public @FindBy(id = "id_order")
    WebElement orderReferenceField;

    public @FindBy(id = "fileUpload")
    WebElement chooseFileBtn;

    public @FindBy(id = "message")
    WebElement messageField;

    public @FindBy(id = "submitMessage")
    WebElement sendBtn;

    public @FindBy(id = "desc_contact1")
    WebElement infoMessage;

    public @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    WebElement errorMessage;

    public @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successMessage;

    public @FindBy(partialLinkText = "Home")
    WebElement homeBtn;

    public ContactUsPage() {
        PageFactory.initElements(driver, this);
    }
}
