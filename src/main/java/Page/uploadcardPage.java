package Page;

import Excel.ExcelUtil;
import com.microsoft.playwright.Page;

import java.awt.*;
import java.io.IOException;

public class uploadcardPage extends PageBase{
    public uploadcardPage(Page page) {
        super(page);
    }

    private String datatab = "text=المخزون الجديد";
    private String uploadcardfile = "//span[normalize-space()='رفع محتوي كرت']";
    private String company = "//input[@placeholder='ابحث عن شركة...']";
    private String cards = "//mat-select[@formcontrolname='cardCategoryId']";
    private String uploadcarddata = "//textarea[@formcontrolname='cards']";
    private String arrowcards="Escape";
    private String selectitems = "mat-option";
    private String supplier = "//input[@placeholder='ابحث عن مورد...']";
    private String date = "//input[@formcontrolname='expiryDate']";
    private String discount = "//input[@formcontrolname='discount']";
    private String exchangeRate = "//input[@formcontrolname='exchangeRate']";


    private String notes="//textarea[@formcontrolname='note']";

    private String extradelmeter = "//input[@formcontrolname='extraDelimiter']";
    private  String saveButton = "حفظ";

    private String selectcode="(//mat-select)[2]";
    private String selectamount="(//mat-select)[3]";
    private String uploadconfirm="مراجعة وتأكيد";

    private String penddinguploads="text=الملفات المعلقة";
    private String sortopt="//span[contains(normalize-space(.), 'رقم العملية')]";
    private String showpenddingrequest="(//i[@title='عرض' and normalize-space()='visibility'])[1]";


    private String confirmup="تأكيد";

    public void addcard(String companynames,String cardss,String delameter,
                        String supp,String dates,String discounts,
                        String exchangerates,String notess) throws InterruptedException, AWTException, IOException {

        clickButton(home);

        clickButton(datatab);
        clickButton(uploadcardfile);
        sendText(company,companynames);
        Thread.sleep(1000);
        clickButton(company);
        Thread.sleep(1000);
        chosselist(selectitems,companynames);
        Thread.sleep(1500);
        clickButton(cards);
        Thread.sleep(1000);
        chosselist(selectitems,cardss);
        Thread.sleep(500);
        keypoardclick(arrowcards);
        Thread.sleep(500);
        sendText(uploadcarddata,getcards(cardss,delameter));
        Thread.sleep(1000);
        sendText(supplier,supp);
        Thread.sleep(1000);
        clickButton(supplier);
        chosselist(selectitems,supp);
        Thread.sleep(1000);
        sendText(date,dates);
        sendText(discount,discounts);
        sendText(exchangeRate,exchangerates);

        sendText(notes,notess);


        Thread.sleep(1000);
        clickbtn(saveButton);
        Thread.sleep(1000);

        clickButton(selectcode);
        chosselist(selectitems,"Code");
        Thread.sleep(1000);
        clickButton(selectamount);
        chosselist(selectitems,"Amount");
        Thread.sleep(1000);
        clickbtn(uploadconfirm);
        Thread.sleep(1000);
        clickbtn(confirmup);
        Thread.sleep(1000);

        clickButton(penddinguploads);
        clickButton(sortopt);
        Thread.sleep(1000);
        clickButton(showpenddingrequest);

        clickbtn(confirmup);
        Thread.sleep(2000);


    }

    public String getcards(String amount,String delametar){
        String upload="";
        for(int i=1;i<=500;i++){
            upload+=random12Digits()+delametar+amount+"\n";
        }
        return upload;
    }
}
