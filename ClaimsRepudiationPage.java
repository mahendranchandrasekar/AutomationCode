package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClaimsRepudiationPage extends AbstractPage {


    public WebElement verifyTxtRepudiationDetails(String Ttest) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + Ttest + "')]" ) );
    }

    public WebElement repudiationReason1(String searchText) {
        return waitForElementPresent( By.xpath( "//tbody/tr/th[text()='Repudiation Cause']/../../../tbody/tr/td[text()='" + searchText + "']" ) );
    }

    public WebElement repudiateClaim() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//div[contains(@id,'ddl301330')][@class='ComboBox_Default']" ) );
    }

    public WebElement repudiateClaimOption(String strRepudiateOption) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//div[contains(@id,'ddl301330')]/div/div[contains(text(),'" + strRepudiateOption + "')]" ) );
    }

    public WebElement save() {
        return waitForElementPresent( By.xpath( "//input[@id='ucMandatoryFieldEditor_customFieldSaveButton']" ) );
    }

    public WebElement btnSave() {
        return waitForElementPresent( By.xpath( "//input[@class='btnSave button']" ) );
    }

    public WebElement CRQuestionsButton() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_301324.ascx__301324__55353791_rptAdviceHeader_ctl01_imgOpen" ) );
    }

    public WebElement verifymessage(String fieldname, String fieldvalue) {
        return waitForElementPresent( By.xpath( "//th[contains(text(),'" + fieldname + "')]/../../tr[2]/td[contains(text(),'" + fieldvalue + "')]" ) );
    }

    public WebElement immediateSettlementOption(String strRepudiateOption) {

        return waitForElementPresent( org.openqa.selenium.By.xpath( "//div[contains(@id,'ddl301373')]/div/div[contains(text(),'" + strRepudiateOption + "')]" ) );
    }

    public WebElement immediateSettlementReason(String strRepudiateOption) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[contains(text(),'" + strRepudiateOption + "')]" ) );
    }

    public WebElement errorMessage(String error) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//*[contains(text(),'" + error + "')]" ) );
    }

//    public WebElement okBtn() {
//        return waitForElementPresent( org.openqa.selenium.By.xpath( "//*[@id='btnCancel']" ) );
//    }

    public WebElement claimCloseConfirmationResponse() {
        return waitForElementPresent( By.xpath( "//img[contains(@class, 'ComboBoxImage_Default')]" ) );
    }

    public WebElement claimCloseConfirmationResponse_Yes() {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'Yes')]" ) );
    }

    public WebElement claimCloseConfirmationResponse(String fieldValue) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement claimReasonSelection() {
        return waitForElementPresent( By.xpath( "//*[contains(@id,'ucMandatoryFieldEditor_301655_searchButton')]" ) );
    }

    public WebElement claimReasonSelectionWindow() {
        return waitForElementPresent( By.xpath( "//*[@id=\"detailFieldRadGrid_ctl01\"]/tbody/tr[1]/td[1]/a" ) );
    }

    public WebElement clearTheReserve() {
        return waitForElementPresent( By.xpath( "(//div/img[contains(@id, 'ucMandatoryFieldEditor_dd')])[5]" ) );
    }

    public WebElement claimCloseSaveBtn() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_btnSave" ) );
    }


    public WebElement claimStatusInEventHistory() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[1]/td[1]/a" ) );
    }

    public WebElement readingReserveErrorMessage() {
        return waitForElementPresent( By.xpath( "//span[@id='lblGlobalError']/font" ) );
    }

