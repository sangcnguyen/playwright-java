package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public abstract class BrowserManager {
    protected Page page;
    protected Browser browser;
    protected BrowserContext context;

    protected abstract void startService();

    protected abstract void stopService();

    public void closePageInstance() {
        stopService();
    }

    public Page getPageInstance() {
        if (page == null) {
            startService();
        }
        return page;
    }
}
