package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountPersonalOptionsPage extends AbstractPage {

    public WebElement searchOptions() {
        return waitForElementPresent(By.linkText("Search Options"));
    }

    public WebElement navigateDirectForSingleRecordOption() {
        return waitForElementPresent(By.id("ctl00_cphBody_chkSingleSearchResult"));
    }

//    public WebElement save() {
//        return waitForElementPresent(By.id("ctl00_cphBody_btnSave"));
//    }
}
