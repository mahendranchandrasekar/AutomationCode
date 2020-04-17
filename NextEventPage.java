package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NextEventPage extends AbstractPage {

    public WebElement go() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventWizard_btnWizard']"));
    }

    public boolean goDisplayed() {
        return elementDisplayed(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventWizard_btnWizard"));
    }

    public WebElement addANote() {
        return waitForUnstableElement(By.xpath(".//*[text()='Add a Note']/../input"));
    }


    public WebElement addOutOfProcessEvent() {
        return waitForElementPresent(By.xpath(".//*[text()='Add an OutOfProcess Event']/../input"));
    }

    public WebElement conversationType() {
        return waitForElementPresent(By.id("ddlNoteType"));
    }


    public WebElement noteType() {
        return waitForElementPresent(By.id("ddlPriority"));
    }

    public WebElement descriptionNote() {
        return waitForElementPresent(By.id("txtNoteDescription"));
    }

    public WebElement finishnote() {
        return waitForElementPresent(By.id("btnFinish"));
    }

//    public WebElement cancelNote() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement frame() {
        return waitForElementPresent(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard"));
    }

    public WebElement clickOnSecondClaim() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl03_lnkChangeCase']"));
    }

    public WebElement eventTypeSensitive() {
        return waitForElementPresent(By.id("ddlEventToAdd"));
    }

    public WebElement nextButtonSensitive() {
        return waitForElementPresent(By.id("btnNext"));
    }

    public WebElement frameEditEvent() {
        return waitAndFindElement(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEvent"));
    }

    public WebElement firstRowinEvent() {
        return waitForElementPresent(By.xpath(".//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01']/tbody/tr[1]/td[1]/a"));
    }

    public WebElement eventRowTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01"));
    }

    public WebElement eventRowTableItem(String Event) {
        System.out.println(".//table[contains(@id,'rgEventHistory_ctl01')]/tbody/tr/td/a[contains(text(),'" + Event + "')]");
        return waitForElementPresent(By.xpath(".//table[contains(@id,'rgEventHistory_ctl01')]/tbody/tr/td/a[contains(text(),'" + Event + "')]"));
    }

    public WebElement noteDescEdit() {
        return waitForElementPresent(By.id("txtDocument"));
    }

    public WebElement noteCategoryEdit() {
        return waitForElementPresent(By.id("txtDocumentCategory"));
    }

    public WebElement noteMoreInfo() {
        return waitForElementPresent(By.id("lblMoreInfo"));
    }

    public WebElement noteTypeEdit() {
        return waitForElementVisible(By.id("ddlNoteStatus"));
    }

    public WebElement noteEditSave() {
        return waitForElementPresent(By.id("btnSaveCustomerLeadDetails"));
    }

    public WebElement noteWhenCreated() {
        return waitForElementPresent(By.id("lblWhenCreated"));
    }

    public WebElement noteCloseButton() {
        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
    }

    public String eventTableXpath() {
        return ".//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01']";
    }

    public WebElement sentiveRecordErrorMessage() {
        return waitForElementPresent(By.xpath("//td[@id='ctl00_tdError']/span[@id='ctl00_lblMessages']"));
    }


    public WebElement logOut() {
        return waitForElementVisible(By.id("ctl00_btnLogOut"));
    }
    public String logOutAQ() {
        return "ctl00_btnLogOut";
    }

    public WebElement fancyFrame() {
        return waitForElementPresent(By.cssSelector("iframe[id^='fancybox-frame'"));
    }

    public WebElement eventHistory() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_rgEventHistory_ctl01\"]/tbody/tr[1]/td[1]/a"));
    }

//    public WebElement customerLead() {
//        return waitForElementPresent(By.xpath("//*[@id=\"btnCustomerLeadDetails\"]"));
//    }

    public WebElement urlText() {
        return waitForElementPresent(By.xpath("//*[@id=\"reEmail\"]"));
    }

    public WebElement nextEventClaims() {
        return waitForElementPresent(By.id("ddlEventToAdd"));
    }

    public WebElement eventTypeDrpDwn() {
        return waitForElementPresent(By.id("ddlEventToAdd"));
    }


    public boolean loadingPage() {
        return waitForElementInVisible(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_imgProgressMatterList"));
    }


    public WebElement createAndSendEmail() {
        return waitForElementPresent(By.id("ctl00_cphBody_btnSaveSendDoc"));
    }

    public WebElement recipientToMail(){
        return  waitForElementPresent(By.xpath("//textarea[contains(@id,'txtRecipientsTo')]"));
    }

    public String claimTable() {
        return "//table[contains(@id,'grdClaims')]/tbody";
    }

    public WebElement supplierFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow"));
    }

    public WebElement claimTableRows() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody"));
    }

    public WebElement supplierHistoryOfChangeFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameRadWindowManager1_HistoryWindow"));
    }

    public WebElement verifyNotallowedToOpenClaimItem() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'There are no claim items.')]"));
    }

