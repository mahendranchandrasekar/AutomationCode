package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentAwaitingApprovalPage extends AbstractPage {

    public WebElement approveRadioBtn() {
        return waitForElementPresent(By.xpath("//span[@class='rbApprove']/input"));
    }

    public WebElement rejectRadioBtn() {
        return waitForElementPresent(By.xpath("//span[@class='rbReject']/input"));
    }

    public WebElement saveBtn() {
        return waitForElementPresent(By.xpath("//input[@value = 'Save']"));
    }

}
