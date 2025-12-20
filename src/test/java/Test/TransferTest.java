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

    LoginPage lp;
    TransferRequestPage tr;
    companyCategoryPage cpc;

    @Test(priority = 0)
    public void testLogin() {

        lp = new LoginPage(page);
        lp.login("mnabeh1", "12345678");
    }



    @Test(priority = 1, dependsOnMethods = "testLogin")
    public void testAddTransferRequest() {

        tr = new TransferRequestPage(page);
        tr.openTransferPage();
    }
    @Test(
            priority = 2,
            dependsOnMethods = "testAddTransferRequest",
            dataProvider = "transfer"
    )
    public void testTransferRequest(String accountFrom, String accountTo) throws InterruptedException {

        tr.makeTransfer(
                accountFrom,
                accountTo,
                "5",
                accountFrom + " ارسل تحويل الى " + accountTo
        );
    }

    @DataProvider(name = "transfer", parallel=false)
    public Object[][] data() throws IOException, InvalidFormatException {
        return Read_excel.read_sheet("transfer");
    }
}
