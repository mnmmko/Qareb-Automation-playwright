package Test;

import Page.WalletTypePage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WalletTypeTest extends BaseTest{

    @Test(priority = 8)
    public void tesaddtWalletType() throws InterruptedException {
        wtp=new WalletTypePage(page);
        wtp.Addwallet( "محفظه" + ran2Digits(),"wallet"+ran2Digits(),"wallet discription");
        assertThat(wtp.getsuccmsg()).containsText("تم حفظ نوع المحفظة بنجاح");
    }
}
