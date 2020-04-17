package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class SelectItemsForPaymentPage extends AbstractPage {

    public WebElement selectButton() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'btnSetToPay')]"));
    }

//    public WebElement saveButton() {
//        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
//    }

    public WebElement paymentMethod() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlPayment')]"));
    }

    public WebElement claimItemsTable() {
        return waitForElementPresent(By.xpath("//h3[text()='Claim Items']/../div/div/table"));
    }

    public WebElement paymentCheckox(String strRow) {
        return waitForElementPresent(By.xpath("(//input[contains(@id,'chkPay')])[" + strRow + "][@type='checkbox']"));
    }
}
