package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicClaimDetailsPage extends AbstractPage {

    public WebElement tripDestination() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlDestinations')]"));
    }

    public WebElement tripDestination2() {
        return waitForElementPresent(By.xpath("//*[@id=\"tbltabpage26310\"]/tbody/tr[4]/td/table/tbody/tr/td[2]/span/select"));
    }

    public String tripDestinationDropDownDivXPath() {
        return "//select[contains(@id,'300938')]/optgroup[@label='All']/option[text()]";
    }

    public WebElement tripDestDrpDwnList(int i) {
        return waitForElementPresent(By.xpath("//select[contains(@id,'300938')]/optgroup[@label='All']/option[" + i + "]"));
    }

    public WebElement tripBooked() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'rdp300939')][@style='background-color: white; border-color: gray; border-width: 1px; border-style: solid;']"));
    }

    public WebElement requestForAdviceDropDownImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Request for Advice')]/../following-sibling::td/div//img"));
    }

    public WebElement requestForAdviceDropDownValue(String searchValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + searchValue + "')]"));
    }

    public WebElement requestForCorrespondenceDetails() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Correspondence Details')]/../following-sibling::td/input[@type='checkbox']"));
    }

    public WebElement validateErrorMessage() {
        return waitForElementPresent(By.xpath("//span[@id='lblGlobalError']"));
    }

//    public WebElement errorMessageokbtn() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement tripFromDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'rdp300940')][@style='background-color: white; border-color: gray; border-width: 1px; border-style: solid;']"));
    }

    public WebElement tripToDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'rdp300941')][@style='background-color: white; border-color: gray; border-width: 1px; border-style: solid;']"));
    }

    public WebElement description() {
        return waitForElementPresent(By.xpath("//textarea[contains(@id,'txt300946')]"));
    }

    public WebElement errorMessage() {
        return waitForElementToBeClickableAndReturnElement(By.id("lblError"));
    }

    public WebElement save() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement supplierSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

//    public WebElement cancel() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement editSave() {
        return waitForElementPresent(By.id("btnSave"));
    }

    public WebElement reserveAmount() {
        return waitForElementPresent(By.name("txt300952"));
    }

    public WebElement getFirstOpenClaim() {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[1]/a"));
    }

    public WebElement enterChequeDetailsbtn() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Enter Cheque Details')]"));
    }

    public WebElement saveAndClose() {
        return waitForElementPresent(By.id("btnSaveAndClose"));
    }

    public boolean saveAndCloseIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("btnSaveAndClose"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public String searchClaimIDResultXPath() {
        return "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr/td[contains(text(),'##SearchPage Value##')]";
    }

    public WebElement selectClaimNumber(String strText) {
        WebElement myElement = findElement(By.xpath(searchClaimIDResultXPath().replace("##SearchPage Value##", strText)));
        WebElement editbutton = myElement.findElement(By.xpath("../td[1]/a"));
        return editbutton;
    }

    public WebElement datefrom() {
        return waitForElementPresent(By.xpath(".//*[@id='rdp301374_dateInput_text']"));
    }

    public WebElement dateto() {
        return waitForElementPresent(By.xpath(".//*[@id='rdp301375_dateInput_text']"));
    }

    public WebElement savescheme() {
        return waitForElementPresent(By.xpath("//*[@id=\"btnSave\"]"));
    }

//    public WebElement amountset() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_flt301053_text\"]"));
//    }

//    public WebElement newamountset() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_flt301053_text\"]"));
//    }

    public WebElement schemeidset() {
        return waitForElementPresent(By.xpath("//*[@id=\"int301376_text\"]"));
    }

    public WebElement schemeidsearch() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchID_txtMatterID\"]"));
    }

