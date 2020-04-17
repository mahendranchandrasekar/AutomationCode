package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountInformationPage extends AbstractPage {

    public WebElement productAndClaims() {
        return waitForElementPresent(By.xpath("//div[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_pnlLeadDetailsHeader']/div[1]"));
    }
    public WebElement brandLogo(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_imgBrandLogo"));
    }
//    public WebElement postcode(){
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbPostCode"));
//    }

    public WebElement brandLabel(){
        return waitForElementPresent(By.xpath("//div[@class='innerFormLeft'][text()='Brand']"));
    }

//    public WebElement brand(){
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblBrandNameShort"));
//    }

    public WebElement accountNameLabel(){

        return waitForElementPresent(By.xpath("//div[@class='innerFormLeft'][2]"));
    }

    public WebElement accountName1() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountName"));
    }

    public WebElement accountNumber() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountNo"));
    }

    public WebElement policyNumberLabel(){
        return waitForElementPresent(By.xpath("//div[contains(text(),'Policy No')]"));
    }
//    public WebElement policyNumber(){
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountLID"));
//    }
//    public WebElement policyNumberInPolicyInfo(){
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountID"));
//    }
//    public WebElement basePolicyNumber(){
//        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_gridRow']/td[2]"));
//    }

    public WebElement claimsHistoryTitle(){
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_grdClaims']/tbody/tr[1]/th[1][text()='Claims']"));
    }

    public WebElement claimsHistoryTable(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_grdClaims"));
    }

    public WebElement moreLink() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkClaim"));
    }
    public String moreLinkValidation() {
        return "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkClaim']";
    }

    public WebElement product(){
        return waitForElementPresent(By.xpath("//div[contains(@id,'AccountInformation')]/../div/div/div[4]"));
    }

    public WebElement basePolicyHeader() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Base Policy')]"));
    }

    public WebElement basePolicyLink() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_rptPolicies_ctl01_lnkPolicy"));
    }

    public WebElement annualUpgradeHeader() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_rptPolicies_ctl02_headerRow']/th"));
    }

    public WebElement annualUpgradeLink() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_rptPolicies_ctl02_lnkPolicy"));
    }
    public WebElement quoteAndBuyLink() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[text()='Quote & Buy']"));
    }
    public WebElement randomCusomerFirstName() {
        return waitForElementPresent(By.xpath(" //*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[4]"));
    }

    public WebElement randomCusomerLastName() {
        return waitForElementPresent(By.xpath(" //*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[5]"));
    }

    public WebElement expiryDateOfQuote() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Active Quote')]/../following-sibling::tr[1]//td[7]"));
    }

    public WebElement remainingDaysOfQuote() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Active Quote')]/../following-sibling::tr[1]//td[8]"));
    }

    public WebElement comms() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblCommunicationPreference"));
    }

    public WebElement document() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblDocumentPreference"));
    }

    public WebElement selectclaimasclaimclosed() {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'Claim Closed')])[1]/following-sibling::td[4]"));
    }

    public WebElement customerID() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_lblCustomerID"));
    }
    public WebElement RenewalEdit() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_lnkRenewalQuote"));
    }

//    public WebElement mobileNo() {
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbMobileTel"));
//    }

    public WebElement email() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbEmail"));
    }

    public WebElement coverFromDateOfQuote() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Annual Upgrade')]/../following-sibling::tr[1]//td[5]"));
    }
}