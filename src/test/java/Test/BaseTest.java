package Test;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.security.SecureRandom;
import java.util.Random;
import Page.companyPage;
import Page.companyCategoryPage;
import Page.cardCategoryPage;
import Page.currencyPage;
import Page.AccountTypePage;
import Page.BranchPage;
import Page.RegionPage;
import Page.WalletTypePage;
import Page.SupplierPage;
import Page.PaymentColletorPage;
import Page.UploadcardFilePage;
import Page.TransferRequestPage;
import Page.uploadcardcontentPage;
import Page.uploadedcardsPage;
import Page.penddingTransferPage;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    protected static String url;

    static String campname="";
    static String cardamt="";

    static String user="";
    static String pass="";

    static String regionname="منظقه" + ran3Digits();
    static cardCategoryPage clp;
    static currencyPage cpt;
    static AccountTypePage atp;
    static companyPage cp;
    static companyCategoryPage cpc;
    static BranchPage bp;
    static RegionPage rp;
    static WalletTypePage wtp;
    static SupplierPage sp;
    static PaymentColletorPage pcp;
    static UploadcardFilePage ucfp;
    static TransferRequestPage tr;
    static uploadcardcontentPage ucp;
    static uploadedcardsPage udcp;
    static penddingTransferPage ptp;

    static String branchname="branch"+ran3Digits();
    static String supplier="مورد" + ran3Digits();

    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browserName) {

        if(System.getenv("url")==null) {
            url = "http://138.199.218.4:8080/auth/login";
            user = "mnabeh1";
            pass="12345678";
        }else {
            url=System.getenv("url");
            user=System.getenv("username");
            pass=System.getenv("password").toString();
        }
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions =
                new BrowserType.LaunchOptions()
                        .setHeadless(false)   // true لو CI
                        .setSlowMo(50);       // اختياري للتشخيص

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "webkit":
                browser = playwright.webkit().launch(launchOptions);
                break;
            default:
                browser = playwright.chromium().launch(launchOptions);
        }

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1280, 720)
                        .setAcceptDownloads(true)
        );

        page = context.newPage();
        page.navigate(url);

        if(System.getProperty("cardamt")==null){
            campname="موب"+ran3Digits();
            cardamt=ran2Digits();
        }else {
            campname=System.getenv("compname").toString();
            cardamt=System.getProperty("cardamt").toString();
        }

    }

    @AfterSuite
    public void close() {

        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    // ===== Utilities =====

    protected static String randomEmail() {

        String pattern = "ABCDEFGHIJKLMNOPQRSTDNEpUTHQoQUJMHLrErGJyHg89uy71MyuH234567890";
        Random random = new Random();
        StringBuilder randEmail = new StringBuilder();

        while (randEmail.length() < 10) {
            int index = random.nextInt(pattern.length());
            randEmail.append(pattern.charAt(index));
        }

        return randEmail + "@gmail.com";
    }

    protected static String ran6Digits() {
        SecureRandom random = new SecureRandom();
        int number = random.nextInt(1_000_000);
        return String.format("%06d", number);
    }

    protected static String ran3Digits() {
        Random random = new Random();
        int number= 100 + random.nextInt(9000);
        return String.format("%04d", number);

    }
    protected static String ran2Digits() {
        Random random = new Random();
        int number= 0 + random.nextInt(900);
        return String.format("%03d", number);

    }

    public static String randomPhone09() {
        int number = new Random().nextInt(100_000_000); // 8 digits
        return "09" + String.format("%08d", number);
    }

    public static String random12Digits() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10)); // رقم من 0 إلى 9
        }
        return sb.toString();
    }

}
