package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimSummaryPage extends AbstractPage {

    public WebElement claimSummaryTable() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims" ) );
    }

    public WebElement claimsSectionTitle() {
        return waitForElementPresent( By.xpath( ".//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlMatterHeader']/div[1]" ) );
    }

    public WebElement editClaimLink(String strRow) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "(//a[contains(@id,'lnkMatterView')])[" + strRow + "]" ) );
    }

    public WebElement editFirstClaim() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_lnkMatterView" ) );
    }

    public String verifyReserveIconXpath(String strRow) {
        System.out.println( "(//img[contains(@id,'imgMovement')])[" + strRow + "]" );
        return "(//img[contains(@id,'imgMovement')])[" + strRow + "]";
    }

    public WebElement SelectClaim(String strRowIndex) {
        return waitForElementPresent( By.xpath( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl0" + strRowIndex + "_lnkChangeCase" ) );
    }

    public WebElement claimsDetailsTitle() {
        return waitForElementPresent( By.id( "lblBoxTitle" ) );
    }

    public WebElement newClaim() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_btnNewClaim" ) );
    }


    public WebElement firstClaimSelectLink() {
        return waitForElementToBeClickableAndReturnElement( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_lnkChangeCase" ) );
    }

    public String firstClaimSelectLinkXPath() {
        return "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_lnkChangeCase";
    }

    public WebElement outOfProcessEvent() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'Add an OutOfProcess Event')]/../input" ) );
    }


    public WebElement gpCheckRequired() {
        return waitForElementToBeClickableAndReturnElement( By.xpath("//label[contains(text(),'NEXT ACTION: GP Check Required')]/../input"));
    }

    public WebElement firstclaimStatus() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[11]" ) );
    }


    public WebElement getNextTask() {
        return waitAndFindElement( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_WorkflowTaskPane_GetNextTask_btnGetNextTask" ) );
    }

    public WebElement escalateTask() {
        return waitAndFindElement( By.xpath( "//input[contains(@value,'Escalate this task')]" ) );
    }

    public WebElement escalateReasonDropDown() {
        return waitAndFindElement( By.xpath( "//*[contains(@id,'EscalationReason')]" ) );
    }

    public WebElement escalateReasonOkbtn() {
        return waitAndFindElement( By.xpath( "//*[contains(@id,'btnEscalateOk')]" ) );
    }


    public WebElement selectFirstClaimInClaimTable() {
        return waitForElementPresent( By.xpath( "//input[contains(@value,'New Claim')]/../div/div/table/tbody/tr[2]/td/a/img" ) );
    }

    public WebElement financialTable() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Financial')]" ) );
    }

    public WebElement verifyStatus() {
        return waitForElementPresent( By.xpath( "//th[contains(text(),'Status')]/../following-sibling::tr[1]/td[10]" ) );
    }

    public WebElement verifyPaymentFailedEvent() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Payment Failed')]" ) );
    }

    public WebElement claimPaymentAdvice() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'advice (CC)')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement InternalTab() {
        return waitForElementPresent( By.xpath( "(//span[contains(text(),'Internal')])[2]" ) );
    }

    public WebElement recoveryTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Recoveries')][1]" ) );
    }

    public WebElement customerName() {
        return waitForElementPresent( By.xpath( "//div[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlCustomPartCaseListBottom']/div/table/tbody/tr[2]/td[4]" ) );
    }

    public WebElement errorMessage() {
        return waitForElementPresent( By.xpath( "" ) );
    }


    public WebElement recoveryOppurtunity_OtherInsurance() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Other Insurance')]/../td[8]" ) );
    }

    public WebElement recoveryOppurtunity_ThirdParty() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Third Party at Fault')]/../td[8]" ) );
    }

    public WebElement recoveryStatus() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Status')]/../../../../tbody/tr/td[13]" ) );
    }

    public WebElement recoveryAmt() {
        return waitForElementPresent( By.xpath( "//th[contains(text(),'Est. Recov.')]/../following-sibling::tr[2]/td[13]" ) );
    }

    public WebElement estRecoveryAmt() {
        return waitForElementPresent( By.xpath( "//th[contains(text(),'Est. Recov.')]/../following-sibling::tr[2]/td[12]" ) );
    }

    public String namePeopleRows() {
        return "//div[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlCustomPartCaseListBottom']/div/table/tbody/tr[2]";
    }

    public String namePeopleRowsTableData() {
        return "//div[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlCustomPartCaseListBottom']/div/table/tbody/tr[2]/td";
    }

    public WebElement sanctionCheck() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'True')]" ) );
    }


    public WebElement verifyClaimItemCannotBeEditable() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'GBP')]/../td[6][not(contains(@class, 'pencil'))]" ) );
    }

    public WebElement paymentFailedStatusInFinancialTable() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Payment Status')]/../../../following-sibling::tbody/tr/td[contains(text(),'Failed')]" ) );
    }

    public WebElement internalTab() {
        return waitForElementPresent( By.xpath( "(//span[contains(text(),'Internal')])[2]" ) );
    }

    public WebElement paymentFailedStatusInInternalTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Item Status')]/../../../following-sibling::tbody/tr/td[21]" ) );
    }

    public WebElement close() {
        return waitForElementPresent( By.id( "btnClose" ) );
    }

    public WebElement firstClaimID() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[2]" ) );
    }

    public WebElement firstclaimReserve() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[8]" ) );
    }

    public WebElement jumpToEvent() {
        return waitForElementPresent( By.xpath( "//label[contains(text(),'Add a JumpTo Event')]/../input" ) );
    }

    public WebElement selectUpgrade(String upgrade) {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'" + upgrade + "')]/../following-sibling::td/a[contains(text(),'select')]" ) );
    }

    public WebElement enterCancellationDate() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Cancellation Date')]/../following-sibling::td[1]/div/div/span/input[1]" ) );
    }

    public WebElement selectCancellationReasondrpdown() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Cancellation Reason')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement selectCancellationReason(String reason) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + reason + "')]" ) );
    }

    public WebElement upgradeStatus(String upgrade, String status) {
        System.out.println( "//a[contains(text(),'" + upgrade + "')]/../following-sibling::td[contains(text(),'" + status + "')]" );
        return waitForElementPresent( By.xpath( "//a[contains(text(),'" + upgrade + "')]/../following-sibling::td[contains(text(),'" + status + "')]" ) );
    }

    public WebElement customerRefundCheckBox() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Customer Refund ')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement refundReasontextarea() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Refund Reason ')]/../following-sibling::td[1]/textarea" ) );
    }

    public WebElement refundErrorMessage(String errMessage) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + errMessage + "')]" ) );
    }

    public WebElement supplierFields(String field) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'" + field + "')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement supplierTypeImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Supplier Type')]/../following-sibling::td[1]/div/div/img" ) );
    }


    public WebElement gpCheckRequiredFields(String value) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'" + value + "')]/../following-sibling::td[1]/input" ) );
    }

    public WebElement supplierType(String value) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + value + "')]" ) );
    }

    public WebElement selectNamedPeopleInSchemeSummary(String people) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + people + "')]/preceding-sibling::td[1]/img" ) );
    }

    public WebElement validateNamedPeopleDetailsInSchemeSummary(String searchField, String searchValue) {
        return waitForElementPresent( By.xpath( "//th[contains(text(),'" + searchField + "')]/../following-sibling::tr/td[contains(text(),'" + searchValue + "')]" ) );
    }

    public WebElement noteEvent() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'Add a Note')]/../input" ) );
    }

    public WebElement selectRefund() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_chk302267_27576961" ) );
    }

    public WebElement perilsAndCost() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//span[contains(text(),'Perils and Costs')]" ) );
    }

    public WebElement saveAndCloseBtn() {
        return waitForElementPresent( By.id( "btnSaveAndClose" ) );
    }

    public WebElement claimItemId() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'Rad301203_ctl01')]/tbody/tr/td" ) );

    }

    public WebElement requestTypeImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Request Type')]/../following-sibling::td//img" ) );
    }

    public WebElement requestTypeTemplate(String value) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + value + "')]" ) );
    }

    public WebElement TMAClaim_editIcon(String policyHolder) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + policyHolder + "')]/preceding-sibling::td/a/img" ) );
    }

    public WebElement suppliersTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Supplier Instructions')]" ) );
    }

    public WebElement requestType(String template) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + template + "')]" ) );
    }

