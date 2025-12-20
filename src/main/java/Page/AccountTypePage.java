package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountTypePage extends PageBase{
    public AccountTypePage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String accountType="//span[normalize-space()='أنواع الحسابات']";
    private String addaccount="إضافة";
    private String namear="//input[@formcontrolname='nameArabic']";
    private  String nameen="//input[@formcontrolname='nameEnglish']";
    private String description="//input[@formcontrolname='description']";
    private String active="//input[@type='checkbox']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addaccunttype(String name_ar,String name_en,String desc) throws InterruptedException {

        clickButton(home);
        clickButton(accountType);
        Thread.sleep(1000);
        clickbtn(addaccount);
        Thread.sleep(1000);
        sendText(namear,name_en);
        sendText(nameen,name_en);
        sendText(description,desc);
        clickButton(active);
        Thread.sleep(1000);
        clickbtn(saveButton);
    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
