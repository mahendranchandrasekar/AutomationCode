package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DetailFieldsListPage extends AbstractPage {

    public WebElement filterByLeadType() {
        return waitForElementPresent(By.name("ctl00$cphBodyWithoutUpdatePanel$cphBody$ddlFilterByLeadType"));
    }

    public WebElement managePages() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnManagePages"));
    }
}