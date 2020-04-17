package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalConfirmationPage extends AbstractPage {

    public WebElement homeButton() {
        return waitForElementPresent(By.xpath("/html/body/app/div/header/div/nav/ul/li[1]/a/i"));
    }

    public WebElement signOut() {
        return waitForElementPresent(By.xpath("/html/body/app/div/header/div/div[2]/ul/li[2]/a/i"));
    }

}
