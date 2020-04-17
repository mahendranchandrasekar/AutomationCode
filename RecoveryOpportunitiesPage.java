package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecoveryOpportunitiesPage extends AbstractPage {

    public WebElement recoveryOpportunitiesTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdRecoveries')]"));
    }

    public WebElement save() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public List<WebElement> selectRecoveryCheckbox() {
        return findElements(By.xpath("//input[@type='checkbox'][contains(@id,'chkRecoverySelection')]"));
    }

    public WebElement recoveryOptionListView(String recoverOptions) {
        return waitForElementPresent(By.xpath("//table//td[contains(text(),'" + recoverOptions + "')]"));
    }

    public WebElement amount() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtRecoveryAmount')]"));
    }

    public WebElement percentage() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtRecoveryPercent')]"));
    }

    public WebElement lblRecoveriesList(int i) {
        return waitForElementPresent(By.xpath("(//h2[text()='Recovery Opportunities']/../div/div/div/table/tbody/tr/td[1])[" + i + "]"));
    }

    public WebElement lblOtherInsurerList(int i) {
        return waitForElementPresent(By.xpath("(//h2[text()='Enter Other Insurers']/../div/div/table/tbody/tr/td[1])[" + i + "]"));
    }

    public String recoveryListTable() {
        return "//h2[text()='Recovery Opportunities']/../div/div/div/table/tbody/tr/td[1]";
    }

    public String OtherInsurerTable() {
        return "//h2[text()='Enter Other Insurers']/../div/div/table/tbody/tr/td[1]";
    }

    public WebElement recoveryTab() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'RECOVERY')]"));
    }

    public WebElement recoveryTasksTab() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'RECOVERY TASKS')]"));
    }

    public WebElement claimIDInputbox() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'ClaimID')]/../../following-sibling::tr/td[9]/input"));
    }

    public WebElement claimIDInputboxFilter() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'ClaimID')]/../../following-sibling::tr/td[9]/img"));
    }

    public WebElement equalToFilter() {
        return waitForElementPresent(By.xpath("//td[text()='EqualTo']"));
    }

    public WebElement assign(String action) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+action+"')]/..//a[contains(text(),'Assign') or contains(text(),'Reassign')]"));
    }

    public WebElement assignToTeam(String team, String action) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + team + "')]/preceding-sibling::td/a[contains(text(),'" + action + "')]"));
    }

    public WebElement validateAllocation(String claimID) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + claimID + "')]/preceding-sibling::td[6]"));
    }


    public WebElement workflowTaskInput() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Create Workflow Task In Group')]/../following-sibling::td//input"));
    }

    public WebElement workflowTaskOptions(String workflowOption) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + workflowOption + "')]"));
    }
}
