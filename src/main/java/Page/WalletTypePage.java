package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WalletTypePage extends PageBase{
    public WalletTypePage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String walletType="//span[normalize-space()='نوع المحفظة']";
    private String addwllet="إضافة";
    private String namear="//input[@formcontrolname='nameArabic']";
    private  String nameen="//input[@formcontrolname='nameEnglish']";
    private String description="//textarea[@formcontrolname='description']";
    private  String active="(//input[@type='checkbox'])[1]";
    private  String wallet="(//input[@type='checkbox'])[2]";
    private  String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void Addwallet(String name_ar,String name_en,String descriptions) throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        clickButton(walletType);
        Thread.sleep(1000);
        clickbtn(addwllet);
        Thread.sleep(1000);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        sendText(description,descriptions);
        clickButton(active);
        clickButton(wallet);
        clickbtn(saveButton);
        Thread.sleep(1000);

    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
