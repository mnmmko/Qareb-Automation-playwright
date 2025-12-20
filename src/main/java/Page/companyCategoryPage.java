package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class companyCategoryPage extends PageBase{
    public companyCategoryPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String companycatpage="text=تصنيف الشركات";
    private String addcomcat="//mat-icon[text()='add']";
    private String namear="//input[@placeholder='اكتب الاسم بالعربي']";
    private String nameen="//input[@placeholder='اكتب الاسم بالإنجليزي']";
    private String status="(//div[contains(@class,'mat-mdc-form-field-flex')])[3]";
    private String status1="(//mat-option)[1]";
    private String order="//input[@placeholder='ادخل الترتيب']";
    private String iscollapse="//input[@type='checkbox']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void add_new_company_category(String name_ar,String name_en,String orders){
        clickButton(datatab);
        clickButton(companycatpage);
        clickButton(addcomcat);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        clickButton(status);
        clickButton(status1);
        sendText(order,orders);
        clickButton(iscollapse);
        clickbtn(saveButton);
    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
