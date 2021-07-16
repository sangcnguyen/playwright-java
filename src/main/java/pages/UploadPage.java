package pages;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class UploadPage {
    private final Page page;

    private final String LOCATOR_FILE_INPUT = "#file-upload";
    private final String LOCATOR_FILE_SUBMIT = "#file-submit";
    private final String LOCATOR_SUCCESS_MESSAGE = "#uploaded-files";

    public UploadPage(Page page) {
        this.page = page;
    }

    public void goToPage() {
        page.navigate("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String fileName) {
        var fileToUpload = Paths.get(String.format("src/test/resources/%s", fileName));
        page.setInputFiles(LOCATOR_FILE_INPUT, fileToUpload);
        page.click(LOCATOR_FILE_SUBMIT);
    }

    public Object getMessageAfterUpload() {
        page.waitForSelector(LOCATOR_SUCCESS_MESSAGE);
        return page.evalOnSelector(LOCATOR_SUCCESS_MESSAGE, "el => el.outerText");
    }
}
