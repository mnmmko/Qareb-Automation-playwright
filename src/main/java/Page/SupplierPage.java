package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SupplierPage extends PageBase{
    public SupplierPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String supplier="//span[normalize-space()='الموردين']";
    private String addsupp="إضافة";
    private String namear="//input[@formcontrolname='nameArabic']";
    private  String nameen="//input[@formcontrolname='nameEnglish']";
    private  String address1="//input[@formcontrolname='address1']";
    private  String phonenum1="//input[@formcontrolname='phoneNumber1']";
    private  String status="//mat-select";
    private String selectstatus="mat-option";
    private  String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addsupplier(String name_ar,String name_en,String add1,String phone1,String status1) throws InterruptedException {
//       clickButton(datatab);
        clickButton(supplier);
        Thread.sleep(1000);
        clickbtn(addsupp);
        Thread.sleep(1000);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        sendText(address1,add1);
        sendText(phonenum1,phone1);
       clickButton(status);
        Thread.sleep(1000);
       chosselist(selectstatus,status1);
        clickbtn(saveButton);
        Thread.sleep(500);
    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
