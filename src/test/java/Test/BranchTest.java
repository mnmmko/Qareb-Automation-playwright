package Test;

import Page.BranchPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BranchTest extends BaseTest{

    @Test(priority = 7)
    public void addbranchtest() throws InterruptedException {
        bp=new BranchPage(page);
        bp.addbranch("branch"+ran2Digits(),regionname);
        assertThat(bp.getsuccmsg()).containsText("تم حفظ الفرع بنجاح");
    }

}
