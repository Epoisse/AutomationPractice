package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class SignInSteps extends CommonMethods {

    @When("user navigated to Sign In page")
    public void user_navigated_to_sign_in_page() {
        click(homePage.signInBtn);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        sendText(signInPage.emailField, ConfigReader.getPropertyValue("username"));
        sendText(signInPage.passwordField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks Sign In button")
    public void user_clicks_sign_in_button() {
        click(signInPage.signInBtn);
    }

    @Then("user successfully signed in")
    public void user_successfully_signed_in() {
        Assert.assertTrue(myAccountPage.welcomeMessage.isDisplayed());
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        sendText(signInPage.emailField, "wrongemail");
        sendText(signInPage.passwordField, "wrongpassword");
    }

    @Then("user sees error message on the screen")
    public void user_sees_error_message_on_the_screen() {
        Assert.assertFalse(signInPage.errorMessage.isDisplayed());
    }

    @When("user sees information message {string}")
    public void user_sees_information_message(String string) {
        Assert.assertEquals(string, signInPage.informationMessage.getText());
    }

    @When("user enters valid email")
    public void user_enters_valid_email() {
        sendText(signInPage.createEmailField, getRandomEmail());
    }

    @When("user clicks Create an account button")
    public void user_clicks_create_an_account_button() {
        click(signInPage.createAccountBtn);
    }

    @When("user enters invalid {string}")
    public void user_enters_invalid(String string) {
        sendText(signInPage.createEmailField, string);
    }

    @Then("user sees error {string} on the screen")
    public void user_sees_error_on_the_screen(String string) {
        Assert.assertEquals(string, signInPage.createAccountErrorMessage.getText());
    }

    @When("user provides invalid credentials")
    public void user_provides_invalid_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> invalidCredentials = dataTable.asMaps();
        for (Map<String, String> data :
                invalidCredentials) {
            String email = data.get("email");
            String password = data.get("password");
            String errorMessage = data.get("errorMessage");

            sendText(signInPage.emailField, email);
            sendText(signInPage.passwordField, password);
            click(signInPage.signInBtn);
            Assert.assertEquals(errorMessage, signInPage.errorMessage.getText());
        }
    }

}
