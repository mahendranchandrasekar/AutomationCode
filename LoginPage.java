package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

    public WebElement eMail() {
        return waitForElementPresent(By.id("ctl00_cphBody_userName"));
    }

    public WebElement password() {
        return waitForElementPresent(By.id("ctl00_cphBody_password"));
    }

    public WebElement logon() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBody_btnLogon"));
    }

}
