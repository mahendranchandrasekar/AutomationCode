package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UploadDocumentPage extends AbstractPage {

    public WebElement chooseFile() {
        return waitForElementPresent(By.id("ctl00_cphBody_FileUpload1"));
    }

}
