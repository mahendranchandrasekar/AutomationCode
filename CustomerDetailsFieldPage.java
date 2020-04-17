package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerDetailsFieldPage extends AbstractPage {


    public WebElement commPrefTab() {
        return waitForElementVisible( By.xpath( "//span[text()='Comms Preferences']" ) );
    }

    public WebElement internalTab() {
        return waitForElementVisible( By.xpath( "//span[text()='Internal']" ) );
    }

    public WebElement commPrefPhone() {
        return waitForElementVisible( By.id( "chk301955" ) );
    }

    public WebElement commPrefPhoneLabel() {
        return waitForElementVisible( By.id( "lbl301955" ) );
    }

    public WebElement commPrefPhoneAcknowledge() {
        return waitForElementPresent( By.id( "ack301955" ) );
    }

    public WebElement commPrefEMail() {
        return waitForElementPresent( By.id( "chk301894" ) );
    }

    public WebElement commPrefEMailLabel() {
        return waitForElementPresent( By.id( "lbl301894" ) );
    }

    public WebElement commPrefEMailAcknowledge() {
        return waitForElementPresent( By.id( "ack301894" ) );
    }

    public WebElement commPrefLetter() {
        return waitForElementPresent( By.id( "chk301895" ) );
    }

    public WebElement commPrefLetterLabel() {
        return waitForElementPresent( By.id( "lbl301895" ) );
    }

    public WebElement commPrefLetterAcknowledge() {
        return waitForElementPresent( By.id( "ack301895" ) );
    }

    public WebElement commPrefSMS() {
        return waitForElementPresent( By.id( "chk301897" ) );
    }

    public WebElement commPrefSMSLabel() {
        return waitForElementPresent( By.id( "lbl301897" ) );
    }

    public WebElement commPrefSMSAcknowledge() {
        return waitForElementPresent( By.id( "ack301897" ) );
    }

    public WebElement docPrefAudio() {
        return waitForElementVisible( By.id( "chk301960" ) );
    }

    public WebElement docPrefBraille() {
        return waitForElementVisible( By.id( "chk301961" ) );
    }

    public WebElement docPrefLarge() {
        return waitForElementVisible( By.id( "chk301962" ) );
    }

    public WebElement docPrefRetunToDesk() {
        return waitForElementVisible( By.id( "chk301963" ) );
    }

    public WebElement docPrefTalking() {
        return waitForElementVisible( By.id( "chk301964" ) );
    }

    public WebElement docPrefAudioLabel() {
        return waitForElementVisible( By.id( "lbl301960" ) );
    }

    public WebElement docPrefBrailleLabel() {
        return waitForElementVisible( By.id( "lbl301961" ) );
    }

    public WebElement docPrefLargeLabel() {
        return waitForElementVisible( By.id( "lbl301962" ) );
    }

    public WebElement docPrefAudioAcknowledge() {
        return waitForElementVisible( By.id( "ack301960" ) );
    }

    public WebElement docPrefBrailleAcknowledge() {
        return waitForElementVisible( By.id( "ack301961" ) );
    }

    public WebElement docPrefLargeAcknowledge() {
        return waitForElementVisible( By.id( "ack301962" ) );
    }

    public WebElement docPrefRetunToDeskAcknowledge() {
        return waitForElementVisible( By.id( "ack301963" ) );
    }

    public WebElement docPrefTalkingAcknowledge() {
        return waitForElementVisible( By.id( "ack301964" ) );
    }

    public WebElement saveAndCloseButton() {
        return waitForElementVisible( By.id( "btnSaveAndClose" ) );
    }

//    public WebElement closeButton() {
//        return waitForElementVisible( By.id( "btnClose" ) );
//    }

    public WebElement selectCutomerBar() {
        return waitForElementVisible( By.id( "ucMandatoryFieldEditor_302722_searchButton" ) );
    }

    public WebElement fieldsInBarringPage(String fieldName) {
        return waitForElementVisible( By.xpath( "//th[text()='" + fieldName + "']" ) );
    }

    public String optionsInBarringPage(String fieldValue) {
        return "//td[contains(text(),'" + fieldValue + "')]";
    }

    public String nextLink() {
        return "//a[contains(text(),'Next')]";
    }


    public WebElement closeBarringWindowInConfiguration() {
        return waitForElementPresent( By.xpath( "//td[@title='Close']/img[@id='CloseButtonctl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow']" ) );

    }


    public WebElement selectSystemLockType(String systemLockType) {
        return waitForElementVisible( By.xpath( "//td[contains(text(),'" + systemLockType + "')]/preceding-sibling::td/a" ) );
    }

    public String selectSystemLockTypeXpath(String systemLockType) {
        return "//td[contains(text(),'" + systemLockType + "')]/preceding-sibling::td/a";
    }

    public WebElement customerBlocks() {
        return waitForElementVisible( By.xpath( "//input[@class='ComboBoxInput_Default']" ) );
    }


    public WebElement saveBtn() {
        return waitForElementToBeClickableAndReturnElement( By.id( "ucMandatoryFieldEditor_btnSave" ) );
    }

//    public WebElement cancelBtn() {
//        return waitForElementVisible( By.id( "btnCancel" ) );
//    }

    public WebElement nameOfBarInTable(String fieldValue) {
        return waitForElementVisible( By.xpath( "//table[@class='gridView']//td[2][contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement statusOfBar(String fieldValue) {
        return waitForElementVisible( By.xpath( "//table[@class='gridView']//td[3][contains(text(),'" + fieldValue + "')]" ) );
    }

    public WebElement notificationMessage(String notificationType) {
        return waitForElementVisible( By.xpath( "//td[contains(text(),'" + notificationType + "')]/following-sibling::td" ) );
    }

    public WebElement nameOfBarInEdit() {
        return waitForElementVisible( By.id( "ucMandatoryFieldEditor_ddl302812_Input" ) );
    }

    public WebElement nameOfBarBarStatusInEditOption(String option) {
        return waitForElementVisible( By.xpath( "//div[contains(text(),'" + option + "')]" ) );
    }

    public WebElement barStatus() {
        return waitForElementVisible( By.id( "ucMandatoryFieldEditor_ddl302813_Input" ) );
    }

    public String notificationMessageXpath(String notificationType) {
        return "//td[contains(text(),'" + notificationType + "')]/following-sibling::td";
    }

    public WebElement selectTheBar(String block) {
        return waitForElementVisible( By.xpath( "//td[contains(text(),'" + block + "')]/preceding-sibling::td//a[contains(text(),'Select')]" ) );
    }

    public WebElement complianceBlockMessageField() {
        return waitForElementVisible( By.id( "txt302836" ) );
    }

    public WebElement barringConfigurationFrame() {
        return waitForElementVisible( By.id( "RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow" ) );
    }

    public WebElement policyCaseId() {
        return waitForElementVisible( By.id( "lblCaseID" ) );
    }

    public WebElement caseIdUnderWorkflow(String caseIdForPolicy) {
        return waitForElementVisible( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']//td[12]/a[contains(text(),'" + caseIdForPolicy + "')]" ) );
    }

    public WebElement adminGroupId() {
        return waitForElementVisible( By.xpath( "//span[contains(text(),'Admin GroupID')]/../following-sibling::td[1]/input" ) );
    }

    public WebElement potentialRelatedFraud() {
        return waitForElementVisible( By.xpath( "//span[contains(text(),'Potential Related Fraud')]/../following-sibling::td[1]/input" ) );
    }

    public String potentialRelatedFraudXpath() {
        return "//span[contains(text(),'Potential Related Fraud')]/../following-sibling::td[1]/input";
    }

    public WebElement updateBtn() {
        return waitForElementVisible( By.id( "btnAdd" ) );
    }

    public WebElement restrictionMessage(String message) {
        return waitForElementVisible( By.xpath( "//*[contains(text(),'" + message + "')]" ) );
    }

    public WebElement reassessmentDate() {
        return waitForElementVisible( By.id( "ucMandatoryFieldEditor_rdp302728_dateInput_text" ) );
    }

    public WebElement errorMessage(String error) {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//*[contains(text(),'" + error + "')]" ) );
    }

    public WebElement dateOfDeath() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Date Of Death')]/../following-sibling::td//input[contains(@id,'dateInput')]" ) );
    }

    public WebElement causeOfDeath() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Cause Of Death')]/../following-sibling::td//input" ) );
    }

    public WebElement detailsOfDeath() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Details Of Death')]/../following-sibling::td//textarea" ) );
    }

    public WebElement locationOfDeath() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Location Of Death')]/../following-sibling::td//input" ) );
    }

    public WebElement notifyFuneralDirector() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Notify Funeral Director')]/../following-sibling::td//input" ) );
    }

    public WebElement notifyDLGMediaTeam() {
        return waitForElementVisible( org.openqa.selenium.By.xpath( "//span[contains(text(),'Notify DLG Media Team')]/../following-sibling::td//input" ) );
    }

    public WebElement notifyTIMTravelInsuranceManagement() {
        return waitForElementPresent( org.openqa.selenium.By.xpath( "//span[contains(text(),'Notify TIM Travel Insurance Management')]/../following-sibling::td//input" ) );
    }

    public WebElement drdpcustomerBlocksOption() {
        return waitForElementVisible( By.xpath( "//span[contains(text(),'Would you like to add additional customer blocks?')]/../following-sibling::td/div/div/input" ) );
    }


    public WebElement customerBlocksOptionAsNo() {
        return waitForElementVisible( By.xpath( "//div[@class='ComboBoxItem_Default'][contains(text(),'No')]" ) );
    }

    public WebElement customerBlocksOptionAsYes() {
        return waitForElementVisible( By.xpath( "//div[@class='ComboBoxItem_Default'][contains(text(),'Yes')]" ) );
    }
}