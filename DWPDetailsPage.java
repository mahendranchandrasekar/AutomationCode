package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class DWPDetailsPage extends AbstractPage {

    public WebElement dwpMandatoryFields(String valueToCheck) {
        return waitForElementPresent(By.xpath(" //span[contains(text(),'" + valueToCheck + "')]/../..//input[@type = 'checkbox']"));
    }

    public WebElement dwpSaveBtn() {
        return waitForElementPresent(By.xpath("//input[@id='ucMandatoryFieldEditor_btnSave']"));
    }

}
