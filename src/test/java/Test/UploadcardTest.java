package Test;

import Page.UploadcardFilePage;
import Page.uploadcardPage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class UploadcardTest extends BaseTest {

    @Test(priority = 11)
    public void testuplpadcard() throws InterruptedException, IOException, AWTException {
        ucp=new uploadcardPage(page);
        ucp.addcard( campname,cardamt,",","دجون", "2026/10/11","0.02","1","upload file");

    }
}
