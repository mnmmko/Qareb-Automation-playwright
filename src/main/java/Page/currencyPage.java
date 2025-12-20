package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class currencyPage extends PageBase{
    public currencyPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String currency="//span[normalize-space()='العملات']";
    private String addacurrency="إضافة";
    private String namear="//input[@formcontrolname='nameArabic']";
    private  String nameen="//input[@formcontrolname='nameEnglish']";
    private  String symbol="//input[@formcontrolname='symbol']";
    private  String fraction="//input[@formcontrolname='fraction']";
    private  String localcurrency="(//input[@type='checkbox'])[1]";
    private  String perv="(//input[@type='checkbox'])[2]";
    private  String active="(//input[@type='checkbox'])[3]";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void add_currency(String name_ar,String name_en,String symbols,String fractions) throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        clickButton(currency);
        Thread.sleep(1000);
        clickbtn(addacurrency);
        Thread.sleep(1000);
        sendText(namear,name_ar);
        sendText(nameen,name_en);
        sendText(symbol,symbols);
        sendText(fraction,fractions);
        clickButton(localcurrency);
        clickButton(perv);
//        clickButton(active);
        clickbtn(saveButton);
        Thread.sleep(1000);
    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }
}
