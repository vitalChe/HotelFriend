import com.sun.org.glassfish.gmbal.Description;
import global.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseTest {


    @Test
    @Description("positive test for sign In procedure")
    public void checkSignInProcedure(){
        singInSteps.clickSignInUpButton();
        singInSteps.clickButtonGoogle();
        String name = singInSteps.getTextFromNameButton();
        Assert.assertEquals("Vitalii Bortenko", name);
    }

    @Test
    @Description("negative test for sign In procedure")
    public void checkSignInProcedureFailed() {
        singInSteps.clickSignInUpButton();
        singInSteps.moveToSignInTab();
        singInSteps.passSignInProcedure("bort@mail.ru", "gfgfggffff");
        Assert.assertEquals(singInSteps.getErrorMessageText(),"Login or password is incorrect");
    }
}




