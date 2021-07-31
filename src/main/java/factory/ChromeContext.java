package factory;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class ChromeContext extends BrowserManager {
    @Override
    protected void startService() {
        var videoPath = Paths.get("videos/");
        var contextOptions = new com.microsoft.playwright.Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setRecordVideoDir(videoPath)
                .setRecordVideoSize(1920, 1080);
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(contextOptions);
        page = context.newPage();
    }

    @Override
    protected void stopService() {
        context.close();
        browser.close();
    }
}
