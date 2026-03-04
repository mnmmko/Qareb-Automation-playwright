package Test;

import Page.RegionPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegionTest extends BaseTest{

    @Test(priority = 7)
    public void addRegionTest() throws InterruptedException {
        rp=new RegionPage(page);

        rp.addregion(regionname,"region"+ran2Digits(),branchname,"منطقة");
//        assertThat(rp.getsuccmsg()).containsText("تم حفظ المنطقة بنجاح");
    }
}
