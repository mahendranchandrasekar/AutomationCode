package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IAdminSecurityManagementPage extends AbstractPage {

    public WebElement provideSensitiveAccess(String recordAccessType) {
        return waitForElementPresent(By.xpath(".//*[text()='" + recordAccessType + "']/../td[4]/input"));
    }

    public WebElement provideUserAccess() {
        return waitForElementPresent(By.id("ctl00_cphBody_ddlAssignUser"));
    }

    public WebElement assignSensitiveAccess() {
        return waitForElementPresent(By.id("ctl00_cphBody_btnAssignUserSave"));
    }

    public WebElement iptValueForSpecificRegion(String region) {
        return waitForElementPresent(By.xpath("//input[@value='" + region + "']/../following-sibling::td[2]/input"));
    }

    public WebElement validateIPTRegion(String region) {
        return waitForElementPresent(By.xpath("//input[contains(@value,'" + region + "')]"));
    }

    public WebElement retrieveValueFromTaxRegion(String region) {
        return waitForElementPresent(By.xpath("(//input[contains(@value,'" + region + "')])[2]/../following-sibling::td/input[1]"));
    }


    public WebElement groupId(String userLevel) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + userLevel + "')]/preceding-sibling::td"));
    }

    public WebElement vatRateTypeForStatus(String status) {
        return waitForElementPresent(By.xpath("//table[@id='Rad303091_ctl01']//tbody//td[contains(text(),'"+status+"')]/following-sibling::td"));
    }

    public WebElement vatRateForStatus(String status,String country) {
        return waitForElementPresent(By.xpath("//table[@id='Rad303091_ctl01']//tbody//td[contains(text(),'"+country+"')]/following-sibling::td[contains(text(),'"+status+"')]/following-sibling::td[2]"));
    }
}
