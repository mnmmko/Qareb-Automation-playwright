package Test;

import Page.currencyPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CurrencyTest extends BaseTest{

    @Test(priority = 5)
    public void testaddCurrency() throws InterruptedException {
        cpt=new currencyPage(page);
        cpt.add_currency("العمله"+cardamt,"currency"+cardamt,"USD"+cardamt,"frac");
        assertThat(cpt.getsuccmsg()).containsText("تم الحفظ بنجاح");
    }
}
