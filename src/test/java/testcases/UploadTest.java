package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest extends BaseTest {
    @BeforeMethod
    public void goToPage() {
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
