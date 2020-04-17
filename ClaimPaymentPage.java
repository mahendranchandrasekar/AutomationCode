package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimPaymentPage extends AbstractPage {

//    public WebElement claimPaymentTable() {
//        return waitForElementPresent( By.xpath( "//table[contains(@id,'grdClaims')]" ) );
//    }

    public WebElement othersRadioButton() {
        return waitForElementPresent( By.xpath( "//input[@value='Other']" ) );
    }

    public WebElement paymentMethod() {
        return waitForElementPresent( By.xpath( "//select[contains(@id,'ddlPayment')]" ) );
    }

    public WebElement payeeType() {
        return waitForElementPresent( By.xpath( "//select[contains(@id,'PayeeTypeddl')]" ) );
    }

    public WebElement amount() {
        return waitForElementPresent( By.xpath( "//span[contains(@id,'PaymentAmount')]" ) );
    }

    public WebElement paymentHelperFields() {
        return waitForElementPresent( By.linkText( "Enter Payment Details" ) );
    }


    public String claimImtemCheckboxXpath() {
        return "//table[contains(@id,'grdClaims')]//input[@type='checkbox']";
    }

    public WebElement ClaimItemTable() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'ucMandatoryFieldEditor')][contains(@id,'grdClaims')" ) );
    }

    public WebElement selectBtn() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'btnSetToPay')]" ) );
    }

    public WebElement payeeFirstName() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'PayeeFirstName')]" ) );
    }

    public WebElement payeeLastName() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'PayeeLastName')]" ) );
    }

    public WebElement payeeSortCode() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'SortCode')]" ) );
    }

    public WebElement accountNumber() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'AccountNumber')]" ) );
    }

    public WebElement bankName() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'BankName')]" ) );
    }

    public WebElement address1() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'Address1')]" ) );
    }

    public WebElement address2() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'Address2')]" ) );
    }

    public WebElement town() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'Town')]" ) );
    }

    public WebElement county() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'County')]" ) );
    }

    public WebElement postCode() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'PostCode')]" ) );
    }

    public WebElement country() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'Country')]" ) );
    }

    public WebElement guestPeople() {
        return waitForElementPresent( By.xpath( "//select[contains(@id,'ddlguestpeople')]" ) );
    }

    public String paymentCheckbox(String detail) {
        return "//table[contains(@id,'grdClaims')]/tbody/tr/td[6][contains(text(),'" + detail + "')]/../td/input[contains(@id,'chkPay')]";
    }

    public String goodwillPaymentRecentRecord() {
        return "(//td[contains(text(),'Goodwill')]/..)[last()]/td";
    }

    public String paymentRecordForGoodWill(String paymentTRID) {
        return "//td[contains(text(),'" + paymentTRID + "')]/../td";
    }

    public String paymentTypeDropdownValues() {
        return "//div[@class='ComboBoxItem_Default']";
    }

    public WebElement paymentMethodInput() {
        return waitForElementPresent( By.xpath( "(//input[@value='Please select...' or @value='BACS'])[1]" ) );
    }

    public WebElement paymentType(String paymentType) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + paymentType + "')]" ) );
    }

    public WebElement paymentDescription() {

        WebElement webElment = null;
        try {
            webElment = waitForElementPresent( By.xpath( "//span[contains(text(),'Payment Description')]/../following-sibling::td/textarea" ) );
        } catch (Exception ex) {
            webElment = waitForElementPresent( By.xpath( "//span[contains(text(),'Payment Description')]/../following-sibling::td/input" ) );
        }
        return webElment;
    }

    public WebElement paymentAmount() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Amount')]/../following-sibling::td//input[1]" ) );
    }

    public WebElement goodwillEvent() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'OOP Raise Goodwill/Compensation Payment')]" ) );
    }

    public WebElement goodwillEventPreviewEmail() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Preview this email')]" ) );
    }

    public WebElement previewEmail() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Preview this email')]" ) );
    }

    public WebElement amountInPreview() {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'payment for £')]/span" ) );
    }

    public WebElement previewEmailCloseBtn() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Close')]" ) );
    }

    public WebElement payeeGoodWill() {
        return waitForElementPresent( By.xpath( "//input[contains(@id,'ucMandatoryFieldEditor_txt302292')]" ) );
    }

    public WebElement accountNoGoodWill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Account Number')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement sortNoGoodWill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Sort Code')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement bankNameGoodWill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Bank Name')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement addressLine1Goodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Address 1')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement postcodeGoodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Postcode')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement addressline2Goodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Address 2')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement addressline3Goodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'Address 3')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement cityGoodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'City')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement countyGoodwill() {
        return waitForElementPresent( By.xpath( "//span[contains(text(), 'County')]/../following-sibling::td[1]/input[1]" ) );

    }

    public WebElement countryGoodwill() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_txt302015" ) );
    }

    public WebElement save() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_customFieldSaveButton" ) );
    }

    public WebElement goodwillSave() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_btnSave" ) );
    }

    public WebElement saveInPaymentMethod() {
        return waitForElementPresent( By.id( "ucMandatoryFieldEditor_btnSave" ) );
    }

    public WebElement radBtnPackagedAccount() {
        return waitForElementPresent( By.id( "rblAccountTypes_0" ) );
    }

    public WebElement savePaymentBtn() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//input[@value='Save']" ) );
    }

    public WebElement selectPayee(String payee) {
        return waitForElementPresent( By.xpath( "//label[contains(text(),'" + payee + "')]//../input" ) );
    }

    public WebElement saveBtn() {
        return waitForElementPresent( By.xpath( "//input[contains(@class,'btnSave')]" ) );
    }

    public WebElement paymentPageAccountNo() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Account No') or contains(text(),'Account Number')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageSortCode() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Sort Code')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageBankName() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Bank Name')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageAddress1() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Address1')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageAddress2() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Address2 ')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPagePostcode() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'PostCode ')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageTown() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Town')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPageCounty() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'County')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement selectAccountDetail(String accountNumber) {
        return waitForElementPresent( By.xpath( " //*[contains(text(),'" + accountNumber + "')]/preceding-sibling::input" ) );
    }

    public WebElement clickOnMedicalImage() {
        return waitForElementPresent( By.xpath( "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_gridRow']/td[2]/img" ) );
    }

    public WebElement paymentPayeeFirstName() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Payee First Name')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement paymentPayee() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Payee')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement medicalClaimTypeText() {
        return waitForElementPresent( By.xpath( "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_grdMedicalExclusions']/tbody/tr[2]/td[1]" ) );
    }

    public WebElement selectPayeeMethod() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Payment Method')]/../following-sibling::td/div" ) );
    }

    public WebElement typePayee() {
        return waitForElementPresent( By.xpath( "(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl302502')])[1]" ) );
    }

    public WebElement drpdnPayeeType(String type) {
        return waitForElementPresent( By.xpath( "//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302502_') and contains(text(),'" + type + "')]" ) );
    }

    public WebElement drpdnPayeeTypeThirdParty(String type) {
        return waitForElementPresent( By.xpath( "(//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302502_') and contains(text(),'" + type + "')])[1]" ) );
    }

    public WebElement errMsgPayment() {
        return waitForElementPresent( By.xpath( "//*[@id='lblGlobalError']/font[contains(text(),'This claim is on hold, so no payments can currently be made')]" ) );
    }

    public WebElement errorMessageForPHPayment(String fieldValue) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + fieldValue + "')]" ) );
    }

