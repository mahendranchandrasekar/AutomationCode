package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PerilsAndCostsPage extends AbstractPage {

    public WebElement dateOfLoss() {
        return waitForUnstableElement(By.name("dol"));
    }

    public WebElement claimCause() {
        return waitForElementToBeClickableAndReturnElement(By.name("causeID"));
    }

    public WebElement claimCauseDesc() {
        return waitForElementVisible(By.xpath("//textarea[@name='desc']"));
    }

    public WebElement addPeril() {
        return waitForElementPresent(By.xpath("//button[text()=' Peril']"));
    }

    public WebElement claimSubCause() {
        return waitForElementPresent(By.xpath("//select[@name='perilRLID']"));
    }

    public WebElement claimLossDate() {
        return waitForElementVisible(By.id("date"));
    }

    public WebElement claimSavePeril() {
        return waitForElementPresent(By.xpath("//button[@class='btn button']"));
    }

    public WebElement claimAddPH() {
        return waitForElementPresent(By.cssSelector(".fa.fa-plus.fa-2x"));
    }

    public WebElement claimAddPerson(String person) {
        String xpath = "//b[contains(text(),'" + person + "')]/../..";
        return waitForElementPresent(By.xpath(xpath)).findElement(By.cssSelector(".fa.fa-plus.fa-2x"));
    }

    public WebElement claimAddPersonPeril(String peril) {
        String xpath = "//b[contains(text(),'" + peril + "')]/../../..";
        return waitForElementPresent(By.xpath(xpath)).findElement(By.cssSelector(".fa.fa-plus.fa-lg"));
    }

    public WebElement addClaimItemPerson(String person, String peril) {
        String xpath = "//b[contains(text(),'" + peril + "')]/../../..//b[contains(text(),'" + person + "')]/../../..";
        return waitForElementPresent(By.xpath(xpath)).findElement(By.cssSelector(".fa.fa-plus.fa-lg"));
    }

    public WebElement addClaimItem(String person) {
        String xpath = "//b[contains(text(),'" + person + "')]/../../..";
        return waitForElementPresent(By.xpath(xpath)).findElement(By.cssSelector(".fa.fa-plus.fa-lg"));
    }

    public WebElement addPerson() {
        return waitForElementPresent(By.xpath("//button[text()=' Person']"));
    }

    public WebElement addClaimItem() {
        return waitForElementPresent(By.xpath("(//button[text()=' Claim Item'])[last()]"));
    }

    public WebElement addAnotherPerson() {
          return waitForElementPresent(By.xpath("(//button[text()=' Person'])[2]"));
    }

    public WebElement addAnotherClaimItem() {
            return waitForElementPresent(By.xpath("(//button[text()=' Claim Item'])[2]"));

    }

    public WebElement claimDetail2() {
        return waitForElementPresent(By.name("typeID"));
    }

    public WebElement claimDetail1() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='claimDetail1']"));
    }

    public WebElement costTypeCurrency() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//select[@name='currency']"));
    }

    public WebElement costTypeDesc() {
        return waitForElementPresent(By.xpath("//input[@name='desc']"));
    }

    public WebElement costTypeAmount() {
        return waitForElementPresent(By.xpath("//input[@name='amount']"));
    }

    public WebElement costTypeGBP() {
        return waitForElementPresent(By.xpath("//input[@name='gbp']"));
    }

    public WebElement saveClaimDetails() {
        return waitForElementPresent(By.xpath("//button[text()=' Save Claim Details']"));
    }

    public boolean saveClaimDetailsIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.xpath("//button[text()=' Save Claim Details']"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public WebElement saveClaimItem() {
        return waitForElementPresent(By.xpath("//button[text()=' Save Claim Item']"));
    }

    public WebElement perilsandCosts() {
        return waitForElementPresent(By.xpath("//*[@id='tsPages_tab26317']/span/span"));
    }

    public WebElement insertRecordFromResource() {
        return waitForElementPresent(By.xpath("//*[@id='300964_searchButton']"));
    }

    public WebElement selectLink1() {
        return waitForElementPresent(By.xpath("//*[@id=\"detailFieldRadGrid_ctl01\"]/tbody/tr[1]/td[1]/a"));
    }

    public WebElement claimPerilEdit() {
        return waitForElementPresent(By.xpath("(//table[@id='Rad300964_ctl01']/tbody//td/a[contains(text(),'Edit')])[2]"));
    }

    public WebElement claimPerildateofLoss() {
        return waitForElementPresent(By.xpath("//table[@id='tbl300944']/tbody//td/div/div/span/input[contains(@id,'dateInput_text')]"));
    }

    public WebElement claimPerildescription() {
        return waitForElementPresent(By.xpath("//table[@id='Rad300964_ctl01']/tbody//td/input[contains(@id,'txt300962')]"));
    }

    public WebElement claimPerilStatus() {
        return waitForElementPresent(By.xpath("//table[@id='Rad300964_ctl01']/tbody//td//input[@class='ComboBoxInput_Default']"));
    }

    public WebElement claimPerilStatusOption(String status) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + status + "')]"));
    }

    public WebElement claimPerilUpdate() {
        return waitForElementPresent(By.xpath("//table[@id='Rad300964_ctl01']/tbody//td/a[contains(text(),'Update')]"));
    }

    public WebElement editClaimSaveAndCloseBtn() {
        return waitForElementToBeClickableAndReturnElement(By.name("btnSaveAndClose"));
    }

    public WebElement claimDetails() {
        return waitForElementPresent(By.xpath(".//*[@id='tsPages_tab26310']/span/span"));
    }

    public WebElement claimPerilDestination() {
        return waitForElementPresent(By.xpath("//div[@id='holder']/div[@id='mpPages']/div/table[@id='tbltabpage26310']//td//table//td/span/select"));
    }

    public WebElement claimPerilEditedDestination(String destination) {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']//tr[2]/td[contains(text(),'" + destination + "')]"));
    }

    public WebElement claimEvidenceCollationEdit() {
        return waitForElementPresent(By.xpath("//*[@id='Rad300991_ctl01_ctl04_EditButton']"));
    }

    public WebElement claimEvidenceCollationNotesValue() {
        return waitForElementPresent(By.xpath(".//*[@id='Rad300991_ctl01']/tbody/tr/td[9]"));
    }

    public WebElement claimEvidenceCollationCauseCode() {
        return waitForElementPresent(By.xpath("//*[@id='Rad300991_ctl01_ctl04_ddl300985_Input']"));
    }

    public WebElement claimEvidenceCollationNotes() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad300991_ctl01_ctl04_txt300997\"]"));
    }

    public WebElement claimEvidenceCollationUpdate() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad300991_ctl01_ctl04_UpdateButton\"]"));
    }

    public WebElement editClaimSavBtn() {
        return waitForElementPresent(By.name("btnSave"));
    }

    public WebElement perilCostClaimItemTable() {
        return waitForElementPresent(By.xpath("//table[@id='Rad301031_ctl01']"));
    }

    public WebElement countryOfLoss() {
        return waitForElementPresent(By.xpath("/html/body/app/section[2]/claim-grid-page/section[1]/claim-details/div/div[2]/select"));
    }

    public WebElement editClaimitem() {
        return waitForElementPresent(By.xpath("/html/body/app/section[2]/claim-grid-page/section[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div/table/tbody/tr/td[6]"));
    }

    public WebElement selectTitle() {

        return waitForElementPresent(By.xpath("//select[@formcontrolname='title']"));
    }

    public WebElement firstName() {

        return waitForElementPresent(By.xpath("//input[@name='firstName']"));
    }

    public WebElement lastName() {

        return waitForElementPresent(By.xpath("//input[@name='lastName']"));
    }

    public WebElement enterdob() {

        return waitForElementPresent(By.id("dob"));
    }

    public WebElement selectType() {

        return waitForElementPresent(By.xpath("//select[@formcontrolname='type']"));
    }

    public WebElement cancelClaimItems() {
        return waitForElementPresent(By.xpath("//a[text()=' Cancel'][@class='button cancel']"));
    }

    public WebElement txtAddedPerson() {
        return waitForElementPresent(By.xpath("//tr[@person-row]//b"));
    }


    public WebElement btnEditParticularPeril(String peril) {
        return waitForElementPresent(By.xpath("//b[contains(text(),'" + peril + "')]/../../..//i[@class='fa fa-pencil fa-2x']"));
    }

    public WebElement btnEditParticularPerson(String person) {
        return waitForElementPresent(By.xpath("//b[contains(text(),'" + person + "')]/../../..//button[text()=' Person']"));
    }

    public WebElement btnEditParticularClaimItem(String item) {
        return waitForElementPresent(By.xpath("//b[contains(text(),'" + item + "')]/../../..//button[text()=' Claim Item']"));
    }

    public WebElement personTitle() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='title']"));
    }

    public WebElement personFName() {
        return waitForElementPresent(By.xpath("//input[@name='firstName']"));
    }

    public WebElement personLName() {
        return waitForElementPresent(By.xpath("//input[@name='lastName']"));
    }

    public WebElement personDOB() {
        return waitForElementPresent(By.id("dob"));
    }

    public WebElement personType() {
        return waitForElementPresent(By.xpath("//select[@name='type']"));
    }

    public WebElement personSave() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save')]"));
    }

    public WebElement validateExcessValue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Excess')]/../../../following-sibling::tbody/tr/td[16]"));
    }

    public List<WebElement> validationofAddingNewPerson() {
        return findElements(By.xpath("//div[text()='A new Person']"));

    }

    public String validationofAddingNewPersonXpath() {
        return "//div[text()='A new Person']";

    }

}