//    public WebElement okBtn_Claim() {
//        return waitForElementPresent( By.id( "btnCancel" ) );
//    }

    public WebElement claimClosedTime() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[1]/td[2]" ) );
    }

    public WebElement claimClosedBy() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[1]/td[3]" ) );
    }

    public WebElement UpgradeSales_Frame() {
        return waitForElementPresent( By.id( "RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEvent" ) );
    }

    public WebElement UpgradeSales_EventText() {
        return waitForElementPresent( By.id( "txtDocument" ) );
    }

    public WebElement verifyClaimClosedEventinEventHistoryTable() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Reopened')]" ) );
    }

    public WebElement claimReopenedDate() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[2]/td[2]" ) );
    }

    public WebElement claimReopenedBy() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[2]/td[3]" ) );
    }

    public WebElement selectItems() {
        return waitForElementPresent( By.xpath( "//span[@class='chkReason']/input" ) );
    }

    public WebElement readTheReserveValue() {
        return waitForElementPresent( By.xpath( "//img[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_imgMovement']/.." ) );
    }

    public WebElement claimReopenedStatus() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[11]" ) );
    }

    public WebElement enterReopenComments() {
        return waitForElementPresent( By.id( "txtComments" ) );
    }


    public WebElement lblFirstClaimID() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[2]" ) );
    }

    public WebElement lblFirstCountryOfLoss() {
        return waitForElementPresent( By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[4]" ) );
    }


    public WebElement reOpenFinishbtn() {
        return waitForElementPresent( By.id( "btnFinish" ) );
    }

    public WebElement reOpenReasonDropdown() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'reopen reason')]/../following-sibling::td/div/div/img" ) );
    }

    public WebElement txtRepudiationReason(String reason) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[@class='selectable'][contains(text(),'" + reason + "')]" ) );
    }

    public WebElement reOpenReason(String reason) {
        System.out.println( "//div[contains(text(), '" + reason + "')]" );
        return waitForElementPresent( By.xpath( "//div[contains(text(), '" + reason + "')]" ) );
    }

    public WebElement immediateSettlement() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//div[contains(@id,'ddl301373')][@class='ComboBox_Default']" ) );
    }


    public WebElement approveRepudiation() {
        return waitForElementPresent( By.xpath( "//div[contains(@id,'ddl301377')][@class='ComboBox_Default']" ) );
    }

    public WebElement approveRepudiationOption(String repReason) {
        return waitForElementPresent( By.xpath( "//div[contains(@id,'ddl301377')][@class='ComboBox_Default']" ) );
    }

    public WebElement approveComments() {
        return waitForElementPresent( By.xpath( "//textarea[contains(@id,'txt301460')]" ) );
    }

    public WebElement repudiationapproveSave() {
        return waitForElementPresent( By.xpath( "//input[@id='ucMandatoryFieldEditor_btnSave']" ) );
    }

    public WebElement Reasonbtn() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//input[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_301352.ascx__301352')]" ) );
    }

    public WebElement Reasondropdown() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_301352.ascx__301352')]" ) );
    }

    public WebElement saveresBtn() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@id='ucMandatoryFieldEditor_btnSave']" ) );
    }

    public WebElement ClaimReasonbtn() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//input[starts-with(@id,'ucMandatoryFieldEditor_301655_searchButton_')]" ) );
    }

    public WebElement repudiateClaimReasonOption(String strRepudiateOption) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//td[5][contains(text(),'" + strRepudiateOption + "')]/../td[1]/a" ) );
    }

    public WebElement check_Supplier() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Current Medical Facility')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement check_customer() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Customer')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement check_nextofkin() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Next of Kin')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement helperfield_save() {
        return waitForElementPresent( By.xpath( "//input[@id='ucMandatoryFieldEditor_btnSave']" ) );
    }


    public WebElement ApprovalValuedropdown(String value) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//div[contains(text(),'" + value + "')]" ) );
    }

    public WebElement ApprovalDeclinedReasons() {
        return waitForElementPresent( By.xpath( "//textarea[starts-with(@id,'ucMandatoryFieldEditor_txt301460')]" ) );

    }

    public WebElement approveRejectrepudiateLineItemdropdown() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlApproveReject')]"));
    }


    public WebElement reopenReasonInput() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "(//*[contains(text(),'reopen reason')]/../following-sibling::td//input)[1]" ) );
    }

    public WebElement btnOK_FraudReferral() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@value='OK']" ) );
    }

    public String btnOK() {
        return "//input[@value='OK']";
    }

    public WebElement weddingbtnOK() {
        return waitForElementPresent( By.xpath( "//button[contains(text(),'OK')]" ) );
    }

    public WebElement closeClaimReasonInput() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[3]/input" ) );
    }

    public WebElement closeClaimReasonInputFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[3]/img" ) );
    }

    public WebElement closeClaimSubReasonInput() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[5]/input" ) );
    }

    public WebElement closeClaimSubReasonInputFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[5]/img" ) );
    }

    public WebElement selectCloseClaimReason() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/tbody/tr[1]/td/a[contains(text(),'Select')]" ) );
    }

    public WebElement clearReserveImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Clear the reserve on this claim')]/../following-sibling::td/div/div/img" ) );
    }

    public WebElement clearReserveValue(String fieldValue) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement clearReserveErrorMessage(String errorMessage) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + errorMessage + "')]" ) );
    }

    public WebElement Okbtn() {
        return waitForElementPresent( By.xpath( "//input[@value='OK']" ) );
    }

    public WebElement eventValidation(String fieldValue) {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement claimDetailValidation(String fieldValue) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement claimReasonValidation(String fieldValue) {
        return waitForElementPresent( By.xpath( "//tbody/tr/td[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement validateClaimStatusInDigitalPortal(String claimID, String claimStatus) {
        return waitForElementPresent( By.xpath( "//div[contains(@class,'notifications')]/h2[contains(text(),'Open Claims')]/../div//div/h3[contains(text(),'Claim No')]/following-sibling::p[text()='" + claimID + "']/../following-sibling::div/h3[contains(text(),'Status')]/following-sibling::p[text()='" + claimStatus + "']" ) );
    }

    public WebElement retrieveClaimID() {
        return waitForElementPresent( By.xpath( "//img[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_imgSelected')]/../../td[2]" ) );
    }

    public String validateretrieveClaimID() {
        return "//img[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_imgSelected')]/../../td[2]";
    }

    public WebElement repudiateClaimSubReasonInput() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[5]/input" ) );
    }

    public WebElement repudiateClaimSubReasonInputFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/thead/tr[2]/td[5]/img" ) );
    }

    public WebElement repudiationReasonsWarning(String reason) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[contains(text(),'" + reason + "')]" ) );
    }


    public WebElement failedPaymentadvice() {
        return waitForElementPresent( By.xpath( "//td/span[contains(text(),'Failed payment')]/../following::textarea[1]" ) );
    }


    public WebElement text_Repudiationbox1() {
        return waitForElementPresent( By.xpath( "//textarea[contains(@name,'ucMandatoryFieldEditor$txt304122')]" ) );
    }

    public WebElement text_Repudiationbox2() {
        return waitForElementPresent( By.xpath( "//textarea[contains(@name,'ucMandatoryFieldEditor$txt304123')]" ) );
    }

    public WebElement lblFirstClaimLossDate() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[7]" ) );
    }

    public WebElement claimFullRepudiationFreeText1() {
        return waitForElementPresent( By.xpath( "//textarea[contains(@id,'txt304122')]" ) );
    }


    public WebElement ClaimClearReasonbtn() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//input[starts-with(@id,'ucMandatoryFieldEditor_301655_clearResourceListButton_')]" ) );
    }

    public WebElement ReasonPrimaryDropdown(int i) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//tr[" + i + "]/td[15]/select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_301352.ascx__301352')]" ) );
    }

    public WebElement ReasonSecDropdown(int i) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//tr[" + i + "]/td[16]/select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_301352.ascx__301352')]" ) );
    }

    public WebElement ReasonApproveRejectPrimaryReason(int i) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//tr[" + i + "]/td[14]/select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_305324.ascx__305324')]" ) );
    }

    public WebElement ReasonApproveRejectSubReason(int i) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//tr[" + i + "]/td[15]/select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_305324.ascx__305324')]" ) );
    }

    public WebElement ApproveRejectPartialRepudiation(int i) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//tr[" + i + "]/td[16]/select[starts-with(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_305324.ascx__305324')]" ) );
    }

    public WebElement lnkRepudiationReason(String reason) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[@class='selectable'][contains(text(),'" + reason + "')]/../td//img" ) );
    }

    public WebElement questionFromAQ(String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//span[1]" ) );
    }

    public WebElement selectAnswerYesOrNo(String id, String option) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//div/button[contains(text(),'" + option + "')]" ) );
    }

    public WebElement selectAnswerDropdown(String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//select" ) );
    }

    public WebElement selectAnswerTextArea(String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//textarea" ) );
    }

    public WebElement selectAnswerTextAreaClick(String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//textarea/../div/i" ) );
    }

    public WebElement outcome(String outcome) {
        return waitForElementPresent( By.xpath( "//h3[contains(text(),'" + outcome + "')]" ) );
    }

    public WebElement next() {
        return waitForExpectedElement( By.xpath( "//button[@class='primary-button']" ), 5 );
    }

    public WebElement selectAnswerTextSearchField(String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//div[@class='search-field']/input" ) );
    }

    public WebElement selectAnswerTextSearchFieldClick(String quesID, String id) {
        return waitForElementPresent( By.xpath( "//*[@id='" + quesID + "']//div[text()='" + id + "']" ) );
    }

    public WebElement clickReturnHome() {
        return waitForElementPresent( By.id( "undefined" ) );
    }

    public WebElement selectMedicalCondition(String strchooseAns) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//label[contains(text(),'" + strchooseAns + "')]/preceding-sibling::input" ) );
    }
    public WebElement nextButton() {
        return waitForExpectedElement( By.xpath( "//input[@id='btnNext']" ), 5 );
    }

    public WebElement repudiateLineItemSave() {
        return waitForElementPresent( By.xpath( "//input[contains(@class,'btnSave button')]" ) );
    }

}

