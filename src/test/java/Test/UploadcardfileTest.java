package Test;


import Page.PaymentColletorPage;
import Page.UploadcardFilePage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UploadcardfileTest extends BaseTest{

    @Test(priority = 10)
    public void testuplpadcardfile() throws InterruptedException, IOException, AWTException {
       ucfp=new UploadcardFilePage(page);
        ucfp.addfile( campname,cardamt, "دجون", "2026/10/11","0.02","1","upload file");

    }
}
