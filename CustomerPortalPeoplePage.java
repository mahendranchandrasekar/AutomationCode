package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalPeoplePage extends AbstractPage {

    public WebElement person(String strPerson) {
        return waitForElementPresent(By.xpath("//h3[text()='" + strPerson + "']/../../div[2]//label"));
    }

    public WebElement nextButton() {
        return waitForElementPresent(By.cssSelector("button.primary-button.active[routerlink='/claimItems']"));
    }

    public WebElement addPerson() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/div/div/div/i"));
    }

    public WebElement addAccountHolder() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[2]/button/i"));
    }

    public WebElement title() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/add-person/div/div[1]/div[1]/div/select"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/add-person/div/div[1]/div[2]/div/input"));
    }

    public WebElement lastName() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/add-person/div/div[1]/div[3]/div/input"));
    }

    public WebElement dob() {
        return waitForElementPresent(By.xpath("//*[@id=\"dob\"]"));
    }

    public WebElement relationship() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/add-person/div/div[1]/div[4]/div/select"));
    }

    public WebElement saveIcon() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[1]/add-person/div/div[2]/div[1]/i"));
    }

    public WebElement saveIcon1() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/people/div/div/div[2]/div[2]/button/i"));
    }

}

