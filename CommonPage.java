package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage extends AbstractPage {

    public WebElement fancyFrame() {
        return waitForElementPresent( By.cssSelector( "iframe[id^='fancybox-frame'" ) );
    }

    public WebElement month() {
        return waitForElementToBeClickableAndReturnElement( By.cssSelector( ".pika-select pika-select-month" ) );
    }

    public WebElement year() {
        return waitForElementToBeClickableAndReturnElement( By.cssSelector( ".pika-select pika-select-year" ) );
    }

    public WebElement day(String strDay) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//button[@class='pika-button pika-day'][text()='" + strDay + "']" ) );
    }
}