//    public WebElement close_btn() {
//        return waitForElementPresent( By.id( "btnClose" ) );
//    }

    public WebElement enterChaseHours() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Chase Frequency')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement communicationPreferenceImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Communication Preference')]/../following-sibling::td//img" ) );
    }

    public WebElement select_communicationPreference(String comPreference) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'Please select')]/following-sibling::div[contains(text(),'" + comPreference + "')]" ) );
    }

    public WebElement select_supplier(String supplier) {
        return waitForElementPresent( By.xpath( "//td[text()='" + supplier + "']/following-sibling::td[4]/span/input" ) );
    }

    public WebElement enter_supplierLineItemValue() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Supplier Line Item Value')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement supplier_internalTab() {
        return waitForElementPresent( By.xpath( "//span[text()='Internal']" ) );
    }

    public WebElement lineItemValue_internalTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Supplier Line Item Value')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement remove_supplier(String template) {
        return waitForElementPresent( By.xpath( "//td[text()='" + template + "']/following-sibling::td[13]/a[contains(text(),'Delete')]" ) );
    }

//    public WebElement saveAndClose() {
//        return waitForElementPresent( By.id( "btnSaveAndClose" ) );
//    }

    public WebElement validatePrePopulatedSupplier(String fieldname) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'" + fieldname + "')]/../following-sibling::td/input" ) );
    }

    public WebElement validatePrePopulatedSupplierType() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Supplier Type')]/../following-sibling::td//input[1]" ) );
    }

    public WebElement validateSupplierRequestStatus(String template) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + template + "')]/following-sibling::td[11]" ) );
    }

    public WebElement retrieveCoverTerms(String cover) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + cover + "')]/preceding-sibling::td//a" ) );
    }

    public WebElement coverTermsTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Cover Terms')]" ) );
    }

    public WebElement cause_PolicyLimits() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[4]/input" ) );
    }


    public WebElement claimDetail1_PolicyLimits() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[6]/input" ) );
    }

    public WebElement Subcause_PolicyLimits() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[5]/input" ) );
    }


    public WebElement cause_PolicyLimits_filter() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[4]/img" ) );
    }

    public WebElement claimDetail1_PolicyLimits_filter() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[6]/img" ) );
    }

    public WebElement Subcause_PolicyLimits_filter() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//td//tr[2]/td[5]/img" ) );
    }

    public WebElement containsFilter() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Contains')]" ) );
    }

    public WebElement maximumAmount_PolicyLimits(String cause) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr/td//table//td[contains(text(),'" + cause + "')]/following-sibling::td[4]" ) );
    }

    public WebElement cause_PolicyExcess() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr//td//tr[2]/td[4]/input" ) );
    }

    public WebElement cause_PolicyExcess_filter() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr//td//tr[2]/td[4]/img" ) );
    }

    public WebElement maximumAmount_PolicyExcess(String cause) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr/td//table//td[contains(text(),'" + cause + "')]/following-sibling::td[4]" ) );
    }

    public WebElement editClaim() {
        return waitForElementPresent( By.xpath( "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_imgSelected']/../preceding-sibling::td" ) );
    }

    public WebElement internalTab_Claim() {
        return waitForElementPresent( By.xpath( "//span[text()='Internal']" ) );
    }

    public WebElement claimDetail1() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Detail 1')]/../../../following-sibling::tbody/tr/td[6]" ) );
    }

    public WebElement claimDetail2() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Detail 2')]/../../../following-sibling::tbody/tr/td[7]" ) );
    }

    public WebElement claimDescription() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Description')]/../../../following-sibling::tbody/tr/td[8]" ) );
    }

    public WebElement claimAmount() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Amount')]/../../../following-sibling::tbody/tr/td[9]" ) );
    }

    public WebElement currencyCode() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Currency Code')]/../../../following-sibling::tbody/tr/td[10]" ) );
    }

    public WebElement gbp() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'GBP')]/../../../following-sibling::tbody/tr/td[11]" ) );
    }

    public WebElement excess() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Excess')]/../../../following-sibling::tbody/tr/td[14]" ) );
    }

    public WebElement total() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Total')]/../../../following-sibling::tbody/tr/td[17]" ) );
    }

    public WebElement supplierTypeInput() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Default Suppliers:')]/../../following-sibling::tr[1]/td/div/div/table/thead/tr[2]/td[5]/input" ) );
    }

    public WebElement supplierTypeFilter() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Default Suppliers:')]/../../following-sibling::tr[1]/td/div/div/table/thead/tr/td[5]/img" ) );
    }

    public WebElement retrieveCountry() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Default Suppliers:')]/../../following-sibling::tr[1]/td/div/div/table/tbody/tr/td[8]" ) );
    }

    public WebElement viewClaim() {
        return waitForExpectedElement( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkClaim" ), 45 );

    }

    public WebElement retrieveCountry_Claim() {
        return waitForElementPresent( By.xpath( "//a[text()='TMA'][1]//following::td[1]" ) );
    }

    public WebElement navigateBackTMAClaim() {
        return waitForElementPresent( By.xpath( "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl16_imgSelected']/../preceding-sibling::td[12]//a[contains(text(),'TMA')]" ) );
    }

    public WebElement whodone() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Supplier')]/../following-sibling::td[2]" ) );
    }

    public WebElement whendone() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Select Supplier')]/../following-sibling::td[1]" ) );
    }

    public WebElement totalAmountPaidDisplayedFromInternalTab(String claimItemId) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + claimItemId + "')]/following-sibling::td[16]" ) );
    }

    public WebElement totalAmountPaidDisplayedFromFinancialTab() {
        return waitForElementPresent( By.xpath( "//table[@id='Rad301068_ctl01']/tbody/tr/td[5]" ) );
    }


    public WebElement approveRejectRushPayment() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'Approve Or Reject Rush Payment')]/../input" ) );
    }

    public WebElement raiseBulkPayment() {
        return waitForElementPresent( By.xpath( "//label[contains(text(),'Raise Bulk Payment')]/../input" ) );
    }

    public WebElement claimItemId1() {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'Medical Expenses')])[1]/../td[1]" ) );
    }

    public WebElement claimItemId2() {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'Medical Expenses')])[2]/../td[1]" ) );
    }

    public WebElement claimItemIdInInternalTab(String claimItem) {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'" + claimItem + "')])[1]/../td[1]" ) );
    }

    public WebElement btnSelectionOfOOPEvent() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'Add an OutOfProcess Event')]/../input[@checked='checked']" ) );
    }

    public WebElement selectReasonForClaimClose() {
        return waitForElementPresent( By.xpath( "//input[@title='Select Resource']" ) );
    }

    public WebElement selectFilter1ForClaimClose() {
        return waitForElementPresent( By.xpath( "//input[@name='detailFieldRadGrid$ctl01$ctl02$ctl02$ctl02']" ) );
    }

    public WebElement selectFilter2ForClaimClose() {
        return waitForElementPresent( By.xpath( "//input[@name='detailFieldRadGrid$ctl01$ctl02$ctl02$ctl04']" ) );
    }

    public WebElement selectFilter3ForClaimClose() {
        return waitForElementPresent( By.xpath( "//input[@name='detailFieldRadGrid$ctl01$ctl02$ctl02$ctl06']" ) );
    }

    public WebElement filter_1_ClaimClose() {
        return waitForElementPresent( By.xpath( "(//img[@alt='Filter'])[2]" ) );
    }

    public WebElement filter_2_ClaimClose() {
        return waitForElementPresent( By.xpath( "(//img[@alt='Filter'])[3]" ) );
    }

    public WebElement filter_3_ClaimClose() {
        return waitForElementPresent( By.xpath( "(//img[@alt='Filter'])[4]" ) );
    }

    public WebElement filterConstraint() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'EqualTo')]" ) );
    }

    public WebElement btnSelectReasonForClaimClose() {
        return waitForElementPresent( By.xpath( "//td//a[contains(text(),'Select')]" ) );
    }

    public WebElement assignPanelSolicitor() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Assigned Panel Solicitor:')]/following-sibling::input[2]" ) );
    }

    public WebElement assignSolicitor() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='detailFieldRadGrid_ctl01']/tbody/tr[1]//a" ) );
    }


    public WebElement enterLegalExpenseDataCapture(String fieldName) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/span/input[1]" ) );
    }

    public WebElement validateToolTipMsg() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//a[contains(text(),'Additional Legal Expenses Data Capture')]/.." ) );
    }

    public WebElement editLegalClaim() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td/a" ) );
    }

    public WebElement legalTab() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Legal')]" ) );
    }

    public WebElement validateSolicitorName() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Solicitor Name')]/../following-sibling::td/input" ) );
    }

    public WebElement validateLikelihoodOfSuccess() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Likelihood of Success')]/../following-sibling::td/span/input[1]" ) );
    }

    public WebElement validateLegalClaimCheckFrequency() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Legal Claim Check Frequency')]/../following-sibling::td/span/input[1]" ) );
    }

    public WebElement validateNextActionDate() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Next Check Date')]/../following-sibling::td/div/div/span/input[2]" ) );
    }

    public WebElement enterNonSolicitorDetails(String fieldName) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement validateNonSolicitorDetails(String fieldName) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "(//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/input)[1]" ) );
    }

    public WebElement validateNonSolicitorDetailsEmail(String fieldName) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "(//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/input)[2]" ) );
    }

    public WebElement getClaimfirstClaimID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims')]/tbody/tr[2]/td[2]" ) );
    }

    public WebElement editfirstClaimID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims')]/tbody/tr[2]/td[1]/a" ) );
    }

    public WebElement getfirstClaimItemID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "(//th[contains(text(),'TableRowID')]/../../following-sibling::tbody/tr/td[1])[1]" ) );
    }

    public WebElement countryForVATdropdownImg() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Country (for VAT)')]/../following-sibling::td/div/div/img" ) );
    }

    public WebElement countryForVATdropdownValue(String country) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//div[contains(text(),'" + country + "')]" ) );
    }

    public WebElement retrieveClaimID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td/img[contains(@id,'imgSelected')]/../../td[2]" ) );
    }

    public WebElement retrieveClaimAssignee() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td/img[contains(@id,'imgSelected')]/../preceding-sibling::td[5]" ) );
    }

    public WebElement claimleadID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[@id='lblLeadID']" ) );
    }

    public WebElement leadIDDisplayed(String leadID) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//a[contains(text(),'" + leadID + "')]" ) );
    }

    public WebElement title_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//a[contains(text(),'Title')]/../../following-sibling::tr/td[4]/input" ) );
    }

    public WebElement filter_titleReminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//a[contains(text(),'Title')]/../../following-sibling::tr/td[4]/img" ) );
    }

    public WebElement viewClaim_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//th[contains(text(),'View Claim')]/../following-sibling::tr/td[8]/input" ) );
    }

    public WebElement filter_viewClaim_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//th[contains(text(),'View Claim')]/../following-sibling::tr/td[8]/img" ) );
    }

    public WebElement equalTofilter_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[contains(text(),'EqualTo')]" ) );
    }

    public String retrievedTable_Reminder() {
        return "//table[@id='ctl00_cphBody_grdDiaryAppointments_ctl01']/tbody/tr";
    }

    public WebElement creationDate_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='ctl00_cphBody_grdDiaryAppointments_ctl01']/tbody/tr[1]/td[7]" ) );
    }

    public WebElement dueDate_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='ctl00_cphBody_grdDiaryAppointments_ctl01']/tbody/tr[1]/td[5]/span" ) );
    }

    public WebElement endDate_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='ctl00_cphBody_grdDiaryAppointments_ctl01']/tbody/tr[1]/td[6]/span" ) );
    }

    public WebElement assignee_Reminder() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//table[@id='ctl00_cphBody_grdDiaryAppointments_ctl01']/tbody/tr[1]/td[3]" ) );
    }

    public WebElement validateCountry() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Country')]" ) );
    }

    public WebElement validateNonICUPPPD() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Private Hosp Non ICU PPD')]" ) );
    }

    public WebElement validateICUPPD() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Private Hosp ICU PPD')]" ) );
    }

    public WebElement validateReciprocalAgreement() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Reciprocal Agreement')]" ) );
    }

    public WebElement validateTypeOfAgreement() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Type of Agreement')]" ) );
    }

    public WebElement validateOutPatient() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Private Hosp Outpatient PPD')]" ) );
    }

    public WebElement validateHospital() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Public Hosp PPD')]" ) );
    }

    public WebElement tmaTab() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'TMA')]" ) );
    }

