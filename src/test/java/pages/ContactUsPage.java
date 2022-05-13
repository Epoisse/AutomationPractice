package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ContactUsPage extends CommonMethods {

    @FindBy(css = "a.home")
    public WebElement returnToHomeIcon;

    @FindBy(id = "id_contact")
    public WebElement subjectHeadingDD;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "id_order")
    public WebElement orderReferenceField;

    @FindBy(id = "fileUpload")
    public WebElement chooseFileBtn;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(id = "submitMessage")
    public WebElement sendBtn;

    @FindBy(id = "desc_contact1")
    public WebElement infoMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    public WebElement errorMessage;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successMessage;

    @FindBy(partialLinkText = "Home")
    public WebElement homeBtn;

    public ContactUsPage() {
        PageFactory.initElements(driver, this);
    }
}
