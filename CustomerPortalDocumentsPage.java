package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalDocumentsPage extends AbstractPage {

    public WebElement nextButton() {
        return waitForElementPresent(By.xpath("/html/body/app/div/evidence/div/div[2]/button"));
    }

    public WebElement myClaims() {
        return waitForElementPresent(By.xpath("/html/body/app/div/header/div/nav/ul/li[3]/a/i"));
    }

    public WebElement view() {
        return waitForElementPresent(By.xpath("/html/body/app/div/claims/div/div/div[3]/div[2]/div[6]/div/a"));
    }

    public WebElement view1() {
        return waitForElementPresent(By.xpath("//*[@id=\"notifArea\"]/notification/div/div[1]/div[4]/div/a/i"));
    }

    public WebElement upload1() {
        return waitForElementPresent(By.xpath("/html/body/app/div/evidence/div/div[1]/div[3]/div/div[2]/div[1]/div[3]/input"));
    }

    public WebElement upload2() {
        return waitForElementPresent(By.xpath("/html/body/app/div/evidence/div/div[1]/div[3]/div/div[3]/div[1]/div[3]/input"));
    }

    public WebElement upload3() {
        return waitForElementPresent(By.xpath("/html/body/app/div/evidence/div/div[1]/div[3]/div/div[4]/div[1]/div[3]/input\n"));
    }

}
