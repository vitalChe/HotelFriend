package steps;

import org.openqa.selenium.WebDriver;
import pages.SignInPage;

public class SignInSteps {

    SignInPage signInPage;
    private WebDriver driver;

    public SignInSteps(WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
    }

    public void clickSignInUpButton() {
        signInPage.getSignInUpButton().click();
    }

    public void clickButtonGoogle() {
        signInPage.getButtonGoogle().click();
    }

    public String getTextFromNameButton() {
        return signInPage.getUserName().getText();
    }

    public String getErrorMessageText() {

        return signInPage.getErrorMessage().getText();
    }

    public void moveToSignInTab() {
        signInPage.getSignInTab().click();
    }


    public void passSignInProcedure(String email, String password) {
        signInPage.getInputEmailSignInTab().sendKeys(email);
        signInPage.getInputPasswordSignInTab().sendKeys(password);
        signInPage.getSignInButtonInForm().click();

    }
}
