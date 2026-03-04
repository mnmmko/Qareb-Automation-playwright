package Test;

import Page.companyPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CompanyTest extends BaseTest{




    @Test(priority = 2)
    public void testaddcompany() throws InterruptedException {
        cp=new companyPage(page);
        cp.add_new_company(campname,"mob"+ran3Digits(),ran3Digits(),"sales",ran6Digits(),"1 - فعال","دينار","الدولية","0.02");
//        assertThat(cp.getsuccmsg()).containsText("تم حفظ بيانات الشركة بنجاح");
    }
}
