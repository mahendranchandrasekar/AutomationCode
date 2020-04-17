package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IncidentsPage extends AbstractPage {
    public WebElement incidentsWebTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdIncidents')]"));
    }

//    public WebElement save() {
//        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
//    }

    public WebElement related(String strRowID) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//table[contains(@id,'grdIncidents')]/tbody/tr[" + strRowID + "]/td/span[@class='checkboxRelated']"));
    }

}
