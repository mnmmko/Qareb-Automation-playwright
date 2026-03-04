package Test;

import Page.penddingTransferPage;
import Page.uploadcardcontentPage;
import Page.uploadedcardsPage;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class PenddingTransferTest extends BaseTest{

    @Test(priority = 13)
    public void testuplpadcard() throws InterruptedException, IOException, AWTException {
        ptp=new penddingTransferPage(page);
        ptp.Accepttransfer();


    }
}
