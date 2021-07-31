package testcases;

import com.google.inject.Inject;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;
import factory.BrowserManager;
import factory.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    public Page page;
    //    private Browser browser;
//    private BrowserContext context;
    @Inject
    BrowserManager browserManager;

    @BeforeClass
    public void setUp() {
//        var videoPath = Paths.get("videos/");
//        var contextOptions = new Browser.NewContextOptions()
//                .setViewportSize(1920, 1080)
//                .setRecordVideoDir(videoPath)
//                .setRecordVideoSize(1920, 1080);
//        browser = Playwright
//                .create()
//                .chromium()
//                .launch(new BrowserType.LaunchOptions().setHeadless(true));
//        context = browser.newContext(contextOptions);
//        page = context.newPage();
//        browserManager = BrowserFactory.getBrowserInstance(BrowserType.CHROME);


        browserManager.getPageInstance();
    }

    @AfterClass
    public void tearDown() {
        browserManager.closePageInstance();
    }
}
