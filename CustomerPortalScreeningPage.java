package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalScreeningPage extends AbstractPage {

    public WebElement screening() {
        return waitForElementPresent(By.xpath("/html/body/app/div/header/div/nav/ul/li[2]/a"));
    }

    public WebElement next() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/people-page/div/div/div[2]/div[2]/button/i"));
    }

    public WebElement qestion1() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[1]/div/toggle/div/div/div[1]"));
    }

    public WebElement whomToApplyFor1() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[1]/div[2]/div[2]/div/label"));
    }

    public WebElement qestion2() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[2]/div/toggle/div/div/div[1]"));
    }

    public WebElement whomToApplyFor2() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[2]/div[2]/div[2]/div/label"));
    }

    public WebElement qestion3() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[3]/div/toggle/div/div/div[1]"));
    }

    public WebElement whomToApplyFor3() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[3]/div[2]/div[2]/div/label"));
    }

    public WebElement qestion4() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[4]/div/toggle/div/div/div[1]"));
    }

    public WebElement whomToApplyFor4() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[4]/div[2]/div[2]/div/label"));
    }

    public WebElement qestion5() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[5]/div/toggle/div/div/div[1]"));
    }

    public WebElement whomToApplyFor5() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[5]/div[2]/div[2]/div/label"));
    }

    public WebElement checkConditions() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/div[2]/div/button"));
    }

    public WebElement formScreening() {
        return waitForElementPresent(By.xpath("//*[@id=\"ConditionsPlaceHolder\"]/form"));
    }

    public WebElement enterCondition() {
        return waitForElementPresent(By.xpath("//input[@id='ContentPlaceHolder1_ConditionText']"));
    }

    public WebElement selectCondition() {
        return waitForElementPresent(By.xpath("//*[@id=\"101_BTN\"]"));
    }

    public WebElement selectAnswer1() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer2() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer3() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer4() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer5() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer6() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement selectAnswer7() {
        return waitForElementPresent(By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement clickContinue() {
        return waitForElementPresent(By.xpath("//*[@id=\"Continue\"]"));
    }

    public WebElement clickFinish() {
        return waitForElementPresent(By.xpath("//*[@id=\"Finish\"]"));
    }

    public WebElement next1() {
        return waitForElementPresent(By.xpath("//*[@id=\"screening\"]/div/button"));
    }

}