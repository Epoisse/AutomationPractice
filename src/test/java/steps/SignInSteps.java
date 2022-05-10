package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class SignInSteps extends CommonMethods {

    @When("user navigated to Sign In page")
    public void user_navigated_to_sign_in_page() {
        click(homePage.signInBtn);
    }

    @When("user enter valid credentials")
    public void user_enter_valid_credentials() {
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

    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        sendText(signInPage.emailField, "wrongemail");
        sendText(signInPage.passwordField, "wrongpassword");
    }

    @Then("user see error message on the screen")
    public void user_see_error_message_on_the_screen() {
        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
    }

}
