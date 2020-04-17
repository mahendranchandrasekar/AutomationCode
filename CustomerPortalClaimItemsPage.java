package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalClaimItemsPage extends AbstractPage {

    public WebElement nextButton() {
        return waitForElementPresent(By.cssSelector("button.primary-button.active[routerlink='/documents']"));
    }

    public WebElement whatDate() {
        return waitForElementPresent(By.xpath("//*[@id=\"dateOfLoss\"]"));
    }

    public WebElement whatHappened() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[1]/form/div[2]/textarea"));
    }

    public WebElement addItem() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div/div/i"));
    }

    public WebElement claimItem() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/form/div[1]/div[1]/div/select"));
    }

    public WebElement amount() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div[1]/div[2]/div/input"));
    }

    public WebElement currency() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div[1]/div[3]/div/select"));
    }

    public WebElement person() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div[1]/div[4]/div/select"));
    }

    public WebElement description() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div[1]/div[5]/div/textarea"));
    }

    public WebElement save() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[2]/div[2]/div[2]/div[1]/i"));
    }

    public WebElement save1() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/claim-edit/div[3]/button/i"));
    }

    public WebElement submit() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/claim-details/div/div/div[2]/button/i"));
    }

    public WebElement notification() {
        return waitForElementPresent(By.xpath("//div[@id='notifArea']/notification/div/div[1]/div[2]/h3"));
    }
}
