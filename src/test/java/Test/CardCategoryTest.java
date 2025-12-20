package Test;

import Page.cardCategoryPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CardCategoryTest extends BaseTest{



    @Test(priority = 3)
    public void testaddcard() throws InterruptedException {
        clp=new cardCategoryPage(page);
        clp.addcard("دينار"+cardamt,cardamt,campname,cardamt,cardamt,"30","20","10" );
        assertThat(clp.getsuccmsg()).containsText("تم الحفظ بنجاح");
    }
}