//    public WebElement claimItemCancelbtn() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement accountSelectionFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow"));
    }

    public WebElement selectPaymentInput() {
        return waitForElementPresent(By.xpath("//span[contains(@id,'grdClaims_ctl02_lblPaid')]/following-sibling::input"));
    }

    public WebElement selectPaymentBtn() {
        return waitForElementPresent(By.xpath("//input[contains(@value, 'Select')]"));
    }

    public WebElement referenceTableRowId() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Table Row ID')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement failureCode() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'New Status')]/../following-sibling::td[1]/input[1]"));

    }

    public WebElement fileName() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Filename')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement validateClaimID() {
        return waitForElementPresent(By.xpath("//span[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_WorkflowTaskPane_lblCase']"));
    }

    public WebElement saveBtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement TMAProcessingAdviceSaveBtn(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSaveBasicTableEdit"));
    }

    public WebElement recoveryEvent(String event) {
        System.out.println("//*[contains(text(),'"+ event +"')]");
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+event+"')]"));
    }

    public WebElement notifyDlgMediaEvent() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Notify DLG Media Team -  Email')]"));
    }

    public WebElement recoveryEventInEventHistory(String event) {

        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + event + "')])[2]"));
    }

    public WebElement recoveryPaymentChaseEmail() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Recovery Payment Chase | Email (SYSTEM)')]"));
    }

    public WebElement createClaimLead() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Create Claim Lead')]"));
    }

    public WebElement claimReferred() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Claim Referred to Team Leader')]"));
    }

    public WebElement firstClaimID() {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[2]"));
    }

    public WebElement confirmationOfCoverLetter() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Confirmation Of Cover Letter')]"));
    }


    public WebElement oopCustomerChaseStartchase() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'OOP Customer Chase - Start chase')]"));
    }

    public WebElement customerChaseInProgress() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Customer Chase In Progress')]"));
    }

    public WebElement oopResendDocument() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'OOP Resend Document')]"));
    }

    public WebElement eventNotificationRegardingAge(String event) {
        return waitForElementPresent(By.xpath("Need to replace later"));
    }

    public WebElement fancyClose() {
        return waitForElementPresent(By.xpath("//a[@id='fancybox-close']"));
    }

    public WebElement closeRulesEngineFrameBtn() {
        return waitForElementPresent(By.xpath("//*[@title='Close']"));
    }

    public WebElement selectedClaimID() {
        return waitForElementPresent(By.xpath("//img[contains(@id,'imgSelected')]/../preceding-sibling::td[13]"));
    }


    public WebElement oopGoodWillPayment() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'OOP Raise Goodwill/Compensation Payment')]"));
    }

    public WebElement enterChequeDetails() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Enter Cheque Details')]"));
    }

    public WebElement enterBACSDetails() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Enter BACS Details')]"));
    }

    public WebElement oopEndorsementUpdate() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Endorsement Update')]"));
    }

    public WebElement oopResendDocumentConfirmation() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Resend - New Product Confirmation | Letter')]"));
    }

    public WebElement claimReferredToCustomerValidation() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Claim Referred to Customer Validation - Automatic')]"));
    }


    public WebElement manageChase() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'OOP Customer Chase - Manage chase')]"));
    }


    public WebElement cardPurchaseComplete() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Card Purchase Complete')]"));
    }

    public WebElement cardFailure() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Card Failure')]"));
    }

    public WebElement purchaseCompleteCardNumber() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Card Purchase Complete')]/following-sibling::td[1]/span"));
    }

    public WebElement failureCardNumber() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Card Failure')]/following-sibling::td[1]/span"));
    }


    public WebElement btnCloseWindow() {
        return waitForElementPresent(By.id("btnClose"));
    }


    public WebElement CancelBtn() {
        return waitForElementPresent(By.id("btnCancel"));
    }


    public WebElement confirmationOfCoverEmail() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Confirmation Of Cover Email')]"));
    }

    public WebElement confirmationOfCoverSMS() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Confirmation Of Cover SMS')]"));
    }

    public WebElement registeredClaimSMS() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'New Claim Registered | SMS')]"));
    }

    public WebElement registeredClaimEmail() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'New Claim Registered | Email')]"));
    }

    public WebElement managechaseevent() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'OOP Customer Chase - Manage chase')]"));
    }


    public WebElement BACSFailureAddFailureEvent() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'TESTING - BACS failure - Add failure')]"));
    }

    public WebElement ddRequestFailed() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'DD Request Failed')]"));
    }

    public WebElement resolveFailureByPhone() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Resolve Failure - by Phone')]"));
    }

    public WebElement BACSAccountDetailsRelatedEvents(String event) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + event + "')]"));
    }

    public WebElement approvalframe() {
        return waitForElementPresent(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard"));
    }

    public WebElement claimapproveSavebtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement approveclaimmovement() {
        return waitForElementPresent(By.xpath("//input[contains(@value,'Please select')][1]"));
    }

    public WebElement approveclaimmovementwithYesOption() {
        return waitForElementPresent(By.xpath("//div[contains(@id,'ddl301350')]/div/div[contains(text(),'Yes')]"));
    }

    public WebElement approveclaimmovementwitNoOption() {
        return waitForElementPresent(By.xpath("//div[contains(@id,'ddl301350')]/div/div[contains(text(),'No')]"));
    }

    public WebElement ReserveEvent() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'OOP Approve or Reject Reserve Movement')]"));
    }

    public WebElement claimreasonframe() {
        return waitForElementPresent(By.id("RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow"));
    }

    public WebElement Claimrejectedletter(String event) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + event + "')]"));

    }

    public WebElement newBusinessDocPack() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'New Business Doc Pack')]"));

    }
    public WebElement adviceOfEvidence() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Advice of Evidence')]"));

    }
    public WebElement evidence() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Advice of Evidence')]"));

    }

    public String ClaimrejectedletterXpath(String event) {
        return "//td[contains(text(),'" + event + "')]";

    }

    public WebElement emailTabInTMAEvent() {
        return waitForElementPresent(By.xpath("//a[contains(@id,'tabEmail')]//*[contains(text(),'Email')]"));
    }

    public WebElement emailContentInTMAEvent() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'TMA Disclaimer')]"));
    }

