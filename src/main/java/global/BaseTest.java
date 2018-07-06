package global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import steps.SignInSteps;

public class BaseTest {

     protected WebDriver driver ;
     protected SignInSteps singInSteps;

//    public BaseTest(){
//
//    }

    @BeforeMethod
    public void openSignInPage() {
        driver =  new ChromeDriver();
        singInSteps = new SignInSteps(driver);
        driver.get("https://hotelfriend.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

