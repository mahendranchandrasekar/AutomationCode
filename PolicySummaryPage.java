package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PolicySummaryPage extends AbstractPage {


    public WebElement policySummaryHeader() {
        return waitForElementPresent(By.xpath("//div[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlMatterHeader']/div[1]"));
    }

    public WebElement quoteSummaryHeader() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Quote & Buy')]/../preceding-sibling::div[1]"));
    }


    public WebElement customerDetailsTab() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCustomerDetails"));
    }

    public boolean customerDetailsTabDisplayed() {
        return elementDisplayed(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlCustomer"));
    }

    public boolean customerDetailsTabIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlCustomer"));
        return lstWb.size() != 0;
    }

    public boolean isErrorPageDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.xpath("//h2[text()='An error has occurred']"));
        return lstWb.size() != 0;
    }

    public WebElement basePolicy() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_gridRow"));
    }

    public WebElement policySummaryTable() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_pnlCustom']/div[1]//table/tbody"));
    }

    public WebElement quoteSummaryTable() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_pnlCustom']/div[3]//table/tbody"));
    }

    public WebElement email() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbEmail"));
    }

    public WebElement productType() {
        return waitForElementVisible(By.xpath("//*[@id=\"policySchemeData\"]"));
    }

    public WebElement productName() {
        return waitForElementVisible(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblBrandNameShort\"]"));
    }

    public WebElement coverDetailsTab() {
        return waitForElementPresent(By.id("tsPages_tab26308"));
    }

    public WebElement addCoverBtn() {
        return waitForElementPresent(By.id("300930_searchButton"));
    }

    public WebElement addCoverBtnFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameRadWindowManager1_PagesDialogWindow"));
    }

    public WebElement selectCover(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/..//a"));
    }

    public WebElement excludedMedicalConditionTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_grdMedicalExclusions"));
    }

    public WebElement expandExcludedMedicalConditionTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_imgOpen"));
    }

    public WebElement basePolicyEdit() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_lnkMatterView"));
    }

    public WebElement saveBankAccount() {
        return waitForElementPresent(By.xpath("//input[@class='btnSave button']"));
    }

    public WebElement saveChequeAccount(){
        return waitForElementPresent(By.xpath("//input[@value='Save' and @class='btnSave button']"));
    }

    public WebElement btnChequeSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement radioExistingBankAccount() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Bank Account')]/..//input"));
    }

    public WebElement radioExistingCheque() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Cheque')]/..//input"));
    }

    public WebElement viewBillingDetailsLink() {
        return waitForExpectedElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkBilling"), 45);
    }

    public WebElement purchaseBtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPurchasedProducts"));
    }

    public WebElement ledgerBtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCustomerLedger"));
    }


    public String contactCustomerOption() {
        return "//*[contains(text(),'Contact customer - options')]";
    }

    public WebElement lnkSelectUpgrade(String upgrades) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//td[2][contains(text(),'" + upgrades + "')]/../td[12]/input"));
    }

    public String lnkLatestUpgrade(String upgrades) {
        return "//td[2][contains(text(),'" + upgrades + "')]/../td[12]/input";
    }

    public String lnkAcctInformation(String upgrades, int i) {
        return "(//td[2][contains(text(),'" + upgrades + "')]/../td[13]/input)[" + i + "]";
    }

    public String lnkAccountInfoList(String upgrades) {
        return "//td[2][contains(text(),'" + upgrades + "')]/../td[13]/input";
    }

    public WebElement lblPaymentStatus(String status) {
        return waitForElementPresent(By.xpath("//td[10][contains(text(),'" + status + "')]"));
    }

    public WebElement btnPurchase() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPurchasedProducts"));
    }

    public boolean isBtnPurchaseInvisible() {
        return waitForElementInVisible(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPurchasedProducts"));
    }

    public WebElement btnClose() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancel"));
    }

    public WebElement btnBack() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnGoBack"));
    }

    public WebElement cardEditButton() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Card')]/../td[2]/a/img"));
    }

    public WebElement lnkPolicyView() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountLID"));
    }

    public WebElement lblAccountno() {
        return waitForExpectedElement(net.serenitybdd.core.annotations.findby.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_lblAccountNumber"), 10);
    }

    public WebElement btnCancel() {
        return waitForExpectedElement(net.serenitybdd.core.annotations.findby.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancelAccountScreen"), 10);
    }

    public WebElement leadDetailsLink() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_lnkLeadDetails"));
    }

    public WebElement deceasedCustomerColor(String customer) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + customer + "')]/.."));
    }

    public WebElement navigateToTaskReminderTab() {
        return waitForElementPresent(By.id("pnl41_Text"));
    }

    public WebElement validateTableHeader(String header) {
        return waitForElementPresent(By.xpath("//table[contains(@id,'ctl00_cphBody_grdDiaryAppointments')]/thead/tr[1]/th/a[contains(text(),'" + header + "')]"));
    }

    public WebElement validateotherTableHeader(String header) {
        return waitForElementPresent(By.xpath("//table[contains(@id,'ctl00_cphBody_grdDiaryAppointments')]/thead/tr[1]/th[contains(text(),'" + header + "')]"));
    }

    public WebElement btnAccounts() {
        return waitForElementPresent(By.xpath("//*[@value='Accounts']"));
    }

    public WebElement txtCardPayment(String type) {
        return waitForElementPresent(By.xpath("(//th[contains(text(),'Account Type')]/../../..//tr)[2]//td[14][contains(text(),'" + type + "')]"));
    }

    public WebElement txtpurchaseDate(String date) {
        return waitForElementPresent(By.xpath("(//th[contains(text(),'Purchased On')]/../../../..//tr)[3]//td[4][contains(text(),'" + date + "')]"));
    }

    public WebElement txtpurchasedAmount(String amount) {
        return waitForElementPresent(By.xpath("(//th[contains(text(),'Purchased On')]/../../../..//tr)[3]//td[10][contains(text(),'" + amount + "')]"));
    }

    public List<WebElement> waitForPaymentScheduleModelWindow() {
        return waitForElementsVisible(By.xpath("//div[contains(@id,'nlPurchasedProductPaymentSchedule')]"), 20);
    }

//    public WebElement viewClaimDetailsLink() {
//        return waitForExpectedElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkClaim"), 45);
//    }

    public WebElement noClaimsMessage() {
        return waitForElementPresent(By.xpath("//td[text()='There are no claims on this account']"));
    }

    public WebElement paymentCommentSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }


    public int jointAccountHolderCount() {
        System.out.println("Inside jointAccountHolderCount************");
        List<WebElement> list = getDriver.findElements(By.xpath("(//table[@class='MasterTable_Default'])[2]/tbody/tr"));
        int numberOfRows = list.size();
        System.out.println("numberOfRows************" + numberOfRows);
        return numberOfRows;


    }

    public String jointAccountHolderDetails(int rowNumber) {
        System.out.println("Inside jointAccountHolderDetails************");
        WebElement cellValue = getDriver.findElement(By.xpath("(//table[@class='MasterTable_Default'])[1]/tbody/tr[" + rowNumber + "]/td[2]"));
        String cellDetails = cellValue.getText();
        System.out.println("cellDetails************" + cellDetails);
        return cellDetails;
    }
}
