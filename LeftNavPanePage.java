package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LeftNavPanePage extends AbstractPage {

    public WebElement leads() {
        return waitForElementToBeClickableAndReturnElement(By.id("pnl3_Text"));
    }

    public WebElement policies() {
        return waitForElementToBeClickableAndReturnElement(By.linkText("POLICIES"));
    }

    public WebElement searchLead() {
        return waitForElementToBeClickableAndReturnElement(By.id("pnl3a_Text"));
    }

    public WebElement policiesPanel() {
        return waitForElementPresent(By.id("pnl3_Panel"));
    }

    public WebElement quickSearchOn(){
       return waitForElementPresent(By.id("ctl00_ddlSearchField"));
    }

    public WebElement quickSearchFor(){
        return waitForElementPresent(By.id("ctl00_txtSearchText"));
    }

    public WebElement quickSearch(){
        return waitForElementPresent(By.id("ctl00_btnQuickSearch"));
    }

    public boolean policiesPanelIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("pnl3_Panel"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public WebElement iMenu() {
        return waitForElementPresent(By.id("pnl1_Text"));
    }

    public WebElement iAdmin() {
        return waitForElementPresent(By.id("pnl7_Text"));
    }
    public WebElement recoveryConfigtab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Recovery Configuration')][@class=\"innerWrap\"]"));
    }

    public String iAdminId() {
        return "//td[contains(text(),'iADMIN')]";
    }

    public WebElement manageUserGroup() {
        return waitForElementPresent(By.id("pnl6_Text"));
    }

    public WebElement iReporting() {
        return waitForElementPresent(By.id("pnl4_Text"));
    }

    public List<WebElement> iReportElement() {
        return findElements(By.id("pnl4_Text"));
    }

    public WebElement newPolicy() {
        return waitForElementPresent(By.id("pnl3c_Text"));
    }

    public WebElement companyDetails() {
        return waitForElementPresent(By.id("pnl3_Text"));
    }
    public WebElement recoveryTab() {
        return waitForElementPresent(By.id("pnl45_Text"));
    }
    public WebElement recoveryTaskTab() {
        return waitForElementPresent(By.id("pnl45e_Text"));
    }
    public boolean workflowPanelIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("pnl6_Text"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }
    public WebElement claimIDFilter(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasksOutstanding_ctl01']/thead/tr[2]/td[9]/input"));
    }
    public WebElement claimIDFilterClick(){
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBody_grdTasksOutstanding_ctl01']/thead/tr[2]/td[9]/img"));
    }
    public WebElement claimIDFilterClickEqualTo(){
        return waitForElementPresent(By.linkText("EqualTo"));
    }
    public WebElement claimIDInRecoveryTask(){
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBody_grdTasksOutstanding_ctl01']/tbody/tr/td[9]"));
    }
    public WebElement workflowPanel() {
        return waitForElementPresent(By.id("pnl6_Panel"));
    }

    public WebElement workflowTasks() {
        return waitForElementPresent(By.id("pnl6c_Text"));
    }

    public WebElement workflow() {
        return waitForElementVisible(By.id("pnl6_Text"));
    }

    public WebElement imenuWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("pnl3_ImageTD")));
    }

    public WebElement chaseConfirmation(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'Chase Confirmation Follow-up Time (days)')]/../../td[2]/input[1]"));
    }
    public WebElement chasePayment(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'Chase Payment Follow-up time (days)')]/../../td[2]/input[1]"));
    }

    public WebElement iadminWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("pnl2_Text")));
    }

    public WebElement companyDetailsWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'IPT')]")));
    }

    public WebElement leadManager() {
        return waitForElementPresent(By.id("pnl3_Text"));
    }

    public WebElement iptTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'IPT')]"));
    }
    public WebElement vatTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'VAT')]"));
    }

    public WebElement waitForiptTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'IPT Rates')]"));
    }
    public WebElement waitForVATTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'VAT Rate:')]"));
    }

    public WebElement quoteTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'QuoteAndBuy')]"));
    }

    public WebElement waitForQVPDays() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Quote Validity Period:')]"));
    }

    public boolean IReportingPanelIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.xpath("//td[contains(text(),'iREPORTING')]"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public WebElement IReportingPanel() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'iREPORTING')]"));
    }

    public WebElement ireportWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(),'MANAGE REPORTS')]")));


    }

    public boolean manageReportPanelIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.xpath("//td[contains(text(),'MANAGE REPORTS')]"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public WebElement ManageReportPanel() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'MANAGE REPORTS')]"));
    }

    public WebElement ManageReportWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("JSReportTree-SearchText")));
    }

    public WebElement filterSearch() {
        return waitForElementPresent(By.id("JSReportTree-SearchText"));
    }

    public WebElement reportSearchbtn() {
        return waitForElementPresent(By.xpath("//input[@value='search']"));
    }

    public WebElement reportClearbtn() {
        return waitForElementPresent(By.xpath("//input[@value='clear']"));
    }

    public WebElement reportSearchbtnWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Run Report")));
    }

    public WebElement runReport() {
        return waitForElementPresent(By.linkText("Run Report"));
    }

    public WebElement runReportWait() {
        return (new WebDriverWait(getDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btnRun")));
    }

    public WebElement runbtn() {
        return waitForElementPresent(By.id("btnRun"));
    }

    public WebElement runbtnWait() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Results')]"));
    }

    public WebElement automationReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Automation Reports')]/../ins"));
    }

    public WebElement integration() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Integration')]/../ins"));
    }

    public WebElement TMAClaim() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'TMA Claim')]/../ins"));
    }


    public WebElement report() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'40746')]"));
    }

    public WebElement email_report() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Email')]/../ins/following-sibling::a/../ins)[1]"));
    }

    public WebElement disclaimerRequestReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'40848')]"));
    }

    public WebElement resultTable() {
        return waitForElementPresent(By.xpath("//table[@class='reportResultTable']/tbody"));
    }

    public WebElement setUP() {
        return waitForElementPresent(By.id("pnl5_Text"));
    }


    public WebElement batchJobs() {
        return waitForElementPresent(By.id("pnl5i_Text"));
    }

    public WebElement detailFields() {
        return waitForElementPresent(By.id("pnl5m_Text"));
    }

    public WebElement workflowGroups() {
        return waitForElementPresent(By.id("pnl6a_Text"));
    }

    public WebElement noteTypes() {
        return waitForElementPresent(By.id("pnl5h_Text"));
    }

    public WebElement myAccount() {
        return waitForElementPresent(By.id("pnl5_Text"));
    }

    public WebElement personalOption() {
        return waitForElementPresent(By.id("pnl5c_Text"));
    }

    public WebElement policyType() {
        return waitForElementPresent(By.id("pnl5a_Text"));
    }

    public WebElement resourcesAndTables() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Resources and Tables')]/following-sibling::td[5]/a[@title='Manage Detail Field Pages']"));
    }

    public WebElement tmaTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'TMA')]"));
    }

    public WebElement waitFortmaTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Medical Report Chase Time Hours')]"));
    }

    public WebElement txtMaxEarlyRenewal() {
        return waitForElementPresent(By.id("int302547_text"));
    }

    public WebElement systemTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'System')]"));
    }

    public WebElement lblDocuments() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Documents to Print:')]"));
    }
    public WebElement documentManager() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'DOCUMENT MANAGER')][@id='pnl9_Text']"));
    }

    public WebElement closeRuleEnginewindow() {
        return waitForElementPresent(By.id("fancybox-close"));
    }


    public WebElement claimCompetencyTab() {
        return waitForElementPresent(By.id("pnl44_Text"));
    }

    public WebElement claimCompetency() {
        return waitForElementPresent(By.id("pnl44a_Text"));
    }

    public WebElement allocateCompetency() {
        return waitForElementPresent(By.id("pnl44c_Text"));
    }

    public String claimCompetencyId() {
        return "pnl44a_Text";
    }

    //TODO-Sruthi Start
    public WebElement manualClaimHandlerAlloc() {
        return waitForElementPresent(By.id("pnl44d_Text"));
    }

    public WebElement claimTasksTab() {
        return waitForElementPresent(By.id("pnl44e_Text"));
    }
    //TODO-Sruthi End
    public WebElement clickOnAssign(String ClaimID) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" +ClaimID+ "')]/../td[1]/a[contains(text(),'Assign')]"));
    }
    public WebElement clickOnReAssign(String ClaimID) {
       return waitForElementToBeClickableAndReturnElement(By.xpath("//*[contains(text(),'" +ClaimID+ "')]/../td[1]/a[contains(text(),'Reassign')]"));
    }
    public WebElement clickOnReAssignClaimID() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'65715')]/../td[1]/a[contains(text(),'Assign')]"));
    }
    public WebElement clickOnReAssignSecondTimeClaimID() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'66345')]/../td[1]/a[contains(text(),'Assign')]"));
    }

    public WebElement getAssigneNameInOutStanding(String ClaimID) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+ClaimID+"')]/../td[2]"));
    }
    public WebElement getAssigneeFromworkFlowTask(String CaseID){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+CaseID+"')]/../../td[8]"));
    }
    public WebElement getAssigneeFromPolicyPage(String ClaimID){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+ClaimID+"')]/../td[10]"));
    }

    public WebElement lnkEditTMAHandler(){
        return waitForElementPresent(By.xpath("//td[contains(text(),'Claim Handler TMA')]/../td[4]//input[contains(@alt,'Edit')]"));
    }

    public String listTMAClaimHandler(){
        return "//table[@class='MasterTable_Default gridctl00_cphBody_rgGroupsEdit_ctl01']//td[contains(text(),'Claim Handler TMA')]/preceding-sibling::td[1]";
    }

    public WebElement txtAllocationFailedReason(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'Reason Automatic Allocation Failed')]/../../../..//td[contains(text(),'TMA Claim')]"));

    }

    public String listTMAAssignee(){
        return "//table[@class='MasterTable_Default gridctl00_cphBodyWithoutUpdatePanel_cphBody_grdClaimHandlers_ctl01']//following-sibling::tbody/tr/td[3]";
    }

    public WebElement lnkAssignTMAClaim(){
        return waitForElementPresent(By.xpath("//table[@class='MasterTable_Default gridctl00_cphBodyWithoutUpdatePanel_cphBody_grdClaimHandlers_ctl01']//following-sibling::tbody/tr[@class='GridRow_Default']/td[1]/a[contains(text(),'Assign')]"));
    }

    public WebElement txtAssignee(String Handler){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+Handler+"')]"));
    }
    public WebElement txtClaimIdAtAssignee(String ClaimId){
        return waitForElementPresent(By.xpath("//table[@class='MasterTable_Default gridRad302987_ctl01']//td[contains(text(),'"+ClaimId+"')]"));
    }

    public WebElement claimIdManualFilter(){
        return waitForElementPresent(By.xpath("//input[@name='ctl00$cphBodyWithoutUpdatePanel$cphBody$grdUnallocatedClaims$ctl01$ctl02$ctl02$ctl00' or @name='ctl00$cphBodyWithoutUpdatePanel$cphBody$grdAllocatedClaims$ctl01$ctl02$ctl02$ctl00']"));

    }

    public WebElement selectFilter(){
        return waitForElementPresent(By.xpath("(//img[@alt='Filter'])[1]"));
    }

    public WebElement txtFilterValue(){
        return waitForElementPresent(By.xpath("//td[text()='EqualTo']"));
    }

    public WebElement reassignTMAClaim(){
        return waitForElementPresent(By.xpath("//tr[@class='GridAltRow_Default']/td/a[contains(text(),'Assign')]"));
    }

    public WebElement iDairy() {
        return waitForElementPresent(By.id("pnl8_Text"));
    }

    public WebElement claimHandlerTextField(){
        return waitForElementPresent(By.xpath("//input[@name='ctl00$cphBodyWithoutUpdatePanel$cphBody$grdClaimHandlers$ctl01$ctl02$ctl02$ctl02']"));
    }

    public WebElement claimHandlerFilter(){
        return waitForElementPresent(By.xpath("//span[contains(@id,'grdClaimHandlersStyleSheetHolder')]/following-sibling::table[1]//tr[2]/td[3]/input/../img"));
    }
    public WebElement manageUsers() {
        return waitForElementPresent(By.id("pnl5_Text"));
    }
}