//    public WebElement causeoptionselect() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301049_Input\"]"));
//    }
//
//    public WebElement subcauseoptionselect() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301050_Input\"]"));
//    }
//
//    public WebElement claimdetailoptionselect() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301051_Input\"]"));
//    }
//
//    public WebElement claimdetail2optionselect() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301052_Input\"]"));
//    }
//
//    public WebElement applicationoptionselect() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301054_Input\"]"));
//    }
//
//    public WebElement BACSPaymentCompletedClaim(String claimId) {
//        return waitForElementPresent(By.xpath("//*[contains(text(),'" + claimId + "')]/preceding-sibling::td/a"));
//    }

    public WebElement Referralcomment() {
        return waitForElementPresent(By.xpath("//*[contains(@id,'txt301459')]"));
    }

    public WebElement getFirstClaim() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[2]"));
    }

    public WebElement selectThirdParty() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Has this Claim come from another Insurer/Third Party?')]/../following-sibling::td[1]/div//input[1]"));
    }

    public WebElement selectClaimType() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Claim Type')]/../following-sibling::td[1]/div//img"));
    }

    public WebElement claimTypeOption(String strOption) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + strOption + "')]"));
    }

    public WebElement selectThirdPartyOption(String strOption) {
        return waitForElementPresent(By.xpath("//div[contains(@id,'ddl301738')][@class='ComboBoxItem_Default'][contains(text(),'" + strOption + "')]"));
    }

    public WebElement thirdPartyReferenceNumber() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Contribution Reference Number')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement selectOtherPartyAddBtn() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Other Party')]//following-sibling::input[2]"));
    }

    public WebElement selectOtherParty(String fieldValue) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + fieldValue + "')]/preceding-sibling::td[2]/a"));
    }

    public WebElement enterOtherThirdPartyDetails(String fieldName) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + fieldName + "')]/../following-sibling::td[1]/input"));
    }

    public WebElement getSelectedClaim() {
        return waitForElementPresent(By.xpath("//img[contains(@id,'imgSelected')]/../preceding-sibling::td/a"));
    }

    public WebElement medicalReportRequestEmailLink() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Medical Report Request | Email')])[1]"));
    }

    public WebElement moreInfoLink() {
        return waitForElementPresent(By.xpath("//span[@id='lblMoreInfo']"));
    }

//    public WebElement closeWindow() {
//        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
//    }

//    public WebElement cancelbtn() {
//        return waitForElementPresent(By.id("ctl00_cphBody_btnCancel"));
//    }

    public WebElement enterAgentFields(String field) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + field + "')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement enterGPFields(String field) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + field + "')]/../following-sibling::td[1]/input[1]"));
    }

//    public WebElement navigateToLeadDetailsTab() {
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnLeadDetails"));
//    }

    public WebElement signnatureInEmailForManualLetter() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Kind regards')]/following-sibling::div"));
    }

    public WebElement emaiFrameForManualLetter() {
        return waitForElementPresent(By.id("RadEContentIframectl00_cphBody_reEmail"));
    }

    public WebElement editDateOfLoss() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'rdp300944')][@style='background-color: white; border-color: gray; border-width: 1px; border-style: solid;']"));
    }

    public List<WebElement> progressWindow() {
        return waitForElementsPresent(By.id("imgProgressDetailFieldView"));
    }

//    public WebElement navigateToBasePolicyFromPurchasesTab() {
//        return waitForElementPresent(By.xpath("//span[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountLID']"));
//    }

    public WebElement chkBoxLetter() {
        return waitForElementPresent(By.xpath("//*[contains(@id,'ucMandatoryFieldEditor_chk304')]"));
    }

    public WebElement txtTitleName() {

        try {
            return waitForElementPresent(By.xpath("//span[contains(text(),'Title')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//span[contains(text(),'Title')]/../following-sibling::td/input[@type='text']"));
        }
    }

    public WebElement txtFirstName() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'First Name')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtSurname() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Surname')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtAddressLine1() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Address Line 1')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtTown() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Town')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtPostcode() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Postcode')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtMobileTelephone() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Mobile Telephone')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtHomeTelephone() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Home Telephone')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement txtEmailAddress() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Email Address')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement drpRelationshipToCustomer() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Relationship to Customer')]/../following-sibling::td/div/div/input"));
    }

    public WebElement drpClickRelationshipToCustomer(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@class,'ComboBoxDropDown')]/div/div[contains(text(),'" + type + "')]"));
    }

    public WebElement txtMentalIncapacityClaimant() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Mental Incapacity Claimant Name')]/../following-sibling::td/input[contains(@name,'ucMandatoryFieldEditor$txt')]"));
    }

    public WebElement messageValidation() {
        try {
            return waitForElementPresent(By.xpath("//span[@id='ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_302350.ascx__302350__27709909_lblStatus']"));
        } catch (Exception e) {
            return waitAndFindElement(By.id("lblGlobalError"));
        }
    }
}



