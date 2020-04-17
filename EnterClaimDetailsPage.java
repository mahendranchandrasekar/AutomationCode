package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class EnterClaimDetailsPage extends AbstractPage {

    public WebElement enterClaimDetailsFrame() {
        return waitForElementPresent(By.name("rwEventWizard"));
    }

}
