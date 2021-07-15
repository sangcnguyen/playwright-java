package pages;

import com.microsoft.playwright.Page;

public class DynamicLoading {
    private final Page page;

    private final String locator_dynamic_link_1 = "a[href='/dynamic_loading/1']";
    private final String locator_dynamic_link_2 = "a[href='/dynamic_loading/2']";
    private String locator_start_button = "text=Start";
    private String locator_visible_DynamicLink_1 = "div[id='finish'] h4";


    public DynamicLoading(Page page) {
        this.page = page;
    }

    public void goToPage() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading");
    }

    public void clickDynamicLoadingLink1() {
        page.click(locator_dynamic_link_1);
    }

    public void clickDynamicLoadingLink2() {
        page.click(locator_dynamic_link_2);
    }

    public void clickStart() {
        page.click(locator_start_button);
    }

    public String getActualDynamicLink1() {
        return locator_visible_DynamicLink_1;
    }
}
