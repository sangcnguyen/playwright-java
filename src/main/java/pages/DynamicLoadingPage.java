package pages;

import com.microsoft.playwright.Page;

public class DynamicLoadingPage {
    private final Page page;

    private final String LOCATOR_DYNAMIC_LINK_1 = "a[href='/dynamic_loading/1']";
    private final String LOCATOR_DYNAMIC_LINK_2 = "a[href='/dynamic_loading/2']";
    private final String LOCATOR_START_BUTTON = "text=Start";
    private final String LOCATOR_VISIBLE_TEXT = "div[id='finish'] h4";


    public DynamicLoadingPage(Page page) {
        this.page = page;
    }

    public void goToPage() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading");
    }

    public void clickDynamicLoadingLink1() {
        page.click(LOCATOR_DYNAMIC_LINK_1);
    }

    public void clickDynamicLoadingLink2() {
        page.click(LOCATOR_DYNAMIC_LINK_2);
    }

    public void clickStart() {
        page.click(LOCATOR_START_BUTTON);
    }

    public Object getActualDynamicLinkText() {
        page.waitForSelector(LOCATOR_VISIBLE_TEXT);
        return page.evalOnSelector(LOCATOR_VISIBLE_TEXT, "el => el.innerText");
    }
}
