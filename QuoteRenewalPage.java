package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 588800 on 7/24/2017.
 */
public class QuoteRenewalPage extends AbstractPage {

    public WebElement selectUpgrade(String cover) {
        return waitForElementPresent(By.xpath("//td[3]/a[text()='" + cover + "']/../../td[1]/a"));
    }

    public WebElement txtQInceptionDate() {
        return waitForElementPresent(By.id("rdp300931_dateInput_text"));
    }

    public WebElement txtQStartDate() {
        return waitForElementPresent(By.id("rdp300932_dateInput_text"));
    }

    public WebElement txtQEndDate() {

        return waitForElementPresent(By.id("rdp300933_dateInput_text"));
    }

    public WebElement chkBxAutoRenewal() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302307"));
    }

    public WebElement chkBxManualRenewal() {
        return waitForElementPresent(By.id("chk302323"));
    }

    public WebElement manualRenewal() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302323"));
    }

    public WebElement chkBxAutomaticRenewal() {
        return waitForElementPresent(By.id("chk302307"));
    }

    public WebElement chkBxMissingData() {
        return waitForElementPresent(By.id("chk302308"));
    }

    public WebElement missingData() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302308"));
    }

    public WebElement chkBxAutoReQuote() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302306"));
    }
    public WebElement chkBxAutoRenewalQuote() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Automatic Renewal')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxOnHold1() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302311"));
    }

    public WebElement chkBxOnHold2() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302312"));
    }

    public WebElement chkBxManualReQuote() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302324"));
    }

    public WebElement btnSave() {
        try {
            return waitForElementPresent(By.xpath("//input[@id='ucMandatoryFieldEditor_btnSave']"));
        } catch (Exception e) {
            return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
        }
    }

    public WebElement quoteDetails() {
        return waitForElementVisible(By.id("//*[contains(text(),'Quote Details')]"));
    }
    public WebElement cancellationDetails() {
        return waitForElementVisible(By.id("//*[contains(text(),'Cancellation Details')]"));
    }
//    public WebElement btnCancel() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement txtComment() {
        return waitForElementPresent(By.id("txtComments"));
    }

    public WebElement btnFinish() {
        return waitForElementPresent(By.id("btnFinish"));
    }


    public String lnkBasePolicySelected() {
        return "//th[contains(text(),'Base Policy')]/../following-sibling::tr[1]//td/img[contains(@id,'imgSelected')]";
    }

    public String lnkBasePolicySelect() {
        return "//th[contains(text(),'Base Policy')]/../following-sibling::tr[1]//td/a[contains(text(),'select')]";
    }

    public WebElement chkBxSupressComm() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302335"));
    }

    public WebElement lblRenewalQuote() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow"));
    }

    public WebElement lblQuoteCreatedDate() {
        return waitForElementPresent(By.xpath("//tr[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow')]/td[6]"));
    }

    public String lblSecondQuote() {
        return "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl02_gridRow";
    }

    public WebElement drpdnRenewalReason(String reason) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302552_') and contains(text(),'" + reason + "')]"));
    }

    public WebElement renewalReason() {
        return waitForElementPresent(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl302552_')])[1]"));
    }

    public WebElement txtEarlyRenewalDate() {
        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302548_')]"));
    }

    public WebElement txtValidRenewalDate() {
        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302549_')]"));
    }

    public WebElement txtStdRenewalDate() {
        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302550_')]"));
    }

    public WebElement editFirstQuote() {
        return waitForElementPresent(By.xpath("//tr[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow')]/td[1]//a"));
    }

    public WebElement premiumIPT(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[8]"));
        // return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[3]"));
    }
    public WebElement coverShouldNotDisplay(String cover){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+cover+"')]"));
    }

    public WebElement txtQuoteExpiryDate() {
        return waitForElementPresent(By.id("rdp301221_dateInput_text"));
    }

    public WebElement tabActions() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Action Dates')]"));
    }

    public WebElement lblTotalPrice(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[13]"));
        // return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[8]"));
    }


    public WebElement lblLastYrPrice(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[32]"));
    }

    public WebElement lblPremium(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[7]"));
//        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[27]"));
    }


    public WebElement lblProPremium(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[9]"));
        //  return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[27]"));
    }

    public WebElement paymentOptions() {
        return waitForElementPresent(By.id("ddl302059_Input"));
    }

    public WebElement drpdnPaymentOption(String payment) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ddl302059_') and contains(text(),'" + payment + "')]"));
    }

    public WebElement renewalDetails(String detail) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + detail + "')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement reasonForEarlyRenewalImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Reason For Early Renewal')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement reasonForEarlyRenewalReason(String reason) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + reason + "')]"));
    }

    public WebElement chkBxRenewalStoppedByRep() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302310"));
    }

    public WebElement chkBxForeignOrNoPostcode() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302321"));
    }

    public WebElement chkBxCustomerDeceased() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302315"));
    }

    public WebElement chkBxUnderwriterTriggersHit() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302316"));
    }

    public WebElement chkBxOutstandingPayment() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302317"));
    }

    public WebElement chkBxCustomerBarred() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302318"));
    }

    public WebElement chkBxAcctClosedUpgradeNotCancelled() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302319"));
    }

    public WebElement chkBxUpgradeDummyClientRecord() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302320"));
    }

    public WebElement chkBxForeignAddress() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302321"));
    }

    public WebElement chkBxValidCPAAndDDI() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302456"));
    }

    public WebElement validCPAAndDDIValue() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Billing Account ID for auto-renewal')]/../following-sibling::td/span/input[1]"));
    }

    public WebElement chkBxMedicalScreeningScore() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302457"));
    }

    public WebElement chkBxCustTurned70() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302458"));
    }

    public WebElement chkBxCustAskedToCancel() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302325"));
    }

    public WebElement chkBxExpireQuote() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302559"));
    }

    public WebElement chkBxSyncQuoteExpiryDate() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302560"));
    }

    public WebElement chkBk100Days() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302561"));
    }

    public WebElement chkBk59Days() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302562"));
    }

    public WebElement chkBk30Days() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302563"));
    }

    public WebElement chkBk14Days() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302564"));
    }

    public WebElement chkBk0Days() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk302565"));
    }

    public WebElement portalAgedLogon() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk304314"));
    }

    public WebElement saveAndClose() {

        return waitForElementPresent(By.id("btnSaveAndClose"));
    }

    public WebElement lblCoverStartDate(String cover) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + cover + "')]/../following-sibling::td[2]"));
    }

    public WebElement lblCoverEndDate(String cover) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + cover + "')]/../following-sibling::td[4]"));
    }

    public WebElement renewalQuoteRemainingDays() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_Tr1']/../tr[3]/td[8]"));
    }

    public  WebElement txtXdaysPrior()
    {
       return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_int303748_text']"));
    }
}
