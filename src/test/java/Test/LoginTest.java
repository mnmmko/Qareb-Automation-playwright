package Test;

import Page.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage lp;


    String campname="موب"+ran3Digits();
    String cardamt=ran2Digits();
    @Test(priority = 0,groups = "testLogin")
    public void testLogin() {

        lp = new LoginPage(page);
        lp.login("mnabeh1", "12345678");
    }







}
