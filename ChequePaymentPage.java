package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChequePaymentPage extends AbstractPage {

    public WebElement paymentStopCheckBox() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'grdPayments')]//input" ) );
    }

    public WebElement paymentStopSaveBtn() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'SaveButton')]" ) );
    }

    public WebElement messageDisplayedInChequePayment() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'No payments available')]" ) );
    }
}
