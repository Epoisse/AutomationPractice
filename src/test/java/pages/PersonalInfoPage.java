package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class PersonalInfoPage extends CommonMethods {
    @FindBy(css = "div.radio")
    public List<WebElement> radioButtons;

    @FindBy(css = "input#customer_firstname")
    public WebElement firstNameField;

    @FindBy(css = "input#customer_lastname")
    public WebElement lastNameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement daysDD;

    @FindBy(id = "months")
    public WebElement monthsDD;

    @FindBy(id = "uniform-years")
    public WebElement yearDD;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;

    // Your Address

    @FindBy(id = "firstname")
    public WebElement firstNameAddressBlockField;

    @FindBy(id = "lastname")
    public WebElement lastNameAddressBlockField;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement addressLine1;

    @FindBy(id = "address2")
    public WebElement addressLine2;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "id_state")
    public WebElement stateDD;

    @FindBy(id = "postcode")
    public WebElement postcodeField;

    @FindBy(id = "id_country")
    public List<WebElement> countryDD;

    @FindBy(id = "other")
    public WebElement additionalInfoField;

    @FindBy(id = "phone")
    public WebElement phoneField;

    @FindBy(id = "alias")
    public WebElement aliasField;

    @FindBy(id = "submitAccount")
    public WebElement registerBtn;

    public PersonalInfoPage() {
        PageFactory.initElements(driver, this);
    }
}