//    public WebElement btnOk() {
//        return waitForElementPresent( By.id( "btnCancel" ) );
//    }

    public WebElement purchaseBtn() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPurchasedProducts" ) );
    }

    public WebElement accountInformationDetails(String claimID) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + claimID + "')]/following-sibling::td//input[@title='Account Information']" ) );
    }

    public WebElement paymentScheduleDetails(String coverName) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + coverName + "')]/following-sibling::td//input[@title='Payment Schedule']" ) );
    }

    public WebElement accountNumberInPurchase() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_lblAccountNumber" ) );

    }

    public WebElement sortCodeInPurchase() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_lblSortcode" ) );
    }

    public WebElement cancelBtnAccountInformation() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancelAccountScreen" ) );
    }

    public WebElement backBtnAccountInformation() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_btnGoBack" ) );
    }

    public WebElement enterCMSReferenceNumber() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'CMS Reference Number')]/../following-sibling::td[1]/input[1]" ) );
    }

    public WebElement complaintClosureReasonImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Complaint Closure Reason')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement complaintClosureReason(String reason) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + reason + "')]" ) );
    }

    public WebElement firstclaim() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_grdClaims_ctl02_lnkPerils" ) );
    }

    public WebElement cancelBtnPayment() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancel" ) );
    }

    public WebElement paymentScheduleTable(int columnNumber) {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'grdPurchasedProductPaymentSchedule')]/tbody/tr/td[" + columnNumber + "]" ) );
    }

    public WebElement paymentMethodValue(String method) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + method + "')]" ) );
    }

    public WebElement enterDOBtxtBox() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_rdpDateOfBirth_dateInput_text" ) );
    }

    public WebElement updateCustomerbtn() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnUpdateCustomer" ) );
    }

    public WebElement renewalTab() {
        return waitForElementPresent( By.xpath( "(//span[contains(text(),'Renewal')])[1]" ) );
    }

    public WebElement upgradeImportedFromUISchkbox() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Upgrade Imported From UIS')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement upgradeImportedFromUISchkboxValueChecked() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Upgrade Imported From UIS')]/../following-sibling::td/input[2]" ) );
    }

    public WebElement saveAndClosebtn() {
        return waitForElementPresent( By.id( "btnSaveAndClose" ) );
    }

    public WebElement createPayment() {
        return waitForElementPresent( By.id( "ddlEventToAdd" ) );
    }

    public WebElement selectPaymentImg() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Payment Method')]/../following-sibling::td/div//img" ) );
    }

    public WebElement selectPaymentMethod(String method) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + method + "')]" ) );
    }

    public WebElement enterSortCode() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Sort Code')]/../following-sibling::td/input[1]" ) );
    }


    public WebElement selectAvailableAccountDetails(String paymentType, String accountDetails) {
        System.out.println( "-------------------------------ACccount Summary scrren------------------------" );
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + paymentType + "') and contains(text(),'" + accountDetails + "')]/preceding-sibling::input" ) );
    }

    public WebElement selectExistingAccForCompensation(String paymentMethod, String accountDetails) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + paymentMethod + "') and contains(text(),'" + accountDetails + "')]/preceding-sibling::input" ) );
    }

    public WebElement txtDropDownValuesInPayeeType() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Payee Type')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement drpdnfieldValue(String name) {
        return waitForElementVisible( By.xpath( "//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302502') and contains(text(),'" + name + "')]" ) );
    }

    public WebElement selectPayeeMethodOption(String payeeMethos) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + payeeMethos + "')]" ) );
    }

    public WebElement txtFieldPayee() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Payee')]" ) );
    }

    public WebElement txtFieldPayeeType() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Payee Type')]" ) );
    }

    public WebElement txtFieldAccountNumber() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Account Number')]" ) );
    }

    public WebElement txtFieldBankName() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Bank Name')]" ) );
    }

    public WebElement txtFieldSortCode() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Sort Code')]" ) );
    }

    public WebElement txtFieldTown() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Town')]" ) );
    }

    public WebElement txtFieldAddress1() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Address1')]" ) );
    }

    public WebElement txtFieldAddress2() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'Address2')]" ) );
    }

    public WebElement txtFieldcounty() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'County')]" ) );
    }

    public WebElement txtFieldPostCode() {
        return waitForElementPresent( By.xpath( "//*[contains(@title,'PostCode')]" ) );
    }

