package Test;

import Page.AccountTypePage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountTypeTest extends BaseTest{



    @Test(priority = 4)
    public void testaAddAccountType() throws InterruptedException {
        atp=new AccountTypePage(page);
        atp.addaccunttype("حساب"+cardamt,"account"+cardamt,"desc of account");
        assertThat(atp.getsuccmsg()).containsText("تم الحفظ بنجاح");
    }

}
