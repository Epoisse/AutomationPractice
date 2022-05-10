package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start() {
        openBrowserAndLaunchApp();
    }

    @After
    public void end(Scenario scenario) {
        byte[]pic;
        if (scenario.isFailed()) {
            pic = takesScreenshot("failed/" + scenario.getName());
        } else {
            pic = takesScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        tearDown();
    }
}
