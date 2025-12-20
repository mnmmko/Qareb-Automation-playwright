package Test;

import Page.SupplierPage;
import Page.WalletTypePage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SupplierTest extends BaseTest{

    @Test(priority = 9)
    public void tesaddtsupplier() throws InterruptedException {
        sp=new SupplierPage(page);
        sp.addsupplier( "مورد" + ran2Digits(),"supp"+ran2Digits(),"address1",randomPhone09(),"فعال");
        assertThat(sp.getsuccmsg()).containsText("تم حفظ المورد بنجاح");
    }

}
