package testcases;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;
import factory.BrowserType;
import factory.PageThreadLocal;
import module.PageModule;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.DynamicLoadingPage;
import pages.UploadPage;

public abstract class BaseTest {
    Page page;
    DynamicLoadingPage dynamicLoadingPage;
    UploadPage uploadPage;

    @BeforeClass
    public void setUp() {
        page = BrowserFactory.createInstance(BrowserType.FIREFOX);
        PageThreadLocal.setPage(page);
        Injector injector = Guice.createInjector(new PageModule());
        dynamicLoadingPage = injector.getInstance(DynamicLoadingPage.class);
        uploadPage = injector.getInstance(UploadPage.class);
    }

    @AfterClass
    public void closeBrowser() {
        PageThreadLocal.closePage();
    }
}
