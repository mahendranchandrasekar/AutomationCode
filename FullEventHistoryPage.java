package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class FullEventHistoryPage extends AbstractPage {

    public WebElement filter() {
        return waitForElementPresent(By.id("ddlFilterByEvent"));
    }

    public WebElement showFullEventHistory() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_btnShowFullEventHistory"));
    }

    public WebElement closeWindow() {
        return waitForElementPresent(By.name("btnCloseWindow"));
    }

    public WebElement eventHistoryTableHeader() {
        return waitForElementPresent(By.id("rgEventHistory_ctl01_Header"));
    }

    public WebElement eventHistoryTable() {
        return waitForElementPresent(By.id("rgEventHistory_ctl01"));
    }

    public WebElement incidentTab() {
        return waitForElementPresent(By.xpath(".//a[@title='Page: 26369 - Incidents']"));
    }
    public WebElement insertNewRecord() {
        return waitForElementPresent(By.id("301252_searchButton"));
    }

    public WebElement editButton(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'TestingEvent')]/../td[10]/a"));
    }
    public WebElement incidentName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,\"Rad301252_ctl01\")][contains(@id,\"txt\")]"));
    }

    public WebElement incidentDescription() {
        return waitForElementPresent(By.xpath("//textarea[starts-with(@id, \"Rad301252_ctl01\")]"));
    }

    public WebElement incidentDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id, \"rdp301250_dateInput_text\")]"));
    }

    public WebElement sortOrder() {
        return waitForElementPresent(By.xpath("//input[contains(@id, \"int301253_text\")]"));
    }

    public WebElement status() {
        return waitForElementPresent(By.xpath("//input[contains(@id, \"ddl301249_Input\")]"));
    }

    public WebElement statusValue(String strValue) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//div[contains(@id,'ddl301249')][contains(text(),'" + strValue + "')]"));
    }

    public WebElement update() {
        return waitForElementPresent(By.xpath("//a[contains(@id, \"UpdateButton\")]"));
    }

    public WebElement cancel() {
        return waitForElementPresent(By.xpath("//a[contains(@id, \"CancelButton\")]"));
    }

    public WebElement saveAndClose() {
        return waitForElementPresent(By.id("btnSaveAndClose"));
    }

    public boolean saveAndCloseDisplayed() {
        return elementDisplayed(By.id("btnSaveAndClose"));
    }

//    public WebElement save() {
//        return waitForElementToBeClickableAndReturnElement(By.id("btnSave"));
//    }

    public WebElement editIncident(String strRowId) {
        return waitForElementPresent(By.xpath("//table[@id='Rad301252_ctl01']/tbody/tr[" + strRowId + "]/td/a[contains(@id,'EditButton')]"));
    }

    public WebElement edit() {
        return waitForElementPresent(By.xpath("//a[contains(@id,'EditButton')]"));
    }


    public WebElement incidentConfigurationTable() {
        return waitForElementPresent(By.id("Rad301252_ctl01"));
    }

    public WebElement payUpdateClaimSMS() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'SMS - Payment Update (SYSTEM)')]"));
    }

    public WebElement claimPaymentEmail() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Email - (TIM) Settlement Notification Email (S)')]"));
    }

    public WebElement previewEmailLink() {
        return waitForElementPresent(By.xpath("//*[contains(@title,'Preview this email')]"));
    }

    public WebElement insidePreviewEmailURL() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'membershipbenefits')]"));
    }

    public WebElement previewEmailCloseBtn() {
        return waitForElementVisible(By.xpath("//a[contains(text(),'Close')]"));
    }

    public WebElement settlementLetter() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Letter - (TIM) Settlement Letter')]"));
    }

    public WebElement supplierLOAFormEmail() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Hospital LOA Form | Email')]"));
    }

    public WebElement supplierLOAFormEmailDoc() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Supplier LOA Form | Email')]/following-sibling::td[8]//input"));
    }

    public WebElement customerLOAFormEmail() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Customer LOA Form | Email')]"));
    }

    public WebElement customerLOAFormEmailDoc() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Customer LOA Form | Email')]/following-sibling::td[9]//input"));
    }


    public WebElement settlementLetterPDF() {
        return waitForElementPresent(By.xpath("//table[@id='rgEventHistory_ctl01']//tr/td[contains(text(),'Settlement Letter')]/../td[11]//input"));
    }

    public WebElement moreDetailsBtn() {
        return waitForElementPresent(By.xpath("//input[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnCustomerDF']"));
    }

    public WebElement commPreference() {
        return waitForElementPresent(By.xpath("//input[@id='ddl301397_Input']"));
    }

    public WebElement commPreferenceTab(String preferenceValue) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + preferenceValue + "')]"));
    }

    public WebElement saveAndCloseBtn() {
        return waitForElementPresent(By.xpath("//input[@id='btnSaveAndClose']"));
    }

    public WebElement commPreferenceValue(String preferenceValue) {
        return waitForElementPresent(By.xpath("//div[@id='ddl301307_DropDown']/div[contains(text(),'" + preferenceValue + "')]"));
    }

    public WebElement supplierEmailStatus() {
        return waitForElementPresent(By.xpath("//input[@id='supplier']"));
    }

    public WebElement supplierEmail() {
        return waitForElementPresent(By.xpath("//input[@id='supplierEmail']"));
    }

    public WebElement messageContent() {
        return waitForElementPresent(By.xpath("//input[@id='messageContent']"));
    }

    public WebElement perils() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[1]/th[3]"));
    }

    public WebElement dol() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[1]/th[7]"));
    }

    public WebElement paid() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[1]/th[9]"));
    }

    public WebElement statuss() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[1]/th[10]"));
    }

    public WebElement MESSAGE() {
        return waitForElementPresent(By.xpath("//*[@id=\"lblError\"]"));
    }

    public WebElement verifyemailicon() {
        return waitForElementPresent(By.xpath(""));
    }

    public WebElement eventhistorytable() {
        return waitForElementPresent(By.xpath("//*[@id=\"rgEventHistory_ctl01\"]"));
    }

    public String eventhistorytableRows() {
        return "//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr";
    }

    public String eventhistorytablerowdata() {
        return "//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr/td";
    }

    public WebElement eventHistoryCloseWindow() {
        return waitForElementPresent(By.id("btnCloseWindow"));
    }

    public WebElement highvalueReserveEmailevent() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'High Value Reserve Email Notification (SYSTEM)')]"));
    }

    public WebElement highvalueReserveevent() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'High Claim Reserve Change')]"));
    }

    public WebElement newQuoteConfirmationEmail() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'New Quote Confirmation | Email')]"));
    }

    public WebElement newQuoteConfirmationSms() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'New Quote Confirmation | SMS')]"));
    }

    public WebElement newQuoteConfirmationLetter() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'New Quote Confirmation | Letter')]"));
    }

    public String claimCloseReasontableRows() {
        return "//*[@id=\"detailFieldRadGrid_ctl01\"]/tbody/tr";
    }

    public String claimCloseTablerowdata() {
        return "//*[@id=\"detailFieldRadGrid_ctl01\"]/tbody/tr/td[2]";
    }


    public WebElement generateRemittanceAdvice() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Generate Remittance Advice')]"));
    }

    public WebElement generateRemittanceAdvicePDF() {
        return waitForElementPresent(By.xpath("//table[@id='rgEventHistory_ctl01']//tr/td[contains(text(),'Generate Remittance Advice')]/../td[10]//input"));
    }

    public WebElement emailCommunication(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]"));
    }

    public WebElement lblBaggage() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Baggage')]"));
    }

    public WebElement processclaim() {
        return waitForElementPresent(By.xpath("//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr[8]/td[2]"));
    }

    public WebElement finalizepayment() {
        return waitForElementPresent(By.xpath("//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr[6]/td[2]"));

    }

