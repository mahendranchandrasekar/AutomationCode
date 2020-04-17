package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalPerilQuesPage extends AbstractPage {

    public WebElement perilQuestion(String questionId) {
        return waitForElementPresent(By.xpath("//*[@id='" + questionId + "']//label"));
    }

    public WebElement perilQuestionforClaimOccurDueToPerilItem(String questionId) {
        return waitForElementPresent(By.xpath("//*[@id='" + questionId + "']//label/span[1]"));
    }

    public WebElement ansButton(String ans) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//button[text()='" + ans + "']"));
    }

    public WebElement itemLostLocationDropDown() {
        return waitForElementPresent(By.xpath("//select"));
    }

    public WebElement itemEnterDetails() {
        return waitForElementPresent(By.xpath("//div[@class='textarea']//textarea"));
    }

    public WebElement searchCondition() {
        return waitForElementPresent(By.xpath("//input[@type='text']"));
    }


    public String otherMedicalRadioBtn() {
        return "//input[@name = 'screenedConditions']/following-sibling::label[contains(text(),'Other')]";
    }
    public WebElement otherMedicalRadioBtnElement() {
        return waitForElementPresent(By.xpath("//input[@name = 'screenedConditions']/following-sibling::label[contains(text(),'Other')]/preceding-sibling::input"));
    }



    public WebElement clickOnCondition(String condition) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + condition + "')]"));
    }

    public WebElement itemEnterDetailsValidate() {
        return waitForElementPresent(By.xpath("//div[@class='save-answer']//i"));
    }
    public WebElement selectInsuredPerson() {
        return waitAndFindElement(By.xpath("//select"));

    }
    public WebElement dateTableForTripFromDateXpath(String datreToSelect) {
        return waitForElementPresent(By.xpath("(//div[@class='pika-lendar']/table/tbody)[1]//td/button[text()='" + datreToSelect + "']"));

    }

    public WebElement lblmonth() {
        return waitForElementPresent(By.xpath("//div[@class='pika-label'][1]"));
    }

    public WebElement drpdnFromMonth() {
        return waitForElementPresent(By.xpath("//select[@class='pika-select pika-select-month']"));
    }

    public WebElement clickPreMedicalCondition(String condition){
        return waitForElementPresent(By.xpath("//label[text()='"+condition+"']/../input"));
    }

    public WebElement clickReturnHome(){
        return waitForElementPresent(By.id("undefined"));
    }
}
