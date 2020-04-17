package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FinancialPage extends AbstractPage {

    public WebElement claimMovementTable() {
        return waitForElementPresent(By.xpath("//table[@id='Rad301184_ctl01']"));
    }

    public WebElement financialTab() {
        return waitForElementPresent(By.xpath("//*[@id='tsPages_tab26341']/span/span"));
    }

    public String claimMovementTableStr() {
        return "//table[@id='Rad301184_ctl01']";
    }

    public WebElement totalAmountPaid() {
        return waitForElementPresent(By.xpath("//table[@id='tbl301226']/tbody/tr/td/input[@id='txt301226']"));
    }

    public WebElement claimsPaymentTable() {
        return waitForElementPresent(By.xpath(".//*[@id='Rad301068_ctl01']"));
    }

    public WebElement internalTab() {
        return waitForElementPresent(By.xpath("//span[text()='Internal']"));
    }

    public WebElement retrieveTableRowIDFromFinancialTable() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Payments')]/../../following-sibling::tr//*/table/tbody/tr/td"));
    }

    public WebElement closeWindow_FinancialTab() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[@name='btnClose']"));
    }

    public WebElement retrieveTotalClaimValue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Total Claim Value (calculated) ')]/../following-sibling::td[1]/span[1]"));
    }

    public WebElement retrieveEstimatedAmount() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Estimated Amount')]/../../../../tbody/tr/td[9]"));
    }

    public WebElement retrievePercentage() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Estimated Amount')]/../../../../tbody/tr/td[8]"));
    }

    public WebElement estRecoverAmt() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Est. Recov.')]/../following-sibling::tr[1]/td[13]"));
    }

    public WebElement paymentsRowID() {
        return waitForElementVisible(By.xpath("//table[@class='MasterTable_Default gridRad301068_ctl01']//tbody/tr/td[1]"));
    }

    public WebElement onholdPayments(String paymentRowId) {
        return waitForElementVisible(By.xpath("//h3[contains(text(),'Payments On Hold')]/following::div//table//td[contains(text(),'"+paymentRowId+"')]"));
    }
    public WebElement excessValueDeducted() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Excess and/or limit applied')]/following-sibling::td[2]"));
    }
    public WebElement retrieveApprovedReserve() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Excess and/or limit applied')]/following-sibling::td[7]"));
    }
}
