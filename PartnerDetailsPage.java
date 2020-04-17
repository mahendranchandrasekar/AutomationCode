package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class PartnerDetailsPage extends AbstractPage {

    public WebElement partnerTab() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPartnerDetails"));
    }

    public WebElement title() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucPartnerInfo1_ddlPartnerTitle"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucPartnerInfo1_tbPartnerFirstName"));
    }
}
