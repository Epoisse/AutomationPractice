package steps;

import pages.*;

public class PageInitializers {
    public static ContactUsPage contactUsPage;
    public static ForgotPasswordPage forgotPassword;
    public static HomePage homePage;
    public static SignInPage signInPage;
    public static MyAccountPage myAccountPage;
    public static PersonalInfoPage personalInfoPage;

    public static void initializePageObject() {
        contactUsPage = new ContactUsPage();
        forgotPassword = new ForgotPasswordPage();
        homePage = new HomePage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        personalInfoPage = new PersonalInfoPage();
    }

}

