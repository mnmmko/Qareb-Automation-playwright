package Test;

import Page.uploadcardcontentPage;
import Page.uploadedcardsPage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class UploadcardcontentTest extends BaseTest {

    @Test(priority = 11)
    public void testuplpadcard() throws InterruptedException, IOException, AWTException {
        ucp=new uploadcardcontentPage(page);
        udcp=new uploadedcardsPage(page);
        ucp.addcard( campname,cardamt,",","دجون", "2026/10/11","0.02","1","upload file");
        udcp.accept_upload();

    }
}
