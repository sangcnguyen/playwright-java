package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    @BeforeMethod
    public void goToPage() {
        dynamicLoadingPage.goToPage();
    }

    @AfterMethod
    public void backToPreviousPage() {
        dynamicLoadingPage.goToPage();
    }

    @Test()
    public void verifyElementOnPageThatIsHidden() {
        dynamicLoadingPage.clickDynamicLoadingLink1();
        dynamicLoadingPage.clickStart();
        Assert.assertEquals(dynamicLoadingPage.getActualDynamicLinkText(), "Hello World!");
    }

    @Test()
    public void verifyElementRenderedAfterTheFact() {
        dynamicLoadingPage.clickDynamicLoadingLink2();
        dynamicLoadingPage.clickStart();
        Assert.assertEquals(dynamicLoadingPage.getActualDynamicLinkText(), "Hello World!");
    }
}
