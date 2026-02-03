package Page;

import com.microsoft.playwright.Page;

public class TransferRequestPage extends PageBase {

    public TransferRequestPage(Page page) {
        super(page);
    }

    // ===== Locators =====
    private final String tab = "main.vex-layout-content.container";

    private final String mov =
            "text=المالية";

    private final String transfer =
            "التحويلات";

    private final String addTransfer =
            "إضافة تحويل";

    private final String accountFromInput =
            "(//input[@formcontrolname='name'])[1]";

    private String search="البحث";

    private String selectaccountfrom="(//input[@type='checkbox'])[1]";
    private String selectaccountto="(//input[@type='checkbox'])[2]";

    private final String accountToInput =
            "(//input[@formcontrolname='name'])[2]";


    private final String amount =
            "//input[@formcontrolname='amount']";

    private final String narration =
            "textarea";

    private String date="//input[@formcontrolname='transferDate']";

    private final String saveButton =
            "حفظ";

    private final String alertSuccess =
            "div.swal2-container";

    // ===== Actions =====

    public void openTransferPage() {

        clickButton(home);
        clickButton(mov);
        clickbtnexact(transfer);
    }

    public void makeTransfer(
            String accountFrom,
            String accountTo,
            String amt,
            String narr,
            String dates
    ) throws InterruptedException {

        clickbtn(addTransfer);
        Thread.sleep(1000);

        sendText(accountFromInput, accountFrom);
        Thread.sleep(1000);
        clickbtn(search);
        Thread.sleep(1000);
        clickButton(selectaccountfrom);
        Thread.sleep(1000);

        sendText(accountToInput, accountTo);
        Thread.sleep(1000);
        clickbtn(search);
        Thread.sleep(1000);
        clickButton(selectaccountto);
        Thread.sleep(1000);

        sendText(narration, narr);
        sendText(amount, amt);
        Thread.sleep(500);
        sendText(date, dates);
        clickbtn(saveButton);

        waitInvisibleElement(alertSuccess);
    }
}
