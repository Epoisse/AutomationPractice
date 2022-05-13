package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class PersonalInfoPageSteps extends CommonMethods {

    @When("fill in all required fields with valid credentials")
    public void fill_in_all_required_fields_with_valid_credentials() {
        sendText(personalInfoPage.firstNameField, getRandomFirstName());
        sendText(personalInfoPage.lastNameField, getRandomLastName());
        sendText(personalInfoPage.passwordField, getRandomPassword());
        sendText(personalInfoPage.addressLine1, getRandomString());
        sendText(personalInfoPage.cityField, getRandomCity());
        selectOptionFromDD(personalInfoPage.stateDD, getRandomState());
        sendText(personalInfoPage.postcodeField, "12345");
        sendText(personalInfoPage.phoneField, "123445555");
        click(personalInfoPage.registerBtn);
    }

    @Then("account successfully created")
    public void account_successfully_created() {
        Assert.assertTrue(myAccountPage.welcomeMessage.isDisplayed());
    }

}
