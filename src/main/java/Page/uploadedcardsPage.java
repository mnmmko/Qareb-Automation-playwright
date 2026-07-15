package Page;

import com.microsoft.playwright.Page;

public class uploadedcardsPage extends PageBase{

    public uploadedcardsPage(Page page) {
        super(page);
    }
    private String datatab = "text=المخزون الجديد";
    private String penddinguploads="text=الملفات المعلقة";
    private String sortopt="//span[contains(normalize-space(.), 'رقم العملية')]";
    private String showpenddingrequest="(//i[@title='عرض' and normalize-space()='visibility'])[1]";
    private String confirmup="تأكيد";
    public void accept_upload() throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        clickButton(penddinguploads);
        clickButton(sortopt);
        Thread.sleep(1000);
        clickButton(showpenddingrequest);

        clickbtn(confirmup);
        Thread.sleep(2000);

    }
}
