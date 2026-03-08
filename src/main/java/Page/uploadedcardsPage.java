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
    private String select_status="(//mat-select)[3]";
    private String selectitems = "mat-option";
    private String secconfirmup="تأكيد";
    public void accept_upload(String status) throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        clickButton(penddinguploads);
        clickButton(sortopt);
        Thread.sleep(1000);
        clickButton(showpenddingrequest);

        clickbtn(confirmup);
        clickButton(select_status);
        chosselist(selectitems,status);
        clickbtn(secconfirmup);
        Thread.sleep(2000);

    }
}
