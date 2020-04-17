package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimCalculationPage extends AbstractPage {

    public WebElement claimCalculationTable() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'grdClaims')]" ) );
    }

    public WebElement userdeductionsReasons() {
        return waitForElementPresent( By.xpath( "//*[@id='ddlDeductions']" ) );
    }

    public WebElement userdeductionsAmount() {
        return waitForElementPresent( By.xpath( "//*[@id='txtDeduction']" ) );
    }

    public WebElement userdeductionsAddBtn() {
        return waitForElementPresent( By.xpath( "//*[@id='btnAddDeduction']" ) );
    }

    public WebElement userdeductionsSaveBtn() {
        return waitForElementPresent( By.xpath( "//*[@id='btnSave']" ) );
    }

    public String claimCalculationTableStr() {
        return "//table[contains(@id,'grdClaims')]";
    }

//    public WebElement saveButton() {
//        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_customFieldSaveButton" ) );
//    }
}
