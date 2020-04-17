package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 324102 on 7/17/2017.
 */
public class PaymentFailurePage extends AbstractPage {

    public WebElement nextEventBacsFailureSaveBtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement bacsFailureAmountTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Amount')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailureAdviceTypeTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'AdviceType')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailureTransactionCodeTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Transaction Code')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailureFailureCodeTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Failure Code')]/../following-sibling::td/input[1]"));
    }


    public WebElement bacsFailureAccountNumberTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Account Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailureSortCodeTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Sort Code')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailureAccountNameTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Account Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement bacsFailurePaperlessDDTxt() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Use Paperless DD')]/../following-sibling::td/input[1]"));
    }

    public WebElement paymentScheduledForUpgrade() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Cover - Scheduled')]/following-sibling::td/input"));
    }

    public WebElement lnkpaymentScheduledForUpgrade() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Cover - Scheduled')]/following-sibling::td/input[1]"));
    }

    public WebElement paymentStatusForUpgrade(String status) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + status + "')]"));
    }

    public WebElement paymentFailureForUpgradeCancelBtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancel"));
    }


    public WebElement paymentFailureForUpgradeBackBtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnGoBack"));
    }
}