//    public WebElement closebtnInTMAEmail() {
//        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
//    }

    public WebElement navigateToDashboard() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'DASHBOARD')]"));
    }

    public WebElement navigateToFirstPolicy() {
        return waitForElementPresent(By.xpath("//a[@class='RecentLeadsLink'][1]"));
    }

    public String navigateToPolicyLink() {
        return "//div[contains(text(),'Policy No.')]/following-sibling::div/a";

    }

    public WebElement clickPolicyLink() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Policy No.')]/following-sibling::div/a"));

    }

    public WebElement clickBasePolicy(String policyType) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + policyType + "')]"));
    }

    public WebElement checkPolicyicon() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_imgSelected"));
    }

    public WebElement recoveryReminderEvent(String event) {
        System.out.println("//a[contains(text(),'\"+ event +\"')]");
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + event + "')]"));
    }

    public WebElement selectCase() {
        return waitForElementToBeClickableAndReturnElement(By.id("ddlCase"));
    }

    public WebElement cardCPAEvent(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]"));
    }

    public WebElement sendLOA(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]"));
    }

    public WebElement lblEvents(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event.trim() + "')]"));
    }


    public String enterBasicClaimDetails() {
        return "//label[contains(text(),'NEXT ACTION: Basic Claim Details')]";
    }

    public String validateCustomerResidency() {
        return "ddlEventToAdd";
    }

    public WebElement confirmCustomerResidency() {
        return waitForElementPresent(By.xpath("//select[@id='ddlEventToAdd']"));
    }

    public WebElement confirmResidencyInUKImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer is resident in the UK')]/../following-sibling::td/div/div/img"));
    }

    public WebElement confirmResidencyInUKResponse() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'No')]"));
    }

    public String validateNextButtonSensitive() {
        return "btnNext";
    }


    public WebElement recoveryPaymentRequestEmail() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Recovery Payment Request | Email (SYSTEM)')]"));
    }
    public WebElement fancyboxClose() {
        return waitForElementPresent(By.xpath("//a[@id='fancybox-close']"));
    }


    public By getLoader_PleasewaitLocator() {
        return By.id("pelasewait");
    }


    public By getLoader_Loading() {
        return By.id("loading");
    }

    public WebElement VerifyNextAction(String NextAction) {
        return waitAndFindElement(By.xpath("//*[contains(text(),'" + NextAction + "')]"));
    }

    public WebElement generatedEvent(String event) {
        System.out.println("//td[contains(text(),'" + event + "')]");
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]"));
    }


    public WebElement unlockTIMClaim() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Return Claim to Travel Incident Management')]"));
    }

    public WebElement verifySaveQuoteEvents(String event){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+event+"')]"));

    }
    public WebElement requestType(String event){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+event+"')]/../td[3]/span"));
    }

    public String nextEventClaimsXPath() {
        return "//select[@id='ddlEventToAdd']";
    }

    public WebElement supplierTable() {
        return waitForElementPresent(By.xpath("//table[@class='MasterTable_Default griddetailFieldRadGrid_ctl01']//tbody/tr/td[1]")) ;
    }
    }

