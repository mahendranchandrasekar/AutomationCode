package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ChaseClaimsEvidencePage extends AbstractPage {

    public WebElement clientConfig() {
        return waitForElementPresent(By.xpath("//*[@id=\"tsPages_tab26324\"]/span/span"));
    }

    public WebElement leadManager() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBody_pnlLeadManager\"]/div/a[2]"));
    }

    public WebElement leadType() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByLeadType\"]"));
    }

    public void selectLeadType(String strLeadType) {
        this.leadType().click();
        new Select(this.leadType()).selectByVisibleText(strLeadType);
    }

    public WebElement evidanceChaseBase() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask\"]/tbody/tr/td[2][text()='Evidence Chase Base']/../td[9]/a"));
    }

    public WebElement closeClaimBase() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask\"]/tbody/tr/td[2][text()='Close Claim Base']/../td[9]/a"));
    }

    public WebElement evidanceChaseBaseSetNow() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_btnSetNextRunToNow\"]"));
    }

    public WebElement evidanceChaseBaseSave() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_btnTaskSave\"]"));
    }

//    public WebElement close() {
//        return waitForElementPresent(By.xpath("//*[@id=\"btnCustomerLeadDetails\"]"));
//    }

    public WebElement batchJobModifier() {
        return waitForElementPresent(By.name("txt301308"));
    }
}
