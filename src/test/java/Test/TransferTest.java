package Test;

import Excel.Read_excel;
import Page.LoginPage;
import Page.TransferRequestPage;

import Page.companyCategoryPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransferTest extends BaseTest {








    @Test(priority = 11)
    public void testAddTransferRequest() {

        tr = new TransferRequestPage(page);
        tr.openTransferPage();
    }
    @Test(
            priority = 12,
            dependsOnMethods = "testAddTransferRequest"
    )
    public void testTransferRequest() throws InterruptedException {

        tr.makeTransfer(
                "أسامة ابراهيم ابولجام مندوب",
                "مجدالدين جمال الحوات مندوب",
                "5",
                "أسامة ابراهيم ابولجام مندوب" + " ارسل تحويل الى " + "مجدالدين جمال الحوات مندوب"
                        ,"2026/01/11" );
    }

    @DataProvider(name = "transfer", parallel=false)
    public Object[][] data() throws IOException, InvalidFormatException {
        return Read_excel.read_sheet("transfer");
    }
}
