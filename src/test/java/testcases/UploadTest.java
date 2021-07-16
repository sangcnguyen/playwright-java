package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UploadPage;

public class UploadTest extends BaseTest {
    UploadPage uploadPage;

    @BeforeMethod
    public void goToPage() {
        uploadPage = new UploadPage(page);
        uploadPage.goToPage();
    }

    @Test()
    public void verifyFileIsPresentAfterUpload() {
        var fileName = "SampleImage.jpg";
        // uploading the file
        uploadPage.uploadFile(fileName);
        Assert.assertEquals(uploadPage.getMessageAfterUpload(), fileName);
    }
}
