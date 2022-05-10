package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

public class ForgotPasswordSteps extends CommonMethods {

    @When("user clicks to Forgot password link")
    public void user_clicks_to_forgot_password_link() {
        click(signInPage.forgotPasswordLink);
    }

    @When("user enters valid email address")
    public void user_enters_valid_email_address() {
        sendText(forgotPassword.email, ConfigReader.getPropertyValue("username"));
    }
    @When("user clicks Retrieve Password button")
    public void user_clicks_retrieve_password_button() {
        click(forgotPassword.retrievePasswordBtn);
    }
    @Then("new password successfully sent to email")
    public void new_password_successfully_sent_to_email() {
        Assert.assertTrue(forgotPassword.successMessage.isDisplayed());
    }

    @When("user enters invalid email address")
    public void user_enters_invalid_email_address() {
        sendText(forgotPassword.email, "blablabla");
    }
}
