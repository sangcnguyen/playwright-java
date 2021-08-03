package factory;

import com.microsoft.playwright.Page;

public class BrowserFactory {
    private BrowserFactory() {
    }

    public static Page createInstance(BrowserType browserType) {
        Page page = null;
        switch (browserType) {
            case CHROME:
                page = new ChromeContext().startService();
                break;
            case FIREFOX:
                page = new FirefoxContext().startService();
                break;
        }
        return page;
    }
}
