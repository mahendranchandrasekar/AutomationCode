package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ImportantPage extends AbstractPage {

    public WebElement okButton() {
        return waitForElementPresent(By.id("btnCancel"));
    }

}
