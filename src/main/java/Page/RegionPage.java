package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegionPage extends PageBase{
    public RegionPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String region="//span[normalize-space()='تعريف المناطق']";
    private String addregion="إضافة";
    private String namear="//input[@formcontrolname='name']";
    private  String nameen="//input[@formcontrolname='englishName']";
    private  String regiontype="//mat-label[text()='نوع المنطقة']";
    private String selecttype="mat-option";
    private String active="//input[@type='checkbox']";
    private  String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addregion(String name_ar,String name_en,String region_type) throws InterruptedException {

        clickButton(home);
        clickButton(datatab);
        clickButton(region);
        Thread.sleep(1000);
        clickbtn(addregion);
        Thread.sleep(1000);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        clickButton(regiontype);
        chosselist(selecttype,region_type);
        clickbtn(saveButton);
        Thread.sleep(1000);

    }
    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }

}