//    public WebElement errorMessage() {
//        return waitForElementPresent( By.xpath( "//span[@id='lblGlobalError']" ) );
//    }

    public WebElement txtPayeeTMA() {
        return waitForElementVisible( By.xpath( "//select[@id='ddlEventToAdd']" ) );
    }

    public WebElement dropdownPayeeTitle() {
        return waitForElementVisible( By.xpath( "//span[contains(text(),'Payee Title')]/../following-sibling::td[1]/div/div/img" ) );
    }

    public WebElement paymentPayeeSurName() {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'Payee Surname')]/../following-sibling::td/input[1]" ) );
    }

    public WebElement selectPayeeTitle(String title) {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "(//div[contains(text(),'" + title + "')])[1]" ) );
    }

    public WebElement btnVerifyAccount() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//*[@value='Verify Account Details']" ) );
    }

    public WebElement btnOverrideResult() {
        return waitForElementToBeClickableAndReturnElement( By.xpath( "//*[@value='Override Verification Result']" ) );
    }
    public String overrideVerificationResultButton() {
        return  "//*[@value='Override Verification Result']";
    }

    public WebElement verifyBankValidationMessage(String message) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + message + "')]" ) );
    }

    public String claimItemsSelectedXpath() {
        return "//table[contains(@id,'grdClaims')]//input[@checked='checked']//../preceding-sibling::td[2]";
    }

    public WebElement calculatedClaimAmount(){
        return waitForElementPresent(By.xpath("//span[@class='PaymentAmountCalculated']"));
    }

    public String buttonnVerifyAccount() {
        return  "//*[@value='Verify Account Details']" ;
    }
}
