package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactUsFormSteps extends CommonMethods {

    @When("user sending message by filling out the form from excel file using {string} sheet")
    public void user_sending_message_by_filling_out_the_form_from_excel_file_using_sheet(String sheetName) {
        click(homePage.contactUsBtn);
        List<Map<String, String>> newMessage = ExcelReader.excelIntoMap(Constants.TESTDATA_FILEPATH, sheetName);
        for (Map<String, String> mapNewMessage : newMessage) {
            selectOptionFromDD(contactUsPage.subjectHeadingDD, mapNewMessage.get("SubjectHeading"));
            sendText(contactUsPage.emailField, mapNewMessage.get("Email"));
            sendText(contactUsPage.orderReferenceField, mapNewMessage.get("OrderReference"));
            sendText(contactUsPage.chooseFileBtn, Constants.TESTIMG_FILEPATH);
            sendText(contactUsPage.messageField, mapNewMessage.get("Message"));
            click(contactUsPage.sendBtn);
            Assert.assertTrue(contactUsPage.successMessage.isDisplayed());
            click(homePage.contactUsBtn);
        }
    }
}
