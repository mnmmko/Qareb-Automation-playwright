package Page;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PageBase {

    protected Page page;

    public PageBase(Page page) {
        this.page = page;
    }

    protected String home="//mat-icon[@data-mat-icon-name='home']";

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
    public void clickbtns(String selector) {
        page.getByRole(
                AriaRole.MENUITEM,
                new Page.GetByRoleOptions().setName(selector)
        ).click();
    }

    public void chosselist(String selector,String text) {
        page.locator(selector)
                .filter(new Locator.FilterOptions().setHasText(text)).first()
                .click();
    }
}
