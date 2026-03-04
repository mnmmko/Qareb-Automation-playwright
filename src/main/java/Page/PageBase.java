package Page;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PageBase {

    protected Page page;

    public PageBase(Page page) {
        this.page = page;
    }

    protected String home="//mat-icon[@data-mat-icon-name='home']";

    Robot robot;
    StringSelection file;
    public void wait_for_element(String element, int time){
        page.waitForSelector(element, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(time * 1000)  // بالمللي ثانية
        );
    }

    // ====== Get text ======
    public String getText(String selector) {
        wait_for_element(selector,10);
        return page.locator(selector).textContent();
    }

    // ====== Click ======
    public void clickButton(String selector) {
        wait_for_element(selector,10);
        page.locator(selector).click();
    }

    // ====== Double click ======
    public void doubleClickButton(String selector) {
        wait_for_element(selector,10);
        page.locator(selector).dblclick();
    }

    // ====== Send text ======
    public void sendText(String selector, String text) {
        wait_for_element(selector,10);
        page.locator(selector).fill(text);
    }

    //===========clear text===========
    public void clearText(String selector) {
        wait_for_element(selector,10);
        page.locator(selector).clear();
    }

    // ====== Get placeholder ======
    public String getPlaceholder(String selector) {
        page.waitForSelector(selector);
        return page.locator(selector).getAttribute("placeholder");
    }

    // ====== Get element (Locator) ======
    public Locator getElement(String selector) {
        wait_for_element(selector,10);
        return page.locator(selector);
    }

    // ====== Scroll down ======
    public void scrollDown() {
        page.evaluate("window.scrollBy(0,250)");
    }

    // ====== Select dropdown option ======
    public void selectItem(String selector, String text) {
        wait_for_element(selector,10);
        page.locator(selector).selectOption(
                new SelectOption().setLabel(text)
        );
    }

    // ====== Wait element invisible ======
    public void waitInvisibleElement(String selector) {
        page.waitForSelector(selector,
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.DETACHED));
    }
    public void clickbtn(String selector) {
        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(selector)
        ).click();
    }

    //==========click btn with name===========
    public void clickbtnexact(String selector) {
        page.getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(selector)
                        .setExact(true)
        ).click();

    }

    //==============choose drop dwon list================
    public void chosselist(String selector,String text) {
        page.locator(selector)
                .filter(new Locator.FilterOptions().setHasText(text)).first()
                .click();
    }

    // ===============assert alert===========
    public void assertSuccessAlert(String expectedText) {
        Locator alert = page.locator("#swal2-html-container");

        alert.waitFor(new Locator.WaitForOptions()
                .setTimeout(10_000));

        assertThat(alert).containsText(expectedText);
    }

    public void keypoardclick(String selector) {
        page.keyboard().press(selector);
    }

    public static String random12Digits() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10)); // رقم من 0 إلى 9
        }
        return sb.toString();
    }

    public void addfiles(String filepath) throws AWTException {
        file = new StringSelection(filepath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
