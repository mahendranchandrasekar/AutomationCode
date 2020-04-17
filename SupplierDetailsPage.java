package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class SupplierDetailsPage extends AbstractPage {

    public WebElement leadDetails() {
        return waitForElementVisible(By.xpath("//a[contains(@id,'lnkLeadDetails')]"));
    }

    public WebElement companyName() {
        return waitForElementVisible(By.xpath("//input[@title='Select Resource']"));
    }

    public WebElement selectCompanyName() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id=\"detailFieldRadGrid_ctl01\"]/tbody/tr[1]/td[1]/a"));
    }

    public WebElement tradingAs() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Trading as')]/../following-sibling::td/input[1]"));
    }

    public WebElement area() {
        return waitForElementVisible(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301676']"));
    }

    public WebElement areaValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement countryForVAT() {
        return waitForElementVisible(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301675']"));
    }

    public WebElement countryForVATValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement countriesRegionAs() {
        return waitForElementVisible(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301677']"));
    }

    public WebElement countriesRegionAsValue() {
        return waitForElementVisible(By.xpath(".//*[@id='ucMandatoryFieldEditor_ddl301677_c0']"));
    }

    public WebElement creditCheckedDate() {
        return waitForElementVisible(By.xpath("(//*[contains(@id,'dateInput_text')])[1]"));
    }

    public WebElement dueDiligenceDate() {
        return waitForElementVisible(By.xpath("(//*[contains(@id,'dateInput_text')])[2]"));
    }

    public WebElement website() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Website')]/../following-sibling::td/input[1]"));
    }

    public WebElement supplierStatus() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Status')]/../following-sibling::td/div/div/input[1]"));
    }

    public WebElement supplierStatusValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement supplierType() {
        return waitForElementVisible(By.xpath("(//span[text()='Supplier Type']/../following-sibling::td/div/div/input[1])[1]"));
    }

    public WebElement supplierTypeValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement companyRegistrationNumber() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Registration Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement countryOfRegistration() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Country of Registration')]/../following-sibling::td/div/div/input[1]"));
    }

    public WebElement countryOfRegistrationValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement VATNumber() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'VAT Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement preferredPaymentMethod() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Preferred Payment Method')]/../following-sibling::td/div/div/input[1]"));
    }

    public WebElement preferredPaymentMethodValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement supplierComments() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Comments')]/../following-sibling::td/textarea"));
    }

    public WebElement serviceLevelAgreement() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Service Level Agreement for Suppliers')]/../following-sibling::td/input[1]"));
    }

    public WebElement paymentTerms() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Payment Terms')]/../following-sibling::td/input[1]"));
    }

    public WebElement openingHours() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Opening Hours')]/../following-sibling::td/input[1]"));
    }

    public WebElement nameOfContact() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Name of Contact')]/../following-sibling::td/input[1]"));
    }

    public WebElement moneyTransfer() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Money Transfer')]/../following-sibling::td/input[1]"));
    }

    public WebElement travelAgent() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Travel Agent')]/../following-sibling::td/input[1]"));
    }

    public WebElement bankName() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Bank Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement bankPostcode() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Post Code')]/../following-sibling::td/input[1]"));
    }

    public WebElement bankCountry() {
        return waitForElementVisible(By.xpath(" //span[contains(text(),'Bank Country')]/../following-sibling::td/input[1]"));
    }

    public WebElement sortCode() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Sort Code')]/../following-sibling::td/input[1]"));
    }

    public WebElement accountNumber() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Account Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement IBANNumber() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'IBAN Num')]/../following-sibling::td/input[1]"));
    }

    public WebElement BICNumber() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'BIC Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement bankAddress() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Bank Address')]/../following-sibling::td/textarea"));
    }

    public WebElement saveBtn() {
        return waitForElementVisible(By.xpath("//*[@id='btnSave']"));
    }

    public WebElement supplierBankDetailsTab() {
        return waitForElementVisible(By.xpath("//a[contains(@title,'Supplier Bank Details')]"));
    }

    public WebElement saveAndCloseBtn() {
        return waitForElementVisible(By.xpath("//*[@id='btnSaveAndClose']"));
    }

    public WebElement historyOfChange(String fieldName) {
        return waitForElementVisible(By.xpath("//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/input[contains(@id,'btnHistory')]"));
    }

    public WebElement invoiceDetailsInsertBtn() {
        return waitForElementVisible(By.xpath("//input[@value='Insert']"));
    }

    public WebElement invoiceTotalDueInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Total Amount Payable including VAT')]/../following-sibling::div/input)[1]"));
    }

    public WebElement invoicefeeRateInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Fee Rate')]/../following-sibling::div/input"));
    }

    public WebElement feesInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath(" (//span[contains(text(),'Fees')]/../following-sibling::div/input)[1]"));
    }

    public WebElement invoiceDateInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Invoice Date')]/../following-sibling::div/input"));
    }

    public WebElement invoiceClaimIdInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'txtClaimID')]"));

    }

    public WebElement invoiceClaimItemIdInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Claim Item ID')]/../following-sibling::div/input"));
    }

    public WebElement invoiceClaimItemIdSelect() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlSelectClaimItem')]"));
    }

    public WebElement invoicePayableAmountInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Payable')]/../following-sibling::div/input"));
    }

    public WebElement invoiceSaveBtnInsideFrame() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_btnSaveBasicTableEdit"));
    }

    public WebElement invoiceSaveBtn() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement editFirstSupplier() {
        return waitForElementVisible(By.xpath("//img[@alt='open']"));
    }

    public WebElement editLinkInInvoiceTable() {
        return waitForElementVisible(By.xpath("//table[@id='Rad302444_ctl01']/tbody/tr[last()]/td/a[text()='Edit']"));
    }

    public WebElement vatStatusInTable() {
        return waitForElementVisible(By.xpath("//table[@id='Rad302444_ctl01']/tbody/tr[last()]/td[39]//input[contains(@id,'ddl302988_Input')]"));
    }

    public WebElement vatStatusOption(String option) {
        return waitForElementVisible(By.xpath("//div[contains(text(),'" + option + "')]"));
    }

    public WebElement updateInTable() {
        return waitForElementVisible(By.xpath("//a[contains(text(),'Update')]"));
    }

    public WebElement vatAmountInTable() {
        return waitForElementVisible(By.xpath("//table[@id='Rad302444_ctl01']/tbody/tr[last()]/td[40]"));
    }


    public WebElement currencyDropdown() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Currency')]/../following-sibling::div/select"));
    }

    public WebElement importedVatAmountInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Imported VAT Amount')]/../following-sibling::div/input)[1]"));
    }

    public WebElement defaultStatus() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[@id='Rad302444_ctl01']/tbody/tr[last()]/td[38]"));
    }

    public WebElement costContainerFeesInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Cost Container Fees')]/../following-sibling::div/input)[1]"));
    }

    public WebElement invoiceNumInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Invoice Num')]/../following-sibling::div/input)[1]"));
    }

    public WebElement invoicePeriodInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Invoice Period')]/../following-sibling::div/input)[1]"));
    }

    public WebElement beneificaryInvoiceDateInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Beneificary Invoice Date')]/../following-sibling::div/input)[1]"));
    }

    public WebElement beneificaryInvoiceAmountInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Beneificary Invoice Amount')]/../following-sibling::div/input)[1]"));
    }

    public WebElement ultimateBeneficiaryClaimNoInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Ultimate beneficiary Claim No')]/../following-sibling::div/input)[1]"));
    }

    public WebElement ultimateBeneficiaryBillNoInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Ultimate beneficiary Bill No')]/../following-sibling::div/input)[1]"));
    }

    public WebElement ultimateBeneficiaryDepartmentInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Ultimate Beneficiary Department')]/../following-sibling::div/input)[1]"));
    }

    public WebElement selectClaimToPay(String claimID) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'" + claimID + "')]/preceding-sibling::td//input"));
    }

    public WebElement bankValidationSaveBtn(){
        return waitForElementVisible(By.xpath("//input[contains(@id,'btnSave') and @class='btnSave button']"));
    }

    public WebElement payInvoiceSave() {
        return waitForElementVisible(org.openqa.selenium.By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement bankAccountSaveBtn() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//*[@class='btnSave button']"));
    }

    public String btnBankAccountSave() {
        return "//*[@class='btnSave button']";
    }

    public String vatStatusOption() {
        return "(//span[contains(text(),'VAT Status')]/../following-sibling::div/select)[1]/option";
    }

    public WebElement postcodeInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'PostCode')]/../following-sibling::td/input[1]"));
    }

    public WebElement bankNameInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Bank Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement accountNumberInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Account Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement sortCodeInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Sort Code')]/../following-sibling::td/input[1]"));
    }

    public WebElement address1Input() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Building Number')]/../following-sibling::td/input[1]"));
    }


    public WebElement address2Input() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Street')]/../following-sibling::td/input[1]"));
    }


    public WebElement townInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Town')]/../following-sibling::td/input[1]"));
    }

    public WebElement countryInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[text()='Country']/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement countyInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[text()='County']/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement accountSubTypeInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Account Sub Type')]/../following-sibling::td//input[1]"));
    }

    public WebElement accountSubTypeOption(String fieldValue) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement accountHolderNameInput() {
       return waitForElementVisible(By.xpath("//span[contains(text(),'Account Holder First Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement countryOption(String fieldValue) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement accountTypeInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Account Type')]/../following-sibling::td//input)[1]"));
    }

    public WebElement accountTypeOption(String fieldValue) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement seletChequeDetails(String details) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//label[contains(text()," + details + ")]/preceding-sibling::input"));
    }

    public WebElement patientNameInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Patient name')]/../following-sibling::div/input)[1]"));
    }

    public WebElement patientDOBInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Patient Date of Birth')]/../following-sibling::div/input)[1]"));

    }

    public WebElement amountbeforeVAT() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Amount before VAT')]/../following-sibling::div/input[1])[1]"));

    }

    public WebElement paidInvoicesTab() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Paid Invoices')]"));
    }

    public WebElement invoicePaidForClaim() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[@id='Rad303670_ctl01']/tbody/tr/td[11]"));

    }

    public String invoicePaidForClaimXpath() {
        return "//table[@id='Rad303670_ctl01']/tbody/tr/td[10]";
    }

    public WebElement remittanceNotificationLink() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//a[contains(text(),'Remittance Notification Email')]"));
    }

    public WebElement emailTab() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[@class='innerWrap' and contains(text(),'Email')]"));
    }

    public WebElement invoicePaidMessage() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//*[contains(text(),'The following invoices has been paid')]"));
    }

    public WebElement closeNotification() {
        return waitForElementVisible(org.openqa.selenium.By.id("btnCustomerLeadDetails"));
    }

    public WebElement totalDueInGBP() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdInvoices')]//tr[2]/td[21]"));
    }

    public WebElement selectBankDetails(String details) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//label[contains(text()," + details + ")]/preceding-sibling::input"));

    }

    public String selectBankDetailsXpath(String details) {
        return "//label[contains(text(),'" + details + "')]/preceding-sibling::input";
    }

    public WebElement matterInSupplier() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_rgMatterHeaders_ctl01']/tbody/tr/td[3]"));
    }

    public WebElement supplierTypeMeaningfullForExport() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[text()='Supplier Type MEANINGFUL FOR EXPORT']/../following-sibling::td/div/div/input[1]"));
    }

    public WebElement supplierTypeMeaningfullForExportValue(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public WebElement supplierTypeInFrame() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[text()='Supplier Type']/../following-sibling::td/div/div/input[1])[2]"));
    }

    public WebElement containsFilter() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'Contains')]"));
    }

    public WebElement surgeryName() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Surgery Name')]/../following-sibling::td/input"));
    }

    public WebElement surgeryAddressLine2() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Address 2')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryAddressLine1() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Address 1')]/../following-sibling::td/input)[1]"));
    }

    public String chequeDetailsXpath() {
        return "//*[contains(text(),'Cheque')]";
    }

    public WebElement validateBankAccount() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@value,'Confirm Account Details')]"));
    }

    public WebElement validationMessage() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@value,'Confirm Account Details')]/following-sibling::span"));
    }

    public WebElement validationBankMessage() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'ID3 Bank Validation check result: Pass')]"));
    }

    public WebElement validationInvalidBankMessage() {
//        return waitForElementVisible(By.xpath("//span[contains(text(),'ID3 Bank Validation check result: Refer - Check details')]"));
        return waitForElementVisible(By.xpath("//span[contains(text(),'Account number and sortcode validation check result: INVALID - Modulus Check Failed')]"));
    }


    public WebElement cancelBtn() {
        return waitForElementVisible(org.openqa.selenium.By.id("btnCancel"));
    }

    public WebElement validationSaveBtn() {
        return waitForElementVisible(org.openqa.selenium.By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement supplierTypeInFrameoption(String fieldValue) {
        return waitForElementVisible(By.xpath("(//div[contains(text(),'" + fieldValue + "')])[1]"));
    }

    public String chkBoxForInvoice() {
        return "//input[contains(@id,'chkIsPay')]";
    }

    public WebElement rushPaymentRequest1() {
        return waitForElementPresent(By.xpath("//td/span[contains(@title,'Rush Payment Request - 1')]/../following-sibling::td/textarea"));
    }

    public WebElement rushPaymentRequest2() {
        return waitForElementVisible(org.openqa.selenium.By.id("ucMandatoryFieldEditor_txt303853_27584900"));

    }

    public WebElement caseId() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'CaseID:')]/../following-sibling::td/span"));
    }

    public WebElement approveRushPayment() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//span[contains(text(),'Approve Rush Payment')]/../following-sibling::td//input)[1]"));
    }

    public WebElement approveRushPaymentOption(String fieldValue) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement supplierType1() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Supplier Type MEANINGFUL FOR EXPORT')]/../following-sibling::td/div/div/input"));
    }

    public WebElement supplierType2() {
        return waitForElementVisible(By.xpath("(//span[contains(text(),'Supplier Type')]/../following-sibling::td/div/div/input)[2]"));
    }

    public WebElement supplierType3() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Supplier:')]/../../../..//following::span[contains(text(),'Supplier Type')]/../following-sibling::td/div/div/input"));
    }

    public WebElement txtboxFilter() {
        return waitForElementVisible(By.xpath("//input[@name='detailFieldRadGrid$ctl01$ctl02$ctl02$ctl02']"));
    }

    public WebElement btnNameFilter() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("(//img[@alt='Filter'])[2]"));
    }

    public WebElement filterDropDwnValue() {
        return waitForElementVisible(By.xpath("//td[contains(text(),'EqualTo')]"));

    }

    public WebElement btnSelect(String fieldValue) {
        return waitForElementVisible(By.xpath("//td[contains(text(),'" + fieldValue + "')]/../td//a[contains(text(),'Select')]"));
    }

    public WebElement supplierType_MandatoryFieldImg() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Supplier Type MEANINGFUL FOR EXPORT')]/../following-sibling::td/div/div/img"));
    }

    public WebElement supplierType_MandatoryFieldValue(String value) {
        return waitForElementVisible(By.xpath("//div[contains(text(),'" + value + "')]"));
    }


    public WebElement searchClaimInvoice() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//input[contains(@id,'btSearchCustomerClaim')]"));
    }

    public WebElement selectClaimToUpdate() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'btSelectCustomerClaimInvoice')]"));
    }

    public WebElement createInvoiceButton() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'CreateCustomerClaimInvoice')]"));
    }

    public WebElement editLinkToUpdateInvoice(String claimID) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[text()='" + claimID + "']/..//td/a[text()='Edit']"));
    }

    public String invoiceCheckBox() {
        return "//input[contains(@id,'chkIsPay')]";
    }

    public String claimItemIdInInvoiceTable(int i) {
        return "(//input[contains(@id,'chkIsPay')]/../../../td[3])[" + (i + 1) + "]";
    }

    public WebElement paidClaimItemId(int i) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[@id='Rad303670_ctl01']/tbody/tr[" + (i + 1) + "]/td[11]"));
    }

    public WebElement excessTypeSelect() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Excess type')]/../following-sibling::div[1]/select"));
    }

    public WebElement paymentTypeCategory() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Payment Type Category')]/../following-sibling::div[1]/select"));
    }


    public WebElement firstNameInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'First Name')]/following-sibling::td//input[contains(@id,'txtFirstName')]"));
    }

    public WebElement lastNameInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'Last Name')]/following-sibling::td//input[contains(@id,'txtLastName')]"));
    }

    public WebElement dobInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'Date of Birth')]/following-sibling::td//input[contains(@id,'txtDOB')]"));
    }

    public WebElement searchResultTable() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]"));
    }

    public WebElement customerNameInTable(String customerName) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + customerName + "')]"));
    }

    public WebElement customerDOBInTable(String customerDOB) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + customerDOB + "')]"));
    }

    public WebElement countryOfLossInTable(String countryOfLoss) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + countryOfLoss + "')]"));
    }

    public WebElement claimIDInTable(String claimID) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + claimID + "')]"));
    }

    public WebElement customerLastNameInTable(String customerLastName) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + customerLastName + "')]"));
    }

    public String selectClaimItem() {
        return "//select[contains(@id,'ddlSelectClaimItem')]/option";
    }

    public WebElement patientNameInInvoiceTable() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//th[contains(text(),'Patient name')]/../following-sibling::tr/td[9]"));
    }

    public WebElement patientDobInInvoiceTable() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//th[contains(text(),'Patient Date of Birth')]/../following-sibling::tr/td[10]"));
    }

    public WebElement patientClaimIDInInvoiceTable() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//th[contains(text(),'Claim ID')]/../following-sibling::tr/td[7]"));
    }

    public WebElement patientClaimItemIDInInvoiceTable() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//th[contains(text(),'Claim Item ID')]/../following-sibling::tr/td[8]"));
    }

    public WebElement totalExVat() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Total ex VAT')]/../following-sibling::div/input"));
    }

    public WebElement totalIncVat() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Total inc VAT')]/../following-sibling::div/input"));
    }

    public WebElement paymentOption() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlIsFullPayment')]"));
    }

    public WebElement invoiceClaimDateInput() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'txtClaimDate')]"));
    }

    public WebElement dateInTable(String date) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//table[contains(@id,'grdClaimCustomers')]//tr[2]/td[contains(text(),'" + date + "')]"));
    }

    public WebElement partialPaymentAmount() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'NewItemReserve')]"));
    }

    public WebElement totalPaidGBPAmount() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//th[contains(text(),'Total Paid GBP Amount')]/../..//following-sibling::tbody/tr/td[19]"));
    }

    public WebElement warningMessage(String fieldValue) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//*[contains(text(),'" + fieldValue + "')]"));
    }


    public WebElement reasonForNotValidating() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Reason For Not Validating Bank Account')]/../following::td/textarea[1]"));
    }

    public WebElement DropDownPreferredPayment() {
        return waitForElementVisible(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_ddl301686_Input')]"));
    }

    public WebElement drpdnPaymentValues(String name) {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl301686') and contains(text(),'" + name + "')]"));
    }


    public WebElement txtAccountDetails() {
        return waitForElementPresent(By.xpath("//label[contains(@for,'rblBankAccounts_1')]"));
    }

    public WebElement txtClaimItem() {
        return waitForElementVisible(By.xpath("//select[contains(@id,'SelectClaimItem')]"));
    }


    public WebElement divDropDownSelect() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//span[contains(text(),'Full Or Partial Payment')]/../following::td[1]//input[@class='ComboBoxInput_Default']"));
    }

    public WebElement divDropDownSupplierPaymentOption(String value) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//div[contains(text(),'" + value + "')]"));
    }

    public WebElement supplierRemittanceMsg() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//td/span[contains(text(),'Rush Payment Remittance Message')]/../following-sibling::td/textarea"));
    }

    public WebElement rushPaymentInsert() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[contains(@id,'btnInsert')]"));
    }

    public WebElement Vat() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[text()='VAT']/../following-sibling::div[1]/input"));
    }

    public WebElement Amount() {
        return waitForElementVisible(By.xpath("//span[text()='Amount']/../following-sibling::div[1]/input"));
    }

    public WebElement vatSubCategorySelect() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Vat SubCategory')]/../following-sibling::div[1]/select"));
    }

    public WebElement vatStatusSelect() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//span[contains(text(),'Vat Status')]/../following-sibling::div[1]/select"));
    }

    public WebElement validateAccountDetails() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@value,'Verify Account Details')]"));
    }

    public WebElement accountHolderFirstNameInput() {

        return waitForElementVisible(By.xpath("//span[contains(text(),'Account Holder First Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement accountHolderSecondNameInput() {

        return waitForElementVisible(By.xpath("//span[contains(text(),'Account Holder Second Name')]/../following-sibling::td/input[1]"));
    }

    public WebElement vatAlreadyApplied() {
        return waitForElementVisible(By.xpath("//span[text()='VAT has already been applied']/../following-sibling::div[1]/input"));
    }

    public WebElement ambulance() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Ambulance')]/../following-sibling::td/input[1]"));
    }

    public WebElement costContainer() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Cost Container')]/../following-sibling::td/input[1]"));
    }

    public WebElement funeralDirectors() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Funeral Directors')]/../following-sibling::td/input[1]"));
    }

    public WebElement btnOverrideResult() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@value='Override Verification Result']"));
    }

    public WebElement paymentMethod() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlPaymentMethod')]"));
    }

    public WebElement invoiceTMAClaimIdInput() {

        return waitForElementVisible(org.openqa.selenium.By.xpath("//input[contains(@id,'txtTMAID')]"));

    }
    public String overrideVerificationResultButton() {
        return  "//*[@value='Override Verification Result']";

    }
    public WebElement validateBankMessage() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Account number and sortcode validation check result: VALID')]"));
    }

}



