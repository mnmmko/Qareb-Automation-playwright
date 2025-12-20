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
            "text=التحويلات";

    private final String addTransfer =
            "إضافة تحويل";

    private final String accountFromInput =
            "(//input[contains(@class,'mat-mdc-autocomplete-trigger')])[1]";

    private final String accountToInput =
            "(//input[contains(@class,'mat-mdc-autocomplete-trigger')])[2]";

    private final String selectItem =
            "(//span[@class='mdc-list-item__primary-text'])[1]";

    private final String amount =
            "//input[@formcontrolname='amount']";

    private final String narration =
            "textarea";

    private final String saveButton =
            "حفظ";

    private final String alertSuccess =
            "div.swal2-container";

    // ===== Actions =====

    public void openTransferPage() {

        clickButton(mov);
        clickButton(transfer);
    }

    public void makeTransfer(
            String accountFrom,
            String accountTo,
            String amt,
            String narr
    ) throws InterruptedException {

        clickbtn(addTransfer);


        clickButton(accountFromInput);
        sendText(accountFromInput, accountFrom);
        Thread.sleep(1000);
        clickButton(selectItem);


        clickButton(accountToInput);
        sendText(accountToInput, accountTo);
        Thread.sleep(1000);
        clickButton(selectItem);

        sendText(narration, narr);
        sendText(amount, amt);
        Thread.sleep(500);

        clickbtn(saveButton);

        waitInvisibleElement(alertSuccess);
    }
}
