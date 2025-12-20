package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BranchPage extends PageBase{
    public BranchPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String branch="//span[normalize-space()='تعريف الفروع']";
    private String addbranch="إضافة";
    private String name="//input[@formcontrolname='name']";
    private String region="//input[@formcontrolname='region']";
    private String selectregion="mat-option";
    private String active="//input[@type='checkbox']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addbranch(String names ,String regions) throws InterruptedException {
//        clickButton(datatab);

        clickButton(branch);
        Thread.sleep(1000);
        clickbtn(addbranch);
        Thread.sleep(1000);
        sendText(name,names);
        sendText(region,regions);
        chosselist(selectregion,regions);
        clickButton(active);
        clickbtn(saveButton);
        Thread.sleep(1000);

    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