//    public WebElement btnclose() {
//        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
//    }


    public WebElement eventsInHistory(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]"));
    }

    public String lblEventsInHistory(String event) {
        return "//td[contains(text(),'" + event + "')]";
    }


    public String eventsInHistoryXpath(String event) {
        return "//td[contains(text(),'" + event + "')]";
    }

    public WebElement lblEmailContent() {
        return waitForElementPresent(By.xpath("//*[@id='lblMessage']"));
    }
    public String linkOnEmailContent() {
        return "//a[contains(text(),'here')]";
    }


    public String events(String event) {
        return "//a[contains(text(),'" + event + "')]";

    }


    public WebElement openComplaintLink() {
        return waitForElementPresent(By.linkText("Open Complaint"));
    }

    public WebElement verifyCMSEntry(String referenceNumber) {
        return waitForElementPresent(By.xpath("//textarea[contains(text(),'" + referenceNumber + "')]"));
    }

//    public WebElement closebtn() {
//        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
//    }

    public WebElement exclusionMessage() {
        return waitForElementPresent(By.xpath("//*[@id='person0']/div/p[2]/span"));
    }

    public WebElement nextEventInEventHistory(String event) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + event + "')]"));
    }

    public WebElement lblComments(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]/following-sibling::td[1]/span"));
    }

    public WebElement iconDocument(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+event+"')]/following-sibling::td//input[@title='Open document for viewing or printing']"));
    }

    public WebElement iconEmail(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+event+"')]/following-sibling::td//a[@class='emailPreview']"));
    }

    public WebElement formGenerated(String doc) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + doc + "')]"));
    }

    public WebElement formGeneratedDoc(String doc) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + doc + "')]/following-sibling::td[8]//input"));
    }

    public WebElement previewEmailLinkForEvent(String event) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + event + "')]/following-sibling::td//a[@title='Preview this email']"));
    }

    public String lblRecipientOfSettlementLetter()
    {
        return "(//td[contains(text(),'Claim Payment | Email')]/..//span)[1]";
    }

    public WebElement lblEmailRecipient()
    {
        return waitForElementPresent(By.id("lblTo"));
    }
    public WebElement docNonUKResidencyConfirmedLetter() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Non UK Address. Residency confirmed')]/../td//input[contains(@id,'btnOpenDoc')]"));
    }
    public WebElement txtNonUKResidencyConfirmed() {
        return waitForElementPresent(By.xpath(" //*[contains(text(),'Non UK Address. Residency confirmed')]"));

    }

    public WebElement lblRegURL()
    {
        return waitForElementPresent(By.xpath("//*[contains(text(),'link:')]"));
    }

    public WebElement documentLetters(String DocName) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+DocName+"')]"));
    }
    public WebElement documentLetterPDF(String DocName) {
      return waitForElementPresent(By.xpath("//td[contains(text(),'"+DocName+"')]/.././/div//input[contains(@type ,'image')]"));
    }

    public WebElement documentName(String name){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+name+"')]/../td[3]/span"));
    }

    public WebElement email(String DocName) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+DocName+"')]/.././/div//img[contains(@src,'email')]"));
    }
    public WebElement previewOfEmailLink() {
//        return waitForElementPresent(By.xpath("//*[contains(@href,'3994043')]"));
        return waitForElementPresent(By.xpath("//td[contains(text(),'Email - (TIM) Settlement Notification Email (S)')]/following-sibling::td//a[@title='Preview this email']"));
    }
    public WebElement insidePreviewOfEmailURL() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'customerportal')]"));
    }
}