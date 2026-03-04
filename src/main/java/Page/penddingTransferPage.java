package Page;

import com.microsoft.playwright.Page;

public class penddingTransferPage extends PageBase{
    public penddingTransferPage(Page page) {
        super(page);
    }

    private final String mov =
            "text=المالية";

    private final String transferpendding =
            "التحويلات المعلقة";

    private String ordernum="//span[contains(normalize-space(.), 'رقم العملية')]";

    private String accept="(//i[@title='transactions.accept'])[1]";

    public void Accepttransfer() throws InterruptedException {
        clickButton(home);
        clickButton(mov);
        clickbtnexact(transferpendding);
        clickButton(ordernum);
        clickButton(ordernum);
        Thread.sleep(1000);
        clickButton(accept);
    }

}
