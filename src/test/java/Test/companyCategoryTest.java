package Test;

import Page.companyCategoryPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class companyCategoryTest extends BaseTest{


        @Test(priority = 1)
    public void testAddcompanycategory() {
        cpc = new companyCategoryPage(page);
        cpc.add_new_company_category("تصنيف"+ran3Digits(),"cat"+
                ran3Digits(),ran3Digits());
            assertThat(cpc.getsuccmsg()).containsText("تم حفظ التصنيف بنجاح");
    }
}
