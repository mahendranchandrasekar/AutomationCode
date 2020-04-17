package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 324102 on 7/20/2017.
 */
public class SetUpPage extends AbstractPage {
    public WebElement lnkSelectJob(String jobName) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][text()='" + jobName + "']/../td[9]/a"));
    }

    public WebElement linkSelectJob(String jobName) {
        System.out.println("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[5][contains(text(),'" + jobName + "')]/../td[9]/a");
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[5][contains(text(),'" + jobName + "')]/../td[9]/a"));
    }


    public WebElement enterMedicalReportChaseHours() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Medical Report Chase Time Hours')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement enterloaChaseHours() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'LOA Chase Time Hours')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement enteraccesstomedicalinformationChaseHours() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Access to Medical Information Chase Time Hours')]/../following-sibling::td[1]/input[1]"));
    }

//    public WebElement saveandClose() {
//        return waitForElementPresent(By.id("btnSaveAndClose"));
//    }

    public WebElement selectBatch(String jobName) {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'" + jobName + "')]/../td[9]/a"));
    }

    public WebElement selectBatchJobGP(String jobName) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + jobName + "')]/following-sibling::td[4]/a"));
    }

    public WebElement customerBarredRulesEdit() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Customer Barred Rules')]/following-sibling::td//a[contains(text(),'Edit')]"));
    }

    public WebElement filterWithCase() {
        return waitForElementPresent(By.xpath("//select[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlCase']"));
    }

    public WebElement selectTaskID() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/thead/tr[2]/td[1]/input[1]"));
    }

    public WebElement selectEdit1ForAge(String jobName) {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[contains(text(),'"+jobName+"')]/../td[9]/a"));
    }

    public WebElement selectEdit2ForAge() {
        try {
            return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Age Extension Invitation | Letter')]/../td[9]/a"));
        } catch (Exception e) {
            return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'LETTER (SYSTEM) - Age Extension Required')]/../td[9]/a"));
        }
    }

    public WebElement selectEdit3ForAge() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[5][contains(text(),'Age Extension Invitation SMS')]/../td[9]/a"));
    }

    public WebElement navigateToEventProcessDeadlines(){
        return waitForElementPresent(By.id("pnl5g_Text"));
    }
    public WebElement navigateTonewlyCreatedSLAFordeleting(String processDescription){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+processDescription+"')]/../td[7]/input"));
    }
    public WebElement deleteSLA(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnDelete"));
    }

    public WebElement selectClaimType(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByLeadType"));
    }
    public WebElement newBtnInEventProcessDeadLine(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnAddLimitation"));
    }
    public WebElement selectLeadTypeProcessInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlLeadType"));
    }
    public WebElement processDescriptionInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtDescription"));
    }
    public WebElement fromEventInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlEventFrom"));
    }
    public WebElement toEventInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlEventTo"));
    }
    public WebElement numberOfDaysInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtDays"));
    }
    public WebElement numberOfHoursInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtHours"));
    }
    public WebElement numberOfMinutesInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtMinutes"));
    }
    public WebElement saveBtnInProcessDeadLinePage(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnSave"));
    }
    public WebElement validateEventProcessSuccessfullyCreated(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Your Event Process Deadline record has been saved')]"));
    }
    public WebElement eventProcessRowsDeadLineTable(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgLimitations_ctl01']/tbody/tr"));
    }
    public WebElement numberOFRowsInEventProcessDeadLineTable(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgLimitations_ctl01']/tbody"));
    }


    public WebElement retrieveDaysInProcessTable(int row){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgLimitations_ctl01']/tbody/tr["+row+"]/td[3]"));
    }
    public WebElement retrieveHoursInProcessTable(int row){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgLimitations_ctl01']/tbody/tr["+row+"]/td[4]"));
    }
    public WebElement retrieveMinutesInProcessTable(int row){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgLimitations_ctl01']/tbody/tr["+row+"]/td[5]"));
    }
    public WebElement slaTab(){
        return waitForElementPresent(By.id("pnl46_Text"));
    }
    public WebElement leadTypeInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_ddlLeadType"));
    }
    public WebElement slaInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_ddlSla"));
    }
    public WebElement completedStatusInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_chkCompleted"));
    }
    public WebElement withinslaInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_rbtnSla_0"));
    }
    public WebElement outsideslaInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_rbtnSla_1"));
    }
    public WebElement fromDateInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_rdpFrom_dateInput_text"));
    }
    public WebElement toDateInSLA(){
        return waitForElementPresent(By.id("ctl00_cphBody_rdpTo_dateInput_text"));
    }
    public WebElement claimIDInputBoxInSLA(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasks_ctl01']/thead/tr[2]/td[13]/input"));
    }
    public WebElement claimIDInputBoxFilterInSLA(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasks_ctl01']/thead/tr[2]/td[13]/img"));
    }
    public WebElement equalToFilter(){
        return waitForElementPresent(By.xpath("//table[@cellpadding='0']/tbody/tr[6]/td/table/tbody/tr/td[2][contains(text(),'EqualTo')]"));
    }
    public WebElement claimValidationInTaskTable(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasks_ctl01']/tbody"));
    }
    public WebElement slaInTaskTable(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasks_ctl01']/tbody/tr/td[6]"));
    }
    public WebElement timeRemainingInTaskTable(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasks_ctl01']/tbody/tr/td[7]"));
    }
    public WebElement validateNoTaskListed(){
        return waitForElementPresent(By.xpath("//div[contains(text(),'No records to display')]"));
    }

    public WebElement allowPaymentChkBox() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Allow Events and Hold Payments')]/../following-sibling::td/input[@type='checkbox']"));
    }

    public WebElement updateCutomerBarredRules() {
        return waitForElementPresent(By.id("btnAdd"));
    }

    public WebElement closeCustomerBarredRulesFrame() {
        return waitForElementPresent(By.id("CloseButtonctl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow"));
    }

    public WebElement healixNurseNotes() {
            return waitForElementPresent(By.xpath("//td[contains(text(),'Healix Nurse Notes')]/following::td[7]/a"));
    }

    public WebElement groupIDtoEditBar() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Admin GroupID CSV allowed to apply or edit')]/../following::td[1]/input"));
    }

    public WebElement selectEdit4() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Full Time Education Information | Email')]/../td[9]/a/img"));
    }

    public WebElement selectEdit5() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[5][contains(text(),'Full Time Education Information Letter')]/../td[9]/a/img"));
    }

    public WebElement selectEdit6() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Guest Cover Invitation | Letter')]/../td[9]/a"));
    }

    public WebElement selectEdit7() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Guest Cover Invitation | Email')]/../td[9]/a"));
    }

    public WebElement selectEdit4ForAge() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Letter Upgrade Cancellation (No Age Extension)')]/../td[9]/a"));
    }

    public WebElement selectEdit5ForAge() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTask']/tbody/tr/td[2][contains(text(),'Expired Age Extension Quotes')]/../td[9]/a"));
    }
}
