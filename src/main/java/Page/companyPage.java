package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class companyPage extends PageBase{
    public companyPage(Page page) {
        super(page);
    }


    private String datatab="text=البيانات الاساسية";
    private String companypage="//span[normalize-space()='الشركات']";
    private String addcompany="إضافة شركة";
    private String namear="//input[@formcontrolname='nameArabic']";
    private  String nameen="//input[@formcontrolname='nameEnglish']";
    private  String code="//input[@formcontrolname='code']";
    private  String type="//input[@formcontrolname='type']";
    private  String fileUploadcard ="//input[@formcontrolname='fileUploadCode']";
    private  String status="(//mat-select)[1]";
    private String currency="//input[@placeholder='ابحث عن العملة']";
    private String category="//input[@placeholder='ابحث عن التصنيف']";
    private  String droplist="mat-option span.mdc-list-item__primary-text";
    private String discount="//input[@formcontrolname='discount']";
    private String MNO="//input[@type='checkbox']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";


    public void add_new_company(String name_ar,String name_en
            ,String codes,String Type,String Fileuploadcode,String statuss
            ,String curr,String cat , String disc
    ) throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        clickButton(companypage);
        Thread.sleep(1000);
        clickbtn(addcompany);
        Thread.sleep(1000);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        sendText(code,codes);
        sendText(type,Type);
        sendText(fileUploadcard,Fileuploadcode);
        clickButton(status);
        Thread.sleep(1000);
        chosselist(droplist,statuss);
        clickButton(currency);
        Thread.sleep(1000);
        chosselist(droplist,curr);
        clickButton(category);
        Thread.sleep(1000);
        chosselist(droplist,cat);
        sendText(discount,disc);
       clickButton(MNO);
        clickbtn(saveButton);
    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
