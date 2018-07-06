package pages;


import global.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Sign In / Sign Up']")
    private WebElement signInUpButton;

    @FindBy(xpath = "//*[text()='Google']/..")
    private WebElement buttonGoogle;

    @FindBy(xpath = "//*[@class='hf-header-menu-user_name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='tab-title'][text()='Sign In']")
    private WebElement signInTab;

    @FindBy(xpath = "//*[@class='form-notification center']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[@title='submit'][text()='Sign In']")
    private WebElement signInButtonInForm;

    @FindBy(xpath = "//input[@type='email'][@placeholder='E-mail']")
    private WebElement inputEmailSignInTab;


    @FindBy(xpath = "//input[@type='password'][@placeholder='Password']")
    private WebElement inputPasswordSignInTab;


    public WebElement getSignInUpButton() {
        return signInUpButton;
    }

    public WebElement getButtonGoogle() {
        return buttonGoogle;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getSignInButtonInForm() {
        return signInButtonInForm;
    }

    public WebElement getInputPasswordSignInTab() {
        return inputPasswordSignInTab;
    }

    public WebElement getInputEmailSignInTab() {
        return inputEmailSignInTab;
    }

    public WebElement getSignInTab() {
        return signInTab;
    }

    public WebElement getErrorMessage() {
        waitUntilElementVisible(3, errorMessage);
        return errorMessage;
    }
}
