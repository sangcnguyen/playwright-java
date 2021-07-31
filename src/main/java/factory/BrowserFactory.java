package factory;

public class BrowserFactory {
    private BrowserFactory() {
    }

    public static BrowserManager getBrowserInstance(BrowserType browserType) {
        BrowserManager browserManager = null;
        if (browserType.equals(BrowserType.CHROME)) browserManager = new ChromeContext();
        return browserManager;
    }
}
