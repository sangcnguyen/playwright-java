package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public abstract class AbstractBrowser {
    protected Page page;
    protected Browser browser;
    protected BrowserContext context;

    protected abstract Page startService();
}
