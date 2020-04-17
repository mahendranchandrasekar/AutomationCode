package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class PaymentApprovalLimitsPage extends AbstractPage {

    public WebElement level() {
        return waitForElementPresent(By.id("txt300949"));
    }

    public WebElement paymentApprovalLimit() {
        return waitForElementPresent(By.xpath("(//span[contains(text(), 'Payment Approval Limit')])[2]/../following-sibling::td/span/input[1]"));
    }

    public WebElement selfApprovalLimit() {
        return waitForElementPresent(By.xpath("//span[contains(text(), 'Self Approval Limit')]/../following-sibling::td/span/input[1]"));
    }

    public WebElement paymentApprovalLimitTable() {
        return waitForElementPresent(By.id("detailFieldRadGrid_ctl01"));
    }

    public WebElement next() {
        return waitForElementPresent(By.linkText("Next"));
    }

    public WebElement dialogFrame() {
        return waitForElementPresent(By.name("DialogWindow"));
    }

    public WebElement addUpdate() {
        return waitForElementToBeClickableAndReturnElement(By.id("btnAdd"));
    }


    public WebElement levelName() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[text()='Level']/../following-sibling::tr/td[5]/input"));
    }

    public WebElement levelNameFilter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[text()='Level']/../following-sibling::tr/td[5]/img"));
    }

    public WebElement levelNameFilterContains() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'Contains')]"));
    }
}
