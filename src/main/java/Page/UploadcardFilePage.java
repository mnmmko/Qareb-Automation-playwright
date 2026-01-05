package Page;

import Excel.ExcelUtil;
import com.microsoft.playwright.Page;
import org.apache.poi.ss.formula.functions.T;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


public class UploadcardFilePage extends PageBase {
    public UploadcardFilePage(Page page) {
        super(page);
    }

    File excelFile;

    private String datatab = "text=المخزون الجديد";
    private String uploadcardfile = "//span[normalize-space()='رفع ملف كروت']";
    private String company = "//input[@placeholder='ابحث عن شركة...']";
    private String cards = "//mat-select[@formcontrolname='cardCategoryId']";
    private String arrowcards="Escape";
    private String selectitems = "mat-option";
    private String supplier = "//input[@placeholder='ابحث عن مورد...']";
    private String date = "//input[@formcontrolname='expiryDate']";
    private String discount = "//input[@formcontrolname='discount']";
    private String exchangeRate = "//input[@formcontrolname='exchangeRate']";
    private String autoserial="//input[@type='checkbox']";
    private String notes="//textarea";
    private String uploadfiles="//div[@class='upload-file']";
    private  String saveButton = "حفظ";

    private String selectcode="(//mat-select)[2]";
    private String selectamount="(//mat-select)[3]";
    private String uploadconfirm="مراجعة وتأكيد";



    private String confirmup="تأكيد";

    public void addfile(String companynames,String cardss,String supp,String dates,String discounts,String exchangerates,String notess) throws InterruptedException, AWTException, IOException {

        clickButton(home);
        excelFile = ExcelUtil.createExcelFile(cardss);
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
        sendText(supplier,supp);
        Thread.sleep(1000);
        chosselist(selectitems,supp);
        Thread.sleep(500);
        sendText(date,dates);
        sendText(discount,discounts);
        sendText(exchangeRate,exchangerates);
        clickButton(autoserial);
        sendText(notes,notess);
        clickButton(uploadfiles);
        Thread.sleep(1000);
        addfiles(excelFile.getAbsolutePath().toString());
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

    }


}
