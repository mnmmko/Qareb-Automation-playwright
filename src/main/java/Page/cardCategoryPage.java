package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class cardCategoryPage extends PageBase{
    public cardCategoryPage(Page page) {
        super(page);
    }

    private String datatab="text=البيانات الاساسية";
    private String cardpage="//span[normalize-space()='فئات الشركات']";
    private String addcard="إضاف";
    private String nameofcard="//input[@formcontrolname='description']";
    private String amount="//input[@formcontrolname='amount']";
    private String company="(//input)[3]";
    private String selectcamp="mat-option";
    private String price="//input[@formcontrolname='price']";
    private String foriegnprice="//input[@formcontrolname='priceForForeignCurrency']";
    private String alert1="//input[@formcontrolname='alertLevel1']";
    private String alert2="//input[@formcontrolname='alertLevel2']";
    private String alert3="//input[@formcontrolname='alertLevel3']";
    private String active="//input[@type='checkbox']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addcard(String name,String amt,String companys,
                        String prices,String foriegnprices,String alert_1,
                        String alert_2,String alert_3) throws InterruptedException {
                    clickButton(home);
                    clickButton(datatab);
                    clickButton(cardpage);
                    Thread.sleep(1000);
                    clickbtn(addcard);
                    Thread.sleep(1000);
                    sendText(nameofcard,name);
                    sendText(amount,amt);
                    sendText(company,companys);
                    Thread.sleep(1000);
                    chosselist(selectcamp,companys);
                    sendText(price,prices);
                    sendText(foriegnprice,foriegnprices);
                    sendText(alert1,alert_1);
                    sendText(alert2,alert_2);
                    sendText(alert3,alert_3);
                    clickButton(active);
                    clickbtn(saveButton);

    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }

}
