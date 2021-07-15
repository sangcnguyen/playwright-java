package testcases;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;

public class BaseTest {
    public Page page;
    private Browser browser;
    private BrowserContext context;

    @BeforeClass
    public void setUp() {
        var videoPath = Paths.get("videos/");
        var contextOptions = new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setRecordVideoDir(videoPath)
                .setRecordVideoSize(1920, 1080);
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(contextOptions);
        page = context.newPage();
    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
    }
}
