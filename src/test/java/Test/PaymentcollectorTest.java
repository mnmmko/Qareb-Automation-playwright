package Test;

import Page.PaymentColletorPage;
import Page.WalletTypePage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PaymentcollectorTest extends BaseTest{

    @Test(priority = 9)
    public void tesaddpaymentcollector() throws InterruptedException {
        pcp=new PaymentColletorPage(page);
        pcp.addpaymentcolletor( "0.02" ,regionname,branchname,"address");
//        assertThat(pcp.getsuccmsg()).containsText("تم ترقية المستخدم إلى مندوب بنجاح");
    }
}
