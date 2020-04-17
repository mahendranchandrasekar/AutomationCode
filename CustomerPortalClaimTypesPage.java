package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalClaimTypesPage extends AbstractPage {

    public WebElement nextButton() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/div/button/i"));
    }

    public WebElement baggage() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[1]/div[1]/div/label"));
    }

    public WebElement baggageType() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[1]/div[1]/div[2]/select"));
    }

    public WebElement cancellation() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[1]/div[2]/div/label"));
    }

    public WebElement cancellationType() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[1]/div[2]/div[2]/select"));
    }

    public WebElement curtailment() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[2]/div/div/label"));
    }

    public WebElement curtailementType() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[2]/div/div[2]/select"));
    }

    public WebElement emergencyMedical() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[3]/div/div/label"));
    }

    public WebElement emergencyMedicalType() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/perils/div/div/div[2]/peril-select/div/div/div[3]/div/div[2]/select"));
    }
}