//    public WebElement closeWindowbtn() {
//        return waitForElementPresent( org.openqa.selenium.By.id( "btnClose" ) );
//    }

    public WebElement retrieveNonICUPPDValue(String country) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Default Reserves:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + country + "')]/following-sibling::td[1]" ) );
    }

    public WebElement retrieveICUPPDValue(String country) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Default Reserves:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + country + "')]/following-sibling::td[2]" ) );
    }

    public WebElement retrieveHospOutpatientPPDValue(String country) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Default Reserves:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + country + "')]/following-sibling::td[3]" ) );
    }

    public WebElement retrievepublicHospPPDValue(String country) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Default Reserves:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + country + "')]/following-sibling::td[6]" ) );
    }

    public WebElement numberOfICUDays() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@formcontrolname='icuDays']" ) );
    }

    public WebElement numberOfNonICUDays() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@formcontrolname='nonIcuDays']" ) );
    }

    public WebElement numberOfOutPatientDays() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@formcontrolname='outPatientDays']" ) );
    }

    public WebElement numberOfPublicHospitalDays() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@formcontrolname='publicHospitalDays']" ) );
    }

    public WebElement estimateCost() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//button[contains(text(),'Estimate Costs')]" ) );
    }

    public WebElement amount() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@formcontrolname='amount']" ) );
    }

    public WebElement enterCause_PolicyLimits() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//table/thead/tr[2]/td[4]/input" ) );
    }

    public WebElement enterCause_PolicyLimitsImg() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//table/thead/tr[2]/td[4]/img" ) );
    }

    public WebElement retrievepolicyLimitsAmount() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Limits')]/../../following-sibling::tr//table/tbody/tr[1]/td[8]" ) );
    }

    public WebElement enterCause_PolicyExcess() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr//table/thead/tr[2]/td[4]/input" ) );
    }

    public WebElement enterCause_PolicyExcessImg() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr//table/thead/tr[2]/td[4]/img" ) );
    }

    public WebElement retrievepolicyExcessAmount() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Excess')]/../../following-sibling::tr//table/tbody/tr[1]/td[8]" ) );
    }

    public WebElement insertPolicyOverrideLimit() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Limit Overrides')]/../following-sibling::div[3]/input" ) );
    }

    public WebElement insertExcessOverrideLimit() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Policy Excess Overrides')]/../following-sibling::div[3]/input" ) );
    }

    public WebElement overrideFields(String fieldName) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[text()='" + fieldName + "']/../following-sibling::div/select" ) );
    }

    public WebElement amountField() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Amount')]/../following-sibling::div/input" ) );
    }

    public WebElement savebtnInOverride() {
        return waitForElementPresent( org.openqa.selenium.By.id( "ucMandatoryFieldEditor_btnSaveBasicTableEdit" ) );
    }

    public WebElement barApplied(String fieldValue) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement barStatus(String fieldValue) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//td[contains(text(),'6 - stop upgrade purchases')]/following-sibling::td[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement cancel_btn() {
        return waitForElementPresent( By.id( "btnCancel" ) );
    }

    public WebElement buyNow_btnStatus() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//button[contains(@class,'disabled') and contains(text(),'Buy Now')]" ) );
    }

    public WebElement referralReasonDropdownImg() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Referral Reason')]/../following-sibling::td/div/div/img" ) );
    }

    public WebElement referralReasonDropdownvalue(String fieldValue) {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//div[contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement savebtn() {
        return waitForElementPresent( org.openqa.selenium.By.id( "ucMandatoryFieldEditor_btnSave" ) );
    }

    public WebElement comments_txtbox() {
        return waitForElementPresent( org.openqa.selenium.By.id( "txtComments" ) );
    }

    public WebElement finish_btn() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//input[@value='Finish']" ) );
    }

    public WebElement backtoAqLink() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//a[contains(text(),'Back to AQ')]" ) );
    }

    public WebElement txtAQClaimStatus() {
        return waitForElementPresent( By.xpath( "//tr[@class='GridRow_Default current-case']//td[11]" ) );
    }

    public WebElement chkBoxIncident(String incident) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + incident + "')]//..//span[@class='checkboxRelated']" ) );
    }

    public WebElement txtRecovery(String status) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + status + "')]" ) );
    }

    public String txtPartialOnlineClaim() {
        return "//th[contains(text(),'Partial Online Claims')]";
    }

    public String btnCreate() {
        return "//input[@value='Create']";
    }

    public WebElement txtdate() {
        return waitForElementPresent( By.xpath( "(//tr[@class='GridRow_Default'])[3]//following-sibling::td[4]" ) );
    }

    public WebElement btncreateClicking() {
        return waitForElementPresent( By.xpath( "//input[@value='Create']" ) );
    }

    public WebElement txtPeril(String peril) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + peril + "')]" ) );
    }


    public String recoveryAmountPaidInTP() {
        return "//td[contains(text(),'Third Party at Fault')]/../td[10]";
    }


    public WebElement recoveryAmountPaidInTPList(int i) {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'Third Party at Fault')]/../td[10])[" + i + "]" ) );
    }


    public String recoveryAmountEstimatedInTP() {
        return "//td[contains(text(),'Third Party at Fault')]/../td[9]";
    }

    public WebElement recoveryAmountEstimatedInTPList(int i) {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'Third Party at Fault')]/../td[9])[" + i + "]" ) );
    }

    public WebElement retrieveNewlyCreatedClaimID() {
        return waitForElementPresent( By.xpath( "//img[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims_ctl02_imgSelected']/../../td[2]" ) );
    }

    public String selectParticularClaim(String claimID) {
        return "//td[contains(text(),'" + claimID + "')]/following-sibling::td[13]/a[contains(text(),'select')]";
    }

    public WebElement selectClaim(String claimID) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + claimID + "')]/following-sibling::td[13]/a[contains(text(),'select')]" ) );
    }

    public WebElement selectSolicitorType() {
        return waitForElementPresent( By.id( "ddlEventToAdd" ) );
    }

    public WebElement addSolicitorImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Assigned Panel Solicitor')]/following-sibling::input[contains(@title,'Select Resource')]" ) );
    }

    public WebElement addSolicitor(String solicitor) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + solicitor + "')]/preceding-sibling::td/a[contains(text(),'Select')]" ) );
    }

    public WebElement viewClaim(String claimID) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + claimID + "')]/following-sibling::td/a/img" ) );
    }

    public String claimListedUnderDashBoard(String claimID) {
        return   "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgAssignedCases_ctl01']/tbody/tr/td[contains(text(),'" + claimID + "')]";
    }

    public WebElement slaColor(String claimID) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgAssignedCases_ctl01']/tbody/tr/td[contains(text(),'" + claimID + "')]/../td/a/i/img" ) );
    }

    public String validateDeadlineInDashBoard(String claimID, String deadLine) {
        return  "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgAssignedCases_ctl01']/tbody/tr/td[contains(text(),'" + claimID + "')]/preceding-sibling::td//td[contains(text(),'" + deadLine + "')]" ;
    }

    public WebElement viewClaimFromDashBoard(String claimID) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgAssignedCases_ctl01']/tbody/tr/td[contains(text(),'" + claimID + "')]/following-sibling::td//a/img" ) );
    }

    public WebElement navigateToDashBoard() {
        return waitForElementPresent( By.xpath( "//td[@id='pnl2_Text']" ) );
    }


    public WebElement claimAmountInSummaryTable(String s) {
        return waitForElementPresent( By.xpath( "//td[text()='" + s + "']/following-sibling::td[7]" ) );
    }


    public WebElement getWorkflowCurrentTask() {
        return waitForElementPresent( By.xpath( "//span[contains(@id,'WorkflowTaskPane_lblCurrentTask')]" ) );
    }

    public WebElement getWorkflowCaseID() {
        return waitForElementPresent( By.xpath( "//td[not(contains(@class, 'fieldlabel'))]/span[contains(@id,'WorkflowTaskPane_lblCase')]" ) );
    }

    public WebElement txtFreeTextBox() {
        return waitForElementPresent( By.xpath( "//textarea[contains(@name,'ucMandatoryFieldEditor$txt30')]" ) );

    }

    public WebElement paymentAccountWithoutValidation() {
        return waitForElementPresent( By.xpath( "//label[contains(text(),'Payment Account Add Without Validation')]/../input" ) );
    }

    public WebElement txtSupplierType(String countryName) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Default Suppliers:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + countryName + "')]/preceding-sibling::td[3]" ) );
    }

    public WebElement txtCompanyName(String countryName) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Default Suppliers:')]/../../following-sibling::tr//table/tbody/tr/td[contains(text(),'" + countryName + "')]/..//following-sibling::td[4]" ) );
    }

    public String fieldICUDays() {
        return "//input[@formcontrolname='icuDays']";
    }

    public String fieldNonICUDays() {
        return "//input[@formcontrolname='nonIcuDays']";
    }

    public String fieldOutPatientDays() {
        return "//input[@formcontrolname='outPatientDays']";
    }

    public String fieldPublicHospitalDays() {
        return "//input[@formcontrolname='publicHospitalDays']";
    }

    public WebElement perilsAndCostClaimItemId() {
        return waitForElementPresent( By.xpath( "//span[text()='Claim Items:']/../../following-sibling::tr[1]//tbody//td[1]" ) );
    }

    public WebElement gpcheckgeneratedEvent() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'NEXT ACTION: GP Check Generated')]/../input" ) );
    }

    public WebElement enterGPDetails() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//label[contains(text(),'NEXT ACTION: Enter GP Details')]/../input" ) );
    }


    public WebElement enterPolicyWordingRelatesToRepudiation() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//span[contains(text(),'Free text box – enter policy wording which relates to repudiation')]/../following-sibling::td[1]/textarea" ) );
    }

    public WebElement enterExplainationRelatesToPolicyWording() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//span[contains(text(),'Free text box – to explain how the circumstances relates to policy wording')]/../following-sibling::td[1]/textarea" ) );
    }


    public WebElement selectMTCRefunddrpdown() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'MTC Refund Allowed')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement selectMTCRefundApproval(String reason) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + reason + "')]" ) );
    }

    public WebElement selectReturnTIMClaimDropdown() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Return Claim to TIM Reasons')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement selectReturnTIMClaimReason(String reason) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + reason + "')]" ) );
    }

    public WebElement selectLetterType() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//select[@name='ddlEventToAdd']" ) );
    }

    public WebElement validateAnswer(String id) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//*[@id='Rad304955_ctl01']/tbody/tr/td[contains(text(),'" + id + "')]/../td[7]" ) );
    }

    public WebElement validateOutcome(String id) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//*[@id='Rad304955_ctl01']/tbody/tr/td[contains(text(),'" + id + "')]/../td[5]" ) );
    }
    public WebElement validateOutcome2(String id) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "(//*[@id='Rad304955_ctl01']/tbody/tr/td[contains(text(),'Outcome')]/../td[5])[2]" ) );
    }

    public WebElement compareAnswer(String id, String option) {
        return waitForElementPresent( By.xpath( "//*[@id='" + id + "']//b[contains(text(),'" + option + "')]" ) );
    }

    public WebElement btnCreatEvent() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//input[@value='Create Event And Open To Print']" ) );
    }

    public WebElement txtPatientDetails(String detail) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'" + detail + "')]/../..//input[@type='text']" ) );
    }

    public WebElement txtPatientUKAddress() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Patients UK Address')]/../..//textarea" ) );
    }

    public WebElement customerClaimedChkBox() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_chk304910_55636799" ) );
    }

    public WebElement customerAlreadyTrip() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Is the customer already on the trip ')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement perilsAndCost_Tab_Claim() {
        return waitForElementPresent( By.xpath( "//span[text()='Perils and Costs']" ) );
    }

    public WebElement claimDetail1(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Detail 1')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[6]" ) );
    }

    public WebElement claimDetail2(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Detail 2')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[7]" ) );
    }

    public WebElement claimDescription(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Description')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[9]" ) );
    }

    public WebElement claimAmount(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Amount')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[10]" ) );
    }

    public WebElement currencyCode(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Currency Code')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[11]" ) );
    }

    public WebElement gbp(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'GBP')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[12]" ) );
    }

    public WebElement excess(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Excess')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[16]" ) );
    }

    public WebElement total(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Total')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[19]" ) );
    }

    public WebElement claimItemsTable() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Claim Items:')]/../../following-sibling::tr//table//tbody" ) );
    }

    public WebElement limit(int iRow) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Limit')]/../../../following-sibling::tbody/tr[" + iRow + "]/td[17]" ) );
    }

    public WebElement saveClaimHandlerName() {
        return waitForElementPresent( By.xpath( "//table[@class='MasterTable_Default'][1]/tbody/tr[2]/td[10]" ) );
    }
    public WebElement hoveringOverClaimIdInDashboard() {
        return waitForElementPresent( By.xpath( "//img[contains(@id,'ctl06_imgInsideSla')]" ) );
    }
    public WebElement navigateToNextPage() {
        return waitForElementPresent( By.xpath("//a[@title='Next page']") );
    }
    public WebElement selectSupplier() {
        return waitForElementPresent( By.xpath( "//input[contains(@name,'ucMandatoryFieldEditor$304316_searchButton')]" ) );
    }

    public WebElement gpCheckCustomerAuthorise() {
        return waitForElementToBeClickableAndReturnElement( By.xpath("//span[contains(text(),'Do we have customer authorisation?')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement retrieveTMAClaimID() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//img[@src='/images/icons/edit.gif']/../../../td[3]" ) );
    }


}
