package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class CustomerFAQPage extends AbstractPage {


    public WebElement lblMyCover() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'My Cover')]" ) );
    }

    public WebElement lblMedCond() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Medical Conditions')]" ) );
    }

    public WebElement lblClaim() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Making a Claim')]" ) );
    }

    public WebElement lblPolicy() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Policy Numbers and Documents')]" ) );
    }

    public WebElement lblChangeAddr() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Changing My Address')]" ) );
    }

    public WebElement lblAddUpgrades() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Adding Upgrades to My cover')]" ) );
    }

    public WebElement lblCloseAcct() {
        return waitForElementPresent( By.xpath( "//ul[@class='categories']/button[contains(text(),'Closing My Account')]" ) );
    }
}
