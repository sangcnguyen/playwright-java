import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    DynamicLoading dynamicLoading;

    @BeforeMethod
    public void goToPage() {
        dynamicLoading = new DynamicLoading(page);
        dynamicLoading.goToPage();
    }

    @AfterMethod
    public void backToPreviousPage() {
        dynamicLoading.goToPage();
    }

    @Test()
    public void verifyElementOnPageThatIsHidden() {
        dynamicLoading.clickDynamicLoading1();
        dynamicLoading.clickStart();
        page.waitForSelector(dynamicLoading.getActualDynamicLink1());
        Object value = page.evalOnSelector(dynamicLoading.getActualDynamicLink1(), "el => el.innerText");
        Assert.assertEquals(value, "Hello World!");
    }

    @Test()
    public void verifyElementRenderedAfterTheFact() {
        dynamicLoading.clickDynamicLoading2();
        dynamicLoading.clickStart();
        page.waitForSelector(dynamicLoading.getActualDynamicLink1());
        Object value = page.evalOnSelector(dynamicLoading.getActualDynamicLink1(), "el => el.innerText");
        Assert.assertEquals(value, "Hello World!");
    }
}
