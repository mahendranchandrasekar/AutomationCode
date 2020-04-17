package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class PerilQuestionsPage extends AbstractPage {

    public WebElement reportedLost() {
        return waitForElementPresent(By.xpath("//td[text()='Has the item been reported lost?']/../td[2]/select"));
    }

    public WebElement lossReportAvailable(){
        return waitForElementPresent(By.xpath("//td[text()='Is a loss report available?']/../td[2]/select"));
    }
    public WebElement reportsProduced() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'grdQuestions_ctl03_ddlAnswerOptions')]"));
    }

    public WebElement whoReportedTo() {
        return waitForElementPresent(By.xpath("//td[text()='Who was the loss reported to?']/../td[2]/select"));
    }

    public WebElement proofOfOwnership() {
        return waitForElementPresent(By.xpath("//td[text()='Do you have proof of ownership for the item(s)?']/../td[2]/select"));
    }

    public WebElement dateReported() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'What date was the item reported lost?')]/following-sibling::td//input[contains(@class,'hasDatepicker')]"));
    }

    public WebElement savePerilQuestions() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[contains(@id,'CustomDetailFieldViews')][@class='button']"));
    }

    public WebElement perilQuestionCancelBtn() {
        return waitForElementPresent(By.id("btnCancel"));
    }

    public WebElement storeNotes() {
        return waitForElementPresent(By.xpath("//textarea[contains(@id,'txtAnswerText')]"));
    }

    public WebElement affectedPerson() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlAnswerOptions')]"));
    }

    public List<WebElement> affectedPersonS() {
        return findElements(By.xpath("//select[contains(@id,'grdQuestions_ctl02_ddlAnswerOptions')]"));
    }

    public WebElement frame() {
        return waitForElementPresent(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard"));
    }

    public WebElement enterComments(){
        return waitForElementPresent(By.id("ctl00_cphBody_txtRecipientsTo"));
    }
    public WebElement perilQuestionSaveBtn() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//div[@id='outer']/table/tbody/tr[3]/td/div/table//table[@id='ucMandatoryFieldEditor_tableDataEntry']//div[@class='RadGrid_Default']//input"));
    }

    public WebElement retrievecaseID() {
        return waitForElementPresent(By.xpath("//span[@id='lblCaseID']"));
    }

    public WebElement favouriteColor() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'grdQuestions_ctl07_ddlAnswerOptions')]"));
    }

    public WebElement whatDayItIs() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'grdQuestions_ctl08_ddlAnswerOptions')]"));
    }


        public WebElement whatInjuryDidYouSufferFrom() {
            return waitForElementPresent(By.xpath("//td[text()='What injury did you suffer from?']/following-sibling::td[1]/select"));
        }
        public WebElement Wastheinjurylinkedtoaundeclaredmedicalcondition(){
            return waitForElementPresent(By.xpath("//td[text()='Was the injury linked to a undeclared medical condition?']/following-sibling::td[1]/select"));
        }

        public WebElement getPerilQuestionsTable(){
            return waitForElementPresent(By.xpath("//table[contains(@id,'grdQuestions')]/tbody"));
        }

        public WebElement validatePerilQuestions(String questions){
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+questions+"')]"));
        }

        public WebElement verifyPerilQuestionsDropdownValues(String values){
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+values+"')]/following-sibling::td[1]/select"));
        }

        public WebElement verifyPerilQuestionsTextAreaValues(String values){
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+values+"')]/following-sibling::td[1]/textarea"));
        }

        public WebElement verifyPerilQuestionsTextboxValues(String values){
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+values+"')]/following-sibling::td[1]/input"));
        }

        public WebElement perilQuesTextArea(String searchField) {
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+searchField+"')]/..//textarea"));
        }


        public WebElement perilQuesSelect(String searchField) {
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+searchField+"')]/..//select"));
        }

        public WebElement perilQuesInput(String searchField) {
            return waitForElementPresent(By.xpath("//td[contains(text(),'"+searchField+"')]/..//input"));
        }
    }