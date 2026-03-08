package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PaymentColletorPage extends PageBase{
    public PaymentColletorPage(Page page) {
        super(page);
    }

    private String datatab="text=الاشتراكات";
    private String collector="//span[normalize-space()='المندوبين']";
    private String addcoolector="إضافة مندوب";
    private String arrpw="(//mat-icon[text()='arrow_upward'])[1]";
    private String name="//input[@formcontrolname='name']";
    private String phone="//input[@formcontrolname='phoneNum1']";
    private String precntageofsale="//input[@formcontrolname='percentageOfSales']";
    private String region="//input[@formcontrolname='region']";
    private String selecttype="mat-option";
    private String branch="//input[@formcontrolname='branch']";
    private String address="//input[@formcontrolname='address']";
    private final String saveButton = "حفظ";
    private String successmsg=".swal2-html-container";

    public void addpaymentcolletor(String precntage,String regions,String branchs,String address1) throws InterruptedException {
        clickButton(home);
        clickButton(datatab);
        Thread.sleep(500);
        clickButton(collector);
        Thread.sleep(1000);
        clickbtn(addcoolector);
        clickButton(arrpw);
        sendText(precntageofsale,precntage);
        clearText(branch);

        sendText(branch,branchs);
        chosselist(branch,branchs);
        Thread.sleep(1000);
        clearText(region);
        sendText(region,regions);
        chosselist(region,regions);
        Thread.sleep(1000);
        chosselist(selecttype,regions);

        chosselist(selecttype,branchs);
        sendText(address,address1);
        Thread.sleep(1000);
        clickbtn(saveButton);
        Thread.sleep(1000);





    }

    public Locator getsuccmsg(){
        return page.locator(successmsg);
    }


}
